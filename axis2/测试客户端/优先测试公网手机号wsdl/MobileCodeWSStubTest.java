package com.naruto.test;

import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.axis2.transport.http.impl.httpclient4.HttpTransportPropertiesImpl;

public class MobileCodeWSStubTest {

    public static void main(String[] args) {
        try{
            MobileCodeWSStub service = new MobileCodeWSStub();

            //身份认证
            HttpTransportPropertiesImpl.Authenticator auth = new HttpTransportPropertiesImpl.Authenticator();
            auth.setUsername("需要身份验证再添加");
            auth.setPassword("需要身份验证再添加");
            service._getServiceClient().getOptions().setProperty(HTTPConstants.AUTHENTICATE, auth);
            service._getServiceClient().getOptions().setTimeOutInMilliSeconds(1000);

            try{
                //设置参数
                MobileCodeWSStub.GetMobileCodeInfo mtReq = new MobileCodeWSStub.GetMobileCodeInfo();
                mtReq.setMobileCode("18179095420");
                //用户ID可以为空, 错误的会显示 用户ID错误
                mtReq.setUserID("");

                //调用远程wsdl服务
                MobileCodeWSStub.GetMobileCodeInfoResponse mobileCodeInfo = service.getMobileCodeInfo(mtReq);
                //获取输出结果
                String resultMsg = mobileCodeInfo.getGetMobileCodeInfoResult();

                System.out.println("result:" + resultMsg);
            }catch (Exception e){
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
