import java.time.LocalDateTime;

public class MessageMemento {
//    A class that represents a snapshot of a message sent by a user.
//    It should have properties for the message content and timestamp.
    private Message message;
    private LocalDateTime timeStamp;

    public MessageMemento(Message message, LocalDateTime timeStamp) {
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public void updateMemento(Message message, LocalDateTime timeStamp) {
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }


}
