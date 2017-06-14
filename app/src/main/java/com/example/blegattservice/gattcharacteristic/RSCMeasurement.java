package com.example.blegattservice.gattcharacteristic;

import java.nio.ByteBuffer;
import java.util.HashMap;

import org.bluetooth.gatt.utils.GattByteBuffer;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;

public class RSCMeasurement extends DeviceGattCharacteristic {

	private final static int maskInstantaneousStrideLengthPresent = 0x01;
	private final static int maskTotalDistancePresent = 0x02;
	private final static int maskWalkingorRunningStatusbits = 0x04;
		
	private int Flags = 0;
	private boolean flagInstantaneousStrideLengthPresent = false;
	private boolean flagTotalDistancePresent = false;
	private boolean flagWalkingorRunningStatusbits = false;
	private int InstantaneousSpeed = 0;
	private int InstantaneousCadence = 0;
	private int InstantaneousStrideLength = 0;
	private long TotalDistance = 0; 

	public RSCMeasurement(BluetoothGattService gattservice,
			BluetoothGattCharacteristic gattcharacteristic) {
		super(gattservice, gattcharacteristic);
	}

	@Override
	public HashMap<String, Object> getData() {
		int startb = 0;
		HashMap<String, Object> data = new HashMap<String, Object>();
		byte[] value = mGattCharacteristic.getValue();

		Flags = GattByteBuffer.wrap(ByteBuffer.wrap(value, 0, 1).array()).getUint8();
		if( (Flags&maskInstantaneousStrideLengthPresent) > 0 ) {
			flagInstantaneousStrideLengthPresent = true;
			data.put("StrideLengthFlag", "true");
		} else {
			flagInstantaneousStrideLengthPresent = false;
			data.put("StrideLengthFlag", "false");
		}
		
		if( (Flags&maskTotalDistancePresent) > 0 ) {
			flagTotalDistancePresent = true;
			data.put("TotalDistanceFlag", "true");
		} else {
			flagTotalDistancePresent = false;
			data.put("TotalDistanceFlag", "false");
		}
		
		if( (Flags&maskWalkingorRunningStatusbits) > 0 ) {
			flagWalkingorRunningStatusbits = true;
			data.put("RunningStatusFlag", "true");
		} else {
			flagWalkingorRunningStatusbits = false;
			data.put("RunningStatusFlag", "false");
		}
		
		InstantaneousSpeed = GattByteBuffer.wrap(ByteBuffer.wrap(value, 1, 2).array()).getUint16();
		data.put("Speed", InstantaneousSpeed);
		InstantaneousCadence = GattByteBuffer.wrap(ByteBuffer.wrap(value, 3, 1).array()).getUint8();
		data.put("Cadence", InstantaneousCadence);
		
		startb = 4;		
		if(flagInstantaneousStrideLengthPresent) {
			InstantaneousStrideLength = GattByteBuffer.wrap(ByteBuffer.wrap(value, startb, 2).array()).getUint16();
			data.put("StrideLength", InstantaneousStrideLength);
			startb += 2;
		}
		
		if(flagTotalDistancePresent) {
			TotalDistance  = GattByteBuffer.wrap(ByteBuffer.wrap(value, startb, 4).array()).getUint32();
			data.put("TotalDistance", TotalDistance);
		}
		
		return data;
	}

	public int getFlags() {
		return Flags;
	}
	
	public boolean getInstantaneousStrideLengthPresent() {
		return flagInstantaneousStrideLengthPresent;
	}
	
	public boolean getTotalDistancePresent() {
		return flagTotalDistancePresent;
	}
	
	public boolean getWalkingorRunningStatusbits() {
		return flagWalkingorRunningStatusbits;
	}
	
	public int getInstantaneousSpeedInCount() {
		return InstantaneousSpeed;
	}
	
	public float getInstantaneousSpeedInMPS() {
		return (float)(InstantaneousSpeed/256.0f);
	}
	
	public float getInstantaneousSpeedInKMPHR() {
		return (float)(InstantaneousSpeed/256.0f)*3.6f;
	}
	
	public int getInstantaneousCadence() {
		return InstantaneousCadence;
	}
	
	public int getInstantaneousStrideLengthInCM() {
		if(flagInstantaneousStrideLengthPresent) {
			return InstantaneousStrideLength;
		} else {
			return 0;
		}
	}
	
	public float getInstantaneousStrideLengthInMeter() {
		if(flagInstantaneousStrideLengthPresent) {
			return (float)(InstantaneousStrideLength/100.0f);
		} else {
			return 0.0f;
		}
	}
	
	public Long getTotalDistanceInDeciMeter() {
		if(flagTotalDistancePresent) {
			return TotalDistance;
		} else {
			return 0L;
		}
	}

	public float getTotalDistanceInMeter() {
		if(flagTotalDistancePresent) {
			return (float)(TotalDistance/10.0f);
		} else {
			return 0.0f;
		}
	}

	public float getTotalDistanceInKiloMeter() {
		if(flagTotalDistancePresent) {
			return (float)(TotalDistance/10000.0f);
		} else {
			return 0.0f;
		}
	}

}
