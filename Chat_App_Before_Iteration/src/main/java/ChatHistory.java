import java.util.ArrayList;

public class ChatHistory {
//A class that stores the chat history for a user.
// It should have methods to add a new message to the history and
// get the last message sent.
    private ArrayList<Message> messages;

    public ChatHistory() {
        messages = new ArrayList<>();
    }

    public void addMessage(Message message) {
        messages.add(message);
    }

    public void removeMessage(Message message) {
        messages.remove(message);
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public ArrayList<Message> getMessagesByUser(User user) {
        ArrayList<Message> output = new ArrayList<>();
        for (Message message : messages) {
            if ((message.senderIs(user) || (message.getRecipient()[0].equals(user))) && message.getRecipient().length == 1) {
                output.add(message);
            }
        }
        return output;
    }

    public ArrayList<Message> getMessagesByUsers(User[] users) {
        ArrayList<Message> output = new ArrayList<>();
        for (Message message : messages) {
            if (message.getRecipient().length == users.length) {
                if (numbCorrectUsers(users, message) == users.length) {
                    output.add(message);
                }
            }
        }
        return output;
    }

    private static int numbCorrectUsers(User[] users, Message message) {
        int usersFound = 0;
        for (User user : users) {
            if (message.senderIs(user)) {
                usersFound++;
            }
            for (User recipient : message.getRecipient()) {
                if (recipient.equals(user))
                    usersFound++;
            }
        }
        return usersFound;
    }

    public Message getLastMessage() {
        return messages.get(messages.size() - 1);
    }
}
