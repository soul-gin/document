package cn.tongdun.preserver.wsdl; /**
 * cn.tongdun.preserver.wsdl.OsQueryEquipment_FCBSServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.4  Built on : Oct 21, 2016 (10:47:34 BST)
 */


/**
 *  cn.tongdun.preserver.wsdl.OsQueryEquipment_FCBSServiceCallbackHandler Callback class, Users can extend this class and implement
 *  their own receiveResult and receiveError methods.
 */
public abstract class OsQueryEquipment_FCBSServiceCallbackHandler {
    protected Object clientData;

    /**
     * User can pass in any object that needs to be accessed once the NonBlocking
     * Web service call is finished and appropriate method of this CallBack is called.
     * @param clientData Object mechanism by which the user can pass in user data
     * that will be avilable at the time this callback is called.
     */
    public OsQueryEquipment_FCBSServiceCallbackHandler(Object clientData) {
        this.clientData = clientData;
    }

    /**
     * Please use this constructor if you don't want to set any clientData
     */
    public OsQueryEquipment_FCBSServiceCallbackHandler() {
        this.clientData = null;
    }

    /**
     * Get the client data
     */
    public Object getClientData() {
        return clientData;
    }

    /**
     * auto generated Axis2 call back method for osQueryEquipment_FCBS method
     * override this method for handling normal response from osQueryEquipment_FCBS operation
     */
    public void receiveResultosQueryEquipment_FCBS(
        OsQueryEquipment_FCBSServiceStub.MT_QueryEquipmentResp result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from osQueryEquipment_FCBS operation
     */
    public void receiveErrorosQueryEquipment_FCBS(Exception e) {
    }
}
