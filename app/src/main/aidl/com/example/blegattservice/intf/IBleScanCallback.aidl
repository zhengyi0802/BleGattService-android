package com.example.blegattservice.intf;

/**
 * BleScanCallback aidl interface object
 * @author : Chevy Lin
 * @version : 1.0.0
 * @since  : Nov. 10, 2015 
 */
interface IBleScanCallback {

	/**
	 * getBleDeviceData() function is to execute the callback function with parameters device name, device address, and rssi
	 * @param : String name
	 * @param : String address
	 * @param : int rssi
	 * @return : none
	 */
	void getBleDeviceData(String name, String address, int rssi);
	 
	/**
	 * scanStatus() function is to execute the callback function by  the scan state, true or false
	 * @param : boolean (true or false) scan state
	 * @return : none
	 */
	void scanStatus(boolean state);
}