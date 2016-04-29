package com.pl.alkosoft;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MkCrudStarter.class)
@WebAppConfiguration
@IntegrationTest
public class MkCrudStarterTests {

	@Autowired
	WebApplicationContext webContext;
	MockMvc mockMvc;

	@Before
	public void setUp() throws Exception{
		mockMvc = MockMvcBuilders.webAppContextSetup(webContext).build();
	}

	@Test
	public void contextLoads() throws Exception {
		mockMvc.perform(get("/playerslistjpa")).andExpect(status().isOk());
	}

/*	@Test
	public void setWebServiceByTomcat() throws Exception{
		HttpStatus statusCode = new RestTemplate().getForEntity("http://localhost:8082/products", Object.class).getStatusCode();
		assertTrue(statusCode.is2xxSuccessful());
	}*/

}
