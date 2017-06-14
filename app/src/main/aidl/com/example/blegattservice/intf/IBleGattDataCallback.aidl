package com.example.blegattservice.intf;

/**
 * BleGattDataCallback aidl interface object
 * @author : Chevy Lin
 * @version : 1.0.0
 * @since  : Nov. 10, 2015 
 */
interface IBleGattDataCallback {

	/**
	 * DataCallback() function is a callback function for client side to access data
	 * @param : String key
	 * @param : String value
	 * @param : String address
	 * @return : none
	 */
	void DataCallback(String key, String value, String address);

	/**
	 * ConnectStatus() function is a callback function for client side to get the connection status
	 * @param : boolean state (true or false)
	 * @param : String address
	 * @return : none
	 */
	void ConnectStatus(boolean state, String address);
}
