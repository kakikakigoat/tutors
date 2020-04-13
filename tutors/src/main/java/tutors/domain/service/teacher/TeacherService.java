package tutors.domain.service.teacher;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tutors.domain.model.Region;
import tutors.domain.model.Subject;
import tutors.domain.model.Teacher;
import tutors.domain.repository.TeacherRepository;
import tutors.domain.repository.UserRepository;

@Service
@Transactional
public class TeacherService {
	@Autowired
	TeacherRepository teacherRepository;
	@Autowired
	UserRepository userRepository;


	//教師の作成
	public Teacher createteacher(Integer userId,int minWage,String policy) {
		Teacher teacher = new Teacher();
		teacher.setTeacherUserId(userId);
		teacher.setMinWage(minWage);
		teacher.setPolicy(policy);
		return teacherRepository.save(teacher);
	}

	//教師の検索
	public Page<Teacher> searchTeacher(Subject subject,Region region,Pageable pageable) {
		if(subject == null && region != null) {
			return teacherRepository
					.findByUser_Region_RegionId(region.getRegionId(),pageable);
		}
		else if(region == null && subject != null) {
			return teacherRepository
					.findByUser_Subjects_SubjectId(subject.getSubjectId(),pageable);
		} 
		else if(region == null && subject == null) {
			return teacherRepository.findAll(pageable);
		}else {
			return teacherRepository.findByUser_Region_RegionIdAndUser_Subjects_subjectId(
					region.getRegionId(), subject.getSubjectId(),pageable);
		}		
	}
}
