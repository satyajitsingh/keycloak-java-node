package com.hmpo.hmdemo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hmpo.hmdemo.controller.KeycloakController;
import com.hmpo.hmdemo.services.KeyCloakService;

import junit.framework.Assert;

import com.hmpo.hmdemo.datamodel.UserDTO;
import com.hmpo.hmdemo.datamodel.KeyCloakState;
import com.hmpo.hmdemo.datamodel.UserCredentials;
import com.hmpo.hmdemo.controller.KeycloakController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HmdemoApplication.class)
@WebAppConfiguration
public  class KeycloakJavaTests {
	
	private MockMvc mvc;
	
	
	@Autowired
	WebApplicationContext webApplicationContext;
	
	
    private KeycloakController controllerMock = mock(KeycloakController.class);
	private KeyCloakService mock = mock(KeyCloakService.class);
	private KeyCloakState mockKeystate = mock(KeyCloakState.class);

	
	
	 
	/*----tests */

    @SuppressWarnings("deprecation")
	@Test
	public void controllerTest() throws Exception {
    	
    	assertThat(controllerMock).isNotNull();
    }
    
    @Test
    public void contexLoads() throws Exception {
    	assertThat(mock).isNotNull();
    }
    
    @Test
    public void verifyUser() throws Exception {
    	
    	/*Test to verify user in KeyCloak
    	 * 
    	 */
        UserCredentials uCred = new UserCredentials();
        uCred.setUsername("testuser");
        uCred.setPassword("password");
        String token="";
        
        when(mock.getToken(uCred)).thenReturn(token);
        token = mock.getToken(uCred);
        Assert.assertNotNull(token);
    }
    

	@Test
    public void createUser() {
    	/*Test to create a user in KeyCloak
    	 * 
    	 */
    	UserDTO uDTO = new UserDTO();
    	uDTO.setFirstName("UserFname");
    	uDTO.setLastName("UserLastName");
    	uDTO.setEmailAddress("testmail@email.com");
    	uDTO.setUserName("userName");
    	uDTO.setPassword("password");
    	KeyCloakState kc = new KeyCloakState();
    	kc.setstatusId(201);
    	kc.setMessage("User created in keycloak successfully");
    	int successStatus = 201;
    	
    	when(mock.createUser(uDTO)).thenReturn(kc);
    	assertEquals("User created in keycloak successfully", kc.getMessage());
    	assertEquals(successStatus, kc.getstatusId().intValue());
    }
    
   
}


