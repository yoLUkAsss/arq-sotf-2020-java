package com.coronavirus.insumos;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.coronavirus.insumos.service.UserService;
import com.coronavirus.insumos.users.User;
import com.coronavirus.insumos.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserServiceTest {
	
	@Autowired
	private UserService userService;

	@Test
	public void testCanCreateUser() {
		User user = new User();
		user.setEmail("sandoval.lucasj@gmail.com");
		user.setEntity("Entidad");
		user.setFullname("Sandoval Lucas");
		user.setLocation("Location");
		user.setPassword("password");
		user.setPhone("Telefono");
		user.setPosition("Position");
		user.setUsername("lsandoval");
		
		User created = userService.create(user);
		
		assertNotNull(created.getId());
	}

}
