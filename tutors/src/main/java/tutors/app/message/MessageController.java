package tutors.app.message;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tutors.domain.model.Message;
import tutors.domain.model.User;
import tutors.domain.repository.MessageReposioty;
import tutors.domain.repository.UserRepository;
import tutors.domain.service.user.LoginUserDetails;



@Controller
@RequestMapping("profile")
public class MessageController {

    @Autowired 
    UserRepository userRepository;
    @Autowired
    MessageReposioty messageRepository;

    @ModelAttribute
    public MessageForm messageForm() {
        return new MessageForm();
    }
    
    //メッセージボックス
    @GetMapping("/messageBox")
    String showMessage(@AuthenticationPrincipal LoginUserDetails userDetails,
            MessageForm messageForm,
            Model model) {
        User user = userDetails.getUser();
        int myUserId = user.getUserId();
        User myUser = userRepository.findById(myUserId).orElse(null);
        //自分が含まれるメッセージを検索
        List<Message> messages = messageRepository
                .findBySenderUser_userIdOrReceiverUser_UserId(myUserId, myUserId);
        List<User> userList = new ArrayList<>();
        for(Message message:messages) {
            User sentUser = message.getSenderUser();
            User receivedUser = message.getReceiverUser();
            userList.add(receivedUser);
            userList.add(sentUser);
        }
        //重複分と自分自身は削除
        userList = userList.stream().distinct().collect(Collectors.toList());
        userList.remove(myUser);
        List<MessageDto> messageDtos = new ArrayList<>();
        for(User messageUser:userList) {
            MessageDto messageDto = new MessageDto();
            Message latestMessage = messageRepository.findLatestMessage(myUserId, messageUser.getUserId());
            messageDto.setMessageUser(messageUser);
            messageDto.setMessage(latestMessage);
            messageDtos.add(messageDto);
        }
        messageForm.setMessageDto(messageDtos);
        model.addAttribute("userList",userList);
        return "profile/messageBox";
    }


    
    //メッセージ画面
    @GetMapping("/{userId}/message")
    String showMessage(@PathVariable("userId") Integer userId,
            @AuthenticationPrincipal LoginUserDetails userDetails,
            Model model) {
        User receiverUser = userRepository.findById(userId).orElse(null);
        User senderUser = userDetails.getUser();
        int senderUserId = senderUser.getUserId();
        int receiverUserId = receiverUser.getUserId();
        List<Message> messages = messageRepository.findMessages(senderUserId, receiverUserId);
        model.addAttribute("messages",messages);
        model.addAttribute("receiverUser",receiverUser);
        model.addAttribute("senderUser",senderUser);
        return "profile/message";
    }

    //送信時の処理
    @PostMapping("/{userId}/message")
    String sendMessage(@Validated MessageForm messageForm,
            BindingResult bindingResult,
            @AuthenticationPrincipal LoginUserDetails userDetails,
            @PathVariable("userId") Integer userId,
            Model model) {
        
        User senderUser = userDetails.getUser();
        User receiverUser = userRepository.findById(userId).orElse(null);
        int senderUserId = senderUser.getUserId();
        int receiverUserId = receiverUser.getUserId();
        String messageContent = messageForm.getMessageContent();
        
        //エラー処理
        if(bindingResult.hasErrors()) {
            return showMessage(userId,userDetails,model);
        }
        messageRepository.sendMessage(senderUserId, receiverUserId, messageContent);
        
        return "redirect:/profile/"+userId+"/message";
    }
}
