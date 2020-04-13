package tutors.domain.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@NamedQuery(name="Teacher.findAll", query="SELECT t FROM Teacher t")
public class Teacher implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="teacher_user_id")
    private int teacherUserId;

    @Column(name="max_wage")
    private int maxWage;

    @Column(name="min_wage")
    private int minWage;

    private String policy;

    //bi-directional one-to-one association to User
    @OneToOne
    @JoinColumn(name="teacher_user_id")
    private User user;

    public Teacher() {
    }

    public int getTeacherUserId() {
        return this.teacherUserId;
    }

    public void setTeacherUserId(int teacherUserId) {
        this.teacherUserId = teacherUserId;
    }

    public int getMaxWage() {
        return this.maxWage;
    }

    public void setMaxWage(int maxWage) {
        this.maxWage = maxWage;
    }

    public int getMinWage() {
        return this.minWage;
    }

    public void setMinWage(int minWage) {
        this.minWage = minWage;
    }

    public String getPolicy() {
        return this.policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}