package com.example.blegattservice.gattdevice;

/**
 * 
 * Represents the Bluetooth Le Device data structure for scan device
 * Includes device name, device bt address and rssi. 
 * @author Chevy Lin
 * @since Nov 10, 2015
 * @version 1.0.0
 *  
 */
public class BleDevice  {
	
	private String deviceName;
	private String macAddress;
	private int rssi;
	
	/**
	 * BleDevice Instance function
	 * @param _deviceName Bluetooth Le Device Name
	 * @param _macAddress Bluetooth Le Device Mac Address
	 * @param _rssi Bluetooth Le Device RSSI
	 */
	public BleDevice(String _deviceName, String _macAddress, int _rssi) {
		rssi = _rssi;
		deviceName = _deviceName;
		macAddress = _macAddress;
	}
	
	/**
	 * get the device name function
	 * @return Bluetooth Le Device Name
	 */
	public String getDeviceName() {
		return deviceName;
	}
	
	/**
	 * get the device BT mac address function
	 * @return Bluetooth Le Device Mac Address
	 */
	public String getMacAddress() {
		return macAddress;
	}
	
	/**
	 * get the RSSI value function	
	 * @return rssi value
	 */
	public int getRssi() {
		return rssi;
	}
	
	/**
	 * set the RSSI value function
	 * @param _rssi
	 */
	public void setRssi(int _rssi) {
		rssi = _rssi;
	}
	
 }
