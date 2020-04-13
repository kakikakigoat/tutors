package tutors.domain.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


@Entity
@NamedQuery(name="Review.findAll", query="SELECT r FROM Review r")
public class Review implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private ReviewPK id;

    private int rate;

    @Column(name="review_content")
    private String reviewContent;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="review_time")
    private Date reviewTime;

    //bi-directional many-to-one association to User
    @ManyToOne
    @JoinColumn(name="reviewer_user_id",insertable=false,updatable=false)
    private User user1;

    //bi-directional many-to-one association to User
    @ManyToOne
    @JoinColumn(name="reviewee_user_id",insertable=false,updatable=false)
    private User user2;

    public Review() {
    }

    public ReviewPK getId() {
        return this.id;
    }

    public void setId(ReviewPK id) {
        this.id = id;
    }

    public int getRate() {
        return this.rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getReviewContent() {
        return this.reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public Date getReviewTime() {
        return this.reviewTime;
    }

    public void setReviewTime(Date reviewTime) {
        this.reviewTime = reviewTime;
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