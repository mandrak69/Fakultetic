package eng.dragan.markovic.fon.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eng.dragan.markovic.fon.model.CityDto;
import eng.dragan.markovic.fon.repository.CityRepository;
import eng.dragan.markovic.fon.service.CityService;
import eng.dragan.markovic.fon.entity.CityEntity;


@Service
@Transactional
public class CityServiceImpl implements CityService {
	@Qualifier(value = "cityJpaRepository")
	@Autowired
	private CityRepository<CityEntity> cityRepository;
	


	@Override
	public void save(CityDto cityDto) {
		CityEntity city = new CityEntity(null,cityDto.getNumber(), cityDto.getName());
		System.out.println("from citySevice save city"+city.toString());
		cityRepository.save(city);
	}

	@Override
	public List<CityDto> getAll() {
		List<CityDto> cities = new ArrayList<CityDto>();
		List<CityEntity> cityiesEntity = cityRepository.findAll();
		for (CityEntity cityEntity : cityiesEntity) {
			cities.add(new CityDto(cityEntity.getId(), cityEntity.getName()));
		}
		return cities;
	}

	@Override
	public CityDto findById(Long id) {
		CityEntity cityEntity = cityRepository.findById(id);
		CityDto cityDto = new CityDto(cityEntity.getId(), cityEntity.getName());
		return cityDto;
	}
	
	
}
