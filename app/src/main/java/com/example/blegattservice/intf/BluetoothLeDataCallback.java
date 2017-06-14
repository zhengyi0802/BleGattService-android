package com.example.blegattservice.intf;

import java.util.HashMap;

public interface BluetoothLeDataCallback {
	public void DataCallback(HashMap <String, Object> data, String address);
	public void ConnectStatus(boolean state, String address); 
}
