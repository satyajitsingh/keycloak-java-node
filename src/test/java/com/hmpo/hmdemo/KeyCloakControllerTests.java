package com.hmpo.hmdemo;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import javax.ws.rs.core.MediaType;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hmpo.hmdemo.controller.KeycloakController;
import com.hmpo.hmdemo.datamodel.UserDTO;
import com.hmpo.hmdemo.services.KeyCloakService;

@RunWith(SpringRunner.class)
@WebMvcTest(KeycloakController.class)
public class KeyCloakControllerTests {
	
	 @Autowired MockMvc mvc;
	
	@Autowired
	WebApplicationContext webApplicationContext;
	
	@MockBean KeyCloakService kcService;
	
	
	
	 @Test
	    public void controllerCreateUser() throws Exception {
	    	String uri = "/user/create";
	    	
	    	UserDTO uDTO = new UserDTO();
	       	uDTO.setUserName("userName");
	       	uDTO.setPassword("password");
	       	uDTO.setEmailAddress("testmail@email.com");
	       	uDTO.setFirstName("UserFname");
	       	uDTO.setLastName("UserLastName");
	       	
	        ObjectMapper objectMapper = new ObjectMapper();
			String output = objectMapper.writeValueAsString(uDTO);
	       	
	       	 mvc.perform(post(uri)
	       	      .contentType(MediaType.APPLICATION_JSON)
	       	      .content(output));
	       	      
	       	 	  //.andExpect(status().isOk());
	       	
	     
	    	
	    }

}
