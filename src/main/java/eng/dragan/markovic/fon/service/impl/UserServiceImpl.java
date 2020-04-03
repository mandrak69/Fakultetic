package eng.dragan.markovic.fon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eng.dragan.markovic.fon.converter.UserConverter;
import eng.dragan.markovic.fon.entity.UserEntity;
import eng.dragan.markovic.fon.model.UserDto;
import eng.dragan.markovic.fon.repository.jpa.UserRepository;
import eng.dragan.markovic.fon.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	private final UserRepository userRepository;
	private final UserConverter userConverter;
	
	@Autowired
	UserServiceImpl(UserRepository userRepository,UserConverter userConverter){
		this.userRepository = userRepository;
		this.userConverter = userConverter;
	}
	@Override
	public UserDto findByUsername(String username) {
		UserEntity userEntity = userRepository.findByUsername(username);
		return userConverter.entityToDto(userEntity);
	}

}
