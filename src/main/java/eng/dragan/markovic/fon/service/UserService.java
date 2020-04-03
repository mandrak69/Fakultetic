package eng.dragan.markovic.fon.service;

import eng.dragan.markovic.fon.model.UserDto;

public interface UserService {
	UserDto findByUsername(String username);
}
