package com.coronavirus.insumos.dto;

import com.coronavirus.insumos.model.Input;

public class InputDto extends BaseDTO<Input> {
	
	private Long id;
	private String name;
	private String description;

	
	public InputDto() {}
	
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
