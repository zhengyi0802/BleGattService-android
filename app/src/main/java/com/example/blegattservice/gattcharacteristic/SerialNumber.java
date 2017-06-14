package com.example.blegattservice.gattcharacteristic;

import java.util.HashMap;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;

public class SerialNumber extends DeviceGattCharacteristic {

	private String str;
	
	public SerialNumber(BluetoothGattService gattservice,
			BluetoothGattCharacteristic gattcharacteristic) {
		super(gattservice, gattcharacteristic);
		// TODO Auto-generated constructor stub
	}

	@Override
	public HashMap<String, Object> getData() {
		// TODO Auto-generated method stub
		HashMap<String, Object> data = new HashMap<String, Object>();
		str= mGattCharacteristic.getStringValue(0);
		data.put("SerialNumber", str);
		return data;
	}

	public String getString() {
		return str;
	}
	
}
