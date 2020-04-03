package eng.dragan.markovic.fon.service;

import java.util.List;

import eng.dragan.markovic.fon.model.CityDto;


public interface CityService {
	void save(CityDto cityDto);
	List<CityDto> getAll();
	CityDto findById(Long id);
}
