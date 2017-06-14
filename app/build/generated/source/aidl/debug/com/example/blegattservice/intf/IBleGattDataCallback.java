/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /opt/Android/Projects/BleGattService/app/src/main/aidl/com/example/blegattservice/intf/IBleGattDataCallback.aidl
 */
package com.example.blegattservice.intf;
/**
 * BleGattDataCallback aidl interface object
 * @author : Chevy Lin
 * @version : 1.0.0
 * @since  : Nov. 10, 2015 
 */
public interface IBleGattDataCallback extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.example.blegattservice.intf.IBleGattDataCallback
{
private static final java.lang.String DESCRIPTOR = "com.example.blegattservice.intf.IBleGattDataCallback";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.example.blegattservice.intf.IBleGattDataCallback interface,
 * generating a proxy if needed.
 */
public static com.example.blegattservice.intf.IBleGattDataCallback asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.example.blegattservice.intf.IBleGattDataCallback))) {
return ((com.example.blegattservice.intf.IBleGattDataCallback)iin);
}
return new com.example.blegattservice.intf.IBleGattDataCallback.Stub.Proxy(obj);
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
case TRANSACTION_DataCallback:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
this.DataCallback(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_ConnectStatus:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
java.lang.String _arg1;
_arg1 = data.readString();
this.ConnectStatus(_arg0, _arg1);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.example.blegattservice.intf.IBleGattDataCallback
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
	 * DataCallback() function is a callback function for client side to access data
	 * @param : String key
	 * @param : String value
	 * @param : String address
	 * @return : none
	 */
@Override public void DataCallback(java.lang.String key, java.lang.String value, java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(key);
_data.writeString(value);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_DataCallback, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * ConnectStatus() function is a callback function for client side to get the connection status
	 * @param : boolean state (true or false)
	 * @param : String address
	 * @return : none
	 */
@Override public void ConnectStatus(boolean state, java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((state)?(1):(0)));
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_ConnectStatus, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_DataCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_ConnectStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
}
/**
	 * DataCallback() function is a callback function for client side to access data
	 * @param : String key
	 * @param : String value
	 * @param : String address
	 * @return : none
	 */
public void DataCallback(java.lang.String key, java.lang.String value, java.lang.String address) throws android.os.RemoteException;
/**
	 * ConnectStatus() function is a callback function for client side to get the connection status
	 * @param : boolean state (true or false)
	 * @param : String address
	 * @return : none
	 */
public void ConnectStatus(boolean state, java.lang.String address) throws android.os.RemoteException;
}
