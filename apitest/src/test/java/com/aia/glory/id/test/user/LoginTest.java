package com.aia.glory.id.test.user;

import com.aia.glory.id.TestReports;
import com.aia.glory.id.beans.PostJson;
import com.aia.glory.id.login.entity.LoginResponse;
import com.aia.glory.id.test.ApplicationTest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
public class LoginTest  extends TestReports {

    @Autowired
    private PostJson Postjson;

    @Value("${server.url.user}")
    private String url;

    @Value("${server.auth.username}")
    private String userName;

    @Value("${server.auth.password}")
    private String password;

    @Before
    public void before()  { }

    @After
    public void after()  { }


    @Test
    public void loginTest() throws Exception{
        String api_path = url+"token";

        JSONObject json = new JSONObject();
        json.put("loginId",userName);
        json.put("password",password);

        LoginResponse response = JSON.parseObject(Postjson.execute(api_path,json.toJSONString(),null),LoginResponse.class);

        Assert.assertEquals(response.getToken().getUser().getLoginId(),"ASNPI6D");
    }
}
