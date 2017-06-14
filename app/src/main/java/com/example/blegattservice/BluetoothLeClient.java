package com.example.blegattservice;

import java.util.HashMap;

import org.bluetooth.descriptor.GattDescriptor;

import com.example.blegattservice.gattdevice.BluetoothLeDevice;
import com.example.blegattservice.gattdevice.RSCDevice;
import com.example.blegattservice.intf.BluetoothLeDataCallback;
import com.example.blegattservice.utils.BleLog;
import com.example.blegattservice.utils.HexUtils;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.os.Handler;

/**
 * 
 *  Bluetooth Le Client object for Bluetooth Le Gatt Client Communication.
 * @author Chevy Lin
 * @since Nov 10, 2015
 * @version 1.0.0
 * 
 */
public class BluetoothLeClient {
	private static final String TAG = "BluetoothLeClient";
	
    private static final int STATE_DISCONNECTED		= 0;
    private static final int STATE_CONNECTING			= 1;
    private static final int STATE_CONNECTED			= 2;
    
    private BluetoothManager mBluetoothManager;
    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothGatt mBluetoothGatt;
    private BluetoothLeDevice mDevice;
    private BluetoothLeDataCallback mCallback;
    private String mBluetoothDeviceName;
    private String mBluetoothDeviceAddress;
    private int mConnectionState = STATE_DISCONNECTED;    
    private boolean disconnectRequired = false;
    private int mPosition;

    // Implements callback methods for GATT events that the app cares about.  For example,
    // connection change and services discovered.
    private  BluetoothGattCallback mGattCallback = new BluetoothGattCallback() {

		@Override
		public void onConnectionStateChange(BluetoothGatt gatt, int status,
				int newState) {
			BleLog.i(TAG, "onConnectionStateChange() : old status =  " + status);
            if (newState == BluetoothProfile.STATE_CONNECTED) {
                mConnectionState = STATE_CONNECTED;
                mCallback.ConnectStatus(true, mBluetoothDeviceAddress);
                BleLog.d(TAG, "Connected to GATT server.");
                // Attempts to discover services after successful connection.
                BleLog.d(TAG, "Attempting to start service discovery:" +
                        gatt.discoverServices());
            } else if (newState == BluetoothProfile.STATE_DISCONNECTED) {
                mConnectionState = STATE_DISCONNECTED;
                BleLog.d(TAG, "Disconnected from GATT server.");
                mCallback.ConnectStatus(false, mBluetoothDeviceAddress);
            }
		}

		@Override
		public void onServicesDiscovered(BluetoothGatt gatt, int status) {
			BleLog.i(TAG, "onServicesDiscovered() : status = " + status);
            if (status == BluetoothGatt.GATT_SUCCESS) {
            	BleLog.d(TAG, "onServicesDiscovered received! ");
            	if(mDevice != null && !disconnectRequired) {
            		mDevice.setGattServices(gatt);
            	}
            } else {
            	BleLog.w(TAG, "onServicesDiscovered received: " + status);
            }
		}

		@Override
		public void onCharacteristicRead(BluetoothGatt gatt,
				BluetoothGattCharacteristic characteristic, int status) {
			BleLog.i(TAG, "onCharacteristicRead() : characteristic = " + characteristic.getUuid().toString() + " status = " + status);
			 if (status == BluetoothGatt.GATT_SUCCESS) {
				 byte[] received = characteristic.getValue();
				 String str = HexUtils.array(received); 
				 BleLog.d(TAG,  characteristic.getUuid().toString() + " : "  + str);
			 } else {
				 BleLog.w(TAG, "Characteristic Read Error!");
			 }
			 if(mDevice != null && !disconnectRequired) {
				 HashMap<String, Object> data = mDevice.processNext(gatt, characteristic, BluetoothLeDevice.ACTION_ONREAD);
				 mCallback.DataCallback(data, mBluetoothDeviceAddress);
			 }
		}

		@Override
		public void onCharacteristicWrite(BluetoothGatt gatt,
				BluetoothGattCharacteristic characteristic, int status) {
			BleLog.i(TAG, "onCharacteristicWrite() : characteristic = " + characteristic.getUuid().toString() + " status = " + status);
			 if (status == BluetoothGatt.GATT_SUCCESS) {
				 BleLog.d(TAG,  characteristic.getUuid().toString() + " Write OK!");
			 } else {
				 BleLog.w(TAG, "Characteristic Write Error!");
			 }
			 if(mDevice != null && !disconnectRequired) {
				 HashMap<String, Object> data = mDevice.processNext(gatt, characteristic, BluetoothLeDevice.ACTION_ONWRITE);
				 mCallback.DataCallback(data, mBluetoothDeviceAddress);
			 }
		}

		@Override
		public void onCharacteristicChanged(BluetoothGatt gatt,
				BluetoothGattCharacteristic characteristic) {
			BleLog.i(TAG, "onCharacteristicChanged() characteristic = " + characteristic.getUuid().toString() );
			if(true) {
				byte[] received = characteristic.getValue();
				String str = HexUtils.array(received); 
				BleLog.d(TAG,  characteristic.getUuid().toString() + " : "  + str);
			}
			if(mDevice != null && !disconnectRequired) {
				 HashMap<String, Object> data = mDevice.processNext(gatt, characteristic, BluetoothLeDevice.ACTION_ONREADCHANGED);
				 mCallback.DataCallback(data, mBluetoothDeviceAddress);
			}
		}

		@Override
		public void onDescriptorRead(BluetoothGatt gatt,
				BluetoothGattDescriptor descriptor, int status) {
			BleLog.i(TAG, "onDescriptorRead() descriptor belong to characteristic = " + descriptor.getCharacteristic().getUuid().toString() + " status = " + status);
			if(mDevice != null && !disconnectRequired) {
				mDevice.processDescriptor(gatt, descriptor, BluetoothLeDevice.ACTION_DESCRIPTOR_ONREAD);
			}
		}

		@Override
		public void onDescriptorWrite(BluetoothGatt gatt,
				BluetoothGattDescriptor descriptor, int status) {
			BleLog.i(TAG, "onDescriptorWrite() descriptor belong to characteristic = " + descriptor.getCharacteristic().getUuid().toString() + " status = " + status);
			if(mDevice != null && !disconnectRequired) {
				mDevice.processDescriptor(gatt, descriptor, BluetoothLeDevice.ACTION_DESCRIPTOR_ONWRITE);
			}
		}

		@Override
		public void onReliableWriteCompleted(BluetoothGatt gatt, int status) {
			BleLog.i(TAG, "onReliableWriteCompleted() : status = " + status);
			if(mDevice != null && !disconnectRequired) {
				// do something
			}
		}

		@Override
		public void onReadRemoteRssi(BluetoothGatt gatt, int rssi, int status) {
			BleLog.i(TAG, "onReadRemoteRssi() : rssi = " + rssi + " status = " + status);
			if(mDevice != null && !disconnectRequired) {
				// do something
			}
		}

    };
    
    private final BluetoothLeDataCallback mDefaultDataCallback = new BluetoothLeDataCallback() {

		@Override
		public void DataCallback(HashMap<String, Object> data, String address) {
			BleLog.d(TAG, "mDefaultDataCallback DataCallback");
		}

		@Override
		public void ConnectStatus(boolean state, String address) {		
			BleLog.d(TAG, "mDefaultDataCallback ConnectStatus");
		}
    	
    };
    
    public BluetoothLeClient( int position) {
    	mCallback = mDefaultDataCallback;
    	mPosition = position;
    }
    
    public BluetoothLeClient(BluetoothLeDataCallback callback, int position) {
    	mCallback = callback;
    	mPosition = position;
    }
    
    public BluetoothLeClient(BluetoothLeDataCallback callback, String btAddress) {
    	mCallback = callback;
    	mBluetoothDeviceAddress = btAddress;
    	mPosition = -1;
    }
    
    /**
     * Initializes a reference to the local Bluetooth adapter.
     *
     * @return Return true if the initialization is successful.
     */
    public boolean initialize(Context context) {
        // For API level 18 and above, get a reference to BluetoothAdapter through
        // BluetoothManager.
    	BleLog.i(TAG, "initialize()");
        if (mBluetoothManager == null) {
            mBluetoothManager = (BluetoothManager) context.getSystemService(Context.BLUETOOTH_SERVICE);
            if (mBluetoothManager == null) {
            	BleLog.e(TAG, "Unable to initialize BluetoothManager.");
                return false;
            }
        }

        mBluetoothAdapter = mBluetoothManager.getAdapter();
        if (mBluetoothAdapter == null) {
        	BleLog.e(TAG, "Unable to obtain a BluetoothAdapter.");
            return false;
        }

        return true;
    }

    /**
     * Connects to the GATT server hosted on the Bluetooth LE device.
     *
     * @param address The device address of the destination device.
     *
     * @return Return true if the connection is initiated successfully. The connection result
     *         is reported asynchronously through the
     *         {@code BluetoothGattCallback#onConnectionStateChange(android.bluetooth.BluetoothGatt, int, int)}
     *         callback.
     */
    public boolean connect(Context context, final String address) {
    	BleLog.i(TAG, "connect()");
        if (mBluetoothAdapter == null || address == null) {
        	BleLog.w(TAG, "BluetoothAdapter not initialized or unspecified address.");
            return false;
        }

        // Previously connected device.  Try to reconnect.
        if (mBluetoothDeviceAddress != null && address.equals(mBluetoothDeviceAddress)
                && mBluetoothGatt != null) {
        	BleLog.d(TAG, "Trying to use an existing mBluetoothGatt for connection.");
            if (mBluetoothGatt.connect()) {
                mConnectionState = STATE_CONNECTING;
                disconnectRequired = false;
                return true;
            } else {
                return false;
            }
        }

        final BluetoothDevice device = mBluetoothAdapter.getRemoteDevice(address);
        if (device == null) {
        	BleLog.w(TAG, "Device not found.  Unable to connect.");
            return false;
        }
        // We want to directly connect to the device, so we are setting the autoConnect
        // parameter to false.
        mBluetoothGatt = device.connectGatt(context, false, mGattCallback);
        BleLog.d(TAG, "Trying to create a new connection.");
        mBluetoothDeviceAddress = address;
        mBluetoothDeviceName = device.getName();
        mConnectionState = STATE_CONNECTING;
        if(!RegisterDevice(device) ) {
        	BleLog.w(TAG, "Unknown Device.");
        	mDevice = null;
        	disconnect();
        	return false;
        }
        return true;
    }

    /**
     * Disconnects an existing connection or cancel a pending connection. The disconnection result
     * is reported asynchronously through the
     * {@code BluetoothGattCallback#onConnectionStateChange(android.bluetooth.BluetoothGatt, int, int)}
     * callback.
     */
    public void disconnect() {
    	BleLog.i(TAG, "disconnect()");
        if (mBluetoothAdapter == null || mBluetoothGatt == null) {
        	BleLog.w(TAG, "BluetoothAdapter not initialized");
            return;
        }
        disconnectRequired = true;        
		mBluetoothGatt.disconnect();
		close();
		UnRegisterDevice();
    }
    
    /**
     * After using a given BLE device, the app must call this method to ensure resources are
     * released properly.
     */
    public void close() {
    	BleLog.i(TAG, "close()");
        if (mBluetoothGatt == null) {
            return;
        }
        mBluetoothGatt.close();
        mBluetoothGatt = null;
    }
    
    public int getPosition() {
    	return mPosition;
    }

    public String getAddress() {
    	return mBluetoothDeviceAddress;
    }
    
    private boolean RegisterDevice(BluetoothDevice device) {
    	BleLog.d(TAG, "RegisterDevice()");
    	if(mBluetoothDeviceName == null) return false;
    	if(mBluetoothDeviceName.contains("RunningSensor")) {
    		mDevice = new RSCDevice(device);
        	BleLog.d(TAG, "RegisterDevice() : RunningSensor");
        	return true;
    	}
    	
   	
   	return false;
    }
    
    private void UnRegisterDevice() {
    	BleLog.d(TAG, "UnRegisterDevice() ");
    	mDevice = null;
    }
    
}
