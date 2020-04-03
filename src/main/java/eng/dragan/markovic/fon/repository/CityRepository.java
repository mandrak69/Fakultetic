package eng.dragan.markovic.fon.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import eng.dragan.markovic.fon.entity.CityEntity;

public interface CityRepository<T> extends CrudRepository<CityEntity, Long>{
	
}
