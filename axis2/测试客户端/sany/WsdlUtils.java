package cn.tongdun.preserver.util;

import cn.tongdun.preserver.wsdl.OsQueryEquipment_FCBSServiceStub;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.axis2.transport.http.impl.httpclient4.HttpTransportPropertiesImpl;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;


/**
 * webservice发送请求工具类
 * Author:lsf
 * Date:19-01-08
 */
public class WsdlUtils {
    static int socketTimeout = 30000;// 请求超时时间
    static int connectTimeout = 30000;// 传输超时时间
    static Logger logger = Logger.getLogger(WsdlUtils.class);

    /**
     * 使用SOAP发送消息（HttpClient方式）
     *
     * @param postUrl
     * @param soapXml
     * @param soapAction
     * @return
     */
    public static String doPostSoap(String postUrl, String soapXml,
                                    String soapAction) {
        String retStr = "";
        // 创建HttpClientBuilder
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        // HttpClient
        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
        HttpPost httpPost = new HttpPost(postUrl);
        //  设置请求和传输超时时间
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(socketTimeout)
                .setConnectTimeout(connectTimeout).build();
        httpPost.setConfig(requestConfig);
        try {
            httpPost.setHeader("Content-Type", "text/xml;charset=UTF-8");
            httpPost.setHeader("SOAPAction", soapAction);
            StringEntity data = new StringEntity(soapXml,
                    Charset.forName("UTF-8"));
            httpPost.setEntity(data);
            CloseableHttpResponse response = closeableHttpClient
                    .execute(httpPost);
            HttpEntity httpEntity = response.getEntity();
            if (httpEntity != null) {
                // 打印响应内容
                retStr = EntityUtils.toString(httpEntity, "UTF-8");
                logger.info("response:" + retStr);
            }
            // 释放资源
            closeableHttpClient.close();
        } catch (Exception e) {
            logger.error("请求出错！", e);
        }
        return retStr;
    }

    /**
     * 使用HttpURLConnection方式连接
     * @param soapurl
     * @param soapXML
     * @return
     * @throws IOException
     */
    public static String urlConnectionUtil(String soapurl,String soapXML) throws IOException {
        //第一步：创建服务地址
        //http://172.25.37.31:8080/PeopleSoftService/getPerson.wsdl
        URL url = new URL(soapurl);
        //第二步：打开一个通向服务地址的连接
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        //第三步：设置参数
        //3.1发送方式设置：POST必须大写
        connection.setRequestMethod("POST");
        //3.2设置数据格式：content-type
        connection.setRequestProperty("content-type", "text/xml;charset=utf-8");
        //3.3设置输入输出，因为默认新创建的connection没有读写权限，
        connection.setDoInput(true);
        connection.setDoOutput(true);
        //第四步：组织SOAP数据，发送请求
        //将信息以流的方式发送出去
        OutputStream os = connection.getOutputStream();
        os.write(soapXML.getBytes());
        StringBuilder sb = new StringBuilder();
        //第五步：接收服务端响应，打印
        int responseCode = connection.getResponseCode();
        if(200 == responseCode){//表示服务端响应成功
            //获取当前连接请求返回的数据流
            InputStream is = connection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

//            StringBuilder sb = new StringBuilder();
            String temp = null;
            while(null != (temp = br.readLine())){
                sb.append(temp);
            }
            is.close();
            isr.close();
            br.close();
        }
        os.close();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        //第一步：创建服务地址
        URL url = new URL("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx");
        //第二步：打开一个通向服务地址的连接
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        //第三步：设置参数
        //3.1发送方式设置：POST必须大写
        connection.setRequestMethod("POST");
        //3.2设置数据格式：content-type
        connection.setRequestProperty("content-type", "text/xml;charset=utf-8");
        //3.3设置输入输出，因为默认新创建的connection没有读写权限，
        connection.setDoInput(true);
        connection.setDoOutput(true);

        //第四步：组织SOAP数据，发送请求
        String soapXML = getXML("18179095420");
        //将信息以流的方式发送出去
        OutputStream os = connection.getOutputStream();
        os.write(soapXML.getBytes());
        //第五步：接收服务端响应，打印
        int responseCode = connection.getResponseCode();
        System.out.println(responseCode);
        //表示服务端响应成功
            //获取当前连接请求返回的数据流
            InputStream is = connection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            StringBuilder sb = new StringBuilder();
            String temp = null;
            while(null != (temp = br.readLine())){
                sb.append(temp);
            }

            /**
             * 打印结果
             */
            System.out.println(sb.toString());

            is.close();
            isr.close();
            br.close();

        os.close();
    }


    public static String getXML(String phone){

        String soapXML = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
                +"<soap:Envelope xmlns:xsi=\"http://www.w3.org/2003/XMLSchema-instance\""
                +"xmlns:web=\"http://WebXml.com.cn/\"  "
                +"xmlns:xsd=\"http://www.w3.org/2003/XMLSchema\" "
                +"xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">"
                +"<soap:Body>"
                +"<web:getMobileCodeInfo>"
                +"<mobileCode>18179095420</mobileCode>"
                +"<userID>18179095420</userID>"
                +"</web:getMobileCodeInfo>"
                +"</soap:Body>"
                +"</soap:Envelope>";
        return soapXML;
    }

    @Test
    public void financingContractTask(){
        try{
            OsQueryEquipment_FCBSServiceStub service = new OsQueryEquipment_FCBSServiceStub();

            //身份认证
            HttpTransportPropertiesImpl.Authenticator auth = new HttpTransportPropertiesImpl.Authenticator();
            /*auth.setUsername("Srv_FCBS_POP");
            auth.setPassword("F&3!Lpag");*/
            auth.setUsername("srv_test_pod");
            auth.setPassword("pod123456");
            service._getServiceClient().getOptions().setProperty(HTTPConstants.AUTHENTICATE, auth);
            service._getServiceClient().getOptions().setTimeOutInMilliSeconds(1000);

            try{
                OsQueryEquipment_FCBSServiceStub.MT_QueryEquipmentReq mtReq = new OsQueryEquipment_FCBSServiceStub.MT_QueryEquipmentReq();
                OsQueryEquipment_FCBSServiceStub.DT_QueryEquipmentReq dtReq = new OsQueryEquipment_FCBSServiceStub.DT_QueryEquipmentReq();
                OsQueryEquipment_FCBSServiceStub.IS_INPUT_type0 type1 = new OsQueryEquipment_FCBSServiceStub.IS_INPUT_type0();
                dtReq.setPRODUCT_ID("031548V178");
                //031548V178  320260  浙江省宁波经济技术开发区二十冶金建公司
                //031548V553  320234  宁波金鑫商品混凝土有限公司
                //15SY0076S9298  234529  叶作洪
                //15SY0076S9308  233852  杨玉田
                //15SY0076S9318  234929  马福云
                type1.setMYGMR("320260");                     //名义购买人 BP
                type1.setMYGMRMC("浙江省宁波经济技术开发区二十冶金建公司");                   //名义购买人名称
                type1.setZZORGID("");                   //身份证号码
                type1.setZZPERSONALID("");              //组织机构

                dtReq.setIS_INPUT(type1);
                mtReq.setMT_QueryEquipmentReq(dtReq);
                OsQueryEquipment_FCBSServiceStub.MT_QueryEquipmentResp mtRsp = service.osQueryEquipment_FCBS(mtReq);
                OsQueryEquipment_FCBSServiceStub.ES_RETURN_type0 outs = mtRsp.getMT_QueryEquipmentResp().getES_RETURN();

                System.out.println("MESSAGE:" + outs.getMESSAGE());
                System.out.println("TYPE:" + outs.getTYPE());

                OsQueryEquipment_FCBSServiceStub.ET_EQUIPMENT_type0[] type0s = mtRsp.getMT_QueryEquipmentResp().getET_EQUIPMENT();
                System.out.println(type0s == null);
                OsQueryEquipment_FCBSServiceStub.ET_EQUIPMENT_type0 type0 = type0s[0];
                System.out.println(type0 == null);
                System.out.println("MYGMR:" + type0.getMYGMR());
                System.out.println("MYGMRMC:" + type0.getMYGMRMC());
                System.out.println("PRODUCT_ID:" + type0.getPRODUCT_ID());
            }catch (Exception e){
                e.printStackTrace();

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}