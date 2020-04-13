package tutors.domain.model;

import java.io.Serializable;
import java.time.LocalTime;

import javax.persistence.*;


@Entity
@Table(name="lesson_menu")
@NamedQuery(name="LessonMenu.findAll", query="SELECT l FROM LessonMenu l")
public class LessonMenu implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private LessonMenuPK id;

    @Column(name="lesson_menu_end_time")
    private LocalTime lessonMenuEndTime;

    @Column(name="lesson_menu_start_time")
    private LocalTime lessonMenuStartTime;

    //bi-directional many-to-one association to User
    @ManyToOne
    @JoinColumn(name="teacher_user_id",insertable=false,updatable=false)
    private User user;

    public LessonMenu() {
    }

    public LessonMenuPK getId() {
        return this.id;
    }

    public void setId(LessonMenuPK id) {
        this.id = id;
    }

    public LocalTime getLessonMenuEndTime() {
        return this.lessonMenuEndTime;
    }

    public void setLessonMenuEndTime(LocalTime lessonMenuEndTime) {
        this.lessonMenuEndTime = lessonMenuEndTime;
    }

    public LocalTime getLessonMenuStartTime() {
        return this.lessonMenuStartTime;
    }

    public void setLessonMenuStartTime(LocalTime lessonMenuStartTime) {
        this.lessonMenuStartTime = lessonMenuStartTime;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}