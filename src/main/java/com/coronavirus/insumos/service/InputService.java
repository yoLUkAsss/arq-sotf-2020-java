package com.coronavirus.insumos.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.coronavirus.insumos.dto.InputDto;
import com.coronavirus.insumos.model.Input;
import com.coronavirus.insumos.repository.BaseRepository;
import com.coronavirus.insumos.repository.InputRepository;

public class InputService extends BaseService<Input, InputDto> {

	@Autowired
	private InputRepository inputRepository;
	
	@Override
	public BaseRepository<Input> getBaseRepository() {
		return this.inputRepository;
	}

}
