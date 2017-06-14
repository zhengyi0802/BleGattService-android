package com.example.blegattservice.intf;

import com.example.blegattservice.intf.IBleGattDataCallback;

/**
 * IBleGattClient aidl interface object
 * @author : Chevy Lin
 * @version : 1.0.0
 * @since  : Nov. 10, 2015 
 */
interface IBleGattClient {

	/**
	 * registerCallback() function is to register the Callback object which named BleGattDataCallback
	 * @param : BleScanCallback object
	 * @return : none
	 */
	void registerCallback(IBleGattDataCallback callback);
	
	/**
	 * unregisterCallback() function is to unregister the Callback object which named BleGattDataCallback
	 * @param : none
	 * @return : none
	 */
	void unregisterCallback();
	
	/**
	 * connect() function is to connect Bluetooth Le Device which has the BT address
	 * @param : String address
	 * @return : boolean (true or false) 
	 */
	boolean connect(String address);
	
	/**
	 * disconnect() function is to disconnect Bluetooth Le Device which has the BT address
	 * @param : String address
	 * @return : boolean (true or false) 
	 */
	boolean disconnect(String address);
}
