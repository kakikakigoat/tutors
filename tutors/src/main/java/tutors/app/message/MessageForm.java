package tutors.app.message;

import java.util.List;

import javax.validation.constraints.NotEmpty;

public class MessageForm {
    //入力値
    @NotEmpty(message="空のメッセージは送信できません")
	String messageContent;
    
    //messageBox出力値
    List<MessageDto> messageDto;

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

    public List<MessageDto> getMessageDto()
    {
        return messageDto;
    }

    public void setMessageDto(List<MessageDto> messageDto)
    {
        this.messageDto = messageDto;
    }
	
}
