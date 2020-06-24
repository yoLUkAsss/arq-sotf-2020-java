package com.coronavirus.insumos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.coronavirus.insumos.model.Input;
import com.coronavirus.insumos.service.InputService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class InputServiceTest {

	@Autowired
	private InputService inputService;
	
	@Test
	void testCanCreateInput() {
		Input barbijo = new Input();
		barbijo.setName("Barbijo Medico");
		barbijo.setDescription("Herramienta utilizada por el sistame medico universal");
		
		Input barbijoCreated = inputService.create(barbijo);
		
		assertNotNull(barbijoCreated);
		assertNotNull(barbijoCreated.getId());
	}

}
