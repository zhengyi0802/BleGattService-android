/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /opt/Android/Projects/BleGattService/app/src/main/aidl/com/example/blegattservice/intf/IBleScanCallback.aidl
 */
package com.example.blegattservice.intf;
/**
 * BleScanCallback aidl interface object
 * @author : Chevy Lin
 * @version : 1.0.0
 * @since  : Nov. 10, 2015 
 */
public interface IBleScanCallback extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.example.blegattservice.intf.IBleScanCallback
{
private static final java.lang.String DESCRIPTOR = "com.example.blegattservice.intf.IBleScanCallback";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.example.blegattservice.intf.IBleScanCallback interface,
 * generating a proxy if needed.
 */
public static com.example.blegattservice.intf.IBleScanCallback asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.example.blegattservice.intf.IBleScanCallback))) {
return ((com.example.blegattservice.intf.IBleScanCallback)iin);
}
return new com.example.blegattservice.intf.IBleScanCallback.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_getBleDeviceData:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
this.getBleDeviceData(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_scanStatus:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.scanStatus(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.example.blegattservice.intf.IBleScanCallback
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
	 * getBleDeviceData() function is to execute the callback function with parameters device name, device address, and rssi
	 * @param : String name
	 * @param : String address
	 * @param : int rssi
	 * @return : none
	 */
@Override public void getBleDeviceData(java.lang.String name, java.lang.String address, int rssi) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(name);
_data.writeString(address);
_data.writeInt(rssi);
mRemote.transact(Stub.TRANSACTION_getBleDeviceData, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * scanStatus() function is to execute the callback function by  the scan state, true or false
	 * @param : boolean (true or false) scan state
	 * @return : none
	 */
@Override public void scanStatus(boolean state) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((state)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_scanStatus, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_getBleDeviceData = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_scanStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
}
/**
	 * getBleDeviceData() function is to execute the callback function with parameters device name, device address, and rssi
	 * @param : String name
	 * @param : String address
	 * @param : int rssi
	 * @return : none
	 */
public void getBleDeviceData(java.lang.String name, java.lang.String address, int rssi) throws android.os.RemoteException;
/**
	 * scanStatus() function is to execute the callback function by  the scan state, true or false
	 * @param : boolean (true or false) scan state
	 * @return : none
	 */
public void scanStatus(boolean state) throws android.os.RemoteException;
}
