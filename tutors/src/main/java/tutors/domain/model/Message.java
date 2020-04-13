package tutors.domain.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the message database table.
 * 
 */
@Entity
@NamedQuery(name="Message.findAll", query="SELECT m FROM Message m")
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="message_id")
    private long messageId;

    @Column(name="message_content")
    private String messageContent;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="message_time")
    private Date messageTime;

    //bi-directional many-to-one association to User
    @ManyToOne
    @JoinColumn(name="sender_user_id")
    private User senderUser;

    //bi-directional many-to-one association to User
    @ManyToOne
    @JoinColumn(name="receiver_user_id")
    private User receiverUser;

    public Message() {
    }

    public long getMessageId() {
        return this.messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public String getMessageContent() {
        return this.messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Date getMessageTime() {
        return this.messageTime;
    }

    public void setMessageTime(Date messageTime) {
        this.messageTime = messageTime;
    }

    public User getSenderUser() {
        return this.senderUser;
    }

    public void setSenderUser(User senderUser) {
        this.senderUser = senderUser;
    }

    public User getReceiverUser() {
        return this.receiverUser;
    }

    public void setReceiverUser(User receiverUser) {
        this.receiverUser = receiverUser;
    }

}