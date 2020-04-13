package tutors.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tutors.domain.model.Message;

@Repository
@Transactional
public interface MessageReposioty extends JpaRepository<Message, Long>{
   
    
    //メッセージボックス
    List<Message>findBySenderUser_userIdOrReceiverUser_UserId
    (Integer senderUserId,Integer receiverUserId);

    
    
  //メッセージボックス
    @Query(value="SELECT * FROM MESSAGE WHERE MESSAGE.sender_user_id = (:senderUserId) "
            + "AND MESSAGE.receiver_user_id = (:receiverUserId) "
            + "UNION SELECT * FROM MESSAGE WHERE MESSAGE.sender_user_id = (:receiverUserId) "
            + "AND MESSAGE.receiver_user_id = (:senderUserId)"
            + "ORDER BY message_time DESC LIMIT 1"
            ,nativeQuery = true)
    Message findLatestMessage
    (@Param("senderUserId") int senderUserId, @Param("receiverUserId") int receiverUserId);
    
    //メッセージリスト
    @Query(value="SELECT * FROM MESSAGE WHERE MESSAGE.sender_user_id = (:senderUserId) "
            + "AND MESSAGE.receiver_user_id = (:receiverUserId) "
            + "UNION SELECT * FROM MESSAGE WHERE MESSAGE.sender_user_id = (:receiverUserId) "
            + "AND MESSAGE.receiver_user_id = (:senderUserId)"
            + "ORDER BY message_time ASC"
            ,nativeQuery = true)
    List<Message> findMessages
    (@Param("senderUserId") int senderUserId, @Param("receiverUserId") int receiverUserId);
    
    //メッセージの送信
    @Modifying
    @Query(value = "insert into message (sender_user_id,receiver_user_id,message_content) "
            + "VALUES (:senderUserId,:receiverUserId,:messageContent)", nativeQuery = true)
    @Transactional
    void sendMessage(@Param("senderUserId") int senderUserId, @Param("receiverUserId") int receiverUserId,
            @Param("messageContent") String messageContent);





}
