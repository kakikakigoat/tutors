package tutors.domain.service.teacher;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tutors.domain.model.LessonMenu;
import tutors.domain.model.LessonMenuPK;
import tutors.domain.repository.LessonMenuRepository;

@Service
@Transactional
public class LessonMenuService {
	
	@Autowired
	LessonMenuRepository lessonMenuRepository;
	
	public LessonMenu createLessonMenu(Integer userId,String dayOfTheWeek,LocalTime startTime,LocalTime endTime) {
		LessonMenuPK lessonMenuPK = new LessonMenuPK();
		LessonMenu lessonMenu = new LessonMenu();
		lessonMenuPK.setTeacherUserId(userId);
		lessonMenuPK.setDayOfTheWeek(dayOfTheWeek);
		lessonMenu.setLessonMenuEndTime(endTime);
		lessonMenu.setLessonMenuStartTime(startTime);
		lessonMenu.setId(lessonMenuPK);
		return lessonMenuRepository.save(lessonMenu);
		
	}
	

}
