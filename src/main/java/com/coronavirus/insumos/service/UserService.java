package com.coronavirus.insumos.service;
import static java.util.Collections.emptyList;
import javax.transaction.Transactional;

import com.coronavirus.insumos.users.User;
import com.coronavirus.insumos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.coronavirus.insumos.repository.BaseRepository;
import com.coronavirus.insumos.dto.UserDto;

@Transactional
@Service
public class UserService extends BaseService<User, UserDto> implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserRepository getBaseRepository() {
		return this.userRepository;
	}

	public User findByEmail(String email){ return this.userRepository.findByEmail(email); }

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User usuario = userRepository.findByUsername(email);
		if (usuario == null) {
			throw new UsernameNotFoundException(email);
		}
		return new org.springframework.security.core.userdetails.User(usuario.getUsername(), usuario.getPassword(), emptyList());
	}
}
