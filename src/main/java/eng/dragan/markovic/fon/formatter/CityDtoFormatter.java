package eng.dragan.markovic.fon.formatter;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import eng.dragan.markovic.fon.model.CityDto;
import eng.dragan.markovic.fon.service.CityService;



public class CityDtoFormatter implements Formatter<CityDto>{
	private final CityService cityService;
	
	@Autowired
	public CityDtoFormatter(CityService cityService) {
		System.out.println("=======CityDtoFormatter: constructor============================================");
		this.cityService = cityService;
	}
	
	@Override
	public String print(CityDto cityDto, Locale locale) {
		System.out.println("=======CityDtoFormatter: print============================================");
		System.out.println(cityDto);
		System.out.println("==========================================================================");
		return cityDto.toString();
	}

	@Override
	public CityDto parse(String city, Locale locale) {
		System.out.println("=======CityDtoFormatter: parse============================================");
		System.out.println(city);
		System.out.println("==========================================================================");
		
		Long number=Long.parseLong(city);
		System.out.println(number);
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		CityDto cityDto = cityService.findById(number);
		System.out.println("==========================================================================");
		return cityDto;
	}

}
