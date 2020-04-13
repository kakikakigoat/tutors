package tutors.app.top;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tutors.app.profile.helper.S3DownloadHelper;
import tutors.domain.model.LessonMenu;
import tutors.domain.model.Region;
import tutors.domain.model.Subject;
import tutors.domain.model.Teacher;

import tutors.domain.repository.RegionRepository;
import tutors.domain.repository.SubjectRepository;
import tutors.domain.repository.TeacherRepository;
import tutors.domain.repository.UserRepository;
import tutors.domain.service.teacher.TeacherService;

@Controller
public class TopController {
	@Autowired 
	TeacherService teacherService;
	@Autowired 
	UserRepository userRepository;
	@Autowired 
	TeacherRepository teacherRepository;
	@Autowired
	RegionRepository regionRepository;
	@Autowired
	SubjectRepository subjectRepository;
	@Autowired
	HttpSession session;
	
	@Autowired
    S3DownloadHelper s3DownloadHelper;

	

	@RequestMapping("top")
	String showTop(Model model) {
		//トップ画面
		List<Teacher> teacherList = teacherRepository.findTopTeacher();
		for(Teacher teacher:teacherList) {
		    List<LessonMenu> lessonMenus = teacher.getUser().getLessonMenus();
		    Collections.sort(lessonMenus, new DayOfTheWeekComparator());
		}
		List<Region> regionList = regionRepository.findAll();
		List<Subject> subjectList = subjectRepository.findAll();
		model.addAttribute("regionList",regionList);
		model.addAttribute("subjectList",subjectList);
		model.addAttribute("teacherList",teacherList);
		return "top/top";
	}
	
	
	@GetMapping(value="top/search")
	String showSearchResult(Model model,Pageable pageable,
			@RequestParam Subject subject,
			@RequestParam Region region) {
		//教師の検索
		Page<Teacher> teacherPage = teacherService.searchTeacher(subject,region,pageable);
		if(teacherPage == null || teacherPage.isEmpty()) {
			model.addAttribute("msg","条件に当てはまる教師はいませんでした");
		}
		List<Teacher> teacherList = teacherPage.getContent();
        for(Teacher teacher:teacherList) {
            List<LessonMenu> lessonMenus = teacher.getUser().getLessonMenus();
            Collections.sort(lessonMenus, new DayOfTheWeekComparator());
        }
		List<Region> regionList = regionRepository.findAll();
		List<Subject> subjectList = subjectRepository.findAll();
		model.addAttribute("region",region);
		model.addAttribute("subject",subject);
		model.addAttribute("pageable",pageable);
		model.addAttribute("regionList",regionList);
		model.addAttribute("subjectList",subjectList);
		model.addAttribute("page",teacherPage);
		model.addAttribute("teacherList",teacherList);
		model.addAttribute("url","/top/search");

		return "top/search";
	}
}

