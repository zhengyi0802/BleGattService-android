/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /opt/Android/Projects/BleGattService/app/src/main/aidl/com/example/blegattservice/intf/IBleScanDevice.aidl
 */
package com.example.blegattservice.intf;
/**
 * IBleScanDevice aidl interface object
 * @author : Chevy Lin
 * @version : 1.0.0
 * @since  : Nov. 10, 2015 
 */
public interface IBleScanDevice extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.example.blegattservice.intf.IBleScanDevice
{
private static final java.lang.String DESCRIPTOR = "com.example.blegattservice.intf.IBleScanDevice";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.example.blegattservice.intf.IBleScanDevice interface,
 * generating a proxy if needed.
 */
public static com.example.blegattservice.intf.IBleScanDevice asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.example.blegattservice.intf.IBleScanDevice))) {
return ((com.example.blegattservice.intf.IBleScanDevice)iin);
}
return new com.example.blegattservice.intf.IBleScanDevice.Stub.Proxy(obj);
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
case TRANSACTION_BleScan:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.BleScan(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_registerCallback:
{
data.enforceInterface(DESCRIPTOR);
com.example.blegattservice.intf.IBleScanCallback _arg0;
_arg0 = com.example.blegattservice.intf.IBleScanCallback.Stub.asInterface(data.readStrongBinder());
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
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.example.blegattservice.intf.IBleScanDevice
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
      * BleScan() function is to enable or disable Bluetooth Le Device Scanning
      * @param : boolean flag for enable or disable scan
      * @return : none
      */
@Override public void BleScan(boolean enabled) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((enabled)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_BleScan, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * registerCallback() function is to register the Callback object which named BleScanCallback
	 * @param : BleScanCallback object
	 * @return : none
	 */
@Override public void registerCallback(com.example.blegattservice.intf.IBleScanCallback callback) throws android.os.RemoteException
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
	 * unregisterCallback() function is to unregister the Callback object which named BleScanCallback
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
}
static final int TRANSACTION_BleScan = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_registerCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_unregisterCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
}
/**
      * BleScan() function is to enable or disable Bluetooth Le Device Scanning
      * @param : boolean flag for enable or disable scan
      * @return : none
      */
public void BleScan(boolean enabled) throws android.os.RemoteException;
/**
	 * registerCallback() function is to register the Callback object which named BleScanCallback
	 * @param : BleScanCallback object
	 * @return : none
	 */
public void registerCallback(com.example.blegattservice.intf.IBleScanCallback callback) throws android.os.RemoteException;
/**
	 * unregisterCallback() function is to unregister the Callback object which named BleScanCallback
	 * @param : none
	 * @return : none
	 */
public void unregisterCallback() throws android.os.RemoteException;
}
