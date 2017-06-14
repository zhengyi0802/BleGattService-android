package com.example.blegattservice.utils;

import android.util.Log;

/**
 * 
 * The new Log for Ble debug only
 * 
 * @author Chevy Lin
 * @version 1.0.0
 * @since Nov 10, 2015 
 *
 */
public class BleLog {
	private static final int BLE_VERBOSE = 0;
	private static final int BLE_INFORMATION = 1;
	private static final int BLE_DEBUG = 2;
	private static final int BLE_WARNNING = 3;
	private static final int BLE_ERROR = 4;
	private static final String TAG="[BleLog]";
	
	private static int debug_level = 2;
	
	public static void v(String tag, String msg) {
		if(debug_level <= BLE_VERBOSE ) {
			Log.v(TAG+tag, msg);
		}
	}

	public static void i(String tag, String msg) {
		if(debug_level <= BLE_INFORMATION ) {
			Log.i(TAG+tag, msg);
		}
	}

	public static void d(String tag, String msg) {
		if(debug_level <= BLE_DEBUG ) {
			Log.d(TAG+tag, msg);
		}
	}

	public static void w(String tag, String msg) {
		if(debug_level <= BLE_WARNNING ) {
			Log.w(TAG+tag, msg);
		}
	}
	
	public static void e(String tag, String msg) {
		if(debug_level <= BLE_ERROR ) {
			Log.e(TAG+tag, msg);
		}
	}
	
}
