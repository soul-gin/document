package com.sany.controller.crm.scheduleTask;

import com.sany.ExcpApplicationTest;
import com.sany.entity.crm.CrmRtnInf;
import com.sany.entity.crm.FinancingContract;
import com.sany.service.crm.CrmDockingService;
import com.sany.service.crm.CrmRtnInfService;
import com.sany.util.IdGenerator;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.axis2.transport.http.impl.httpclient4.HttpTransportPropertiesImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import webservice.crm.pushContract.OsFinancingContract_FCBSServiceStub;
import webservice.crm.pushContract.OsFinancingContract_FCBSServiceStub.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * 融资合同接口任务测试
 */
public class FinancingContractTaskTest extends ExcpApplicationTest {

    @Autowired
    private CrmRtnInfService crmRtnInfService;

    @Autowired
    private CrmDockingService crmDockingService;

    @Test
    public void financingContractTask(){
        try{
            OsFinancingContract_FCBSServiceStub service = new OsFinancingContract_FCBSServiceStub();

            //身份认证
            HttpTransportPropertiesImpl.Authenticator auth = new HttpTransportPropertiesImpl.Authenticator();
            auth.setUsername("Srv_FCBS_POP");
            auth.setPassword("F&3!Lpag");
            service._getServiceClient().getOptions().setProperty(HTTPConstants.AUTHENTICATE, auth);
            service._getServiceClient().getOptions().setTimeOutInMilliSeconds(1000);

            //查询日期为上一个月
            Calendar calendar = Calendar.getInstance();
            //calendar.add(Calendar.MONTH, -1);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
            String reqMonth = sdf.format(calendar.getTime());

            List<FinancingContract> financingContractList = crmDockingService.qryFinancingContractList(reqMonth);
            for (FinancingContract financingContract:financingContractList) {
                CrmRtnInf crmRtnInf = new CrmRtnInf();
                IdGenerator idGenerator = new IdGenerator();
                crmRtnInf.setId(idGenerator.next());
                crmRtnInf.setContractNum(financingContract.getZficcontNo());
                crmRtnInf.setReqMonth(reqMonth);
                crmRtnInf.setRtnType("financingContract");
                try{

                    MT_FinancingContractReq mtReq = new MT_FinancingContractReq();
                    DT_FinancingContractReq dtReq = new DT_FinancingContractReq();
                    IT_FINANCE_type0 type1 = new IT_FINANCE_type0();

                    type1.setOBJECT(financingContract.getObject());                     //放款进度编号
                    type1.setCGUARANTOR(financingContract.getCguarantor());             //反担保人
                    type1.setZFICCONT_NO(financingContract.getZficcontNo());            //融资合同号
                    type1.setFKDAT(financingContract.getFkdat());                       //放款日期
                    type1.setQZDAT(financingContract.getQzdat());                       //起租日期
                    type1.setZZREPAYSTARTD(financingContract.getZzrepaystartd());       //还款起始日期
                    type1.setHTEDAT(financingContract.getHtedat());                     //贷款到期日
                    type1.setZZFLD000087(financingContract.getZzfld000087());           //还款方式
                    type1.setZZLOANAMOUNT(financingContract.getZzloanamount());         //贷款金额
                    type1.setZZLOANSCALE(financingContract.getZzloanscale());           //贷款比例
                    type1.setZZLOANPERIOD(financingContract.getZzloanperiod());         //贷款期数
                    type1.setZZDEPOSIT(financingContract.getZzdeposit());               //保证金金额
                    type1.setZZAJFACTORAGE(financingContract.getZzajfactorage());       //担保服务费
                    type1.setZZPLEDGEFEE(financingContract.getZzpledgefee());           //抵押公证费
                    type1.setZZPREMIUM(financingContract.getZzpremium());               //保险费
                    type1.setZZDEPOSITINSR(financingContract.getZzdepositiner());       //续保押金
                    type1.setZZFLD00007K(financingContract.getZzfld00007k());           //户名
                    type1.setZZFLD00008N(financingContract.getZzfld00008n());           //还款账号
                    type1.setZZACCNAME(financingContract.getZzaccname());               //开户行
                    type1.setZZINTSUBSIDY(financingContract.getZzintsubsidy());         //贴息

                    dtReq.addIT_FINANCE(type1);
                    mtReq.setMT_FinancingContractReq(dtReq);
                    MT_FinancingContractResp mtRsp = service.osFinancingContract_FCBS(mtReq);
                    ET_RETURN_type0[] outs = mtRsp.getMT_FinancingContractResp().getET_RETURN();

                    crmRtnInf.setRzhth(outs[0].getRZHTH());
                    crmRtnInf.setZflag(outs[0].getZFLAG());
                    crmRtnInf.setZmesg(outs[0].getZMESG());
                }catch (Exception e){
                    e.printStackTrace();
                    crmRtnInf.setZflag("E");
                    crmRtnInf.setZmesg("调用异常！");
                }
                crmRtnInfService.addCrmRtnInf(crmRtnInf);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
