package eng.dragan.markovic.fon.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import eng.dragan.markovic.fon.entity.UserEntity;


@Repository(value = "userJpaRepository")
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findByUsername(String username);
}
