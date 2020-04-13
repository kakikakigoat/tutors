package tutors.domain.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tutors.domain.model.Subject;
import tutors.domain.model.User;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    
    List<Subject>findByUsersIn(List<User> users);
}
