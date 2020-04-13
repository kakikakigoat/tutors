package tutors.app.message;


import tutors.domain.model.Message;
import tutors.domain.model.User;

public class MessageDto {
    
    //messageBoxへの出力値
    User messageUser;
    Message message;
    public User getMessageUser()
    {
        return messageUser;
    }
    public void setMessageUser(User messageUser)
    {
        this.messageUser = messageUser;
    }
    public Message getMessage()
    {
        return message;
    }
    public void setMessage(Message message)
    {
        this.message = message;
    }
    
}
