package tutors.domain.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import tutors.domain.model.*;

@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByMailAddress(String mailAddress);
	
}
