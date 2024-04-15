import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChatServerTest {
    @Test
    public void testGetAndSendMessage() {
        ChatServer chatServer = new ChatServer();
        User testUser = new User("James", "email1", "pass");
        User testRecipient = new User("John", "email2", "pass");
        Message message = new Message(testUser, new User[] {testRecipient}, "messageString", LocalDateTime.now());
        assertTrue(chatServer.getAndSendMessage(testUser, message, new User[] {testRecipient}));
    }

    @Test
    public void testIsSenderBlocked() {
        ChatServer chatServer = new ChatServer();
        User testUser = new User("James", "email1", "pass");
        User testRecipient = new User("John", "email2", "pass");
        testRecipient.blockUser(testUser);

        assertTrue(chatServer.isSenderBlocked(testUser, new User[] {testRecipient}));

    }
}
