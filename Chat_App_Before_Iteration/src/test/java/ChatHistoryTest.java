import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ChatHistoryTest {
    @Test
    public void testGetMessagesByUser() {
        ChatServer chatServer = new ChatServer();
        User testUser = new User("James", "email1", "pass");
        User testRecipient = new User("John", "email2", "pass");
        testUser.sendMessage(chatServer, "Test", testRecipient);
        testRecipient.sendMessage(chatServer, "Test", testUser);
        ArrayList<Message> actual =  testUser.getChatHistory().getMessagesByUser(testRecipient);

        ArrayList<Message> expected = new ArrayList<>();
        expected.add(new Message(testUser, new User[] {testRecipient}, "Test", null));

        assertTrue(Message.compareMessages(expected.get(0),actual.get(0)));
    }

    @Test
    public void testGetMessagesByUsers() {
        ChatServer chatServer = new ChatServer();
        User testUser = new User("James", "email1", "pass");
        User testRecipient = new User("John", "email2", "pass");
        User testRecipient2 = new User("Jane", "email3", "pass");

        testUser.sendMessage(chatServer, "Test", new User[] {testRecipient,testRecipient2});
        testRecipient.sendMessage(chatServer, "Test", new User[] {testUser,testRecipient2});
        testRecipient2.sendMessage(chatServer, "Test", new User[] {testRecipient,testUser});
        ArrayList<Message> actual =  testUser.getChatHistory().getMessagesByUsers(new User[] {testRecipient,testRecipient2});

        ArrayList<Message> expected = new ArrayList<>();
        expected.add(new Message(testUser, new User[] {testRecipient, testRecipient2}, "Test", null));
//      I couldn't think of a good way to include the timestamp in the comparison so it is not a part of the test.

        assertTrue(Message.compareMessages(expected.get(0),actual.get(0)));
    }
}
