package com.aia.glory.id.test.company;

import com.aia.glory.id.TestReports;
import com.aia.glory.id.beans.PostJson;
import com.aia.glory.id.company.entity.CompanyResponse;
import com.aia.glory.id.login.entity.LoginResponse;
import com.aia.glory.id.position.entity.GetPositionRelationResponse;
import com.aia.glory.id.test.ApplicationTest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes = ApplicationTest.class)
@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CompanyTest  extends TestReports {

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

    private static String seq = String.valueOf(System.currentTimeMillis()).substring(5,12);

    @Before
    public void before()  {
        String api_path = userUrl+"token";

        JSONObject json = new JSONObject();
        json.put("loginId",userName);
        json.put("password",password);

        LoginResponse response = JSON.parseObject(Postjson.execute(api_path,json.toJSONString(),null),LoginResponse.class);
        token = response.getToken().getJwtToken();

        System.out.println("token is "+ token);
        System.out.println("seq is "+ seq);
    }

    @Test
    public void test01Create() {
        String api_path = url + "company";

        JSONObject companyRequest = new JSONObject();

        JSONObject companyModel = new JSONObject();
        companyModel.put("name", "company"+seq);
        companyModel.put("description", "company desc");
        companyModel.put("createDate", "2020-12-30");
        companyModel.put("processingUnitSeq", seq);

        companyRequest.put("action", "INSERT");
        companyRequest.put("companyModel", companyModel);

        CompanyResponse response = JSON.parseObject(Postjson.execute(api_path, companyRequest.toJSONString(), token), CompanyResponse.class);
        Assert.assertEquals("000", response.getResponseCode());
    }

    @Test
    public void test04Delete() {
        String api_path = url + "company";

        JSONObject companyRequest = new JSONObject();

        JSONObject companyModel = new JSONObject();
        companyModel.put("processingUnitSeq", seq);
        companyRequest.put("action", "DELETE");
        companyRequest.put("companyModel", companyModel);

        CompanyResponse response = JSON.parseObject(Postjson.execute(api_path, companyRequest.toJSONString(), token), CompanyResponse.class);
        Assert.assertEquals("000", response.getResponseCode());
    }

    @Test
    public void test02Query() {
        String api_path = url + "company";

        JSONObject companyRequest = new JSONObject();

        companyRequest.put("name", "company"+seq);
        companyRequest.put("action", "GET");
        companyRequest.put("startPage", 1);
        companyRequest.put("pageSize", 1);

        CompanyResponse response = JSON.parseObject(Postjson.execute(api_path, companyRequest.toJSONString(), token), CompanyResponse.class);
        Assert.assertEquals(1, response.getTotal());
    }

    //@Test
    public void test03Update() {
        String api_path = url + "company";

        JSONObject companyRequest = new JSONObject();

        companyRequest.put("action", "UPDATE");

        JSONObject companyModel = new JSONObject();
        companyModel.put("name", "company000"+seq);
        companyModel.put("description", "companyUUTT");
        companyModel.put("processingUnitSeq", seq);

        companyRequest.put("companyModel", companyModel);

        Postjson.execute(api_path, companyRequest.toJSONString(), token);

        JSONObject companyQuery = new JSONObject();

        companyQuery.put("name", "company000"+seq);
        companyQuery.put("action", "GET");
        companyQuery.put("startPage", 1);
        companyQuery.put("pageSize", 1);

        CompanyResponse response = JSON.parseObject(Postjson.execute(api_path, companyQuery.toJSONString(), token), CompanyResponse.class);
        Assert.assertEquals(1, response.getTotal());
    }
}
