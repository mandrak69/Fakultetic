package eng.dragan.markovic.fon.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import eng.dragan.markovic.fon.formatter.CityDtoFormatter;
import eng.dragan.markovic.fon.service.CityService;


@EnableWebMvc 
@ComponentScan(basePackages = {
		"eng.dragan.markovic.fon.controller",
		"eng.dragan.markovic.fon.exception"
})
@Configuration
public class MyWebContextConfig implements WebMvcConfigurer{
	
	private CityService cityService;
	
	@Autowired
	public MyWebContextConfig(CityService cityService) {
		
		this.cityService = cityService;
	}
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setOrder(1);
		return viewResolver;
	}
	
	
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");}
	
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatter(new CityDtoFormatter(cityService));
	}
}
