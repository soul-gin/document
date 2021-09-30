package cn.tongdun.preserver.wsdl;

/**
 * cn.tongdun.preserver.wsdl.OsQueryEquipment_FCBSServiceStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.4  Built on : Oct 21, 2016 (10:47:34 BST)
 */


/*
 *  cn.tongdun.preserver.wsdl.OsQueryEquipment_FCBSServiceStub java implementation
 */
public class OsQueryEquipment_FCBSServiceStub extends org.apache.axis2.client.Stub {
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
    public OsQueryEquipment_FCBSServiceStub(
        org.apache.axis2.context.ConfigurationContext configurationContext,
        String targetEndpoint) throws org.apache.axis2.AxisFault {
        this(configurationContext, targetEndpoint, false);
    }

    /**
     * Constructor that takes in a configContext  and useseperate listner
     */
    public OsQueryEquipment_FCBSServiceStub(
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
    public OsQueryEquipment_FCBSServiceStub(
        org.apache.axis2.context.ConfigurationContext configurationContext)
        throws org.apache.axis2.AxisFault {
        this(configurationContext,
            "http://podev01v-ap.sanygroup.com:50000/XISOAPAdapter/MessageServlet?senderParty=&senderService=Srv_FCBS&receiverParty=&receiverService=&interface=osQueryEquipment_FCBS&interfaceNamespace=http%3A%2F%2Fsany.com%2Ffcbs%2F008%2Fqueryequipment");
    }

    /**
     * Default Constructor
     */
    public OsQueryEquipment_FCBSServiceStub() throws org.apache.axis2.AxisFault {
        this(
            "http://podev01v-ap.sanygroup.com:50000/XISOAPAdapter/MessageServlet?senderParty=&senderService=Srv_FCBS&receiverParty=&receiverService=&interface=osQueryEquipment_FCBS&interfaceNamespace=http%3A%2F%2Fsany.com%2Ffcbs%2F008%2Fqueryequipment");
    }

    /**
     * Constructor taking the target endpoint
     */
    public OsQueryEquipment_FCBSServiceStub(String targetEndpoint)
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
                "OsQueryEquipment_FCBSService" + getUniqueSuffix());
        addAnonymousOperations();

        //creating the operations
        org.apache.axis2.description.AxisOperation __operation;

        _operations = new org.apache.axis2.description.AxisOperation[1];

        __operation = new org.apache.axis2.description.OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName(
                "http://sany.com/fcbs/008/queryequipment",
                "osQueryEquipment_FCBS"));
        _service.addOperation(__operation);

        _operations[0] = __operation;
    }

    //populates the faults
    private void populateFaults() {
    }

    /**
     * Auto generated method signature
     *
     * @see cn.tongdun.preserver.util.OsQueryEquipment_FCBSService#osQueryEquipment_FCBS
     * @param mT_QueryEquipmentReq0
     */
    public OsQueryEquipment_FCBSServiceStub.MT_QueryEquipmentResp osQueryEquipment_FCBS(
        OsQueryEquipment_FCBSServiceStub.MT_QueryEquipmentReq mT_QueryEquipmentReq0)
        throws java.rmi.RemoteException {
        org.apache.axis2.context.MessageContext _messageContext = null;

        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
            _operationClient.getOptions()
                            .setAction("http://sap.com/xi/WebService/soap1.1");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient,
                org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions()
                                                        .getSoapVersionURI()),
                    mT_QueryEquipmentReq0,
                    optimizeContent(
                        new javax.xml.namespace.QName(
                            "http://sany.com/fcbs/008/queryequipment",
                            "osQueryEquipment_FCBS")),
                    new javax.xml.namespace.QName(
                        "http://sany.com/fcbs/008/queryequipment",
                        "MT_QueryEquipmentReq"));

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
                    OsQueryEquipment_FCBSServiceStub.MT_QueryEquipmentResp.class);

            return (OsQueryEquipment_FCBSServiceStub.MT_QueryEquipmentResp) object;
        } catch (org.apache.axis2.AxisFault f) {
            org.apache.axiom.om.OMElement faultElt = f.getDetail();

            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(
                            new org.apache.axis2.client.FaultMapKey(
                                faultElt.getQName(), "osQueryEquipment_FCBS"))) {
                    //make the fault by reflection
                    try {
                        String exceptionClassName = (String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(
                                    faultElt.getQName(), "osQueryEquipment_FCBS"));
                        Class exceptionClass = Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        Exception ex = (Exception) constructor.newInstance(f.getMessage());

                        //message class
                        String messageClassName = (String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(
                                    faultElt.getQName(), "osQueryEquipment_FCBS"));
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
     * @see cn.tongdun.preserver.util.OsQueryEquipment_FCBSService#startosQueryEquipment_FCBS
     * @param mT_QueryEquipmentReq0
     */
    public void startosQueryEquipment_FCBS(
        OsQueryEquipment_FCBSServiceStub.MT_QueryEquipmentReq mT_QueryEquipmentReq0,
        final OsQueryEquipment_FCBSServiceCallbackHandler callback)
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
                mT_QueryEquipmentReq0,
                optimizeContent(
                    new javax.xml.namespace.QName(
                        "http://sany.com/fcbs/008/queryequipment",
                        "osQueryEquipment_FCBS")),
                new javax.xml.namespace.QName(
                    "http://sany.com/fcbs/008/queryequipment",
                    "MT_QueryEquipmentReq"));

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
                                OsQueryEquipment_FCBSServiceStub.MT_QueryEquipmentResp.class);
                        callback.receiveResultosQueryEquipment_FCBS((OsQueryEquipment_FCBSServiceStub.MT_QueryEquipmentResp) object);
                    } catch (org.apache.axis2.AxisFault e) {
                        callback.receiveErrorosQueryEquipment_FCBS(e);
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
                                            "osQueryEquipment_FCBS"))) {
                                //make the fault by reflection
                                try {
                                    String exceptionClassName = (String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(
                                                faultElt.getQName(),
                                                "osQueryEquipment_FCBS"));
                                    Class exceptionClass = Class.forName(exceptionClassName);
                                    java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                    Exception ex = (Exception) constructor.newInstance(f.getMessage());

                                    //message class
                                    String messageClassName = (String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(
                                                faultElt.getQName(),
                                                "osQueryEquipment_FCBS"));
                                    Class messageClass = Class.forName(messageClassName);
                                    Object messageObject = fromOM(faultElt,
                                            messageClass);
                                    java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                            new Class[] { messageClass });
                                    m.invoke(ex,
                                        new Object[] { messageObject });

                                    callback.receiveErrorosQueryEquipment_FCBS(new java.rmi.RemoteException(
                                            ex.getMessage(), ex));
                                } catch (ClassCastException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorosQueryEquipment_FCBS(f);
                                } catch (ClassNotFoundException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorosQueryEquipment_FCBS(f);
                                } catch (NoSuchMethodException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorosQueryEquipment_FCBS(f);
                                } catch (java.lang.reflect.InvocationTargetException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorosQueryEquipment_FCBS(f);
                                } catch (IllegalAccessException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorosQueryEquipment_FCBS(f);
                                } catch (InstantiationException e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorosQueryEquipment_FCBS(f);
                                } catch (org.apache.axis2.AxisFault e) {
                                    // we cannot intantiate the class - throw the original Axis fault
                                    callback.receiveErrorosQueryEquipment_FCBS(f);
                                }
                            } else {
                                callback.receiveErrorosQueryEquipment_FCBS(f);
                            }
                        } else {
                            callback.receiveErrorosQueryEquipment_FCBS(f);
                        }
                    } else {
                        callback.receiveErrorosQueryEquipment_FCBS(error);
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
                        callback.receiveErrorosQueryEquipment_FCBS(axisFault);
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
        OsQueryEquipment_FCBSServiceStub.MT_QueryEquipmentReq param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(OsQueryEquipment_FCBSServiceStub.MT_QueryEquipmentReq.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        OsQueryEquipment_FCBSServiceStub.MT_QueryEquipmentResp param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(OsQueryEquipment_FCBSServiceStub.MT_QueryEquipmentResp.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        OsQueryEquipment_FCBSServiceStub.MT_QueryEquipmentReq param,
        boolean optimizeContent, javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    OsQueryEquipment_FCBSServiceStub.MT_QueryEquipmentReq.MY_QNAME,
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
            if (OsQueryEquipment_FCBSServiceStub.MT_QueryEquipmentReq.class.equals(
                        type)) {
                return OsQueryEquipment_FCBSServiceStub.MT_QueryEquipmentReq.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (OsQueryEquipment_FCBSServiceStub.MT_QueryEquipmentResp.class.equals(
                        type)) {
                return OsQueryEquipment_FCBSServiceStub.MT_QueryEquipmentResp.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }
        } catch (Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

        return null;
    }

    //http://podev01v-ap.sanygroup.com:50000/XISOAPAdapter/MessageServlet?senderParty=&senderService=Srv_FCBS&receiverParty=&receiverService=&interface=osQueryEquipment_FCBS&interfaceNamespace=http%3A%2F%2Fsany.com%2Ffcbs%2F008%2Fqueryequipment
    public static class ES_RETURN_type0 implements org.apache.axis2.databinding.ADBBean {
        /* This type was generated from the piece of schema that had
           name = ES_RETURN_type0
           Namespace URI = http://sany.com/fcbs/008/queryequipment
           Namespace Prefix = ns1
         */

        /**
         * field for TYPE
         */
        protected String localTYPE;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localTYPETracker = false;

        /**
         * field for MESSAGE
         */
        protected String localMESSAGE;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localMESSAGETracker = false;

        public boolean isTYPESpecified() {
            return localTYPETracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getTYPE() {
            return localTYPE;
        }

        /**
         * Auto generated setter method
         * @param param TYPE
         */
        public void setTYPE(String param) {
            localTYPETracker = param != null;

            this.localTYPE = param;
        }

        public boolean isMESSAGESpecified() {
            return localMESSAGETracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getMESSAGE() {
            return localMESSAGE;
        }

        /**
         * Auto generated setter method
         * @param param MESSAGE
         */
        public void setMESSAGE(String param) {
            localMESSAGETracker = param != null;

            this.localMESSAGE = param;
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
                        "http://sany.com/fcbs/008/queryequipment");

                if ((namespacePrefix != null) &&
                        (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi",
                        "http://www.w3.org/2001/XMLSchema-instance", "type",
                        namespacePrefix + ":ES_RETURN_type0", xmlWriter);
                } else {
                    writeAttribute("xsi",
                        "http://www.w3.org/2001/XMLSchema-instance", "type",
                        "ES_RETURN_type0", xmlWriter);
                }
            }

            if (localTYPETracker) {
                namespace = "";
                writeStartElement(null, namespace, "TYPE", xmlWriter);

                if (localTYPE == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "TYPE cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localTYPE);
                }

                xmlWriter.writeEndElement();
            }

            if (localMESSAGETracker) {
                namespace = "";
                writeStartElement(null, namespace, "MESSAGE", xmlWriter);

                if (localMESSAGE == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "MESSAGE cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localMESSAGE);
                }

                xmlWriter.writeEndElement();
            }

            xmlWriter.writeEndElement();
        }

        private static String generatePrefix(
            String namespace) {
            if (namespace.equals("http://sany.com/fcbs/008/queryequipment")) {
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
            public static ES_RETURN_type0 parse(
                javax.xml.stream.XMLStreamReader reader)
                throws Exception {
                ES_RETURN_type0 object = new ES_RETURN_type0();

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

                            if (!"ES_RETURN_type0".equals(type)) {
                                //find namespace for the prefix
                                String nsUri = reader.getNamespaceContext()
                                                               .getNamespaceURI(nsPrefix);

                                return (ES_RETURN_type0) ExtensionMapper.getTypeObject(nsUri,
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

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "TYPE").equals(
                                reader.getName())) ||
                            new javax.xml.namespace.QName("", "TYPE").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "TYPE" + "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setTYPE(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "MESSAGE").equals(
                                reader.getName())) ||
                            new javax.xml.namespace.QName("", "MESSAGE").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "MESSAGE" +
                                "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setMESSAGE(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
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

    public static class DT_QueryEquipmentResp implements org.apache.axis2.databinding.ADBBean {
        /* This type was generated from the piece of schema that had
           name = DT_QueryEquipmentResp
           Namespace URI = http://sany.com/fcbs/008/queryequipment
           Namespace Prefix = ns1
         */

        /**
         * field for ET_EQUIPMENT
         * This was an Array!
         */
        protected ET_EQUIPMENT_type0[] localET_EQUIPMENT;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localET_EQUIPMENTTracker = false;

        /**
         * field for ES_RETURN
         */
        protected ES_RETURN_type0 localES_RETURN;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localES_RETURNTracker = false;

        public boolean isET_EQUIPMENTSpecified() {
            return localET_EQUIPMENTTracker;
        }

        /**
         * Auto generated getter method
         * @return ET_EQUIPMENT_type0[]
         */
        public ET_EQUIPMENT_type0[] getET_EQUIPMENT() {
            return localET_EQUIPMENT;
        }

        /**
         * validate the array for ET_EQUIPMENT
         */
        protected void validateET_EQUIPMENT(ET_EQUIPMENT_type0[] param) {
        }

        /**
         * Auto generated setter method
         * @param param ET_EQUIPMENT
         */
        public void setET_EQUIPMENT(ET_EQUIPMENT_type0[] param) {
            validateET_EQUIPMENT(param);

            localET_EQUIPMENTTracker = param != null;

            this.localET_EQUIPMENT = param;
        }

        /**
         * Auto generated add method for the array for convenience
         * @param param ET_EQUIPMENT_type0
         */
        public void addET_EQUIPMENT(ET_EQUIPMENT_type0 param) {
            if (localET_EQUIPMENT == null) {
                localET_EQUIPMENT = new ET_EQUIPMENT_type0[] {  };
            }

            //update the setting tracker
            localET_EQUIPMENTTracker = true;

            java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localET_EQUIPMENT);
            list.add(param);
            this.localET_EQUIPMENT = (ET_EQUIPMENT_type0[]) list.toArray(new ET_EQUIPMENT_type0[list.size()]);
        }

        public boolean isES_RETURNSpecified() {
            return localES_RETURNTracker;
        }

        /**
         * Auto generated getter method
         * @return ES_RETURN_type0
         */
        public ES_RETURN_type0 getES_RETURN() {
            return localES_RETURN;
        }

        /**
         * Auto generated setter method
         * @param param ES_RETURN
         */
        public void setES_RETURN(ES_RETURN_type0 param) {
            localES_RETURNTracker = param != null;

            this.localES_RETURN = param;
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
                        "http://sany.com/fcbs/008/queryequipment");

                if ((namespacePrefix != null) &&
                        (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi",
                        "http://www.w3.org/2001/XMLSchema-instance", "type",
                        namespacePrefix + ":DT_QueryEquipmentResp", xmlWriter);
                } else {
                    writeAttribute("xsi",
                        "http://www.w3.org/2001/XMLSchema-instance", "type",
                        "DT_QueryEquipmentResp", xmlWriter);
                }
            }

            if (localET_EQUIPMENTTracker) {
                if (localET_EQUIPMENT != null) {
                    for (int i = 0; i < localET_EQUIPMENT.length; i++) {
                        if (localET_EQUIPMENT[i] != null) {
                            localET_EQUIPMENT[i].serialize(new javax.xml.namespace.QName(
                                    "", "ET_EQUIPMENT"), xmlWriter);
                        } else {
                            // we don't have to do any thing since minOccures is zero
                        }
                    }
                } else {
                    throw new org.apache.axis2.databinding.ADBException(
                        "ET_EQUIPMENT cannot be null!!");
                }
            }

            if (localES_RETURNTracker) {
                if (localES_RETURN == null) {
                    throw new org.apache.axis2.databinding.ADBException(
                        "ES_RETURN cannot be null!!");
                }

                localES_RETURN.serialize(new javax.xml.namespace.QName("",
                        "ES_RETURN"), xmlWriter);
            }

            xmlWriter.writeEndElement();
        }

        private static String generatePrefix(
            String namespace) {
            if (namespace.equals("http://sany.com/fcbs/008/queryequipment")) {
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
            public static DT_QueryEquipmentResp parse(
                javax.xml.stream.XMLStreamReader reader)
                throws Exception {
                DT_QueryEquipmentResp object = new DT_QueryEquipmentResp();

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

                            if (!"DT_QueryEquipmentResp".equals(type)) {
                                //find namespace for the prefix
                                String nsUri = reader.getNamespaceContext()
                                                               .getNamespaceURI(nsPrefix);

                                return (DT_QueryEquipmentResp) ExtensionMapper.getTypeObject(nsUri,
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

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "ET_EQUIPMENT").equals(
                                reader.getName())) ||
                            new javax.xml.namespace.QName("", "ET_EQUIPMENT").equals(
                                reader.getName())) {
                        // Process the array and step past its final element's end.
                        list1.add(ET_EQUIPMENT_type0.Factory.parse(reader));

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
                                            "ET_EQUIPMENT").equals(
                                            reader.getName())) {
                                    list1.add(ET_EQUIPMENT_type0.Factory.parse(
                                            reader));
                                } else {
                                    loopDone1 = true;
                                }
                            }
                        }

                        // call the converter utility  to convert and set the array
                        object.setET_EQUIPMENT((ET_EQUIPMENT_type0[]) org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                ET_EQUIPMENT_type0.class, list1));
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "ES_RETURN").equals(
                                reader.getName())) ||
                            new javax.xml.namespace.QName("", "ES_RETURN").equals(
                                reader.getName())) {
                        object.setES_RETURN(ES_RETURN_type0.Factory.parse(
                                reader));

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

    public static class ET_EQUIPMENT_type0 implements org.apache.axis2.databinding.ADBBean {
        /* This type was generated from the piece of schema that had
           name = ET_EQUIPMENT_type0
           Namespace URI = http://sany.com/fcbs/008/queryequipment
           Namespace Prefix = ns1
         */

        /**
         * field for PRODUCT_ID
         */
        protected String localPRODUCT_ID;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localPRODUCT_IDTracker = false;

        /**
         * field for SHORT_TEXT
         */
        protected String localSHORT_TEXT;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localSHORT_TEXTTracker = false;

        /**
         * field for SYBBH
         */
        protected String localSYBBH;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localSYBBHTracker = false;

        /**
         * field for SYBBH_DESC
         */
        protected String localSYBBH_DESC;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localSYBBH_DESCTracker = false;

        /**
         * field for MYGMR
         */
        protected String localMYGMR;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localMYGMRTracker = false;

        /**
         * field for MYGMRMC
         */
        protected String localMYGMRMC;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localMYGMRMCTracker = false;

        /**
         * field for ZZPERSONALID
         */
        protected String localZZPERSONALID;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localZZPERSONALIDTracker = false;

        /**
         * field for ZZORGID
         */
        protected String localZZORGID;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localZZORGIDTracker = false;

        /**
         * field for TYPE
         */
        protected String localTYPE;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localTYPETracker = false;

        /**
         * field for ZEHD_SPART
         */
        protected String localZEHD_SPART;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localZEHD_SPARTTracker = false;

        /**
         * field for ZEHD_SPARTDESC
         */
        protected String localZEHD_SPARTDESC;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localZEHD_SPARTDESCTracker = false;

        /**
         * field for ZEJQVO
         */
        protected String localZEJQVO;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localZEJQVOTracker = false;

        /**
         * field for ZEJJDATE
         */
        protected String localZEJJDATE;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localZEJJDATETracker = false;

        /**
         * field for ZEBXZC
         */
        protected String localZEBXZC;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localZEBXZCTracker = false;

        /**
         * field for ZEZBSTA
         */
        protected String localZEZBSTA;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localZEZBSTATracker = false;

        /**
         * field for ZEHD_SBUSTA
         */
        protected String localZEHD_SBUSTA;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localZEHD_SBUSTATracker = false;

        /**
         * field for ZEHD_YC
         */
        protected String localZEHD_YC;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localZEHD_YCTracker = false;

        /**
         * field for ZEDS_LJLC
         */
        protected String localZEDS_LJLC;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localZEDS_LJLCTracker = false;

        /**
         * field for ZEDS_LJYXF
         */
        protected String localZEDS_LJYXF;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localZEDS_LJYXFTracker = false;

        /**
         * field for ZEDS_LJYXT
         */
        protected String localZEDS_LJYXT;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localZEDS_LJYXTTracker = false;

        /**
         * field for ZEGPSAREA
         */
        protected String localZEGPSAREA;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localZEGPSAREATracker = false;

        /**
         * field for ZEEQSTA
         */
        protected String localZEEQSTA;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localZEEQSTATracker = false;

        /**
         * field for ZEGPS_WORKMILES
         */
        protected String localZEGPS_WORKMILES;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localZEGPS_WORKMILESTracker = false;

        /**
         * field for ZEGPS_WORKTIME
         */
        protected String localZEGPS_WORKTIME;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localZEGPS_WORKTIMETracker = false;

        /**
         * field for ZEGPS_WORKVOLUME
         */
        protected String localZEGPS_WORKVOLUME;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localZEGPS_WORKVOLUMETracker = false;

        /**
         * field for ZEGPS_WORKTIME_DATE
         */
        protected String localZEGPS_WORKTIME_DATE;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localZEGPS_WORKTIME_DATETracker = false;

        public boolean isPRODUCT_IDSpecified() {
            return localPRODUCT_IDTracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getPRODUCT_ID() {
            return localPRODUCT_ID;
        }

        /**
         * Auto generated setter method
         * @param param PRODUCT_ID
         */
        public void setPRODUCT_ID(String param) {
            localPRODUCT_IDTracker = param != null;

            this.localPRODUCT_ID = param;
        }

        public boolean isSHORT_TEXTSpecified() {
            return localSHORT_TEXTTracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getSHORT_TEXT() {
            return localSHORT_TEXT;
        }

        /**
         * Auto generated setter method
         * @param param SHORT_TEXT
         */
        public void setSHORT_TEXT(String param) {
            localSHORT_TEXTTracker = param != null;

            this.localSHORT_TEXT = param;
        }

        public boolean isSYBBHSpecified() {
            return localSYBBHTracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getSYBBH() {
            return localSYBBH;
        }

        /**
         * Auto generated setter method
         * @param param SYBBH
         */
        public void setSYBBH(String param) {
            localSYBBHTracker = param != null;

            this.localSYBBH = param;
        }

        public boolean isSYBBH_DESCSpecified() {
            return localSYBBH_DESCTracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getSYBBH_DESC() {
            return localSYBBH_DESC;
        }

        /**
         * Auto generated setter method
         * @param param SYBBH_DESC
         */
        public void setSYBBH_DESC(String param) {
            localSYBBH_DESCTracker = param != null;

            this.localSYBBH_DESC = param;
        }

        public boolean isMYGMRSpecified() {
            return localMYGMRTracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getMYGMR() {
            return localMYGMR;
        }

        /**
         * Auto generated setter method
         * @param param MYGMR
         */
        public void setMYGMR(String param) {
            localMYGMRTracker = param != null;

            this.localMYGMR = param;
        }

        public boolean isMYGMRMCSpecified() {
            return localMYGMRMCTracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getMYGMRMC() {
            return localMYGMRMC;
        }

        /**
         * Auto generated setter method
         * @param param MYGMRMC
         */
        public void setMYGMRMC(String param) {
            localMYGMRMCTracker = param != null;

            this.localMYGMRMC = param;
        }

        public boolean isZZPERSONALIDSpecified() {
            return localZZPERSONALIDTracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getZZPERSONALID() {
            return localZZPERSONALID;
        }

        /**
         * Auto generated setter method
         * @param param ZZPERSONALID
         */
        public void setZZPERSONALID(String param) {
            localZZPERSONALIDTracker = param != null;

            this.localZZPERSONALID = param;
        }

        public boolean isZZORGIDSpecified() {
            return localZZORGIDTracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getZZORGID() {
            return localZZORGID;
        }

        /**
         * Auto generated setter method
         * @param param ZZORGID
         */
        public void setZZORGID(String param) {
            localZZORGIDTracker = param != null;

            this.localZZORGID = param;
        }

        public boolean isTYPESpecified() {
            return localTYPETracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getTYPE() {
            return localTYPE;
        }

        /**
         * Auto generated setter method
         * @param param TYPE
         */
        public void setTYPE(String param) {
            localTYPETracker = param != null;

            this.localTYPE = param;
        }

        public boolean isZEHD_SPARTSpecified() {
            return localZEHD_SPARTTracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getZEHD_SPART() {
            return localZEHD_SPART;
        }

        /**
         * Auto generated setter method
         * @param param ZEHD_SPART
         */
        public void setZEHD_SPART(String param) {
            localZEHD_SPARTTracker = param != null;

            this.localZEHD_SPART = param;
        }

        public boolean isZEHD_SPARTDESCSpecified() {
            return localZEHD_SPARTDESCTracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getZEHD_SPARTDESC() {
            return localZEHD_SPARTDESC;
        }

        /**
         * Auto generated setter method
         * @param param ZEHD_SPARTDESC
         */
        public void setZEHD_SPARTDESC(String param) {
            localZEHD_SPARTDESCTracker = param != null;

            this.localZEHD_SPARTDESC = param;
        }

        public boolean isZEJQVOSpecified() {
            return localZEJQVOTracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getZEJQVO() {
            return localZEJQVO;
        }

        /**
         * Auto generated setter method
         * @param param ZEJQVO
         */
        public void setZEJQVO(String param) {
            localZEJQVOTracker = param != null;

            this.localZEJQVO = param;
        }

        public boolean isZEJJDATESpecified() {
            return localZEJJDATETracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getZEJJDATE() {
            return localZEJJDATE;
        }

        /**
         * Auto generated setter method
         * @param param ZEJJDATE
         */
        public void setZEJJDATE(String param) {
            localZEJJDATETracker = param != null;

            this.localZEJJDATE = param;
        }

        public boolean isZEBXZCSpecified() {
            return localZEBXZCTracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getZEBXZC() {
            return localZEBXZC;
        }

        /**
         * Auto generated setter method
         * @param param ZEBXZC
         */
        public void setZEBXZC(String param) {
            localZEBXZCTracker = param != null;

            this.localZEBXZC = param;
        }

        public boolean isZEZBSTASpecified() {
            return localZEZBSTATracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getZEZBSTA() {
            return localZEZBSTA;
        }

        /**
         * Auto generated setter method
         * @param param ZEZBSTA
         */
        public void setZEZBSTA(String param) {
            localZEZBSTATracker = param != null;

            this.localZEZBSTA = param;
        }

        public boolean isZEHD_SBUSTASpecified() {
            return localZEHD_SBUSTATracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getZEHD_SBUSTA() {
            return localZEHD_SBUSTA;
        }

        /**
         * Auto generated setter method
         * @param param ZEHD_SBUSTA
         */
        public void setZEHD_SBUSTA(String param) {
            localZEHD_SBUSTATracker = param != null;

            this.localZEHD_SBUSTA = param;
        }

        public boolean isZEHD_YCSpecified() {
            return localZEHD_YCTracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getZEHD_YC() {
            return localZEHD_YC;
        }

        /**
         * Auto generated setter method
         * @param param ZEHD_YC
         */
        public void setZEHD_YC(String param) {
            localZEHD_YCTracker = param != null;

            this.localZEHD_YC = param;
        }

        public boolean isZEDS_LJLCSpecified() {
            return localZEDS_LJLCTracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getZEDS_LJLC() {
            return localZEDS_LJLC;
        }

        /**
         * Auto generated setter method
         * @param param ZEDS_LJLC
         */
        public void setZEDS_LJLC(String param) {
            localZEDS_LJLCTracker = param != null;

            this.localZEDS_LJLC = param;
        }

        public boolean isZEDS_LJYXFSpecified() {
            return localZEDS_LJYXFTracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getZEDS_LJYXF() {
            return localZEDS_LJYXF;
        }

        /**
         * Auto generated setter method
         * @param param ZEDS_LJYXF
         */
        public void setZEDS_LJYXF(String param) {
            localZEDS_LJYXFTracker = param != null;

            this.localZEDS_LJYXF = param;
        }

        public boolean isZEDS_LJYXTSpecified() {
            return localZEDS_LJYXTTracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getZEDS_LJYXT() {
            return localZEDS_LJYXT;
        }

        /**
         * Auto generated setter method
         * @param param ZEDS_LJYXT
         */
        public void setZEDS_LJYXT(String param) {
            localZEDS_LJYXTTracker = param != null;

            this.localZEDS_LJYXT = param;
        }

        public boolean isZEGPSAREASpecified() {
            return localZEGPSAREATracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getZEGPSAREA() {
            return localZEGPSAREA;
        }

        /**
         * Auto generated setter method
         * @param param ZEGPSAREA
         */
        public void setZEGPSAREA(String param) {
            localZEGPSAREATracker = param != null;

            this.localZEGPSAREA = param;
        }

        public boolean isZEEQSTASpecified() {
            return localZEEQSTATracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getZEEQSTA() {
            return localZEEQSTA;
        }

        /**
         * Auto generated setter method
         * @param param ZEEQSTA
         */
        public void setZEEQSTA(String param) {
            localZEEQSTATracker = param != null;

            this.localZEEQSTA = param;
        }

        public boolean isZEGPS_WORKMILESSpecified() {
            return localZEGPS_WORKMILESTracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getZEGPS_WORKMILES() {
            return localZEGPS_WORKMILES;
        }

        /**
         * Auto generated setter method
         * @param param ZEGPS_WORKMILES
         */
        public void setZEGPS_WORKMILES(String param) {
            localZEGPS_WORKMILESTracker = param != null;

            this.localZEGPS_WORKMILES = param;
        }

        public boolean isZEGPS_WORKTIMESpecified() {
            return localZEGPS_WORKTIMETracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getZEGPS_WORKTIME() {
            return localZEGPS_WORKTIME;
        }

        /**
         * Auto generated setter method
         * @param param ZEGPS_WORKTIME
         */
        public void setZEGPS_WORKTIME(String param) {
            localZEGPS_WORKTIMETracker = param != null;

            this.localZEGPS_WORKTIME = param;
        }

        public boolean isZEGPS_WORKVOLUMESpecified() {
            return localZEGPS_WORKVOLUMETracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getZEGPS_WORKVOLUME() {
            return localZEGPS_WORKVOLUME;
        }

        /**
         * Auto generated setter method
         * @param param ZEGPS_WORKVOLUME
         */
        public void setZEGPS_WORKVOLUME(String param) {
            localZEGPS_WORKVOLUMETracker = param != null;

            this.localZEGPS_WORKVOLUME = param;
        }

        public boolean isZEGPS_WORKTIME_DATESpecified() {
            return localZEGPS_WORKTIME_DATETracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getZEGPS_WORKTIME_DATE() {
            return localZEGPS_WORKTIME_DATE;
        }

        /**
         * Auto generated setter method
         * @param param ZEGPS_WORKTIME_DATE
         */
        public void setZEGPS_WORKTIME_DATE(String param) {
            localZEGPS_WORKTIME_DATETracker = param != null;

            this.localZEGPS_WORKTIME_DATE = param;
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
                        "http://sany.com/fcbs/008/queryequipment");

                if ((namespacePrefix != null) &&
                        (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi",
                        "http://www.w3.org/2001/XMLSchema-instance", "type",
                        namespacePrefix + ":ET_EQUIPMENT_type0", xmlWriter);
                } else {
                    writeAttribute("xsi",
                        "http://www.w3.org/2001/XMLSchema-instance", "type",
                        "ET_EQUIPMENT_type0", xmlWriter);
                }
            }

            if (localPRODUCT_IDTracker) {
                namespace = "";
                writeStartElement(null, namespace, "PRODUCT_ID", xmlWriter);

                if (localPRODUCT_ID == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "PRODUCT_ID cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localPRODUCT_ID);
                }

                xmlWriter.writeEndElement();
            }

            if (localSHORT_TEXTTracker) {
                namespace = "";
                writeStartElement(null, namespace, "SHORT_TEXT", xmlWriter);

                if (localSHORT_TEXT == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "SHORT_TEXT cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localSHORT_TEXT);
                }

                xmlWriter.writeEndElement();
            }

            if (localSYBBHTracker) {
                namespace = "";
                writeStartElement(null, namespace, "SYBBH", xmlWriter);

                if (localSYBBH == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "SYBBH cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localSYBBH);
                }

                xmlWriter.writeEndElement();
            }

            if (localSYBBH_DESCTracker) {
                namespace = "";
                writeStartElement(null, namespace, "SYBBH_DESC", xmlWriter);

                if (localSYBBH_DESC == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "SYBBH_DESC cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localSYBBH_DESC);
                }

                xmlWriter.writeEndElement();
            }

            if (localMYGMRTracker) {
                namespace = "";
                writeStartElement(null, namespace, "MYGMR", xmlWriter);

                if (localMYGMR == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "MYGMR cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localMYGMR);
                }

                xmlWriter.writeEndElement();
            }

            if (localMYGMRMCTracker) {
                namespace = "";
                writeStartElement(null, namespace, "MYGMRMC", xmlWriter);

                if (localMYGMRMC == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "MYGMRMC cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localMYGMRMC);
                }

                xmlWriter.writeEndElement();
            }

            if (localZZPERSONALIDTracker) {
                namespace = "";
                writeStartElement(null, namespace, "ZZPERSONALID", xmlWriter);

                if (localZZPERSONALID == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "ZZPERSONALID cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localZZPERSONALID);
                }

                xmlWriter.writeEndElement();
            }

            if (localZZORGIDTracker) {
                namespace = "";
                writeStartElement(null, namespace, "ZZORGID", xmlWriter);

                if (localZZORGID == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "ZZORGID cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localZZORGID);
                }

                xmlWriter.writeEndElement();
            }

            if (localTYPETracker) {
                namespace = "";
                writeStartElement(null, namespace, "TYPE", xmlWriter);

                if (localTYPE == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "TYPE cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localTYPE);
                }

                xmlWriter.writeEndElement();
            }

            if (localZEHD_SPARTTracker) {
                namespace = "";
                writeStartElement(null, namespace, "ZEHD_SPART", xmlWriter);

                if (localZEHD_SPART == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "ZEHD_SPART cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localZEHD_SPART);
                }

                xmlWriter.writeEndElement();
            }

            if (localZEHD_SPARTDESCTracker) {
                namespace = "";
                writeStartElement(null, namespace, "ZEHD_SPARTDESC", xmlWriter);

                if (localZEHD_SPARTDESC == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "ZEHD_SPARTDESC cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localZEHD_SPARTDESC);
                }

                xmlWriter.writeEndElement();
            }

            if (localZEJQVOTracker) {
                namespace = "";
                writeStartElement(null, namespace, "ZEJQVO", xmlWriter);

                if (localZEJQVO == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "ZEJQVO cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localZEJQVO);
                }

                xmlWriter.writeEndElement();
            }

            if (localZEJJDATETracker) {
                namespace = "";
                writeStartElement(null, namespace, "ZEJJDATE", xmlWriter);

                if (localZEJJDATE == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "ZEJJDATE cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localZEJJDATE);
                }

                xmlWriter.writeEndElement();
            }

            if (localZEBXZCTracker) {
                namespace = "";
                writeStartElement(null, namespace, "ZEBXZC", xmlWriter);

                if (localZEBXZC == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "ZEBXZC cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localZEBXZC);
                }

                xmlWriter.writeEndElement();
            }

            if (localZEZBSTATracker) {
                namespace = "";
                writeStartElement(null, namespace, "ZEZBSTA", xmlWriter);

                if (localZEZBSTA == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "ZEZBSTA cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localZEZBSTA);
                }

                xmlWriter.writeEndElement();
            }

            if (localZEHD_SBUSTATracker) {
                namespace = "";
                writeStartElement(null, namespace, "ZEHD_SBUSTA", xmlWriter);

                if (localZEHD_SBUSTA == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "ZEHD_SBUSTA cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localZEHD_SBUSTA);
                }

                xmlWriter.writeEndElement();
            }

            if (localZEHD_YCTracker) {
                namespace = "";
                writeStartElement(null, namespace, "ZEHD_YC", xmlWriter);

                if (localZEHD_YC == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "ZEHD_YC cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localZEHD_YC);
                }

                xmlWriter.writeEndElement();
            }

            if (localZEDS_LJLCTracker) {
                namespace = "";
                writeStartElement(null, namespace, "ZEDS_LJLC", xmlWriter);

                if (localZEDS_LJLC == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "ZEDS_LJLC cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localZEDS_LJLC);
                }

                xmlWriter.writeEndElement();
            }

            if (localZEDS_LJYXFTracker) {
                namespace = "";
                writeStartElement(null, namespace, "ZEDS_LJYXF", xmlWriter);

                if (localZEDS_LJYXF == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "ZEDS_LJYXF cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localZEDS_LJYXF);
                }

                xmlWriter.writeEndElement();
            }

            if (localZEDS_LJYXTTracker) {
                namespace = "";
                writeStartElement(null, namespace, "ZEDS_LJYXT", xmlWriter);

                if (localZEDS_LJYXT == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "ZEDS_LJYXT cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localZEDS_LJYXT);
                }

                xmlWriter.writeEndElement();
            }

            if (localZEGPSAREATracker) {
                namespace = "";
                writeStartElement(null, namespace, "ZEGPSAREA", xmlWriter);

                if (localZEGPSAREA == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "ZEGPSAREA cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localZEGPSAREA);
                }

                xmlWriter.writeEndElement();
            }

            if (localZEEQSTATracker) {
                namespace = "";
                writeStartElement(null, namespace, "ZEEQSTA", xmlWriter);

                if (localZEEQSTA == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "ZEEQSTA cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localZEEQSTA);
                }

                xmlWriter.writeEndElement();
            }

            if (localZEGPS_WORKMILESTracker) {
                namespace = "";
                writeStartElement(null, namespace, "ZEGPS_WORKMILES", xmlWriter);

                if (localZEGPS_WORKMILES == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "ZEGPS_WORKMILES cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localZEGPS_WORKMILES);
                }

                xmlWriter.writeEndElement();
            }

            if (localZEGPS_WORKTIMETracker) {
                namespace = "";
                writeStartElement(null, namespace, "ZEGPS_WORKTIME", xmlWriter);

                if (localZEGPS_WORKTIME == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "ZEGPS_WORKTIME cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localZEGPS_WORKTIME);
                }

                xmlWriter.writeEndElement();
            }

            if (localZEGPS_WORKVOLUMETracker) {
                namespace = "";
                writeStartElement(null, namespace, "ZEGPS_WORKVOLUME", xmlWriter);

                if (localZEGPS_WORKVOLUME == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "ZEGPS_WORKVOLUME cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localZEGPS_WORKVOLUME);
                }

                xmlWriter.writeEndElement();
            }

            if (localZEGPS_WORKTIME_DATETracker) {
                namespace = "";
                writeStartElement(null, namespace, "ZEGPS_WORKTIME_DATE",
                    xmlWriter);

                if (localZEGPS_WORKTIME_DATE == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "ZEGPS_WORKTIME_DATE cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localZEGPS_WORKTIME_DATE);
                }

                xmlWriter.writeEndElement();
            }

            xmlWriter.writeEndElement();
        }

        private static String generatePrefix(
            String namespace) {
            if (namespace.equals("http://sany.com/fcbs/008/queryequipment")) {
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
            public static ET_EQUIPMENT_type0 parse(
                javax.xml.stream.XMLStreamReader reader)
                throws Exception {
                ET_EQUIPMENT_type0 object = new ET_EQUIPMENT_type0();

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

                            if (!"ET_EQUIPMENT_type0".equals(type)) {
                                //find namespace for the prefix
                                String nsUri = reader.getNamespaceContext()
                                                               .getNamespaceURI(nsPrefix);

                                return (ET_EQUIPMENT_type0) ExtensionMapper.getTypeObject(nsUri,
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

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "PRODUCT_ID").equals(
                                reader.getName())) ||
                            new javax.xml.namespace.QName("", "PRODUCT_ID").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "PRODUCT_ID" +
                                "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setPRODUCT_ID(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "SHORT_TEXT").equals(
                                reader.getName())) ||
                            new javax.xml.namespace.QName("", "SHORT_TEXT").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "SHORT_TEXT" +
                                "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setSHORT_TEXT(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "SYBBH").equals(
                                reader.getName())) ||
                            new javax.xml.namespace.QName("", "SYBBH").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "SYBBH" + "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setSYBBH(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "SYBBH_DESC").equals(
                                reader.getName())) ||
                            new javax.xml.namespace.QName("", "SYBBH_DESC").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "SYBBH_DESC" +
                                "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setSYBBH_DESC(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "MYGMR").equals(
                                reader.getName())) ||
                            new javax.xml.namespace.QName("", "MYGMR").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "MYGMR" + "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setMYGMR(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "MYGMRMC").equals(
                                reader.getName())) ||
                            new javax.xml.namespace.QName("", "MYGMRMC").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "MYGMRMC" +
                                "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setMYGMRMC(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "ZZPERSONALID").equals(
                                reader.getName())) ||
                            new javax.xml.namespace.QName("", "ZZPERSONALID").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "ZZPERSONALID" +
                                "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setZZPERSONALID(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "ZZORGID").equals(
                                reader.getName())) ||
                            new javax.xml.namespace.QName("", "ZZORGID").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "ZZORGID" +
                                "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setZZORGID(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "TYPE").equals(
                                reader.getName())) ||
                            new javax.xml.namespace.QName("", "TYPE").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "TYPE" + "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setTYPE(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "ZEHD_SPART").equals(
                                reader.getName())) ||
                            new javax.xml.namespace.QName("", "ZEHD_SPART").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "ZEHD_SPART" +
                                "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setZEHD_SPART(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "ZEHD_SPARTDESC").equals(
                                reader.getName())) ||
                            new javax.xml.namespace.QName("", "ZEHD_SPARTDESC").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "ZEHD_SPARTDESC" +
                                "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setZEHD_SPARTDESC(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "ZEJQVO").equals(
                                reader.getName())) ||
                            new javax.xml.namespace.QName("", "ZEJQVO").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "ZEJQVO" +
                                "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setZEJQVO(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "ZEJJDATE").equals(
                                reader.getName())) ||
                            new javax.xml.namespace.QName("", "ZEJJDATE").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "ZEJJDATE" +
                                "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setZEJJDATE(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "ZEBXZC").equals(
                                reader.getName())) ||
                            new javax.xml.namespace.QName("", "ZEBXZC").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "ZEBXZC" +
                                "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setZEBXZC(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "ZEZBSTA").equals(
                                reader.getName())) ||
                            new javax.xml.namespace.QName("", "ZEZBSTA").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "ZEZBSTA" +
                                "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setZEZBSTA(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "ZEHD_SBUSTA").equals(
                                reader.getName())) ||
                            new javax.xml.namespace.QName("", "ZEHD_SBUSTA").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "ZEHD_SBUSTA" +
                                "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setZEHD_SBUSTA(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "ZEHD_YC").equals(
                                reader.getName())) ||
                            new javax.xml.namespace.QName("", "ZEHD_YC").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "ZEHD_YC" +
                                "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setZEHD_YC(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "ZEDS_LJLC").equals(
                                reader.getName())) ||
                            new javax.xml.namespace.QName("", "ZEDS_LJLC").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "ZEDS_LJLC" +
                                "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setZEDS_LJLC(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "ZEDS_LJYXF").equals(
                                reader.getName())) ||
                            new javax.xml.namespace.QName("", "ZEDS_LJYXF").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "ZEDS_LJYXF" +
                                "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setZEDS_LJYXF(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "ZEDS_LJYXT").equals(
                                reader.getName())) ||
                            new javax.xml.namespace.QName("", "ZEDS_LJYXT").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "ZEDS_LJYXT" +
                                "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setZEDS_LJYXT(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "ZEGPSAREA").equals(
                                reader.getName())) ||
                            new javax.xml.namespace.QName("", "ZEGPSAREA").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "ZEGPSAREA" +
                                "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setZEGPSAREA(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "ZEEQSTA").equals(
                                reader.getName())) ||
                            new javax.xml.namespace.QName("", "ZEEQSTA").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "ZEEQSTA" +
                                "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setZEEQSTA(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "ZEGPS_WORKMILES").equals(
                                reader.getName())) ||
                            new javax.xml.namespace.QName("", "ZEGPS_WORKMILES").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "ZEGPS_WORKMILES" +
                                "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setZEGPS_WORKMILES(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "ZEGPS_WORKTIME").equals(
                                reader.getName())) ||
                            new javax.xml.namespace.QName("", "ZEGPS_WORKTIME").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "ZEGPS_WORKTIME" +
                                "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setZEGPS_WORKTIME(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "ZEGPS_WORKVOLUME").equals(
                                reader.getName())) ||
                            new javax.xml.namespace.QName("", "ZEGPS_WORKVOLUME").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "ZEGPS_WORKVOLUME" +
                                "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setZEGPS_WORKVOLUME(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName("",
                                "ZEGPS_WORKTIME_DATE").equals(reader.getName())) ||
                            new javax.xml.namespace.QName("",
                                "ZEGPS_WORKTIME_DATE").equals(reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "ZEGPS_WORKTIME_DATE" +
                                "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setZEGPS_WORKTIME_DATE(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
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

    public static class DT_QueryEquipmentReq implements org.apache.axis2.databinding.ADBBean {
        /* This type was generated from the piece of schema that had
           name = DT_QueryEquipmentReq
           Namespace URI = http://sany.com/fcbs/008/queryequipment
           Namespace Prefix = ns1
         */

        /**
         * field for PRODUCT_ID
         */
        protected String localPRODUCT_ID;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localPRODUCT_IDTracker = false;

        /**
         * field for IS_INPUT
         */
        protected IS_INPUT_type0 localIS_INPUT;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localIS_INPUTTracker = false;

        public boolean isPRODUCT_IDSpecified() {
            return localPRODUCT_IDTracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getPRODUCT_ID() {
            return localPRODUCT_ID;
        }

        /**
         * Auto generated setter method
         * @param param PRODUCT_ID
         */
        public void setPRODUCT_ID(String param) {
            localPRODUCT_IDTracker = param != null;

            this.localPRODUCT_ID = param;
        }

        public boolean isIS_INPUTSpecified() {
            return localIS_INPUTTracker;
        }

        /**
         * Auto generated getter method
         * @return IS_INPUT_type0
         */
        public IS_INPUT_type0 getIS_INPUT() {
            return localIS_INPUT;
        }

        /**
         * Auto generated setter method
         * @param param IS_INPUT
         */
        public void setIS_INPUT(IS_INPUT_type0 param) {
            localIS_INPUTTracker = param != null;

            this.localIS_INPUT = param;
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
                        "http://sany.com/fcbs/008/queryequipment");

                if ((namespacePrefix != null) &&
                        (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi",
                        "http://www.w3.org/2001/XMLSchema-instance", "type",
                        namespacePrefix + ":DT_QueryEquipmentReq", xmlWriter);
                } else {
                    writeAttribute("xsi",
                        "http://www.w3.org/2001/XMLSchema-instance", "type",
                        "DT_QueryEquipmentReq", xmlWriter);
                }
            }

            if (localPRODUCT_IDTracker) {
                namespace = "";
                writeStartElement(null, namespace, "PRODUCT_ID", xmlWriter);

                if (localPRODUCT_ID == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "PRODUCT_ID cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localPRODUCT_ID);
                }

                xmlWriter.writeEndElement();
            }

            if (localIS_INPUTTracker) {
                if (localIS_INPUT == null) {
                    throw new org.apache.axis2.databinding.ADBException(
                        "IS_INPUT cannot be null!!");
                }

                localIS_INPUT.serialize(new javax.xml.namespace.QName("",
                        "IS_INPUT"), xmlWriter);
            }

            xmlWriter.writeEndElement();
        }

        private static String generatePrefix(
            String namespace) {
            if (namespace.equals("http://sany.com/fcbs/008/queryequipment")) {
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
            public static DT_QueryEquipmentReq parse(
                javax.xml.stream.XMLStreamReader reader)
                throws Exception {
                DT_QueryEquipmentReq object = new DT_QueryEquipmentReq();

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

                            if (!"DT_QueryEquipmentReq".equals(type)) {
                                //find namespace for the prefix
                                String nsUri = reader.getNamespaceContext()
                                                               .getNamespaceURI(nsPrefix);

                                return (DT_QueryEquipmentReq) ExtensionMapper.getTypeObject(nsUri,
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

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "PRODUCT_ID").equals(
                                reader.getName())) ||
                            new javax.xml.namespace.QName("", "PRODUCT_ID").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "PRODUCT_ID" +
                                "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setPRODUCT_ID(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "IS_INPUT").equals(
                                reader.getName())) ||
                            new javax.xml.namespace.QName("", "IS_INPUT").equals(
                                reader.getName())) {
                        object.setIS_INPUT(IS_INPUT_type0.Factory.parse(reader));

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

    public static class ExtensionMapper {
        public static Object getTypeObject(
            String namespaceURI, String typeName,
            javax.xml.stream.XMLStreamReader reader) throws Exception {
            if ("http://sany.com/fcbs/008/queryequipment".equals(namespaceURI) &&
                    "ES_RETURN_type0".equals(typeName)) {
                return ES_RETURN_type0.Factory.parse(reader);
            }

            if ("http://sany.com/fcbs/008/queryequipment".equals(namespaceURI) &&
                    "DT_QueryEquipmentResp".equals(typeName)) {
                return DT_QueryEquipmentResp.Factory.parse(reader);
            }

            if ("http://sany.com/fcbs/008/queryequipment".equals(namespaceURI) &&
                    "ET_EQUIPMENT_type0".equals(typeName)) {
                return ET_EQUIPMENT_type0.Factory.parse(reader);
            }

            if ("http://sany.com/fcbs/008/queryequipment".equals(namespaceURI) &&
                    "DT_QueryEquipmentReq".equals(typeName)) {
                return DT_QueryEquipmentReq.Factory.parse(reader);
            }

            if ("http://sany.com/fcbs/008/queryequipment".equals(namespaceURI) &&
                    "IS_INPUT_type0".equals(typeName)) {
                return IS_INPUT_type0.Factory.parse(reader);
            }

            throw new org.apache.axis2.databinding.ADBException(
                "Unsupported type " + namespaceURI + " " + typeName);
        }
    }

    public static class IS_INPUT_type0 implements org.apache.axis2.databinding.ADBBean {
        /* This type was generated from the piece of schema that had
           name = IS_INPUT_type0
           Namespace URI = http://sany.com/fcbs/008/queryequipment
           Namespace Prefix = ns1
         */

        /**
         * field for MYGMR
         */
        protected String localMYGMR;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localMYGMRTracker = false;

        /**
         * field for MYGMRMC
         */
        protected String localMYGMRMC;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localMYGMRMCTracker = false;

        /**
         * field for ZZPERSONALID
         */
        protected String localZZPERSONALID;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localZZPERSONALIDTracker = false;

        /**
         * field for ZZORGID
         */
        protected String localZZORGID;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localZZORGIDTracker = false;

        public boolean isMYGMRSpecified() {
            return localMYGMRTracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getMYGMR() {
            return localMYGMR;
        }

        /**
         * Auto generated setter method
         * @param param MYGMR
         */
        public void setMYGMR(String param) {
            localMYGMRTracker = param != null;

            this.localMYGMR = param;
        }

        public boolean isMYGMRMCSpecified() {
            return localMYGMRMCTracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getMYGMRMC() {
            return localMYGMRMC;
        }

        /**
         * Auto generated setter method
         * @param param MYGMRMC
         */
        public void setMYGMRMC(String param) {
            localMYGMRMCTracker = param != null;

            this.localMYGMRMC = param;
        }

        public boolean isZZPERSONALIDSpecified() {
            return localZZPERSONALIDTracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getZZPERSONALID() {
            return localZZPERSONALID;
        }

        /**
         * Auto generated setter method
         * @param param ZZPERSONALID
         */
        public void setZZPERSONALID(String param) {
            localZZPERSONALIDTracker = param != null;

            this.localZZPERSONALID = param;
        }

        public boolean isZZORGIDSpecified() {
            return localZZORGIDTracker;
        }

        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public String getZZORGID() {
            return localZZORGID;
        }

        /**
         * Auto generated setter method
         * @param param ZZORGID
         */
        public void setZZORGID(String param) {
            localZZORGIDTracker = param != null;

            this.localZZORGID = param;
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
                        "http://sany.com/fcbs/008/queryequipment");

                if ((namespacePrefix != null) &&
                        (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi",
                        "http://www.w3.org/2001/XMLSchema-instance", "type",
                        namespacePrefix + ":IS_INPUT_type0", xmlWriter);
                } else {
                    writeAttribute("xsi",
                        "http://www.w3.org/2001/XMLSchema-instance", "type",
                        "IS_INPUT_type0", xmlWriter);
                }
            }

            if (localMYGMRTracker) {
                namespace = "";
                writeStartElement(null, namespace, "MYGMR", xmlWriter);

                if (localMYGMR == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "MYGMR cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localMYGMR);
                }

                xmlWriter.writeEndElement();
            }

            if (localMYGMRMCTracker) {
                namespace = "";
                writeStartElement(null, namespace, "MYGMRMC", xmlWriter);

                if (localMYGMRMC == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "MYGMRMC cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localMYGMRMC);
                }

                xmlWriter.writeEndElement();
            }

            if (localZZPERSONALIDTracker) {
                namespace = "";
                writeStartElement(null, namespace, "ZZPERSONALID", xmlWriter);

                if (localZZPERSONALID == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "ZZPERSONALID cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localZZPERSONALID);
                }

                xmlWriter.writeEndElement();
            }

            if (localZZORGIDTracker) {
                namespace = "";
                writeStartElement(null, namespace, "ZZORGID", xmlWriter);

                if (localZZORGID == null) {
                    // write the nil attribute
                    throw new org.apache.axis2.databinding.ADBException(
                        "ZZORGID cannot be null!!");
                } else {
                    xmlWriter.writeCharacters(localZZORGID);
                }

                xmlWriter.writeEndElement();
            }

            xmlWriter.writeEndElement();
        }

        private static String generatePrefix(
            String namespace) {
            if (namespace.equals("http://sany.com/fcbs/008/queryequipment")) {
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
            public static IS_INPUT_type0 parse(
                javax.xml.stream.XMLStreamReader reader)
                throws Exception {
                IS_INPUT_type0 object = new IS_INPUT_type0();

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

                            if (!"IS_INPUT_type0".equals(type)) {
                                //find namespace for the prefix
                                String nsUri = reader.getNamespaceContext()
                                                               .getNamespaceURI(nsPrefix);

                                return (IS_INPUT_type0) ExtensionMapper.getTypeObject(nsUri,
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

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "MYGMR").equals(
                                reader.getName())) ||
                            new javax.xml.namespace.QName("", "MYGMR").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "MYGMR" + "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setMYGMR(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "MYGMRMC").equals(
                                reader.getName())) ||
                            new javax.xml.namespace.QName("", "MYGMRMC").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "MYGMRMC" +
                                "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setMYGMRMC(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "ZZPERSONALID").equals(
                                reader.getName())) ||
                            new javax.xml.namespace.QName("", "ZZPERSONALID").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "ZZPERSONALID" +
                                "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setZZPERSONALID(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                content));

                        reader.next();
                    } // End of if for expected property start element

                    else {
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if ((reader.isStartElement() &&
                            new javax.xml.namespace.QName("", "ZZORGID").equals(
                                reader.getName())) ||
                            new javax.xml.namespace.QName("", "ZZORGID").equals(
                                reader.getName())) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "nil");

                        if ("true".equals(nillableValue) ||
                                "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException(
                                "The element: " + "ZZORGID" +
                                "  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setZZORGID(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
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

    public static class MT_QueryEquipmentReq implements org.apache.axis2.databinding.ADBBean {
        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://sany.com/fcbs/008/queryequipment",
                "MT_QueryEquipmentReq", "ns1");

        /**
         * field for MT_QueryEquipmentReq
         */
        protected DT_QueryEquipmentReq localMT_QueryEquipmentReq;

        /**
         * Auto generated getter method
         * @return DT_QueryEquipmentReq
         */
        public DT_QueryEquipmentReq getMT_QueryEquipmentReq() {
            return localMT_QueryEquipmentReq;
        }

        /**
         * Auto generated setter method
         * @param param MT_QueryEquipmentReq
         */
        public void setMT_QueryEquipmentReq(DT_QueryEquipmentReq param) {
            this.localMT_QueryEquipmentReq = param;
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
            if (localMT_QueryEquipmentReq == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "MT_QueryEquipmentReq cannot be null!");
            }

            localMT_QueryEquipmentReq.serialize(MY_QNAME, xmlWriter);
        }

        private static String generatePrefix(
            String namespace) {
            if (namespace.equals("http://sany.com/fcbs/008/queryequipment")) {
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
            public static MT_QueryEquipmentReq parse(
                javax.xml.stream.XMLStreamReader reader)
                throws Exception {
                MT_QueryEquipmentReq object = new MT_QueryEquipmentReq();

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
                            if ((reader.isStartElement() &&
                                    new javax.xml.namespace.QName(
                                        "http://sany.com/fcbs/008/queryequipment",
                                        "MT_QueryEquipmentReq").equals(
                                        reader.getName())) ||
                                    new javax.xml.namespace.QName("",
                                        "MT_QueryEquipmentReq").equals(
                                        reader.getName())) {
                                object.setMT_QueryEquipmentReq(DT_QueryEquipmentReq.Factory.parse(
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

    public static class MT_QueryEquipmentResp implements org.apache.axis2.databinding.ADBBean {
        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://sany.com/fcbs/008/queryequipment",
                "MT_QueryEquipmentResp", "ns1");

        /**
         * field for MT_QueryEquipmentResp
         */
        protected DT_QueryEquipmentResp localMT_QueryEquipmentResp;

        /**
         * Auto generated getter method
         * @return DT_QueryEquipmentResp
         */
        public DT_QueryEquipmentResp getMT_QueryEquipmentResp() {
            return localMT_QueryEquipmentResp;
        }

        /**
         * Auto generated setter method
         * @param param MT_QueryEquipmentResp
         */
        public void setMT_QueryEquipmentResp(DT_QueryEquipmentResp param) {
            this.localMT_QueryEquipmentResp = param;
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
            if (localMT_QueryEquipmentResp == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "MT_QueryEquipmentResp cannot be null!");
            }

            localMT_QueryEquipmentResp.serialize(MY_QNAME, xmlWriter);
        }

        private static String generatePrefix(
            String namespace) {
            if (namespace.equals("http://sany.com/fcbs/008/queryequipment")) {
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
            public static MT_QueryEquipmentResp parse(
                javax.xml.stream.XMLStreamReader reader)
                throws Exception {
                MT_QueryEquipmentResp object = new MT_QueryEquipmentResp();

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
                            if ((reader.isStartElement() &&
                                    new javax.xml.namespace.QName(
                                        "http://sany.com/fcbs/008/queryequipment",
                                        "MT_QueryEquipmentResp").equals(
                                        reader.getName())) ||
                                    new javax.xml.namespace.QName("",
                                        "MT_QueryEquipmentResp").equals(
                                        reader.getName())) {
                                object.setMT_QueryEquipmentResp(DT_QueryEquipmentResp.Factory.parse(
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
}
