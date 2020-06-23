package com.coronavirus.insumos.users;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coronavirus.insumos.baseClasses.BaseRepository;
import com.coronavirus.insumos.baseClasses.BaseService;
import com.coronavirus.insumos.users.dto.UserDto;

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
