package tutors.domain.service.matching;

import java.io.Serializable;

public class Json implements Serializable 
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private String userName;
    private String applicationDate;
    
    public String getUserName()
    {
        return userName;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    public String getApplicationDate()
    {
        return applicationDate;
    }
    public void setApplicationDate(String applicationDate)
    {
        this.applicationDate = applicationDate;
    }
    
    
}
