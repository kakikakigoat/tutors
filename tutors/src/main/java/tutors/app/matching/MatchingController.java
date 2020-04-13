package tutors.app.matching;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tutors.app.top.DayOfTheWeekComparator;
import tutors.domain.model.LessonMenu;
import tutors.domain.model.Matching;
import tutors.domain.model.Region;
import tutors.domain.model.Teacher;
import tutors.domain.model.User;
import tutors.domain.repository.MatchingRepository;
import tutors.domain.repository.RegionRepository;
import tutors.domain.repository.TeacherRepository;
import tutors.domain.repository.UserRepository;
import tutors.domain.service.user.LoginUserDetails;

@Controller
@RequestMapping("profile")
public class MatchingController
{
    
    @Autowired
    UserRepository userRepository;
    
    @Autowired 
    TeacherRepository teacherRepository;
    
    @Autowired
    RegionRepository regionRepository;
    
    @Autowired
    MatchingRepository matchingRepository;
    
    @ModelAttribute
    public MatchingForm matchingForm() {
        return new MatchingForm();
    }
    
    
    
    @GetMapping("/{userId}/matching")
    String showContactForm(@PathVariable("userId") Integer teacherUserId,
            @AuthenticationPrincipal LoginUserDetails userDetails,
            Model model) {
        Teacher teacher = teacherRepository.findById(teacherUserId).orElse(null);
        List<LessonMenu> lessonMenus = teacher.getUser().getLessonMenus();
        Collections.sort(lessonMenus, new DayOfTheWeekComparator());
        List<Region> regionList = regionRepository.findAll();
        
        User authUser = userDetails.getUser();
        User user = userRepository.findById(authUser.getUserId()).orElse(null);
        
        model.addAttribute("user",user);
        model.addAttribute("teacher",teacher);
        model.addAttribute("regionList",regionList);
        return "matching/application";
        
    }
    
    @PostMapping("/{userId}/matching")
    String submitContact(@Validated MatchingForm matchingForm, 
            BindingResult bindingResult,
            @PathVariable("userId") Integer userId,
            @AuthenticationPrincipal LoginUserDetails userDetails,
            Model model) {
        Teacher teacher = teacherRepository.findById(userId).orElse(null);
        User matchTeacher = userRepository.findById(userId).orElse(null);
        User authUser = userDetails.getUser();
        User user = userRepository.findById(authUser.getUserId()).orElse(null);
        List<Region> regionList = regionRepository.findAll();
        
        if(bindingResult.hasErrors()) {
            model.addAttribute("teacher",teacher);
            model.addAttribute("user",user);
            model.addAttribute("regionList",regionList);
            System.out.println("error");
            return "matching/application";
        }
        
        Date applicationDate = new Date();  //現在時刻を取得
        Matching matching = new Matching();
        Region region = regionRepository.findById(matchingForm.getRegionId()).orElse(null);
        matching.setUser1(matchTeacher);
        matching.setUser2(user);
        matching.setRegion(region);
        matching.setWage(matchingForm.getWage());
        matching.setApplicationDate(applicationDate);
        matching.setContactAvailability(null);
        matchingRepository.save(matching);
        System.out.println("SAVE");
        return "redirect:/profile/tutor";
    }
    
    @GetMapping("matching/complete")
    String showMatchingComplete() {
        return "matching/complete";
    }
    
    @GetMapping("/tutor")
    String showProfileTutor(
            @AuthenticationPrincipal LoginUserDetails userDetails,
            Model model) {
        User authUser = userDetails.getUser();
        int userId = authUser.getUserId();
        //TUTOR承認可否を行っていないmatchingList
        List<Matching> unapprovedMatchingList =
                matchingRepository.findByUser1_userIdAndContactAvailabilityIsNullOrderByApplicationDateDesc(userId);
        //申請中のTUTORリスト
        List<Matching> applyingMatchingList = 
                matchingRepository.findByUser2_userIdAndContactAvailabilityIsNullOrderByApplicationDateDesc(userId);
        //契約中のTUTORリスト
        List<Matching> underContractMatchingList = 
                matchingRepository.findByUser2_userIdAndContactAvailabilityAndContactEndTimeIsNullOrderByApplicationDateDesc(userId, true);
        
        //契約中の生徒リスト
        List<Matching> underContractStudentMatchingList = 
                matchingRepository.findByUser1_userIdAndContactAvailabilityAndContactEndTimeIsNullOrderByApplicationDateDesc(userId, true);
        
        
        
        model.addAttribute("unapprovedMatchingList",unapprovedMatchingList);
        model.addAttribute("applyingMatchingList",applyingMatchingList);
        model.addAttribute("underContractMatchingList",underContractMatchingList);
        model.addAttribute("underContractStudentMatchingList",underContractStudentMatchingList);
        return "profile/tutor";
    }
    
    
    
    
    //TUTORリクエストに対して拒否された時
    @PostMapping("/tutor/reject")
    String rejectTutor(
            @RequestParam("userId")Integer user2Id,
            @AuthenticationPrincipal LoginUserDetails userDetails) {
        User authUser = userDetails.getUser();
        int user1Id = authUser.getUserId();
        Matching matching = matchingRepository
                .findTopByUser1_userIdAndUser2_userIdAndContactAvailabilityIsNullOrderByApplicationDateDesc
                (user1Id, user2Id);
        //falseをセットしてsave
        Date approvalDate = new Date();
        matching.setApprovalDate(approvalDate);
        matching.setContactAvailability(false);
        matchingRepository.save(matching);
        return "redirect:/profile/tutor";
    }
  //TUTORリクエストに対して承認された時
    @PostMapping("/tutor/approve")
    String approveTutor(
            @RequestParam("userId")Integer user2Id,
            @AuthenticationPrincipal LoginUserDetails userDetails) {
        User authUser = userDetails.getUser();
        int user1Id = authUser.getUserId();
        Matching matching = matchingRepository
                .findTopByUser1_userIdAndUser2_userIdAndContactAvailabilityIsNullOrderByApplicationDateDesc
                (user1Id, user2Id);
        //承認時刻と承認可否をセットしてsave
        Date approvalDate = new Date();
        matching.setApprovalDate(approvalDate);
        matching.setContactAvailability(true);
        matchingRepository.save(matching);
        return "redirect:/profile/tutor";
    }
    @PostMapping("/tutor/finishContact")
    String finish(
            @RequestParam("userId")Integer teacherId,
            @AuthenticationPrincipal LoginUserDetails userDetails) {
        User authUser = userDetails.getUser();
        int studentId = authUser.getUserId();
        Matching matching = matchingRepository
                .findTopByUser1_userIdAndUser2_userIdAndContactEndTimeIsNullOrderByApplicationDateDesc
                (teacherId, studentId);
        Date contactEndTime = new Date();
        System.out.println(contactEndTime);
        matching.setContactEndTime(contactEndTime);
        matchingRepository.save(matching);
        return "redirect:/profile/tutor";
    }
    
}


