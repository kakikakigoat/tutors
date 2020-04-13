package tutors.domain.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


@Entity
@NamedQuery(name="Subject.findAll", query="SELECT s FROM Subject s")
public class Subject implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="subject_id")
    private int subjectId;

    @Column(name="subject_name")
    private String subjectName;

    //bi-directional many-to-many association to User
    @ManyToMany
    @JoinTable(
        name="lesson_subject"
        , joinColumns={
            @JoinColumn(name="subject_id")
            }
        , inverseJoinColumns={
            @JoinColumn(name="teacher_user_id")
            }
        )
    private List<User> users;

    public Subject() {
    }

    public int getSubjectId() {
        return this.subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return this.subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public List<User> getUsers() {
        return this.users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}