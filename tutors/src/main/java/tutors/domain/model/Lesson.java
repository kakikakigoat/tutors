package tutors.domain.model;

import java.io.Serializable;
import javax.persistence.*;




@Entity
@NamedQuery(name="Lesson.findAll", query="SELECT l FROM Lesson l")
public class Lesson implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private LessonPK id;

    //bi-directional many-to-one association to User
    @ManyToOne
    @JoinColumn(name="teacher_user_id",insertable=false,updatable=false)
    private User user1;

    //bi-directional many-to-one association to User
    @ManyToOne
    @JoinColumn(name="user_id",insertable=false,updatable=false)
    private User user2;

    public Lesson() {
    }

    public LessonPK getId() {
        return this.id;
    }

    public void setId(LessonPK id) {
        this.id = id;
    }

    public User getUser1() {
        return this.user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return this.user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

}