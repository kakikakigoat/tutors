package tutors.domain.model;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class ReviewPK implements Serializable {
    //default serial version id, required for serializable classes.
    private static final long serialVersionUID = 1L;

    @Column(name="reviewer_user_id", insertable=false, updatable=false)
    private int reviewerUserId;

    @Column(name="reviewee_user_id", insertable=false, updatable=false)
    private int revieweeUserId;

    public ReviewPK() {
    }
    public int getReviewerUserId() {
        return this.reviewerUserId;
    }
    public void setReviewerUserId(int reviewerUserId) {
        this.reviewerUserId = reviewerUserId;
    }
    public int getRevieweeUserId() {
        return this.revieweeUserId;
    }
    public void setRevieweeUserId(int revieweeUserId) {
        this.revieweeUserId = revieweeUserId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReviewPK)) {
            return false;
        }
        ReviewPK castOther = (ReviewPK)other;
        return 
            (this.reviewerUserId == castOther.reviewerUserId)
            && (this.revieweeUserId == castOther.revieweeUserId);
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + this.reviewerUserId;
        hash = hash * prime + this.revieweeUserId;
        
        return hash;
    }
}