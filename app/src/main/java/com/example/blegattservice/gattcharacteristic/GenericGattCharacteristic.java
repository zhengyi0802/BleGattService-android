package com.example.blegattservice.gattcharacteristic;

import java.util.HashMap;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;

public class GenericGattCharacteristic extends DeviceGattCharacteristic {

	private byte[] values;
	
	public GenericGattCharacteristic(BluetoothGattService gattservice,
			BluetoothGattCharacteristic gattcharacteristic) {
		super(gattservice, gattcharacteristic);		
	}

	@Override
	public HashMap<String, Object> getData() {
		HashMap<String, Object> data = new HashMap<String, Object>();
		values = mGattCharacteristic.getValue();
		data.put("ByteArray", values);
		return data;
	}

}
