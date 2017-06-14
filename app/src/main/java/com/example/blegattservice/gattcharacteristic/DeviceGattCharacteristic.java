package com.example.blegattservice.gattcharacteristic;

import java.util.HashMap;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;

public abstract class DeviceGattCharacteristic {

	protected BluetoothGattService mGattService;
	protected BluetoothGattCharacteristic mGattCharacteristic;
	
	public DeviceGattCharacteristic(BluetoothGattService gattservice, BluetoothGattCharacteristic gattcharacteristic) {
		mGattService = gattservice;
		mGattCharacteristic = gattcharacteristic;
	}
	
	public abstract HashMap<String, Object> getData();
}
