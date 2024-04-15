import java.time.LocalDateTime;
import java.util.ArrayList;

public class User {
//    A class representing a user of the chat application.
//    It should have methods to send messages to other users,
//    receive messages from other users, and undo the last message sent.

    private String name;
    private String email;
    private String password;
    private ArrayList<User> blockedUsers;
    private ChatHistory chatHistory;
    private MessageMemento lastMessage;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.blockedUsers = new ArrayList<>();
        this.chatHistory = new ChatHistory();
        this.lastMessage = new MessageMemento(null, null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<User> getBlockedUsers() {
        return blockedUsers;
    }

    public void setBlockedUsers(ArrayList<User> blockedUsers) {
        this.blockedUsers = blockedUsers;
    }

    public void blockUser(User user) {
        this.blockedUsers.add(user);
    }

    public ChatHistory getChatHistory() {
        return chatHistory;
    }

    public void setChatHistory(ChatHistory chatHistory) {
        this.chatHistory = chatHistory;
    }


    public boolean sendMessage(ChatServer server, String messageString, User[] recipient) {
        Message message = new Message(this, recipient, messageString, LocalDateTime.now());
        if(server.getAndSendMessage(this, message, recipient)){
            chatHistory.addMessage(message);
            lastMessage.updateMemento(message, message.getTimestamp());
            return true;
        }
        else
            return false;
    }

    public boolean sendMessage(ChatServer server, String messageString, User recipient) {
        return sendMessage(server, messageString, new User[] {recipient});
    }

    public boolean receiveMessage(ChatServer server, Message message, User sender) {
        if (message != null) {
            displayMessage(message.toString());
            chatHistory.addMessage(message);
            return true;
        }
        else
            return false;
    }

    public void viewMessagesWith(ChatServer server, User user) {
        for (Message message : chatHistory.getMessagesByUser(user)) {
            displayMessage(message.toString());
        }
    }

    public void viewMessagesWith(ChatServer server, User[] users) {
        for (Message message : chatHistory.getMessagesByUsers(users)) {
            displayMessage(message.toString());
        }
    }

    public void undoLastMessage(ChatServer server) {
        chatHistory.removeMessage(lastMessage.getMessage());
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
