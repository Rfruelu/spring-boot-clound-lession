package com.lujia;

import com.lujia.repository.RedisRoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.HandlerInterceptor;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringlessonjpaApplicationTests {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext applicationContext;

    @Autowired
    private RedisRoleRepository redisRoleRepository;


    @Test
    public void testInsert(){

       // redisRoleRepository.save();
    }

    @Test
    public void contextLoads() throws Exception {

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/index")).andReturn();

        int status = mvcResult.getResponse().getStatus();
        String contentAsString = mvcResult.getResponse().getContentAsString();

        Assert.assertEquals("请求错误",200,status);

        log.info("contentAsString:"+contentAsString);

    }


    @Test
    public void testRedisRoles() throws Exception {

        MvcResult mvcResult =mockMvc.perform(MockMvcRequestBuilders.get("/redis/role/getAll"))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals("请求错误",200,status);

        HandlerInterceptor[] interceptors = mvcResult.getInterceptors();

        log.error("interceptors[0]:"+interceptors[0].getClass().getName());
        MockHttpServletResponse response = mvcResult.getResponse();
        String contentAsString = response.getContentAsString();
        //Object asyncResult = mvcResult.getAsyncResult(1000);

        log.error("contentAsString:"+contentAsString);
    }

    @Before
    public void before() {
        mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
    }
}
