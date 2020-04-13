package tutors.domain.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import tutors.domain.model.*;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
	Page<Teacher> findByUser_Region_RegionId(int regionId,Pageable pageable);
	Page<Teacher> findByUser_Subjects_SubjectId(int subjectId,Pageable pageable);
	Page<Teacher> findByUser_Region_RegionIdAndUser_Subjects_subjectId(int regionId,int subjectId,Pageable pageable);
	Page<Teacher> findAll(Pageable pageable);
	
	
	@Query(value="SELECT * FROM TEACHER ORDER BY RAND() LIMIT 10"
            ,nativeQuery = true)
    List<Teacher> findTopTeacher();
}
