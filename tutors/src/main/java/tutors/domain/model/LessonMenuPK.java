package tutors.domain.model;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The primary key class for the lesson_menu database table.
 * 
 */
@Embeddable
public class LessonMenuPK implements Serializable {
    //default serial version id, required for serializable classes.
    private static final long serialVersionUID = 1L;

    @Column(name="teacher_user_id", insertable=false, updatable=false)
    private int teacherUserId;

    @Column(name="day_of_the_week")
    private String dayOfTheWeek;

    public LessonMenuPK() {
    }
    public int getTeacherUserId() {
        return this.teacherUserId;
    }
    public void setTeacherUserId(int teacherUserId) {
        this.teacherUserId = teacherUserId;
    }
    public String getDayOfTheWeek() {
        return this.dayOfTheWeek;
    }
    public void setDayOfTheWeek(String dayOfTheWeek) {
        this.dayOfTheWeek = dayOfTheWeek;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LessonMenuPK)) {
            return false;
        }
        LessonMenuPK castOther = (LessonMenuPK)other;
        return 
            (this.teacherUserId == castOther.teacherUserId)
            && this.dayOfTheWeek.equals(castOther.dayOfTheWeek);
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + this.teacherUserId;
        hash = hash * prime + this.dayOfTheWeek.hashCode();
        
        return hash;
    }
}