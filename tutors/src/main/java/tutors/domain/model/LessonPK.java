package tutors.domain.model;

import java.io.Serializable;
import java.time.LocalTime;

import javax.persistence.*;


@Embeddable
public class LessonPK implements Serializable {
    //default serial version id, required for serializable classes.
    private static final long serialVersionUID = 1L;

    @Column(name="teacher_user_id", insertable=false, updatable=false)
    private int teacherUserId;

    @Column(name="user_id", insertable=false, updatable=false)
    private int userId;

    @Column(name="day_of_the_week")
    private String dayOfTheWeek;

    @Column(name="start_time")
    private LocalTime startTime;

    @Column(name="end_time")
    private LocalTime endTime;

    public LessonPK() {
    }
    public int getTeacherUserId() {
        return this.teacherUserId;
    }
    public void setTeacherUserId(int teacherUserId) {
        this.teacherUserId = teacherUserId;
    }
    public int getUserId() {
        return this.userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getDayOfTheWeek() {
        return this.dayOfTheWeek;
    }
    public void setDayOfTheWeek(String dayOfTheWeek) {
        this.dayOfTheWeek = dayOfTheWeek;
    }
    public LocalTime getStartTime() {
        return this.startTime;
    }
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }
    public LocalTime getEndTime() {
        return this.endTime;
    }
    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LessonPK)) {
            return false;
        }
        LessonPK castOther = (LessonPK)other;
        return 
            (this.teacherUserId == castOther.teacherUserId)
            && (this.userId == castOther.userId)
            && this.dayOfTheWeek.equals(castOther.dayOfTheWeek)
            && this.startTime.equals(castOther.startTime)
            && this.endTime.equals(castOther.endTime);
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + this.teacherUserId;
        hash = hash * prime + this.userId;
        hash = hash * prime + this.dayOfTheWeek.hashCode();
        hash = hash * prime + this.startTime.hashCode();
        hash = hash * prime + this.endTime.hashCode();
        
        return hash;
    }
}