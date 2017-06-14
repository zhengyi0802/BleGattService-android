package com.example.blegattservice.gattcharacteristic;

import java.util.HashMap;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;

public class RSCFeature extends DeviceGattCharacteristic {
	
	private final static int InstantaneousStrideLengthMeasurementSupported=0x0001;
	private final static int TotalDistanceMeasurementSupported=0x0002;
	private final static int WalkingorRunningStatusSupported=0x0004;
	private final static int CalibrationProcedureSupported=0x0008;
	private final static int MultipleSensorLocationsSupported=0x0010;

	private int feature;

	public RSCFeature(BluetoothGattService gattservice,
			BluetoothGattCharacteristic gattcharacteristic) {
		super(gattservice, gattcharacteristic);
	}

	@Override
	public HashMap<String, Object> getData() {
		HashMap<String, Object> data = new HashMap<String, Object>();
		feature= mGattCharacteristic.getIntValue(BluetoothGattCharacteristic.FORMAT_UINT16, 0);
		
		if(getInstantaneousStrideLengthMeasurementSupported()) {
			data.put("StrideLength", "true");
		} else {
			data.put("StrideLength", "false");
		}
		
		if(getTotalDistanceMeasurementSupported()) {
			data.put("TotalDistance", "true");
		} else {
			data.put("TotalDistance", "false");
		}
		
		if(getWalkingorRunningStatusSupported()) {
			data.put("RunningStatus", "true");
		} else {
			data.put("RunningStatus", "false");
		}
		
		if(getCalibrationProcedureSupported()) {
			data.put("Calibration", "true");
		} else {
			data.put("Calibration", "false");
		}
		
		if(getMultipleSensorLocationsSupported()) {
			data.put("MultipleSensor", "true");
		} else {
			data.put("MultipleSensor", "false");
		}
		return data;
	}
	
	public boolean getInstantaneousStrideLengthMeasurementSupported() {
		return (feature&InstantaneousStrideLengthMeasurementSupported) > 0;
	}

	public boolean getTotalDistanceMeasurementSupported() {
		return (feature&TotalDistanceMeasurementSupported) > 0;
	}
	
	public boolean getWalkingorRunningStatusSupported() {
		return (feature&WalkingorRunningStatusSupported) > 0;
	}

	public boolean getCalibrationProcedureSupported() {
		return (feature&CalibrationProcedureSupported) > 0;
	}

	public boolean getMultipleSensorLocationsSupported() {
		return (feature&MultipleSensorLocationsSupported) > 0;
	}
	
}
