package eng.dragan.markovic.fon.converter;

import org.springframework.stereotype.Component;

import eng.dragan.markovic.fon.entity.UserEntity;
import eng.dragan.markovic.fon.model.UserDto;

@Component
public class UserConverter {

	public UserDto entityToDto(UserEntity userEntity) {
		return new UserDto(userEntity.getId(), userEntity.getUsername(),userEntity.getPassword());}

}
