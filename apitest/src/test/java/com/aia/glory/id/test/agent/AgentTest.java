package com.aia.glory.id.test.agent;

import com.aia.glory.id.TestReports;
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
public class AgentTest extends TestReports {

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

    @Before
    public void before()  {
        String api_path = userUrl+"token";

        JSONObject json = new JSONObject();
        json.put("loginId",userName);
        json.put("password",password);

        LoginResponse response = JSON.parseObject(Postjson.execute(api_path,json.toJSONString(),null),LoginResponse.class);
        token = response.getToken().getJwtToken();
    }

    @After
    public void after()  { }



    @Test
    public void getAgentTest() {
        String api_path = url+"agent";

        JSONObject json = new JSONObject();
        json.put("action","GET");
        json.put("isLast","1");
        json.put("startPage",1);
        json.put("pageSize",1);

        Response response = JSON.parseObject(Postjson.execute(api_path,json.toJSONString(),token),Response.class);
        Assert.assertEquals("000",response.getResponseCode());
    }

    @Test
    public void retrieveExtendParticipantFieldDescTest(){
        String api_path = url+"agent";

        JSONObject json = new JSONObject();
        json.put("action","GETPARTEXTDESC");
        json.put("isLast","1");
        json.put("startPage",1);
        json.put("pageSize",1);

        Response response = JSON.parseObject(Postjson.execute(api_path,json.toJSONString(),token),Response.class);
        Assert.assertEquals("000",response.getResponseCode());
    }

    @Test
    public void retrieveExtendPositionFieldDescTest(){
        String api_path = url+"agent";

        JSONObject json = new JSONObject();
        json.put("action","GETPOSEXTDESC");
        json.put("isLast","1");
        json.put("startPage",1);
        json.put("pageSize",1);

        Response response = JSON.parseObject(Postjson.execute(api_path,json.toJSONString(),token),Response.class);
        Assert.assertEquals("000",response.getResponseCode());
    }

    @Test
    public void getAgentLists(){
        String api_path = url+"agent";

        JSONObject json = new JSONObject();
        json.put("action","GETLIST");
        json.put("isLast","1");
        json.put("startPage",1);
        json.put("pageSize",1);

        Response response = JSON.parseObject(Postjson.execute(api_path,json.toJSONString(),token),Response.class);
        Assert.assertEquals("000",response.getResponseCode());
    }

    //@Test
    public void careerRelateSearch(){

        String api_path = url+"careerRelateSearch";
        JSONObject positionModel = new JSONObject();
        positionModel.put("positionSeq","1119");
        positionModel.put("agencyCode","d");
        positionModel.put("channelCode","Agency Channel");
        positionModel.put("districtCode","ddddd");
        positionModel.put("entityType","ss");
        positionModel.put("companyCode","PAL");
        positionModel.put("leaderCode","LLLLLL");
        positionModel.put("title","UM");
        positionModel.put("entityLeader","Y");

        JSONObject json = new JSONObject();
        json.put("action","GET");
        json.put("positionModel",positionModel);

        Response response = JSON.parseObject(Postjson.execute(api_path,json.toJSONString(),token),Response.class);
        Assert.assertEquals("000",response.getResponseCode());
    }

}
