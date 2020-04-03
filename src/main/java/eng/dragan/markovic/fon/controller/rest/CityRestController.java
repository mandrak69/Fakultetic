package eng.dragan.markovic.fon.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eng.dragan.markovic.fon.model.CityDto;
import eng.dragan.markovic.fon.service.CityService;

@RestController
@RequestMapping("api/v1/cities")
public class CityRestController {
	@Autowired
	CityService cityService;

	@GetMapping
	public List<CityDto> getAll() {
		return cityService.getAll();
	}
}
