package com.example.blegattservice.gattcharacteristic;

import java.util.HashMap;

import org.bluetooth.gatt.utils.GattByteBuffer;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.util.Log;

/* 
 * Bluetooth GATT characteristic Sensor Location
 * Assigned Number:  0x2A5D
 * Properties: Read
 */
public class SensorLocation extends DeviceGattCharacteristic {
	private final static String TAG = "SensorLocation";
	private Location location = Location.Other;

	public enum Location {
		Other, 
		Top_of_shoe, 
		In_shoe, 
		Hip,  
		Front_Wheel, 
		Left_Crank, 
		Right_Crank, 
		Left_Pedal, 
		Right_Pedal,  
		Front_Hub, 
		Rear_Dropout, 
		Chainstay, 
		Rear_Wheel,
		Rear_Hub, 
		Chest, 
		Reserved;
	}

	public SensorLocation(BluetoothGattService gattservice,
			BluetoothGattCharacteristic gattcharacteristic) {
		super(gattservice, gattcharacteristic);
	}
	
	@Override
	public HashMap<String, Object> getData() {
		HashMap<String, Object> data = new HashMap<String, Object>();
		int loc = mGattCharacteristic.getIntValue(BluetoothGattCharacteristic.FORMAT_UINT8, 0);
		switch (loc) {
		case 0:
			location = Location.Other;
			data.put("SensorLocation", "Other");
			break;
		case 1:
			location = Location.Top_of_shoe;
			data.put("SensorLocation", "Top of shoe");
			break;
		case 2:
			location = Location.In_shoe;
			data.put("SensorLocation", "In shoe");
			break;
		case 3:
			location = Location.Hip;
			data.put("SensorLocation", "Hip");
			break;
		case 4:
			location = Location.Front_Wheel;
			data.put("SensorLocation", "Front Wheel");
			break;
		case 5:
			location = Location.Left_Crank;
			data.put("SensorLocation", "Left Crank");
			break;
		case 6:
			location = Location.Right_Crank;
			data.put("SensorLocation", "Right Crank");
			break;
		case 7:
			location = Location.Left_Pedal;
			data.put("SensorLocation", "Left Pedal");
			break;
		case 8:
			location = Location.Right_Pedal;
			data.put("SensorLocation", "Right Pedal");
			break;
		case 9:
			location = Location.Front_Hub;
			data.put("SensorLocation", "Front Hub");
			break;
		case 10:
			location = Location.Rear_Dropout;
			data.put("SensorLocation", "Rear Dropout");
			break;
		case 11:
			location = Location.Chainstay;
			data.put("SensorLocation", "Chainstay");
			break;
		case 12:
			location = Location.Rear_Wheel;
			data.put("SensorLocation", "Rear Wheel");
			break;
		case 13:
			location = Location.Rear_Hub;
			data.put("SensorLocation", "Rear Hub");
			break;
		case 14:
			location = Location.Chest;
			data.put("SensorLocation", "Chest");
			break;
		default:
			location = Location.Reserved;
			data.put("SensorLocation", "Reserved");
			break;
		}
		return data;
	}

	/**
	 * @return The current location of the sensor
	 */
	public Location getSensorLocation() {
		return location;
	}
	
}
