package tutors.domain.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import tutors.domain.model.LessonMenu;
import tutors.domain.model.LessonMenuPK;
import tutors.domain.model.User;

@Transactional
public interface LessonMenuRepository extends JpaRepository<LessonMenu, LessonMenuPK>{
    void deleteByUser(User user);
    /*
    @Query(value = "SELECT * FROM lesson_Menu "
            + "WHERE lesson_menu.teacher_user_id=:teacherUserId"
            , nativeQuery = true)
    List<LessonMenu> searchLessonMenu(@Param("teacherUserId") int teacherUserId);
    
    */
    @Query(value = "select * from lesson_Menu WHERE lesson_menu.teacher_user_id=:teacherUserId order by case "
            + "when day_of_the_week = '月曜日' then 1 when day_of_the_week = '火曜日' then 2 when day_of_the_week = '水曜日' then 3 when day_of_the_week = '木曜日' then 4"
            + " when day_of_the_week = '金曜日' then 5 when day_of_the_week = '土曜日' then 6 when day_of_the_week = '日曜日' then 7 end"
            , nativeQuery = true)
    List<LessonMenu> searchLessonMenu(@Param("teacherUserId") int teacherUserId);


} 
