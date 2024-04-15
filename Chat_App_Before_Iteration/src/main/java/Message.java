import java.time.LocalDateTime;

public class Message {
// A class representing a message sent by a user.
// It should have properties for the sender, recipient(s),
// timestamp, and message content.

    private User sender;
    private User[] recipient;
    private String message;
    private LocalDateTime timestamp;

    public Message(User sender, User[] recipient, String message, LocalDateTime timestamp) {
        this.sender = sender;
        this.recipient = recipient;
        this.message = message;
        this.timestamp = timestamp;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User[] getRecipient() {
        return recipient;
    }

    public void setRecipient(User[] recipient) {
        this.recipient = recipient;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public boolean senderIs(User sender) {
        return this.sender.equals(sender);
    }

    @Override
    public String toString() {
        String output = "From: " + sender.getName() + ", To: ";
        for (User recipient : recipient) {
            output += recipient.getName() + ", ";
        }
        output += "\"" + message + '\"' +
                  ", " + timestamp;
        return output;
    }

    public static boolean compareMessages(Message message1, Message message2) {
        if (message1.message.equals(message2.message)) {
            if (message1.sender.equals(message1.getSender()) && message1.recipient.length == message2.getRecipient().length) {
                for (int i = 0; i < message1.recipient.length; i++) {
                    if (message1.recipient[i].equals(message2.getRecipient()[i])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
