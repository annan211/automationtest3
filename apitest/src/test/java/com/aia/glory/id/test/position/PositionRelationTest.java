package com.aia.glory.id.test.position;

import com.aia.glory.id.TestReports;
import com.aia.glory.id.beans.PostJson;
import com.aia.glory.id.login.entity.LoginResponse;
import com.aia.glory.id.model.Response;
import com.aia.glory.id.position.entity.GetPositionRelationResponse;
import com.aia.glory.id.test.ApplicationTest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
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
public class PositionRelationTest extends TestReports {

    @Value("${server.url.channel}")
    private String url;

    @Value("${server.url.user}")
    private String userUrl;

    @Autowired
    private PostJson Postjson;

    @Value("${server.auth.username}")
    private String userName;

    @Value("${server.auth.password}")
    private String password;

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
        String api_path = url + "positionRelation";

        JSONObject positionRelationUpdateRequest = new JSONObject();
        JSONArray positionRelationModel = new JSONArray();

        JSONObject prm = new JSONObject();
        prm.put("positionRelationSeq",seq);
        prm.put("parentpositionSeq",seq);
        prm.put("childpositionSeq",seq);
        prm.put("positionRelationTypeSeq",seq);
        prm.put("effectiveStartDate","2020-01-01");
        prm.put("effectiveEndDate","2025-01-01");
        prm.put("removeDate","2020-01-01");
        positionRelationModel.add(prm);

        JSONObject positionRelationTypeModel = new JSONObject();
        positionRelationTypeModel.put("active",1);
        positionRelationTypeModel.put("createDate","2020-01-01");
        positionRelationTypeModel.put("dataTypeSeq",seq);
        positionRelationTypeModel.put("description","test");
        positionRelationTypeModel.put("name",seq+"UT");
        positionRelationTypeModel.put("removeDate","2020-01-01  ");
        positionRelationTypeModel.put("positionRelationModel",positionRelationModel);

        positionRelationUpdateRequest.put("action", "INSERT");
        positionRelationUpdateRequest.put("positionRelationTypeModel", positionRelationTypeModel);

        Response response = JSON.parseObject(Postjson.execute(api_path, positionRelationUpdateRequest.toJSONString(), token), Response.class);
        Assert.assertEquals("000", response.getResponseCode());
    }


    //@Test
    public void test02Query() {
        String api_path = url + "positionRelation";

        JSONObject positionRelationRequest = new JSONObject();

        positionRelationRequest.put("action", "GET");
        positionRelationRequest.put("name", seq+"UT");
        positionRelationRequest.put("startPage", 1);
        positionRelationRequest.put("pageSize", 10);

        GetPositionRelationResponse response = JSON.parseObject(Postjson.execute(api_path, positionRelationRequest.toJSONString(), token), GetPositionRelationResponse.class);
        Assert.assertEquals(1, response.getTotal());
    }

    //@Test
    public void test03Update() {
        String api_path = url + "positionRelation";

        JSONObject positionRelationRequest = new JSONObject();

        positionRelationRequest.put("action", "UPDATE");
        positionRelationRequest.put("name", seq+"UT");
        positionRelationRequest.put("startPage", 1);
        positionRelationRequest.put("pageSize", 10);

        GetPositionRelationResponse response = JSON.parseObject(Postjson.execute(api_path, positionRelationRequest.toJSONString(), token), GetPositionRelationResponse.class);
        Assert.assertEquals(1, response.getTotal());
    }

}
