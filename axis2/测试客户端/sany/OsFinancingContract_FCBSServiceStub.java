/**
 * OsFinancingContract_FCBSServiceStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.7  Built on : Nov 20, 2017 (11:41:20 GMT)
 */
package webservice.crm.pushContract;


/*
 *  OsFinancingContract_FCBSServiceStub java implementation
 */
public class OsFinancingContract_FCBSServiceStub extends org.apache.axis2.client.Stub {
    private static int counter = 0;
    protected org.apache.axis2.description.AxisOperation[] _operations;

    //hashmaps to keep the fault mapping
    private java.util.HashMap faultExceptionNameMap = new java.util.HashMap();
    private java.util.HashMap faultExceptionClassNameMap = new java.util.HashMap();
    private java.util.HashMap faultMessageMap = new java.util.HashMap();
    private javax.xml.namespace.QName[] opNameArray = null;

    /**
     *Constructor that takes in a configContext
     */
    public OsFinancingContract_FCBSServiceStub(
        org.apache.axis2.context.ConfigurationContext configurationContext,
        String targetEndpoint) throws org.apache.axis2.AxisFault {
        this(configurationContext, targetEndpoint, false);
    }

    /**
     * Constructor that takes in a configContext  and useseperate listner
     */
    public OsFinancingContract_FCBSServiceStub(
        org.apache.axis2.context.ConfigurationContext configurationContext,
        String targetEndpoint, boolean useSeparateListener)
        throws org.apache.axis2.AxisFault {
        //To populate AxisService
        populateAxisService();
        populateFaults();

        _serviceClient = new org.apache.axis2.client.ServiceClient(configurationContext,
                _service);

        _serviceClient.getOptions()
                      .setTo(new org.apache.axis2.addressing.EndpointReference(
                targetEndpoint));
        _serviceClient.getOptions().setUseSeparateListener(useSeparateListener);
    }

    /**
     * Default Constructor
     */
    public OsFinancingContract_FCBSServiceStub(
        org.apache.axis2.context.ConfigurationContext configurationContext)
        throws org.apache.axis2.AxisFault {
        this(configurationContext,
            "http://poweb.sanygroup.com:8000/XISOAPAdapter/MessageServlet?senderParty=&senderService=Srv_FCBS&receiverParty=&receiverService=&interface=osFinancingContract_FCBS&interfaceNamespace=http%3A%2F%2Fsany.com%2Ffcbs%2F003%2Ffinancingcontract");
    }

    /**
     * Default Constructor
     */
    public OsFinancingContract_FCBSServiceStub()
        throws org.apache.axis2.AxisFault {
        this(
            "http://poweb.sanygroup.com:8000/XISOAPAdapter/MessageServlet?senderParty=&senderService=Srv_FCBS&receiverParty=&receiverService=&interface=osFinancingContract_FCBS&interfaceNamespace=http%3A%2F%2Fsany.com%2Ffcbs%2F003%2Ffinancingcontract");
    }

    /**
     * Constructor taking the target endpoint
     */
    public OsFinancingContract_FCBSServiceStub(String targetEndpoint)
        throws org.apache.axis2.AxisFault {
        this(null, targetEndpoint);
    }

    private static synchronized String getUniqueSuffix() {
        // reset the counter if it is greater than 99999
        if (counter > 99999) {
            counter = 0;
        }

        counter = counter + 1;

        return Long.toString(System.currentTimeMillis()) +
        "_" + counter;
    }

    private void populateAxisService() throws org.apache.axis2.AxisFault {
        //creating the Service with a unique name
        _service = new org.apache.axis2.description.AxisService(
                "OsFinancingContract_FCBSService" + getUniqueSuffix());
        addAnonymousOperations();

        //creating the operations
        org.apache.axis2.description.AxisOperation __operation;

        _operations = new org.apache.axis2.description.AxisOperation[1];

        __operation = new org.apache.axis2.description.OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName(
                "http://sany.com/fcbs/003/financingcontract",
                "osFinancingContract_FCBS"));
        _service.addOperation(__operation);

        _operations[0] = __operation;
    }

    //populates the faults
    private void populateFaults() {
    }

    /**
     * Auto generated method signature
     *
     * @param mT_FinancingContractReq0
     */
    public MT_FinancingContractResp osFinancingContract_FCBS(
        MT_FinancingContractReq mT_FinancingContractReq0)
        throws java.rmi.RemoteException {
        org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
            _operationClient.getOptions()
                            .setAction("http://sap.com/xi/WebService/soap1.1");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient,
                org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                "&");

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions()
                                                        .getSoapVersionURI()),
                    mT_FinancingContractReq0,
                    optimizeContent(
                        new javax.xml.namespace.QName(
                            "http://sany.com/fcbs/003/financingcontract",
                            "osFinancingContract_FCBS")),
                    new javax.xml.namespace.QName(
                        "http://sany.com/fcbs/003/financingcontract",
                        "MT_FinancingContractReq"));

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            Object object = fromOM(_returnEnv.getBody()
                                                       .getFirstElement(),
                    MT_FinancingContractResp.class);

            return (MT_FinancingContractResp) object;
        } catch (org.apache.axis2.AxisFault f) {
            org.apache.axiom.om.OMElement faultElt = f.getDetail();

            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                            new org.apache.axis2.client.FaultMapKey(
                                faultElt.getQName(), "osFinancingContract_FCBS"))) {
                    //make the fault by reflection
                    try {
                        String exceptionClassName = (String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(
                                    faultElt.getQName(),
                                    "osFinancingContract_FCBS"));
                        Class exceptionClass = Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        Exception ex = (Exception) constructor.newInstance(f.getMessage());

                        //message class
                        String messageClassName = (String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(
                                    faultElt.getQName(),
                                    "osFinancingContract_FCBS"));
                        Class messageClass = Class.forName(messageClassName);
                        Object messageObject = fromOM(faultElt,
                                messageClass);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new Class[] { messageClass });
                        m.invoke(ex, new Object[] { messageObject });

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender()
                               .cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @param mT_FinancingContractReq0
     */
    public void startosFinancingContract_FCBS(
        MT_FinancingContractReq mT_FinancingContractReq0,
        final webservice.crm.pushContract.OsFinancingContract_FCBSServiceCallbackHandler callback)
        throws java.rmi.RemoteException {
        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
        _operationClient.getOptions()
                        .setAction("http://sap.com/xi/WebService/soap1.1");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

        addPropertyToOperationClient(_operationClient,
            org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
            "&");

        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

        //Style is Doc.
        env = toEnvelope(getFactory(_operationClient.getOptions()
                                                    .getSoapVersionURI()),
                mT_FinancingContractReq0,
                optimizeContent(
                    new javax.xml.namespace.QName(
                        "http://sany.com/fcbs/003/financingcontract",
                        "osFinancingContract_FCBS")),
                new javax.xml.namespace.QName(
                    "http://sany.com/fcbs/003/financingcontract",
                    "MT_FinancingContractReq"));

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);

        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                public void onMessage(
                    org.apache.axis2.context.MessageContext resultContext) {
                    try {
                        org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                        Object object = fromOM(resultEnv.getBody()
                                                                  .getFirstElement(),
                                MT_FinancingContractResp.class);
                        callback.receiveResultosFinancingContract_FCBS((MT_FinancingContractResp) object);
                    } catch (org.apache.axis2.AxisFault e) {
                        callback.receiveErrorosFinancingContract_FCBS(e);
                    }
                }

                public void onError(Exception error) {
                    if (error instanceof org.apache.axis2.AxisFault) {
                        org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
                        org.apache.axiom.om.OMElement faultElt = f.getDetail();

                        if (faultElt != null) {
                            if (faultExceptionNameMap.containsKey(
                                        new org.apache.axis2.client.FaultMapKey(
                                            faultElt.getQName(),
                                            "osFinancingContract_FCBS"))) {
                                //make the fault by reflection
                                try {
                                    String exceptionClassName = (String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(
                                                faultElt.getQName(),
                                                "osFinancingContract_FCBS"));
                                    Class exceptionClass = Class.forName(exceptionClassName);
                                    java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                    Exception ex = (Exception) constructor.newInstance(f.getMessage());

                                    //message class
                                    String messageClassName = (String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(
                                                faultElt.getQName(),
                                                "osFinancingContract_FCBS"));
                                    Class messageClass = Class.forName(messageClassName);
                                    Object messageObject = fromOM(faultElt,
                                            messageClass);
                                    java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                            new Class[] { messageClass });
                                    m.invoke(ex,
                                        new Object[] { messageObject });

                                    callback.receiveErrorosFinancingContract_FCBS(new java.rmi.RemoteException(
                                            ex.getMessage(), ex));
                                } catch (ClassCastException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorosFinancingContract_FCBS(f);
                                } catch (ClassNotFoundException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorosFinancingContract_FCBS(f);
                                } catch (NoSuchMethodException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorosFinancingContract_FCBS(f);
                                } catch (java.lang.reflect.InvocationTargetException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorosFinancingContract_FCBS(f);
                                } catch (IllegalAccessException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorosFinancingContract_FCBS(f);
                                } catch (InstantiationException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorosFinancingContract_FCBS(f);
                                } catch (org.apache.axis2.AxisFault e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorosFinancingContract_FCBS(f);
                                }
                            } else {
                                callback.receiveErrorosFinancingContract_FCBS(f);
                            }
                        } else {
                            callback.receiveErrorosFinancingContract_FCBS(f);
                        }
                    } else {
                        callback.receiveErrorosFinancingContract_FCBS(error);
                    }
                }

                public void onFault(
                    org.apache.axis2.context.MessageContext faultContext) {
                    org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                    onError(fault);
                }

                public void onComplete() {
                    try {
                        _messageContext.getTransportOut().getSender()
                                       .cleanup(_messageContext);
                    } catch (org.apache.axis2.AxisFault axisFault) {
                        callback.receiveErrorosFinancingContract_FCBS(axisFault);
                    }
                }
            });

        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;

        if ((_operations[0].getMessageReceiver() == null) &&
                _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[0].setMessageReceiver(_callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);
    }

    private boolean optimizeContent(javax.xml.namespace.QName opName) {
        if (opNameArray == null) {
            return false;
        }

        for (int i = 0; i < opNameArray.length; i++) {
            if (opName.equals(opNameArray[i])) {
                return true;
            }
        }

        return false;
    }

    private org.apache.axiom.om.OMElement toOM(
        MT_FinancingContractReq param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(MT_FinancingContractReq.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        MT_FinancingContractResp param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(MT_FinancingContractResp.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        MT_FinancingContractReq param,
        boolean optimizeContent, javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    MT_FinancingContractReq.MY_QNAME,
                    factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    /* methods to provide back word compatibility */

    /**
     *  get the default envelope
     */
    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory) {
        return factory.getDefaultEnvelope();
    }

    private Object fromOM(org.apache.axiom.om.OMElement param,
        Class type) throws org.apache.axis2.AxisFault {
        try {
            if (MT_FinancingContractReq.class.equals(
                        type)) {
                return MT_FinancingContractReq.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (MT_FinancingContractResp.class.equals(
                        type)) {
                return MT_FinancingContractResp.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }
        } catch (Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

        return null;
    }

    //http://poweb.sanygroup.com:8000/XISOAPAdapter/MessageServlet?senderParty=&senderService=Srv_FCBS&receiverParty=&receiverService=&interface=osFinancingContract_FCBS&interfaceNamespace=http%3A%2F%2Fsany.com%2Ffcbs%2F003%2Ffinancingcontract
    public static class DT_FinancingContractResp implements org.apache.axis2.databinding.ADBBean {
        /* This type was generated from the piece of schema that had
           name = DT_FinancingContractResp
           Namespace URI = http://sany.com/fcbs/003/financingcontract
           Namespace Prefix = ns1
         */

        /**
         * field for ET_RETURN
         * This was an Array!
         */
        protected ET_RETURN_type0[] localET_RETURN;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localET_RETURNTracker = false;

        public boolean isET_RETURNSpecified() {
            return localET_RETURNTracker;
        }

        /**
         * Auto generated getter method
         * @return ET_RETURN_type0[]
         */
        public ET_RETURN_type0[] getET_RETURN() {
            return localET_RETURN;
        }

        /**
         * validate the array for ET_RETURN
         */
        protected void validateET_RETURN(ET_RETURN_type0[] param) {
        }

        /**
         * Auto generated setter method
         * @param param ET_RETURN
         */
        public void setET_RETURN(ET_RETURN_type0[] param) {
            validateET_RETURN(param);

            localET_RETURNTracker = param != null;

            this.localET_RETURN = param;
        }

        /**
         * Auto generated add method for the array for convenience
         * @param param ET_RETURN_type0
         */
        public void addET_RETURN(ET_RETURN_type0 param) {
            if (localET_RETURN == null) {
                localET_RETURN = new ET_RETURN_type0[] {  };
            }

            //update the setting tracker
            localET_RETURNTracker = true;

            java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localET_RETURN);
            list.add(param);
            this.localET_RETURN = (ET_RETURN_type0[]) list.toArray(new ET_RETURN_type0[list.size()]);
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
            final javax.xml.namespace.QName parentQName,
            final org.apache.axiom.om.OMFactory factory)
            throws org.apache.axis2.databinding.ADBException {
            return factory.createOMElement(new org.apache.axis2.databinding.ADBDataSource(
                    this, parentQName));
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
            javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
            throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            String prefix = null;
            String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(),
                xmlWriter);

            if (serializeType) {
                String namespacePrefix = registerPrefix(xmlWriter,
                        "http://sany.com/fcbs/003/financingcontract");

                if ((namespacePrefix != null) &&
                        (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi",
                        "http://www.w3.org/2001/XMLSchema-instance", "type",
                        namespacePrefix + ":DT_FinancingContractResp", xmlWriter);
                } else {
                    writeAttribute("xsi",
                        "http://www.w3.org/2001/XMLSchema-instance", "type",
                        "DT_FinancingContractResp", xmlWriter);
                }
            }

            if (localET_RETURNTracker) {
                if (localET_RETURN != null) {
                    for (int i = 0; i < localET_RETURN.length; i++) {
                        if (localET_RETURN[i] != null) {
                            localET_RETURN[i].serialize(new javax.xml.namespace.QName(
                                    "", "ET_RETURN"), xmlWriter);
                        } else {
                            // we don't have to do any thing since minOccures is zero
                        }
                    }
                } else {
                    throw new org.apache.axis2.databinding.ADBException(
                        "ET_RETURN cannot be null!!");
                }
            }

            xmlWriter.writeEndElement();
        }

        private static String generatePrefix(
            String namespace) {
            if (namespace.equals("http://sany.com/fcbs/003/financingcontract")) {
                return "ns1";
            }

            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(String prefix,
                                       String namespace, String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(String prefix,
                                    String namespace, String attName,
                                    String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeAttribute(writerPrefix, namespace, attName,
                    attValue);
            } else {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
                xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(String namespace,
                                    String attName, String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                xmlWriter.writeAttribute(registerPrefix(xmlWriter, namespace),
                    namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(String namespace,
                                         String attName, javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            String attributeNamespace = qname.getNamespaceURI();
            String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }

            String attributeValue;

            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(attributePrefix, namespace, attName,
                    attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            String namespaceURI = qname.getNamespaceURI();

            if (namespaceURI != null) {
                String prefix = xmlWriter.getPrefix(namespaceURI);

                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" +
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            qname));
                }
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                StringBuffer stringToWrite = new StringBuffer();
                String namespaceURI = null;
                String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }

                    namespaceURI = qnames[i].getNamespaceURI();

                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);

                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                qnames[i]));
                    }
                }

                xmlWriter.writeCharacters(stringToWrite.toString());
            }
        }

        /**
         * Register a namespace prefix
         */
        private String registerPrefix(
            javax.xml.stream.XMLStreamWriter xmlWriter,
            String namespace)
            throws javax.xml.stream.XMLStreamException {
            String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();

                while (true) {
                    String uri = nsContext.getNamespaceURI(prefix);

                    if ((uri == null) || (uri.length() == 0)) {
                        break;
                    }

                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {
            private static org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(Factory.class);

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static DT_FinancingContractResp parse(
                javax.xml.stream.XMLStreamReader reader)
                throws Exception {
                DT_FinancingContractResp object = new DT_FinancingContractResp();

                int event;
                javax.xml.namespace.QName currentQName = null;
                String nillableValue = null;
                String prefix = "";
                String namespaceuri = "";

                try {
                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    currentQName = reader.getName();

                    if (reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance",
                                "type") != null) {
                        String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "type");

                        if (fullTypeName != null) {
                            String nsPrefix = null;

                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0,
                                        fullTypeName.indexOf(":"));
                            }

                            nsPrefix = (nsPrefix == null) ? "" : nsPrefix;

                            String type = fullTypeName.substring(fullTypeName.indexOf(
                                        ":") + 1);

                            if (!"DT_FinancingContractResp".equals(type)) {
                                //find namespace for the prefix
                                String nsUri = reader.getNamespaceContext()
                                                               .getNamespaceURI(nsPrefix);

                                return (DT_FinancingContractResp) ExtensionMapper.getTypeObject(nsUri,
                                    type, reader);
                            }
                        }
                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    java.util.ArrayList list1 = new java.util.ArrayList();

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "ET_RETURN").equals(
                                reader.getName())) {
                        // Process the array and step past its final element's end.
                        list1.add(ET_RETURN_type0.Factory.parse(reader));

                        //loop until we find a start element that is not part of this array
                        boolean loopDone1 = false;

                        while (!loopDone1) {
                            // We should be at the end element, but make sure
                            while (!reader.isEndElement())
                                reader.next();

                            // Step out of this element
                            reader.next();

                            // Step to next element event.
                            while (!reader.isStartElement() &&
                                    !reader.isEndElement())
                                reader.next();

                            if (reader.isEndElement()) {
                                //two continuous end elements means we are exiting the xml structure
                                loopDone1 = true;
                            } else {
                                if (new javax.xml.namespace.QName("",
                                            "ET_RETURN").equals(
                                            reader.getName())) {
                                    list1.add(ET_RETURN_type0.Factory.parse(
                                            reader));
                                } else {
                                    loopDone1 = true;
                                }
                            }
                        }

                        // call the converter utility  to convert and set the array
                        object.setET_RETURN((ET_RETURN_type0[]) org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                ET_RETURN_type0.class, list1));
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()) {
                        // 2 - A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }
                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new Exception(e);
                }

                return object;
            }
        } //end of factory class
    }

    public static class ExtensionMapper {
        public static Object getTypeObject(
            String namespaceURI, String typeName,
            javax.xml.stream.XMLStreamReader reader) throws Exception {
            if ("http://sany.com/fcbs/003/financingcontract".equals(
                        namespaceURI) &&
                    "DT_FinancingContractResp".equals(typeName)) {
                return DT_FinancingContractResp.Factory.parse(reader);
            }

            if ("http://sany.com/fcbs/003/financingcontract".equals(
                        namespaceURI) && "ET_RETURN_type0".equals(typeName)) {
                return ET_RETURN_type0.Factory.parse(reader);
            }

            if ("http://sany.com/fcbs/003/financingcontract".equals(
                        namespaceURI) && "IT_FINANCE_type0".equals(typeName)) {
                return IT_FINANCE_type0.Factory.parse(reader);
            }

            if ("http://sany.com/fcbs/003/financingcontract".equals(
                        namespaceURI) &&
                    "DT_FinancingContractReq".equals(typeName)) {
                return DT_FinancingContractReq.Factory.parse(reader);
            }

            throw new org.apache.axis2.databinding.ADBException(
                "Unsupported type " + namespaceURI + " " + typeName);
        }
    }

    public static class MT_FinancingContractReq implements org.apache.axis2.databinding.ADBBean {
        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://sany.com/fcbs/003/financingcontract",
                "MT_FinancingContractReq", "ns1");

        /**
         * field for MT_FinancingContractReq
         */
        protected DT_FinancingContractReq localMT_FinancingContractReq;

        /**
         * Auto generated getter method
         * @return DT_FinancingContractReq
         */
        public DT_FinancingContractReq getMT_FinancingContractReq() {
            return localMT_FinancingContractReq;
        }

        /**
         * Auto generated setter method
         * @param param MT_FinancingContractReq
         */
        public void setMT_FinancingContractReq(DT_FinancingContractReq param) {
            this.localMT_FinancingContractReq = param;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
            final javax.xml.namespace.QName parentQName,
            final org.apache.axiom.om.OMFactory factory)
            throws org.apache.axis2.databinding.ADBException {
            return factory.createOMElement(new org.apache.axis2.databinding.ADBDataSource(
                    this, MY_QNAME));
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
            javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
            throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            //We can safely assume an element has only one type associated with it
            if (localMT_FinancingContractReq == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "MT_FinancingContractReq cannot be null!");
            }

            localMT_FinancingContractReq.serialize(MY_QNAME, xmlWriter);
        }

        private static String generatePrefix(
            String namespace) {
            if (namespace.equals("http://sany.com/fcbs/003/financingcontract")) {
                return "ns1";
            }

            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(String prefix,
                                       String namespace, String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(String prefix,
                                    String namespace, String attName,
                                    String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeAttribute(writerPrefix, namespace, attName,
                    attValue);
            } else {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
                xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(String namespace,
                                    String attName, String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                xmlWriter.writeAttribute(registerPrefix(xmlWriter, namespace),
                    namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(String namespace,
                                         String attName, javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            String attributeNamespace = qname.getNamespaceURI();
            String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }

            String attributeValue;

            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(attributePrefix, namespace, attName,
                    attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            String namespaceURI = qname.getNamespaceURI();

            if (namespaceURI != null) {
                String prefix = xmlWriter.getPrefix(namespaceURI);

                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" +
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            qname));
                }
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                StringBuffer stringToWrite = new StringBuffer();
                String namespaceURI = null;
                String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }

                    namespaceURI = qnames[i].getNamespaceURI();

                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);

                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                qnames[i]));
                    }
                }

                xmlWriter.writeCharacters(stringToWrite.toString());
            }
        }

        /**
         * Register a namespace prefix
         */
        private String registerPrefix(
            javax.xml.stream.XMLStreamWriter xmlWriter,
            String namespace)
            throws javax.xml.stream.XMLStreamException {
            String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();

                while (true) {
                    String uri = nsContext.getNamespaceURI(prefix);

                    if ((uri == null) || (uri.length() == 0)) {
                        break;
                    }

                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {
            private static org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(Factory.class);

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static MT_FinancingContractReq parse(
                javax.xml.stream.XMLStreamReader reader)
                throws Exception {
                MT_FinancingContractReq object = new MT_FinancingContractReq();

                int event;
                javax.xml.namespace.QName currentQName = null;
                String nillableValue = null;
                String prefix = "";
                String namespaceuri = "";

                try {
                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    currentQName = reader.getName();

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    while (!reader.isEndElement()) {
                        if (reader.isStartElement()) {
                            if (reader.isStartElement() &&
                                    new javax.xml.namespace.QName(
                                        "http://sany.com/fcbs/003/financingcontract",
                                        "MT_FinancingContractReq").equals(
                                        reader.getName())) {
                                object.setMT_FinancingContractReq(DT_FinancingContractReq.Factory.parse(
                                        reader));
                            } // End of if for expected property start element

                            else {
                                // 3 - A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException(
                                    "Unexpected subelement " +
                                    reader.getName());
                            }
                        } else {
                            reader.next();
                        }
                    } // end of while loop
                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new Exception(e);
                }

                return object;
            }
        } //end of factory class
    }

    public static class ET_RETURN_type0 implements org.apache.axis2.databinding.ADBBean {
        /* This type was generated from the piece of schema that had
           name = ET_RETURN_type0
           Namespace URI = http://sany.com/fcbs/003/financingcontract
           Namespace Prefix = ns1
         */

        /**
         * field for RZHTH
         */
        protected String localRZHTH;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localRZHTHTracker = false;

        /**
         * field for ZFLAG
         */
        protected String localZFLAG;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localZFLAGTracker = false;

        /**
         * field for ZMESG
         */
        protected String localZMESG;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localZMESGTracker = false;

        public boolean isRZHTHSpecified() {
            return localRZHTHTracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getRZHTH() {
            return localRZHTH;
        }

        /**
         * Auto generated setter method
         * @param param RZHTH
         */
        public void setRZHTH(String param) {
            localRZHTHTracker = param != null;

            this.localRZHTH = param;
        }

        public boolean isZFLAGSpecified() {
            return localZFLAGTracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getZFLAG() {
            return localZFLAG;
        }

        /**
         * Auto generated setter method
         * @param param ZFLAG
         */
        public void setZFLAG(String param) {
            localZFLAGTracker = param != null;

            this.localZFLAG = param;
        }

        public boolean isZMESGSpecified() {
            return localZMESGTracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getZMESG() {
            return localZMESG;
        }

        /**
         * Auto generated setter method
         * @param param ZMESG
         */
        public void setZMESG(String param) {
            localZMESGTracker = param != null;

            this.localZMESG = param;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
            final javax.xml.namespace.QName parentQName,
            final org.apache.axiom.om.OMFactory factory)
            throws org.apache.axis2.databinding.ADBException {
            return factory.createOMElement(new org.apache.axis2.databinding.ADBDataSource(
                    this, parentQName));
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
            javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
            throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            String prefix = null;
            String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(),
                xmlWriter);

            if (serializeType) {
                String namespacePrefix = registerPrefix(xmlWriter,
                        "http://sany.com/fcbs/003/financingcontract");

                if ((namespacePrefix != null) &&
                        (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi",
                        "http://www.w3.org/2001/XMLSchema-instance", "type",
                        namespacePrefix + ":ET_RETURN_type0", xmlWriter);
                } else {
                    writeAttribute("xsi",
                        "http://www.w3.org/2001/XMLSchema-instance", "type",
                        "ET_RETURN_type0", xmlWriter);
                }
            }

            if (localRZHTHTracker) {
                namespace = "";
                writeStartElement(null, namespace, "RZHTH", xmlWriter);

                if (localRZHTH == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "RZHTH cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localRZHTH);
                }

                xmlWriter.writeEndElement();
            }

            if (localZFLAGTracker) {
                namespace = "";
                writeStartElement(null, namespace, "ZFLAG", xmlWriter);

                if (localZFLAG == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "ZFLAG cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localZFLAG);
                }

                xmlWriter.writeEndElement();
            }

            if (localZMESGTracker) {
                namespace = "";
                writeStartElement(null, namespace, "ZMESG", xmlWriter);

                if (localZMESG == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "ZMESG cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localZMESG);
                }

                xmlWriter.writeEndElement();
            }

            xmlWriter.writeEndElement();
        }

        private static String generatePrefix(
            String namespace) {
            if (namespace.equals("http://sany.com/fcbs/003/financingcontract")) {
                return "ns1";
            }

            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(String prefix,
                                       String namespace, String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(String prefix,
                                    String namespace, String attName,
                                    String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeAttribute(writerPrefix, namespace, attName,
                    attValue);
            } else {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
                xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(String namespace,
                                    String attName, String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                xmlWriter.writeAttribute(registerPrefix(xmlWriter, namespace),
                    namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(String namespace,
                                         String attName, javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            String attributeNamespace = qname.getNamespaceURI();
            String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }

            String attributeValue;

            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(attributePrefix, namespace, attName,
                    attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            String namespaceURI = qname.getNamespaceURI();

            if (namespaceURI != null) {
                String prefix = xmlWriter.getPrefix(namespaceURI);

                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" +
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            qname));
                }
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                StringBuffer stringToWrite = new StringBuffer();
                String namespaceURI = null;
                String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }

                    namespaceURI = qnames[i].getNamespaceURI();

                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);

                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                qnames[i]));
                    }
                }

                xmlWriter.writeCharacters(stringToWrite.toString());
            }
        }

        /**
         * Register a namespace prefix
         */
        private String registerPrefix(
            javax.xml.stream.XMLStreamWriter xmlWriter,
            String namespace)
            throws javax.xml.stream.XMLStreamException {
            String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();

                while (true) {
                    String uri = nsContext.getNamespaceURI(prefix);

                    if ((uri == null) || (uri.length() == 0)) {
                        break;
                    }

                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {
            private static org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(Factory.class);

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static ET_RETURN_type0 parse(
                javax.xml.stream.XMLStreamReader reader)
                throws Exception {
                ET_RETURN_type0 object = new ET_RETURN_type0();

                int event;
                javax.xml.namespace.QName currentQName = null;
                String nillableValue = null;
                String prefix = "";
                String namespaceuri = "";

                try {
                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    currentQName = reader.getName();

                    if (reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance",
                                "type") != null) {
                        String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "type");

                        if (fullTypeName != null) {
                            String nsPrefix = null;

                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0,
                                        fullTypeName.indexOf(":"));
                            }

                            nsPrefix = (nsPrefix == null) ? "" : nsPrefix;

                            String type = fullTypeName.substring(fullTypeName.indexOf(
                                        ":") + 1);

                            if (!"ET_RETURN_type0".equals(type)) {
                                //find namespace for the prefix
                                String nsUri = reader.getNamespaceContext()
                                                               .getNamespaceURI(nsPrefix);

                                return (ET_RETURN_type0) ExtensionMapper.getTypeObject(nsUri,
                                    type, reader);
                            }
                        }
                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "RZHTH").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "RZHTH" + "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setRZHTH(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "ZFLAG").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "ZFLAG" + "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setZFLAG(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "ZMESG").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "ZMESG" + "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setZMESG(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()) {
                        // 2 - A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }
                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new Exception(e);
                }

                return object;
            }
        } //end of factory class
    }

    public static class MT_FinancingContractResp implements org.apache.axis2.databinding.ADBBean {
        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://sany.com/fcbs/003/financingcontract",
                "MT_FinancingContractResp", "ns1");

        /**
         * field for MT_FinancingContractResp
         */
        protected DT_FinancingContractResp localMT_FinancingContractResp;

        /**
         * Auto generated getter method
         * @return DT_FinancingContractResp
         */
        public DT_FinancingContractResp getMT_FinancingContractResp() {
            return localMT_FinancingContractResp;
        }

        /**
         * Auto generated setter method
         * @param param MT_FinancingContractResp
         */
        public void setMT_FinancingContractResp(DT_FinancingContractResp param) {
            this.localMT_FinancingContractResp = param;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
            final javax.xml.namespace.QName parentQName,
            final org.apache.axiom.om.OMFactory factory)
            throws org.apache.axis2.databinding.ADBException {
            return factory.createOMElement(new org.apache.axis2.databinding.ADBDataSource(
                    this, MY_QNAME));
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
            javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
            throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            //We can safely assume an element has only one type associated with it
            if (localMT_FinancingContractResp == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "MT_FinancingContractResp cannot be null!");
            }

            localMT_FinancingContractResp.serialize(MY_QNAME, xmlWriter);
        }

        private static String generatePrefix(
            String namespace) {
            if (namespace.equals("http://sany.com/fcbs/003/financingcontract")) {
                return "ns1";
            }

            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(String prefix,
                                       String namespace, String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(String prefix,
                                    String namespace, String attName,
                                    String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeAttribute(writerPrefix, namespace, attName,
                    attValue);
            } else {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
                xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(String namespace,
                                    String attName, String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                xmlWriter.writeAttribute(registerPrefix(xmlWriter, namespace),
                    namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(String namespace,
                                         String attName, javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            String attributeNamespace = qname.getNamespaceURI();
            String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }

            String attributeValue;

            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(attributePrefix, namespace, attName,
                    attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            String namespaceURI = qname.getNamespaceURI();

            if (namespaceURI != null) {
                String prefix = xmlWriter.getPrefix(namespaceURI);

                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" +
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            qname));
                }
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                StringBuffer stringToWrite = new StringBuffer();
                String namespaceURI = null;
                String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }

                    namespaceURI = qnames[i].getNamespaceURI();

                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);

                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                qnames[i]));
                    }
                }

                xmlWriter.writeCharacters(stringToWrite.toString());
            }
        }

        /**
         * Register a namespace prefix
         */
        private String registerPrefix(
            javax.xml.stream.XMLStreamWriter xmlWriter,
            String namespace)
            throws javax.xml.stream.XMLStreamException {
            String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();

                while (true) {
                    String uri = nsContext.getNamespaceURI(prefix);

                    if ((uri == null) || (uri.length() == 0)) {
                        break;
                    }

                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {
            private static org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(Factory.class);

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static MT_FinancingContractResp parse(
                javax.xml.stream.XMLStreamReader reader)
                throws Exception {
                MT_FinancingContractResp object = new MT_FinancingContractResp();

                int event;
                javax.xml.namespace.QName currentQName = null;
                String nillableValue = null;
                String prefix = "";
                String namespaceuri = "";

                try {
                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    currentQName = reader.getName();

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    while (!reader.isEndElement()) {
                        if (reader.isStartElement()) {
                            if (reader.isStartElement() &&
                                    new javax.xml.namespace.QName(
                                        "http://sany.com/fcbs/003/financingcontract",
                                        "MT_FinancingContractResp").equals(
                                        reader.getName())) {
                                object.setMT_FinancingContractResp(DT_FinancingContractResp.Factory.parse(
                                        reader));
                            } // End of if for expected property start element

                            else {
                                // 3 - A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException(
                                    "Unexpected subelement " +
                                    reader.getName());
                            }
                        } else {
                            reader.next();
                        }
                    } // end of while loop
                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new Exception(e);
                }

                return object;
            }
        } //end of factory class
    }

    public static class IT_FINANCE_type0 implements org.apache.axis2.databinding.ADBBean {
        /* This type was generated from the piece of schema that had
           name = IT_FINANCE_type0
           Namespace URI = http://sany.com/fcbs/003/financingcontract
           Namespace Prefix = ns1
         */

        /**
         * field for OBJECT
         */
        protected String localOBJECT;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localOBJECTTracker = false;

        /**
         * field for CGUARANTOR
         */
        protected String localCGUARANTOR;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localCGUARANTORTracker = false;

        /**
         * field for ZFICCONT_NO
         */
        protected String localZFICCONT_NO;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localZFICCONT_NOTracker = false;

        /**
         * field for FKDAT
         */
        protected String localFKDAT;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localFKDATTracker = false;

        /**
         * field for QZDAT
         */
        protected String localQZDAT;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localQZDATTracker = false;

        /**
         * field for ZZREPAYSTARTD
         */
        protected String localZZREPAYSTARTD;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localZZREPAYSTARTDTracker = false;

        /**
         * field for HTEDAT
         */
        protected String localHTEDAT;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localHTEDATTracker = false;

        /**
         * field for ZZFLD000087
         */
        protected String localZZFLD000087;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localZZFLD000087Tracker = false;

        /**
         * field for ZZLOANAMOUNT
         */
        protected String localZZLOANAMOUNT;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localZZLOANAMOUNTTracker = false;

        /**
         * field for ZZLOANSCALE
         */
        protected String localZZLOANSCALE;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localZZLOANSCALETracker = false;

        /**
         * field for ZZLOANPERIOD
         */
        protected String localZZLOANPERIOD;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localZZLOANPERIODTracker = false;

        /**
         * field for ZZDEPOSIT
         */
        protected String localZZDEPOSIT;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localZZDEPOSITTracker = false;

        /**
         * field for ZZAJFACTORAGE
         */
        protected String localZZAJFACTORAGE;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localZZAJFACTORAGETracker = false;

        /**
         * field for ZZPLEDGEFEE
         */
        protected String localZZPLEDGEFEE;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localZZPLEDGEFEETracker = false;

        /**
         * field for ZZPREMIUM
         */
        protected String localZZPREMIUM;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localZZPREMIUMTracker = false;

        /**
         * field for ZZDEPOSITINSR
         */
        protected String localZZDEPOSITINSR;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localZZDEPOSITINSRTracker = false;

        /**
         * field for ZZFLD00007K
         */
        protected String localZZFLD00007K;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localZZFLD00007KTracker = false;

        /**
         * field for ZZFLD00008N
         */
        protected String localZZFLD00008N;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localZZFLD00008NTracker = false;

        /**
         * field for ZZACCNAME
         */
        protected String localZZACCNAME;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localZZACCNAMETracker = false;

        /**
         * field for ZZINTSUBSIDY
         */
        protected String localZZINTSUBSIDY;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localZZINTSUBSIDYTracker = false;

        public boolean isOBJECTSpecified() {
            return localOBJECTTracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getOBJECT() {
            return localOBJECT;
        }

        /**
         * Auto generated setter method
         * @param param OBJECT
         */
        public void setOBJECT(String param) {
            localOBJECTTracker = param != null;

            this.localOBJECT = param;
        }

        public boolean isCGUARANTORSpecified() {
            return localCGUARANTORTracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getCGUARANTOR() {
            return localCGUARANTOR;
        }

        /**
         * Auto generated setter method
         * @param param CGUARANTOR
         */
        public void setCGUARANTOR(String param) {
            localCGUARANTORTracker = param != null;

            this.localCGUARANTOR = param;
        }

        public boolean isZFICCONT_NOSpecified() {
            return localZFICCONT_NOTracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getZFICCONT_NO() {
            return localZFICCONT_NO;
        }

        /**
         * Auto generated setter method
         * @param param ZFICCONT_NO
         */
        public void setZFICCONT_NO(String param) {
            localZFICCONT_NOTracker = param != null;

            this.localZFICCONT_NO = param;
        }

        public boolean isFKDATSpecified() {
            return localFKDATTracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getFKDAT() {
            return localFKDAT;
        }

        /**
         * Auto generated setter method
         * @param param FKDAT
         */
        public void setFKDAT(String param) {
            localFKDATTracker = param != null;

            this.localFKDAT = param;
        }

        public boolean isQZDATSpecified() {
            return localQZDATTracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getQZDAT() {
            return localQZDAT;
        }

        /**
         * Auto generated setter method
         * @param param QZDAT
         */
        public void setQZDAT(String param) {
            localQZDATTracker = param != null;

            this.localQZDAT = param;
        }

        public boolean isZZREPAYSTARTDSpecified() {
            return localZZREPAYSTARTDTracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getZZREPAYSTARTD() {
            return localZZREPAYSTARTD;
        }

        /**
         * Auto generated setter method
         * @param param ZZREPAYSTARTD
         */
        public void setZZREPAYSTARTD(String param) {
            localZZREPAYSTARTDTracker = param != null;

            this.localZZREPAYSTARTD = param;
        }

        public boolean isHTEDATSpecified() {
            return localHTEDATTracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getHTEDAT() {
            return localHTEDAT;
        }

        /**
         * Auto generated setter method
         * @param param HTEDAT
         */
        public void setHTEDAT(String param) {
            localHTEDATTracker = param != null;

            this.localHTEDAT = param;
        }

        public boolean isZZFLD000087Specified() {
            return localZZFLD000087Tracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getZZFLD000087() {
            return localZZFLD000087;
        }

        /**
         * Auto generated setter method
         * @param param ZZFLD000087
         */
        public void setZZFLD000087(String param) {
            localZZFLD000087Tracker = param != null;

            this.localZZFLD000087 = param;
        }

        public boolean isZZLOANAMOUNTSpecified() {
            return localZZLOANAMOUNTTracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getZZLOANAMOUNT() {
            return localZZLOANAMOUNT;
        }

        /**
         * Auto generated setter method
         * @param param ZZLOANAMOUNT
         */
        public void setZZLOANAMOUNT(String param) {
            localZZLOANAMOUNTTracker = param != null;

            this.localZZLOANAMOUNT = param;
        }

        public boolean isZZLOANSCALESpecified() {
            return localZZLOANSCALETracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getZZLOANSCALE() {
            return localZZLOANSCALE;
        }

        /**
         * Auto generated setter method
         * @param param ZZLOANSCALE
         */
        public void setZZLOANSCALE(String param) {
            localZZLOANSCALETracker = param != null;

            this.localZZLOANSCALE = param;
        }

        public boolean isZZLOANPERIODSpecified() {
            return localZZLOANPERIODTracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getZZLOANPERIOD() {
            return localZZLOANPERIOD;
        }

        /**
         * Auto generated setter method
         * @param param ZZLOANPERIOD
         */
        public void setZZLOANPERIOD(String param) {
            localZZLOANPERIODTracker = param != null;

            this.localZZLOANPERIOD = param;
        }

        public boolean isZZDEPOSITSpecified() {
            return localZZDEPOSITTracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getZZDEPOSIT() {
            return localZZDEPOSIT;
        }

        /**
         * Auto generated setter method
         * @param param ZZDEPOSIT
         */
        public void setZZDEPOSIT(String param) {
            localZZDEPOSITTracker = param != null;

            this.localZZDEPOSIT = param;
        }

        public boolean isZZAJFACTORAGESpecified() {
            return localZZAJFACTORAGETracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getZZAJFACTORAGE() {
            return localZZAJFACTORAGE;
        }

        /**
         * Auto generated setter method
         * @param param ZZAJFACTORAGE
         */
        public void setZZAJFACTORAGE(String param) {
            localZZAJFACTORAGETracker = param != null;

            this.localZZAJFACTORAGE = param;
        }

        public boolean isZZPLEDGEFEESpecified() {
            return localZZPLEDGEFEETracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getZZPLEDGEFEE() {
            return localZZPLEDGEFEE;
        }

        /**
         * Auto generated setter method
         * @param param ZZPLEDGEFEE
         */
        public void setZZPLEDGEFEE(String param) {
            localZZPLEDGEFEETracker = param != null;

            this.localZZPLEDGEFEE = param;
        }

        public boolean isZZPREMIUMSpecified() {
            return localZZPREMIUMTracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getZZPREMIUM() {
            return localZZPREMIUM;
        }

        /**
         * Auto generated setter method
         * @param param ZZPREMIUM
         */
        public void setZZPREMIUM(String param) {
            localZZPREMIUMTracker = param != null;

            this.localZZPREMIUM = param;
        }

        public boolean isZZDEPOSITINSRSpecified() {
            return localZZDEPOSITINSRTracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getZZDEPOSITINSR() {
            return localZZDEPOSITINSR;
        }

        /**
         * Auto generated setter method
         * @param param ZZDEPOSITINSR
         */
        public void setZZDEPOSITINSR(String param) {
            localZZDEPOSITINSRTracker = param != null;

            this.localZZDEPOSITINSR = param;
        }

        public boolean isZZFLD00007KSpecified() {
            return localZZFLD00007KTracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getZZFLD00007K() {
            return localZZFLD00007K;
        }

        /**
         * Auto generated setter method
         * @param param ZZFLD00007K
         */
        public void setZZFLD00007K(String param) {
            localZZFLD00007KTracker = param != null;

            this.localZZFLD00007K = param;
        }

        public boolean isZZFLD00008NSpecified() {
            return localZZFLD00008NTracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getZZFLD00008N() {
            return localZZFLD00008N;
        }

        /**
         * Auto generated setter method
         * @param param ZZFLD00008N
         */
        public void setZZFLD00008N(String param) {
            localZZFLD00008NTracker = param != null;

            this.localZZFLD00008N = param;
        }

        public boolean isZZACCNAMESpecified() {
            return localZZACCNAMETracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getZZACCNAME() {
            return localZZACCNAME;
        }

        /**
         * Auto generated setter method
         * @param param ZZACCNAME
         */
        public void setZZACCNAME(String param) {
            localZZACCNAMETracker = param != null;

            this.localZZACCNAME = param;
        }

        public boolean isZZINTSUBSIDYSpecified() {
            return localZZINTSUBSIDYTracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getZZINTSUBSIDY() {
            return localZZINTSUBSIDY;
        }

        /**
         * Auto generated setter method
         * @param param ZZINTSUBSIDY
         */
        public void setZZINTSUBSIDY(String param) {
            localZZINTSUBSIDYTracker = param != null;

            this.localZZINTSUBSIDY = param;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
            final javax.xml.namespace.QName parentQName,
            final org.apache.axiom.om.OMFactory factory)
            throws org.apache.axis2.databinding.ADBException {
            return factory.createOMElement(new org.apache.axis2.databinding.ADBDataSource(
                    this, parentQName));
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
            javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
            throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            String prefix = null;
            String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(),
                xmlWriter);

            if (serializeType) {
                String namespacePrefix = registerPrefix(xmlWriter,
                        "http://sany.com/fcbs/003/financingcontract");

                if ((namespacePrefix != null) &&
                        (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi",
                        "http://www.w3.org/2001/XMLSchema-instance", "type",
                        namespacePrefix + ":IT_FINANCE_type0", xmlWriter);
                } else {
                    writeAttribute("xsi",
                        "http://www.w3.org/2001/XMLSchema-instance", "type",
                        "IT_FINANCE_type0", xmlWriter);
                }
            }

            if (localOBJECTTracker) {
                namespace = "";
                writeStartElement(null, namespace, "OBJECT", xmlWriter);

                if (localOBJECT == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "OBJECT cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localOBJECT);
                }

                xmlWriter.writeEndElement();
            }

            if (localCGUARANTORTracker) {
                namespace = "";
                writeStartElement(null, namespace, "CGUARANTOR", xmlWriter);

                if (localCGUARANTOR == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "CGUARANTOR cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localCGUARANTOR);
                }

                xmlWriter.writeEndElement();
            }

            if (localZFICCONT_NOTracker) {
                namespace = "";
                writeStartElement(null, namespace, "ZFICCONT_NO", xmlWriter);

                if (localZFICCONT_NO == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "ZFICCONT_NO cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localZFICCONT_NO);
                }

                xmlWriter.writeEndElement();
            }

            if (localFKDATTracker) {
                namespace = "";
                writeStartElement(null, namespace, "FKDAT", xmlWriter);

                if (localFKDAT == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "FKDAT cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localFKDAT);
                }

                xmlWriter.writeEndElement();
            }

            if (localQZDATTracker) {
                namespace = "";
                writeStartElement(null, namespace, "QZDAT", xmlWriter);

                if (localQZDAT == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "QZDAT cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localQZDAT);
                }

                xmlWriter.writeEndElement();
            }

            if (localZZREPAYSTARTDTracker) {
                namespace = "";
                writeStartElement(null, namespace, "ZZREPAYSTARTD", xmlWriter);

                if (localZZREPAYSTARTD == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "ZZREPAYSTARTD cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localZZREPAYSTARTD);
                }

                xmlWriter.writeEndElement();
            }

            if (localHTEDATTracker) {
                namespace = "";
                writeStartElement(null, namespace, "HTEDAT", xmlWriter);

                if (localHTEDAT == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "HTEDAT cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localHTEDAT);
                }

                xmlWriter.writeEndElement();
            }

            if (localZZFLD000087Tracker) {
                namespace = "";
                writeStartElement(null, namespace, "ZZFLD000087", xmlWriter);

                if (localZZFLD000087 == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "ZZFLD000087 cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localZZFLD000087);
                }

                xmlWriter.writeEndElement();
            }

            if (localZZLOANAMOUNTTracker) {
                namespace = "";
                writeStartElement(null, namespace, "ZZLOANAMOUNT", xmlWriter);

                if (localZZLOANAMOUNT == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "ZZLOANAMOUNT cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localZZLOANAMOUNT);
                }

                xmlWriter.writeEndElement();
            }

            if (localZZLOANSCALETracker) {
                namespace = "";
                writeStartElement(null, namespace, "ZZLOANSCALE", xmlWriter);

                if (localZZLOANSCALE == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "ZZLOANSCALE cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localZZLOANSCALE);
                }

                xmlWriter.writeEndElement();
            }

            if (localZZLOANPERIODTracker) {
                namespace = "";
                writeStartElement(null, namespace, "ZZLOANPERIOD", xmlWriter);

                if (localZZLOANPERIOD == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "ZZLOANPERIOD cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localZZLOANPERIOD);
                }

                xmlWriter.writeEndElement();
            }

            if (localZZDEPOSITTracker) {
                namespace = "";
                writeStartElement(null, namespace, "ZZDEPOSIT", xmlWriter);

                if (localZZDEPOSIT == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "ZZDEPOSIT cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localZZDEPOSIT);
                }

                xmlWriter.writeEndElement();
            }

            if (localZZAJFACTORAGETracker) {
                namespace = "";
                writeStartElement(null, namespace, "ZZAJFACTORAGE", xmlWriter);

                if (localZZAJFACTORAGE == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "ZZAJFACTORAGE cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localZZAJFACTORAGE);
                }

                xmlWriter.writeEndElement();
            }

            if (localZZPLEDGEFEETracker) {
                namespace = "";
                writeStartElement(null, namespace, "ZZPLEDGEFEE", xmlWriter);

                if (localZZPLEDGEFEE == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "ZZPLEDGEFEE cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localZZPLEDGEFEE);
                }

                xmlWriter.writeEndElement();
            }

            if (localZZPREMIUMTracker) {
                namespace = "";
                writeStartElement(null, namespace, "ZZPREMIUM", xmlWriter);

                if (localZZPREMIUM == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "ZZPREMIUM cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localZZPREMIUM);
                }

                xmlWriter.writeEndElement();
            }

            if (localZZDEPOSITINSRTracker) {
                namespace = "";
                writeStartElement(null, namespace, "ZZDEPOSITINSR", xmlWriter);

                if (localZZDEPOSITINSR == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "ZZDEPOSITINSR cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localZZDEPOSITINSR);
                }

                xmlWriter.writeEndElement();
            }

            if (localZZFLD00007KTracker) {
                namespace = "";
                writeStartElement(null, namespace, "ZZFLD00007K", xmlWriter);

                if (localZZFLD00007K == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "ZZFLD00007K cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localZZFLD00007K);
                }

                xmlWriter.writeEndElement();
            }

            if (localZZFLD00008NTracker) {
                namespace = "";
                writeStartElement(null, namespace, "ZZFLD00008N", xmlWriter);

                if (localZZFLD00008N == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "ZZFLD00008N cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localZZFLD00008N);
                }

                xmlWriter.writeEndElement();
            }

            if (localZZACCNAMETracker) {
                namespace = "";
                writeStartElement(null, namespace, "ZZACCNAME", xmlWriter);

                if (localZZACCNAME == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "ZZACCNAME cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localZZACCNAME);
                }

                xmlWriter.writeEndElement();
            }

            if (localZZINTSUBSIDYTracker) {
                namespace = "";
                writeStartElement(null, namespace, "ZZINTSUBSIDY", xmlWriter);

                if (localZZINTSUBSIDY == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "ZZINTSUBSIDY cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localZZINTSUBSIDY);
                }

                xmlWriter.writeEndElement();
            }

            xmlWriter.writeEndElement();
        }

        private static String generatePrefix(
            String namespace) {
            if (namespace.equals("http://sany.com/fcbs/003/financingcontract")) {
                return "ns1";
            }

            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(String prefix,
                                       String namespace, String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(String prefix,
                                    String namespace, String attName,
                                    String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeAttribute(writerPrefix, namespace, attName,
                    attValue);
            } else {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
                xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(String namespace,
                                    String attName, String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                xmlWriter.writeAttribute(registerPrefix(xmlWriter, namespace),
                    namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(String namespace,
                                         String attName, javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            String attributeNamespace = qname.getNamespaceURI();
            String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }

            String attributeValue;

            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(attributePrefix, namespace, attName,
                    attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            String namespaceURI = qname.getNamespaceURI();

            if (namespaceURI != null) {
                String prefix = xmlWriter.getPrefix(namespaceURI);

                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" +
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            qname));
                }
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                StringBuffer stringToWrite = new StringBuffer();
                String namespaceURI = null;
                String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }

                    namespaceURI = qnames[i].getNamespaceURI();

                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);

                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                qnames[i]));
                    }
                }

                xmlWriter.writeCharacters(stringToWrite.toString());
            }
        }

        /**
         * Register a namespace prefix
         */
        private String registerPrefix(
            javax.xml.stream.XMLStreamWriter xmlWriter,
            String namespace)
            throws javax.xml.stream.XMLStreamException {
            String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();

                while (true) {
                    String uri = nsContext.getNamespaceURI(prefix);

                    if ((uri == null) || (uri.length() == 0)) {
                        break;
                    }

                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {
            private static org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(Factory.class);

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static IT_FINANCE_type0 parse(
                javax.xml.stream.XMLStreamReader reader)
                throws Exception {
                IT_FINANCE_type0 object = new IT_FINANCE_type0();

                int event;
                javax.xml.namespace.QName currentQName = null;
                String nillableValue = null;
                String prefix = "";
                String namespaceuri = "";

                try {
                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    currentQName = reader.getName();

                    if (reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance",
                                "type") != null) {
                        String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "type");

                        if (fullTypeName != null) {
                            String nsPrefix = null;

                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0,
                                        fullTypeName.indexOf(":"));
                            }

                            nsPrefix = (nsPrefix == null) ? "" : nsPrefix;

                            String type = fullTypeName.substring(fullTypeName.indexOf(
                                        ":") + 1);

                            if (!"IT_FINANCE_type0".equals(type)) {
                                //find namespace for the prefix
                                String nsUri = reader.getNamespaceContext()
                                                               .getNamespaceURI(nsPrefix);

                                return (IT_FINANCE_type0) ExtensionMapper.getTypeObject(nsUri,
                                    type, reader);
                            }
                        }
                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "OBJECT").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "OBJECT" +
                                "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setOBJECT(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "CGUARANTOR").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "CGUARANTOR" +
                                "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setCGUARANTOR(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "ZFICCONT_NO").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "ZFICCONT_NO" +
                                "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setZFICCONT_NO(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "FKDAT").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "FKDAT" + "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setFKDAT(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "QZDAT").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "QZDAT" + "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setQZDAT(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "ZZREPAYSTARTD").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "ZZREPAYSTARTD" +
                                "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setZZREPAYSTARTD(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "HTEDAT").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "HTEDAT" +
                                "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setHTEDAT(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "ZZFLD000087").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "ZZFLD000087" +
                                "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setZZFLD000087(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "ZZLOANAMOUNT").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "ZZLOANAMOUNT" +
                                "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setZZLOANAMOUNT(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "ZZLOANSCALE").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "ZZLOANSCALE" +
                                "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setZZLOANSCALE(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "ZZLOANPERIOD").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "ZZLOANPERIOD" +
                                "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setZZLOANPERIOD(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "ZZDEPOSIT").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "ZZDEPOSIT" +
                                "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setZZDEPOSIT(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "ZZAJFACTORAGE").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "ZZAJFACTORAGE" +
                                "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setZZAJFACTORAGE(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "ZZPLEDGEFEE").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "ZZPLEDGEFEE" +
                                "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setZZPLEDGEFEE(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "ZZPREMIUM").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "ZZPREMIUM" +
                                "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setZZPREMIUM(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "ZZDEPOSITINSR").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "ZZDEPOSITINSR" +
                                "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setZZDEPOSITINSR(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "ZZFLD00007K").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "ZZFLD00007K" +
                                "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setZZFLD00007K(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "ZZFLD00008N").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "ZZFLD00008N" +
                                "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setZZFLD00008N(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "ZZACCNAME").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "ZZACCNAME" +
                                "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setZZACCNAME(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "ZZINTSUBSIDY").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "ZZINTSUBSIDY" +
                                "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setZZINTSUBSIDY(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()) {
                        // 2 - A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }
                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new Exception(e);
                }

                return object;
            }
        } //end of factory class
    }

    public static class DT_FinancingContractReq implements org.apache.axis2.databinding.ADBBean {
        /* This type was generated from the piece of schema that had
           name = DT_FinancingContractReq
           Namespace URI = http://sany.com/fcbs/003/financingcontract
           Namespace Prefix = ns1
         */

        /**
         * field for IT_FINANCE
         * This was an Array!
         */
        protected IT_FINANCE_type0[] localIT_FINANCE;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localIT_FINANCETracker = false;

        public boolean isIT_FINANCESpecified() {
            return localIT_FINANCETracker;
        }

        /**
         * Auto generated getter method
         * @return IT_FINANCE_type0[]
         */
        public IT_FINANCE_type0[] getIT_FINANCE() {
            return localIT_FINANCE;
        }

        /**
         * validate the array for IT_FINANCE
         */
        protected void validateIT_FINANCE(IT_FINANCE_type0[] param) {
        }

        /**
         * Auto generated setter method
         * @param param IT_FINANCE
         */
        public void setIT_FINANCE(IT_FINANCE_type0[] param) {
            validateIT_FINANCE(param);

            localIT_FINANCETracker = param != null;

            this.localIT_FINANCE = param;
        }

        /**
         * Auto generated add method for the array for convenience
         * @param param IT_FINANCE_type0
         */
        public void addIT_FINANCE(IT_FINANCE_type0 param) {
            if (localIT_FINANCE == null) {
                localIT_FINANCE = new IT_FINANCE_type0[] {  };
            }

            //update the setting tracker
            localIT_FINANCETracker = true;

            java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localIT_FINANCE);
            list.add(param);
            this.localIT_FINANCE = (IT_FINANCE_type0[]) list.toArray(new IT_FINANCE_type0[list.size()]);
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
            final javax.xml.namespace.QName parentQName,
            final org.apache.axiom.om.OMFactory factory)
            throws org.apache.axis2.databinding.ADBException {
            return factory.createOMElement(new org.apache.axis2.databinding.ADBDataSource(
                    this, parentQName));
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
            javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
            throws javax.xml.stream.XMLStreamException,
                org.apache.axis2.databinding.ADBException {
            String prefix = null;
            String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(),
                xmlWriter);

            if (serializeType) {
                String namespacePrefix = registerPrefix(xmlWriter,
                        "http://sany.com/fcbs/003/financingcontract");

                if ((namespacePrefix != null) &&
                        (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi",
                        "http://www.w3.org/2001/XMLSchema-instance", "type",
                        namespacePrefix + ":DT_FinancingContractReq", xmlWriter);
                } else {
                    writeAttribute("xsi",
                        "http://www.w3.org/2001/XMLSchema-instance", "type",
                        "DT_FinancingContractReq", xmlWriter);
                }
            }

            if (localIT_FINANCETracker) {
                if (localIT_FINANCE != null) {
                    for (int i = 0; i < localIT_FINANCE.length; i++) {
                        if (localIT_FINANCE[i] != null) {
                            localIT_FINANCE[i].serialize(new javax.xml.namespace.QName(
                                    "", "IT_FINANCE"), xmlWriter);
                        } else {
                            // we don't have to do any thing since minOccures is zero
                        }
                    }
                } else {
                    throw new org.apache.axis2.databinding.ADBException(
                        "IT_FINANCE cannot be null!!");
                }
            }

            xmlWriter.writeEndElement();
        }

        private static String generatePrefix(
            String namespace) {
            if (namespace.equals("http://sany.com/fcbs/003/financingcontract")) {
                return "ns1";
            }

            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(String prefix,
                                       String namespace, String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(String prefix,
                                    String namespace, String attName,
                                    String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            String writerPrefix = xmlWriter.getPrefix(namespace);

            if (writerPrefix != null) {
                xmlWriter.writeAttribute(writerPrefix, namespace, attName,
                    attValue);
            } else {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
                xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(String namespace,
                                    String attName, String attValue,
                                    javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                xmlWriter.writeAttribute(registerPrefix(xmlWriter, namespace),
                    namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(String namespace,
                                         String attName, javax.xml.namespace.QName qname,
                                         javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            String attributeNamespace = qname.getNamespaceURI();
            String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }

            String attributeValue;

            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(attributePrefix, namespace, attName,
                    attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            String namespaceURI = qname.getNamespaceURI();

            if (namespaceURI != null) {
                String prefix = xmlWriter.getPrefix(namespaceURI);

                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" +
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            qname));
                }
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
            javax.xml.stream.XMLStreamWriter xmlWriter)
            throws javax.xml.stream.XMLStreamException {
            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                StringBuffer stringToWrite = new StringBuffer();
                String namespaceURI = null;
                String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }

                    namespaceURI = qnames[i].getNamespaceURI();

                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);

                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                    qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                qnames[i]));
                    }
                }

                xmlWriter.writeCharacters(stringToWrite.toString());
            }
        }

        /**
         * Register a namespace prefix
         */
        private String registerPrefix(
            javax.xml.stream.XMLStreamWriter xmlWriter,
            String namespace)
            throws javax.xml.stream.XMLStreamException {
            String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();

                while (true) {
                    String uri = nsContext.getNamespaceURI(prefix);

                    if ((uri == null) || (uri.length() == 0)) {
                        break;
                    }

                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {
            private static org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(Factory.class);

            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static DT_FinancingContractReq parse(
                javax.xml.stream.XMLStreamReader reader)
                throws Exception {
                DT_FinancingContractReq object = new DT_FinancingContractReq();

                int event;
                javax.xml.namespace.QName currentQName = null;
                String nillableValue = null;
                String prefix = "";
                String namespaceuri = "";

                try {
                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    currentQName = reader.getName();

                    if (reader.getAttributeValue(
                                "http://www.w3.org/2001/XMLSchema-instance",
                                "type") != null) {
                        String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "type");

                        if (fullTypeName != null) {
                            String nsPrefix = null;

                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0,
                                        fullTypeName.indexOf(":"));
                            }

                            nsPrefix = (nsPrefix == null) ? "" : nsPrefix;

                            String type = fullTypeName.substring(fullTypeName.indexOf(
                                        ":") + 1);

                            if (!"DT_FinancingContractReq".equals(type)) {
                                //find namespace for the prefix
                                String nsUri = reader.getNamespaceContext()
                                                               .getNamespaceURI(nsPrefix);

                                return (DT_FinancingContractReq) ExtensionMapper.getTypeObject(nsUri,
                                    type, reader);
                            }
                        }
                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    java.util.ArrayList list1 = new java.util.ArrayList();

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "IT_FINANCE").equals(
                                reader.getName())) {
                        // Process the array and step past its final element's end.
                        list1.add(IT_FINANCE_type0.Factory.parse(reader));

                        //loop until we find a start element that is not part of this array
                        boolean loopDone1 = false;

                        while (!loopDone1) {
                            // We should be at the end element, but make sure
                            while (!reader.isEndElement())
                                reader.next();

                            // Step out of this element
                            reader.next();

                            // Step to next element event.
                            while (!reader.isStartElement() &&
                                    !reader.isEndElement())
                                reader.next();

                            if (reader.isEndElement()) {
                                //two continuous end elements means we are exiting the xml structure
                                loopDone1 = true;
                            } else {
                                if (new javax.xml.namespace.QName("",
                                            "IT_FINANCE").equals(
                                            reader.getName())) {
                                    list1.add(IT_FINANCE_type0.Factory.parse(
                                            reader));
                                } else {
                                    loopDone1 = true;
                                }
                            }
                        }

                        // call the converter utility  to convert and set the array
                        object.setIT_FINANCE((IT_FINANCE_type0[]) org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                IT_FINANCE_type0.class, list1));
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement()) {
                        // 2 - A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException(
                            "Unexpected subelement " + reader.getName());
                    }
                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new Exception(e);
                }

                return object;
            }
        } //end of factory class
    }
}
