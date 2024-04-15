import java.util.ArrayList;

public class ChatServer {
//    The mediator class that manages communication between users.
//    It should have methods to register and unregister users,
//    send messages from one user to one or more other users,
//    and block messages from specific users.

    private ArrayList<User> registeredUsers;

    public ChatServer() {
        registeredUsers = new ArrayList<>();
    }

    public void addUser(User user) {
        registeredUsers.add(user);
    }

    public void removeUser(User user) {
        registeredUsers.remove(user);
    }

    public boolean getAndSendMessage(User sender, Message message, User[] recipient){
        if(!isSenderBlocked(sender, recipient)){
            for (User user : recipient) {
                user.receiveMessage(this, message, sender);
            }
           return true;
        }
        return false;
    }

    public boolean isSenderBlocked(User sender, User[] recipient){
        for (User user : recipient) {
            if(user.getBlockedUsers().contains(sender))
                return true;
        }
        return false;
    }
}
