package tutors.domain.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@NamedQuery(name="Matching.findAll", query="SELECT m FROM Matching m")
public class Matching implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="matching_id")
    private int matchingId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="application_date")
    private Date applicationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="approval_date")
    private Date approvalDate;

    @Column(name="contact_availability")
    private Boolean contactAvailability;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="contact_end_time")
    private Date contactEndTime;

    @ManyToOne
    @JoinColumn(name="region_id")
    private Region region;

    private int wage;

    //bi-directional many-to-one association to User
    @ManyToOne
    @JoinColumn(name="teacher_user_id")
    private User user1;

    //bi-directional many-to-one association to User
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user2;

    public Matching() {
    }

    public int getMatchingId() {
        return this.matchingId;
    }

    public void setMatchingId(int matchingId) {
        this.matchingId = matchingId;
    }

    public Date getApplicationDate() {
        return this.applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public Date getApprovalDate() {
        return this.approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    public Boolean getContactAvailability() {
        return this.contactAvailability;
    }

    public void setContactAvailability(Boolean contactAvailability) {
        this.contactAvailability = contactAvailability;
    }

    public Date getContactEndTime() {
        return this.contactEndTime;
    }

    public void setContactEndTime(Date contactEndTime) {
        this.contactEndTime = contactEndTime;
    }

    

    public int getWage() {
        return this.wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
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

    public Region getRegion()
    {
        return region;
    }

    public void setRegion(Region region)
    {
        this.region = region;
    }

}