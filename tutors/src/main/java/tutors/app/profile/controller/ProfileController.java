package tutors.app.profile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import tutors.app.profile.form.*;
import tutors.app.profile.helper.S3DownloadHelper;
import tutors.app.profile.helper.S3UploadHelper;
import tutors.domain.model.LessonMenu;
import tutors.domain.model.Matching;
import tutors.domain.model.Region;
import tutors.domain.model.Subject;
import tutors.domain.model.Teacher;
import tutors.domain.model.User;
import tutors.domain.repository.LessonMenuRepository;
import tutors.domain.repository.MatchingRepository;
import tutors.domain.repository.RegionRepository;
import tutors.domain.repository.SubjectRepository;
import tutors.domain.repository.TeacherRepository;
import tutors.domain.repository.UserRepository;
import tutors.domain.service.teacher.LessonMenuService;
import tutors.domain.service.teacher.TeacherService;
import tutors.domain.service.user.LoginUserDetails;
import tutors.domain.service.user.UserService;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Controller
public class ProfileController {
    @Autowired
    UserService userService;
    @Autowired 
    TeacherService teacherService;
    @Autowired
    LessonMenuService lessonMenuService;
    @Autowired 
    UserRepository userRepository;
    @Autowired 
    RegionRepository regionRepository;
    @Autowired 
    SubjectRepository subjectRepository;
    @Autowired 
    TeacherRepository teacherRepository;
    @Autowired
    LessonMenuRepository lessonMenuRepository;
    @Autowired
    MatchingRepository matchingRepository;
    
    @Autowired
    S3DownloadHelper s3DownloadHelper;

    @Autowired
    S3UploadHelper s3UploadHelper;


    @ModelAttribute
    public UserEditForm userProfileForm() {
        return new UserEditForm();
    }
    @ModelAttribute
    public StudentEditForm studentProfileForm() {
        return new StudentEditForm();
    }
    @ModelAttribute
    public TeacherEditForm teacherProfileForm() {
        return new TeacherEditForm();
    }
    @ModelAttribute
    public FileUploadForm fileUploadForm() {
        return new FileUploadForm();
    }


    @GetMapping("/profile/{userId}")
    String showProfile(@PathVariable("userId") Integer userId,
            @ModelAttribute("userMsg")String userMsg,
            @ModelAttribute ("studentMsg") String studentMsg,
            @ModelAttribute ("teacherMsg") String teacherMsg,
            @AuthenticationPrincipal LoginUserDetails userDetails,
            Model model) {
        User user = userRepository.findById(userId).orElseGet(null);
        User authUser = userDetails.getUser();
        int authUserId = authUser.getUserId();
        
        List<User> users = new ArrayList<>();
        users.add(user);
        Teacher teacher = teacherRepository.findById(userId).orElse(null);
        List<LessonMenu> lessonMenus = lessonMenuRepository.searchLessonMenu(userId);
        List<Subject> subjectList = subjectRepository.findByUsersIn(users);
        Matching matching = matchingRepository.
                findTopByUser1_userIdAndUser2_userIdOrderByApplicationDateDesc(userId, authUserId);

        model.addAttribute("userMsg",userMsg);
        model.addAttribute("teacherMsg",teacherMsg);
        model.addAttribute("user",user);
        model.addAttribute("teacher",teacher);
        model.addAttribute("lessonMenus",lessonMenus);
        model.addAttribute("subjectList",subjectList);
        model.addAttribute("matching",matching);
        return "profile/userProfile";
    }
    //アップロードしている画像ファイルsample.jpgを取得し、データをレスポンス
    @GetMapping(value = "/image/{userId}",
            headers = "Accept=image/jpeg, image/jpg, image/png, image/gif",
            produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_GIF_VALUE})
    @ResponseBody
    public ResponseEntity<BufferedImage> getImage(@PathVariable("userId") Integer userId){
        User user = userRepository.findById(userId).orElse(null);
        String imagePath = user.getProfileImage();
        return ResponseEntity.ok().body(
                s3DownloadHelper.getImage(imagePath));
    }


    //-----------user profile編集--------------//

    @GetMapping("/profile/edit")
    String showProfileEdit(Model model) {
        List<Region> regionList = regionRepository.findAll();
        model.addAttribute("regionList",regionList);
        return "profile/userEdit";
    }


    @PostMapping(value="/profile/edit/")
    String create(@Validated UserEditForm userForm, 
            BindingResult bindingResult,
            @AuthenticationPrincipal LoginUserDetails userDetails,
            RedirectAttributes attributes,
            Model model) {
        if(bindingResult.hasErrors()) {
            return showProfileEdit(model);
        } 
        User user = userDetails.getUser();
        int userId = user.getUserId();
        user.setUserName(userForm.getUserName());
        user.setGender(userForm.getGender());
        user.setAge(userForm.getAge());
        user.setRegion(userForm.getRegion());
        user.setSelfIntroduction(userForm.getSelfIntroduction());
        userService.update(user);
        attributes.addFlashAttribute("userMsg", "※ユーザー情報を更新しました。");
        return "redirect:/profile/"+userId;
    }
    //プロフィール画像をアップロード
    @PostMapping("upload")
    public String upload(@Validated FileUploadForm fileUploadModel,
            BindingResult bindingResult,
            @AuthenticationPrincipal LoginUserDetails userDetails,
            Model model)throws IOException{
        if(bindingResult.hasErrors()) {
            return showProfileEdit(model);
        } 
        User user = userDetails.getUser();
        int userId = user.getUserId();
        String path = String.valueOf(userId);
        user.setProfileImage(path);
        userRepository.save(user);
        s3UploadHelper.saveImage(userId,fileUploadModel.getUploadFile());
        return "redirect:profile/edit";
    }


    //--------------教師プロフィール編集------------------//

    @GetMapping("/profile/teacherEdit/")
    String showTeacherProfileEdit(@AuthenticationPrincipal LoginUserDetails userDetails,
            Model model) {
        User user = userDetails.getUser();
        int userId = user.getUserId();
        Teacher teacher = teacherRepository.findById(userId).orElse(null);
        //データベースより教科一覧を取得
        List<Subject> subjectList = subjectRepository.findAll();
        TeacherEditForm teacherEditForm = new TeacherEditForm();
        teacherEditForm.setSubList(subjectList);
        //指導可能な教科を検索
        List<User> users = new ArrayList<>();
        users.add(user);
        List<Subject> teachableSubjects = subjectRepository.findByUsersIn(users);
        
        List<LocalTime> timeList = 
                Stream.iterate(LocalTime.of(0, 0),t -> t.plusMinutes(30))
                .limit(24*2)
                .collect(Collectors.toList());
        teacherEditForm.setTimeList(timeList);

        model.addAttribute("user",user);
        model.addAttribute("teacher",teacher);
        model.addAttribute("teacherEditForm",teacherEditForm);
        model.addAttribute("teachableSubjects",teachableSubjects);
        return "profile/teacherEdit";
    }


    @PostMapping("/profile/teacherEdit")
    String editTeacher(@Validated TeacherEditForm teacherEditForm, 
            BindingResult bindingResult,
            @AuthenticationPrincipal LoginUserDetails userDetails,
            RedirectAttributes attributes,
            Model model) {
        User user = userDetails.getUser();
        int userId = user.getUserId();
        List<Subject> subjectList = subjectRepository.findAll();
        List<LocalTime> timeList = 
                Stream.iterate(LocalTime.of(0, 0),t -> t.plusMinutes(30))
                .limit(24*2)
                .collect(Collectors.toList());


        //エラー処理
        if(bindingResult.hasErrors()) {
            Teacher teacher = teacherRepository.findById(userId).orElse(null);
            List<User> users = new ArrayList<>();
            users.add(user);
            List<Subject> teachableSubjects = subjectRepository.findByUsersIn(users);
            teacherEditForm.setSubList(subjectList);
            teacherEditForm.setTimeList(timeList);
            model.addAttribute("user",user);
            model.addAttribute("teacher",teacher);
            model.addAttribute("teachableSubjects",teachableSubjects);
            return "profile/teacherEdit";
        }

        //teacherTableへの保存
        teacherService.createteacher(userId, teacherEditForm.getMinWage(), teacherEditForm.getPolicy());
        //対象ユーザーのlessonMenuテーブルをリセット
        lessonMenuRepository.deleteByUser(user);
        //lessonMenuテーブルへの保存
        if(teacherEditForm.getMondayTimeFrom() != null) {
            lessonMenuService.createLessonMenu(userId,"月曜日", teacherEditForm.getMondayTimeFrom(), teacherEditForm.getMondayTimeTo());
        }
        if(teacherEditForm.getTuesdayTimeFrom() != null) {
            lessonMenuService.createLessonMenu(userId,"火曜日", teacherEditForm.getTuesdayTimeFrom(), teacherEditForm.getTuesdayTimeTo());
        }
        if(teacherEditForm.getWednesdayTimeFrom() != null) {
            lessonMenuService.createLessonMenu(userId,"水曜日", teacherEditForm.getWednesdayTimeFrom(), teacherEditForm.getWednesdayTimeTo());
        }
        if(teacherEditForm.getThursdayTimeFrom() != null) {
            lessonMenuService.createLessonMenu(userId,"木曜日", teacherEditForm.getThursdayTimeFrom(), teacherEditForm.getThursdayTimeTo());
        }
        if(teacherEditForm.getFridayTimeFrom() != null) {
            lessonMenuService.createLessonMenu(userId,"金曜日", teacherEditForm.getFridayTimeFrom(), teacherEditForm.getFridayTimeTo());
        }
        if(teacherEditForm.getSaturdayTimeFrom() != null) {
            lessonMenuService.createLessonMenu(userId,"土曜日", teacherEditForm.getSaturdayTimeFrom(), teacherEditForm.getSaturdayTimeTo());
        }
        if(teacherEditForm.getSundayTimeFrom() != null) {
            lessonMenuService.createLessonMenu(userId,"日曜日", teacherEditForm.getSundayTimeFrom(), teacherEditForm.getSundayTimeTo());
        }
        //userにあるsubjectをremove
        User teachUser = userRepository.findById(userId).orElse(null);
        for(Subject sub:subjectList) {
            teachUser.removeSubject(sub);
        }

        //新しく教師の教科を保存
        int[] selectedSubjects = teacherEditForm.getSelectedSubjects();
        if(selectedSubjects != null) {
            for(int value:selectedSubjects) {
                Subject subject = subjectRepository.findById(value).orElse(null);
                teachUser.addSubject(subject);
            }
        }


        userRepository.save(teachUser);
        attributes.addFlashAttribute("teacherMsg", "※教師情報を更新しました。");
        return "redirect:/profile/"+userId;
    }
}