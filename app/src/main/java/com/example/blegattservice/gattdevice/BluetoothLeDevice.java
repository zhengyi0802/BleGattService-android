package com.example.blegattservice.gattdevice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bluetooth.descriptor.GattDescriptor;

import com.example.blegattservice.utils.BleLog;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;

public abstract class BluetoothLeDevice {
	private final static String TAG = "BluetoothLeDevice";
	
	public final static int DEVICETYPE_RSCDEVICE 						= 0x0001;
	
	public final static int ACTION_ONREAD 										= 0x7011;
	public final static int ACTION_ONWRITE 									= 0x7012;
	public final static int ACTION_ONREADCHANGED 				= 0x7013;
	public final static int ACTION_DESCRIPTOR_ONREAD 		= 0x7021;
	public final static int ACTION_DESCRIPTOR_ONWRITE 	= 0x7022;

	protected static List<BluetoothGattService> mServices;
	
	public abstract HashMap<String, Object>  processNext(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int action);
	public abstract void processDescriptor(BluetoothGatt gatt, BluetoothGattDescriptor descriptor,  int action);
	public abstract void processInit(BluetoothGatt gatt, boolean flag);
	public abstract void processEnd(BluetoothGatt gatt, boolean flag);
	
	public abstract void setGattServices(BluetoothGatt gatt);
	
    protected void setCharacteristicNotification(BluetoothGatt gatt,  BluetoothGattCharacteristic characteristic,
            boolean enabled) {
    	BleLog.i(TAG, "setCharacteristicNotification");
    	gatt.setCharacteristicNotification(characteristic, enabled);
    	BluetoothGattDescriptor descriptor = characteristic.getDescriptor(GattDescriptor.CLIENT_CHARACTERISTIC_CONFIGURATION);
    	descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
    	gatt.writeDescriptor(descriptor);
    }
}
