package com.aia.glory.id.test.bank;

import com.aia.glory.id.TestReports;
import com.aia.glory.id.bank.model.BankResponse;
import com.aia.glory.id.beans.PostJson;
import com.aia.glory.id.login.entity.LoginResponse;
import com.aia.glory.id.model.Response;
import com.aia.glory.id.test.ApplicationTest;
import com.aia.glory.id.utils.ExtentUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.NetworkMode;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes = ApplicationTest.class)
@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BankTest extends TestReports {

    @Value("${server.url.channel}")
    private String url;

    @Value("${server.url.user}")
    private String userUrl;

    @Value("${server.auth.username}")
    private String userName;

    @Value("${server.auth.password}")
    private String password;

    @Autowired
    private PostJson Postjson;

    private String token ;

    private static String bankSeq = String.valueOf(System.currentTimeMillis()).substring(5,12);
    private static String bankCode = String.valueOf(System.currentTimeMillis()).substring(5,10);

    @Before
    public void before()  {
        String api_path = userUrl+"token";

        JSONObject json = new JSONObject();
        json.put("loginId",userName);
        json.put("password",password);

        LoginResponse response = JSON.parseObject(Postjson.execute(api_path,json.toJSONString(),null),LoginResponse.class);
        token = response.getToken().getJwtToken();
    }

    @Test
    public void test01CreateBank(){
        String api_path = url+"bank";

        JSONObject json = new JSONObject();
        json.put("action","CREATE");
        json.put("bankSeq",bankSeq);
        json.put("bankName","BANCO DE ORO");
        json.put("companyCode","9010");
        json.put("bankInitials","BDO");
        json.put("bankCode",bankCode);

        Response response = JSON.parseObject(Postjson.execute(api_path,json.toJSONString(),token),Response.class);
        Assert.assertEquals("000",response.getResponseCode());
    }

    @Test
    public void test02SearchBank(){
        String api_path = url+"bank";

        JSONObject json = new JSONObject();
        json.put("action","GET");
        json.put("bankCode",bankCode);
        json.put("startPage",1);
        json.put("pageSize",10);

        BankResponse response = JSON.parseObject(Postjson.execute(api_path,json.toJSONString(),token),BankResponse.class);
        Assert.assertEquals(1,response.getTotal());
    }

    //@Test
    public void test03UpdateBank(){
        String api_path = url+"bank";

        JSONObject json = new JSONObject();
        json.put("action","UPDATE");
        json.put("bankCode","61222");
        json.put("companyCode","5010");
        json.put("bankName","BANCO DE ORO");
        json.put("bankInitials","BDO");
        json.put("bankbranchcode","61222");
        json.put("bankSeq",bankSeq);

        Postjson.execute(api_path,json.toJSONString(),token);

        JSONObject getJson = new JSONObject();
        getJson.put("action","GET");
        getJson.put("bankCode","61222");
        getJson.put("startPage",1);
        getJson.put("pageSize",10);

        BankResponse response = JSON.parseObject(Postjson.execute(api_path,json.toJSONString(),token),BankResponse.class);
        Assert.assertEquals(1,response.getTotal());
    }

    @Test
    public void test04DeleteBank(){
        String api_path = url+"bank";

        JSONObject json = new JSONObject();
        json.put("action","DELETE");
        json.put("bankSeq",bankSeq);

        Postjson.execute(api_path,json.toJSONString(),token);

        JSONObject getJson = new JSONObject();
        getJson.put("action","GET");
        getJson.put("bankSeq",bankSeq);
        getJson.put("startPage",1);
        getJson.put("pageSize",10);

        BankResponse response = JSON.parseObject(Postjson.execute(api_path,json.toJSONString(),token),BankResponse.class);
        Assert.assertEquals(0,response.getTotal());
    }

}
