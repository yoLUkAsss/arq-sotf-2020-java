package com.coronavirus.insumos.service;

import javax.transaction.Transactional;

import com.coronavirus.insumos.users.User;
import com.coronavirus.insumos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coronavirus.insumos.repository.BaseRepository;
import com.coronavirus.insumos.dto.UserDto;

@Transactional
@Service
public class UserService extends BaseService<User, UserDto> {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public BaseRepository<User> getBaseRepository() {
		return this.userRepository;
	}

}
