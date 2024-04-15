import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
    @Test
    public void testSendMessage() {
        ChatServer chatServer = new ChatServer();
        User testUser = new User("James", "email1", "pass");
        User testRecipient = new User("John", "email2", "pass");
        assertTrue(testUser.sendMessage(chatServer, "message", testRecipient));
    }

    @Test
    public void testReceiveMessage(){
        ChatServer chatServer = new ChatServer();
        User testUser = new User("James", "email1", "pass");
        User testRecipient = new User("John", "email2", "pass");
        Message message = new Message(testUser, new User[] {testRecipient}, "messageString", LocalDateTime.now());
        assertTrue(testUser.receiveMessage(chatServer, message, testRecipient));
    }

    @Test
    public void testUndoLastMessage(){
        ChatServer chatServer = new ChatServer();
        User testUser = new User("James", "email1", "pass");
        User testRecipient = new User("John", "email2", "pass");
        testUser.sendMessage(chatServer, "message", testRecipient);
        testUser.undoLastMessage(chatServer);

        assertEquals(testUser.getChatHistory().getMessages().size(), 0);
    }
}
