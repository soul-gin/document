/**
 * OsFinancingContract_FCBSServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.7  Built on : Nov 20, 2017 (11:41:20 GMT)
 */
package webservice.crm.pushContract;


/**
 *  OsFinancingContract_FCBSServiceCallbackHandler Callback class, Users can extend this class and implement
 *  their own receiveResult and receiveError methods.
 */
public abstract class OsFinancingContract_FCBSServiceCallbackHandler {
    protected Object clientData;

    /**
     * User can pass in any object that needs to be accessed once the NonBlocking
     * Web service call is finished and appropriate method of this CallBack is called.
     * @param clientData Object mechanism by which the user can pass in user data
     * that will be avilable at the time this callback is called.
     */
    public OsFinancingContract_FCBSServiceCallbackHandler(Object clientData) {
        this.clientData = clientData;
    }

    /**
     * Please use this constructor if you don't want to set any clientData
     */
    public OsFinancingContract_FCBSServiceCallbackHandler() {
        this.clientData = null;
    }

    /**
     * Get the client data
     */
    public Object getClientData() {
        return clientData;
    }

    /**
     * auto generated Axis2 call back method for osFinancingContract_FCBS method
     * override this method for handling normal response from osFinancingContract_FCBS operation
     */
    public void receiveResultosFinancingContract_FCBS(
        OsFinancingContract_FCBSServiceStub.MT_FinancingContractResp result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from osFinancingContract_FCBS operation
     */
    public void receiveErrorosFinancingContract_FCBS(Exception e) {
    }
}
