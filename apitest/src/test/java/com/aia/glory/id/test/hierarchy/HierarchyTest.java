package com.aia.glory.id.test.hierarchy;

import com.aia.glory.id.Hierarchy.entity.GgHierarchyResponse;
import com.aia.glory.id.TestReports;
import com.aia.glory.id.beans.PostJson;
import com.aia.glory.id.company.entity.CompanyResponse;
import com.aia.glory.id.login.entity.LoginResponse;
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
public class HierarchyTest extends TestReports {

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
        String api_path = url + "ggrphclHierarchyController";

        JSONObject ggHierarchyRequest = new JSONObject();

        JSONObject ggrphclHierarchyModel = new JSONObject();
        ggrphclHierarchyModel.put("versionLog", "5.0");
        ggrphclHierarchyModel.put("createBy", "ASNPI5P");
        ggrphclHierarchyModel.put("updateUser", "ASNPHN");
        ggrphclHierarchyModel.put("ggrphclHierarchySeq",seq);
        ggrphclHierarchyModel.put("geographicalType", seq);

        ggHierarchyRequest.put("action", "INSERT");
        ggHierarchyRequest.put("ggrphclHierarchyModel", ggrphclHierarchyModel);

        GgHierarchyResponse response = JSON.parseObject(Postjson.execute(api_path, ggHierarchyRequest.toJSONString(), token), GgHierarchyResponse.class);
        Assert.assertEquals("000", response.getResponseCode());
    }


    @Test
    public void test02Query() {
        String api_path = url + "ggrphclHierarchyController";

        // search
        JSONObject ggHierarchyQueryRequest = new JSONObject();

        ggHierarchyQueryRequest.put("geographicalType", seq);
        ggHierarchyQueryRequest.put("action", "GET");
        ggHierarchyQueryRequest.put("pageSize", 1);
        ggHierarchyQueryRequest.put("startPage", 1);

        GgHierarchyResponse response = JSON.parseObject(Postjson.execute(api_path, ggHierarchyQueryRequest.toJSONString(), token), GgHierarchyResponse.class);
        Assert.assertEquals(1, response.getTotal());

    }


    //@Test
    public void test03Update() {
        String api_path = url + "ggrphclHierarchyController";

        JSONObject ggHierarchyRequest = new JSONObject();

        JSONObject ggrphclHierarchyModel = new JSONObject();
        ggrphclHierarchyModel.put("versionLog", "2.0");
        ggrphclHierarchyModel.put("ggrphclHierarchySeq",seq);

        ggHierarchyRequest.put("action", "UPDATE");
        ggHierarchyRequest.put("ggrphclHierarchyModel", ggrphclHierarchyModel);

        Postjson.execute(api_path, ggHierarchyRequest.toJSONString(), token);

        // query test
        JSONObject ggHierarchyQueryRequest = new JSONObject();

        ggHierarchyQueryRequest.put("versionLog", "2.0");
        ggHierarchyQueryRequest.put("action", "GET");
        ggHierarchyQueryRequest.put("pageSize", 1);
        ggHierarchyQueryRequest.put("startPage", 1);

        GgHierarchyResponse response = JSON.parseObject(Postjson.execute(api_path, ggHierarchyQueryRequest.toJSONString(), token), GgHierarchyResponse.class);
        Assert.assertEquals(1, response.getTotal());
    }

    @Test
    public void test04Delete() {
        String api_path = url + "ggrphclHierarchyController";

        JSONObject ggHierarchyRequest = new JSONObject();

        ggHierarchyRequest.put("versionLog", "1.0");
        ggHierarchyRequest.put("geographicalType", seq);
        ggHierarchyRequest.put("action", "DELETE");

        Postjson.execute(api_path, ggHierarchyRequest.toJSONString(), token);

        // search
        JSONObject ggHierarchyQueryRequest = new JSONObject();

        ggHierarchyQueryRequest.put("geographicalType", seq);
        ggHierarchyQueryRequest.put("action", "GET");
        ggHierarchyQueryRequest.put("pageSize", 1);
        ggHierarchyQueryRequest.put("startPage", 1);

        GgHierarchyResponse response = JSON.parseObject(Postjson.execute(api_path, ggHierarchyRequest.toJSONString(), token), GgHierarchyResponse.class);
        Assert.assertEquals(0, response.getTotal());
    }
}
