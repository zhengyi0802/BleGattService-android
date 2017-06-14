/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /opt/Android/Projects/BleGattService/app/src/main/aidl/com/example/blegattservice/intf/IBleGattClient.aidl
 */
package com.example.blegattservice.intf;
/**
 * IBleGattClient aidl interface object
 * @author : Chevy Lin
 * @version : 1.0.0
 * @since  : Nov. 10, 2015 
 */
public interface IBleGattClient extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.example.blegattservice.intf.IBleGattClient
{
private static final java.lang.String DESCRIPTOR = "com.example.blegattservice.intf.IBleGattClient";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.example.blegattservice.intf.IBleGattClient interface,
 * generating a proxy if needed.
 */
public static com.example.blegattservice.intf.IBleGattClient asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.example.blegattservice.intf.IBleGattClient))) {
return ((com.example.blegattservice.intf.IBleGattClient)iin);
}
return new com.example.blegattservice.intf.IBleGattClient.Stub.Proxy(obj);
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
case TRANSACTION_registerCallback:
{
data.enforceInterface(DESCRIPTOR);
com.example.blegattservice.intf.IBleGattDataCallback _arg0;
_arg0 = com.example.blegattservice.intf.IBleGattDataCallback.Stub.asInterface(data.readStrongBinder());
this.registerCallback(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_unregisterCallback:
{
data.enforceInterface(DESCRIPTOR);
this.unregisterCallback();
reply.writeNoException();
return true;
}
case TRANSACTION_connect:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.connect(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_disconnect:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.disconnect(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.example.blegattservice.intf.IBleGattClient
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
	 * registerCallback() function is to register the Callback object which named BleGattDataCallback
	 * @param : BleScanCallback object
	 * @return : none
	 */
@Override public void registerCallback(com.example.blegattservice.intf.IBleGattDataCallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_registerCallback, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * unregisterCallback() function is to unregister the Callback object which named BleGattDataCallback
	 * @param : none
	 * @return : none
	 */
@Override public void unregisterCallback() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_unregisterCallback, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * connect() function is to connect Bluetooth Le Device which has the BT address
	 * @param : String address
	 * @return : boolean (true or false) 
	 */
@Override public boolean connect(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_connect, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	 * disconnect() function is to disconnect Bluetooth Le Device which has the BT address
	 * @param : String address
	 * @return : boolean (true or false) 
	 */
@Override public boolean disconnect(java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_disconnect, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_registerCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_unregisterCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_connect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_disconnect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
}
/**
	 * registerCallback() function is to register the Callback object which named BleGattDataCallback
	 * @param : BleScanCallback object
	 * @return : none
	 */
public void registerCallback(com.example.blegattservice.intf.IBleGattDataCallback callback) throws android.os.RemoteException;
/**
	 * unregisterCallback() function is to unregister the Callback object which named BleGattDataCallback
	 * @param : none
	 * @return : none
	 */
public void unregisterCallback() throws android.os.RemoteException;
/**
	 * connect() function is to connect Bluetooth Le Device which has the BT address
	 * @param : String address
	 * @return : boolean (true or false) 
	 */
public boolean connect(java.lang.String address) throws android.os.RemoteException;
/**
	 * disconnect() function is to disconnect Bluetooth Le Device which has the BT address
	 * @param : String address
	 * @return : boolean (true or false) 
	 */
public boolean disconnect(java.lang.String address) throws android.os.RemoteException;
}
