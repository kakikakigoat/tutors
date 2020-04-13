package tutors.domain.model;

import java.io.Serializable;
import javax.persistence.*;


import java.util.List;


@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="user_id")
    private int userId;

    private Integer age;

    private String gender;

    @Column(name="mail_address")
    private String mailAddress;

    private String password;

    @Column(name="profile_image")
    private String profileImage;

    @Column(name="self_introduction")
    private String selfIntroduction;

    @Column(name="user_name")
    private String userName;

    //bi-directional many-to-one association to Lesson
    @OneToMany(mappedBy="user1")
    private List<Lesson> lessons1;

    //bi-directional many-to-one association to Lesson
    @OneToMany(mappedBy="user2")
    private List<Lesson> lessons2;

    //bi-directional many-to-one association to LessonMenu
    @OneToMany(mappedBy="user")
    private List<LessonMenu> lessonMenus;

    //bi-directional many-to-many association to Subject
    @ManyToMany(mappedBy="users",fetch = FetchType.EAGER)
    private List<Subject> subjects;


    public void addSubject(Subject subject) {
        this.subjects.add(subject);
        subject.getUsers().add(this);
    }


    public void removeSubject(Subject subject) {
        this.subjects.remove(subject);
        subject.getUsers().remove(this);
    }
    //bi-directional many-to-one association to Matching
    @OneToMany(mappedBy="user1")
    private List<Matching> matchings1;

    //bi-directional many-to-one association to Matching
    @OneToMany(mappedBy="user2")
    private List<Matching> matchings2;

    //bi-directional many-to-one association to Message
    @OneToMany(mappedBy="senderUser")
    private List<Message> messages1;

    //bi-directional many-to-one association to Message
    @OneToMany(mappedBy="receiverUser")
    private List<Message> messages2;

    //bi-directional many-to-one association to Review
    @OneToMany(mappedBy="user1")
    private List<Review> reviews1;

    //bi-directional many-to-one association to Review
    @OneToMany(mappedBy="user2")
    private List<Review> reviews2;

    //bi-directional one-to-one association to Teacher
    @OneToOne(mappedBy="user")
    private Teacher teacher;

    //bi-directional many-to-one association to Region
    @ManyToOne
    @JoinColumn(name="region_id")
    private Region region;

    public User() {
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMailAddress() {
        return this.mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfileImage() {
        return this.profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getSelfIntroduction() {
        return this.selfIntroduction;
    }

    public void setSelfIntroduction(String selfIntroduction) {
        this.selfIntroduction = selfIntroduction;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Lesson> getLessons1() {
        return this.lessons1;
    }

    public void setLessons1(List<Lesson> lessons1) {
        this.lessons1 = lessons1;
    }

    public Lesson addLessons1(Lesson lessons1) {
        getLessons1().add(lessons1);
        lessons1.setUser1(this);

        return lessons1;
    }

    public Lesson removeLessons1(Lesson lessons1) {
        getLessons1().remove(lessons1);
        lessons1.setUser1(null);

        return lessons1;
    }

    public List<Lesson> getLessons2() {
        return this.lessons2;
    }

    public void setLessons2(List<Lesson> lessons2) {
        this.lessons2 = lessons2;
    }

    public Lesson addLessons2(Lesson lessons2) {
        getLessons2().add(lessons2);
        lessons2.setUser2(this);

        return lessons2;
    }

    public Lesson removeLessons2(Lesson lessons2) {
        getLessons2().remove(lessons2);
        lessons2.setUser2(null);

        return lessons2;
    }

    public List<LessonMenu> getLessonMenus() {
        return this.lessonMenus;
    }

    public void setLessonMenus(List<LessonMenu> lessonMenus) {
        this.lessonMenus = lessonMenus;
    }

    public LessonMenu addLessonMenus(LessonMenu lessonMenus) {
        getLessonMenus().add(lessonMenus);
        lessonMenus.setUser(this);

        return lessonMenus;
    }

    public LessonMenu removeLessonMenus(LessonMenu lessonMenus) {
        getLessonMenus().remove(lessonMenus);
        lessonMenus.setUser(null);

        return lessonMenus;
    }

    public List<Subject> getSubjects() {
        return this.subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<Matching> getMatchings1() {
        return this.matchings1;
    }

    public void setMatchings1(List<Matching> matchings1) {
        this.matchings1 = matchings1;
    }

    public Matching addMatchings1(Matching matchings1) {
        getMatchings1().add(matchings1);
        matchings1.setUser1(this);

        return matchings1;
    }

    public Matching removeMatchings1(Matching matchings1) {
        getMatchings1().remove(matchings1);
        matchings1.setUser1(null);

        return matchings1;
    }

    public List<Matching> getMatchings2() {
        return this.matchings2;
    }

    public void setMatchings2(List<Matching> matchings2) {
        this.matchings2 = matchings2;
    }

    public Matching addMatchings2(Matching matchings2) {
        getMatchings2().add(matchings2);
        matchings2.setUser2(this);

        return matchings2;
    }

    public Matching removeMatchings2(Matching matchings2) {
        getMatchings2().remove(matchings2);
        matchings2.setUser2(null);

        return matchings2;
    }

    public List<Message> getMessages1() {
        return this.messages1;
    }

    public void setMessages1(List<Message> messages1) {
        this.messages1 = messages1;
    }

    public Message addMessages1(Message messages1) {
        getMessages1().add(messages1);
        messages1.setSenderUser(this);

        return messages1;
    }

    public Message removeMessages1(Message messages1) {
        getMessages1().remove(messages1);
        messages1.setSenderUser(null);

        return messages1;
    }

    public List<Message> getMessages2() {
        return this.messages2;
    }

    public void setMessages2(List<Message> messages2) {
        this.messages2 = messages2;
    }

    public Message addMessages2(Message messages2) {
        getMessages2().add(messages2);
        messages2.setReceiverUser(this);

        return messages2;
    }

    public Message removeMessages2(Message messages2) {
        getMessages2().remove(messages2);
        messages2.setReceiverUser(null);

        return messages2;
    }

    public List<Review> getReviews1() {
        return this.reviews1;
    }

    public void setReviews1(List<Review> reviews1) {
        this.reviews1 = reviews1;
    }

    public Review addReviews1(Review reviews1) {
        getReviews1().add(reviews1);
        reviews1.setUser1(this);

        return reviews1;
    }

    public Review removeReviews1(Review reviews1) {
        getReviews1().remove(reviews1);
        reviews1.setUser1(null);

        return reviews1;
    }

    public List<Review> getReviews2() {
        return this.reviews2;
    }

    public void setReviews2(List<Review> reviews2) {
        this.reviews2 = reviews2;
    }

    public Review addReviews2(Review reviews2) {
        getReviews2().add(reviews2);
        reviews2.setUser2(this);

        return reviews2;
    }

    public Review removeReviews2(Review reviews2) {
        getReviews2().remove(reviews2);
        reviews2.setUser2(null);

        return reviews2;
    }

    public Teacher getTeacher() {
        return this.teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Region getRegion() {
        return this.region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

}