package com.example.blegattservice.utils;

public class HexUtils {
	public static String array(byte[] values) {
		String str = "";
		for(int i = 0; i < values.length; i++) {
			//String s = String.format("%x, args)
			str += "0x" + String.format("%x", values[i]);
			if(i < values.length-1) {
				str += ", ";
			}
		}
		return str;
	}
}
