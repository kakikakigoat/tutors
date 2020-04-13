package tutors.app.matching;

import java.util.Date;

import org.hibernate.validator.constraints.Range;

public class MatchingForm {
    
    private Date applicationDate;
   
    private Date approvalDate;
    
    private boolean contactAvailability;
    
    private Date contactEndTime;
    
    @Range(min = 1,max = 47,message="都道府県を選択してください")
    private int regionId;

    @Range(min = 1000, max = 10000, message="契約する時給を選択してください")
    private int wage;

   

    public Date getApplicationDate()
    {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate)
    {
        this.applicationDate = applicationDate;
    }

    public Date getApprovalDate()
    {
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate)
    {
        this.approvalDate = approvalDate;
    }

    public boolean isContactAvailability()
    {
        return contactAvailability;
    }

    public void setContactAvailability(boolean contactAvailability)
    {
        this.contactAvailability = contactAvailability;
    }

    public Date getContactEndTime()
    {
        return contactEndTime;
    }

    public void setContactEndTime(Date contactEndTime)
    {
        this.contactEndTime = contactEndTime;
    }

    public int getRegionId()
    {
        return regionId;
    }

    public void setRegionId(int regionId)
    {
        this.regionId = regionId;
    }

    public int getWage()
    {
        return wage;
    }

    public void setWage(int wage)
    {
        this.wage = wage;
    }
}
