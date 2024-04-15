public class Driver {
    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();

        User john = new User("John", "email1", "password1");
        User jane = new User("Jane", "email2", "password2");
        User jack = new User("Jack", "email3", "password3");


        chatServer.addUser(john);
        chatServer.addUser(jane);
        chatServer.addUser(jack);


        System.out.println();
        System.out.println("### Chat between John and Jane");
        john.sendMessage(chatServer, "Hey Jane", jane);
        jane.sendMessage(chatServer, "Hi John", john);
        john.sendMessage(chatServer, "How are you Jane?", jane);
        jane.sendMessage(chatServer, "I am good. How are you?", john);
        john.sendMessage(chatServer, "Great!", jane);

        System.out.println();
        System.out.println("### Chat between John and Jack");
        jack.sendMessage(chatServer, "How are you John?", john);
        john.sendMessage(chatServer, "I am good Jack", jack);

        System.out.println();
        System.out.println("## Undo John's Last Message");
        john.undoLastMessage(chatServer);
        john.viewMessagesWith(chatServer,jack);

        System.out.println();
        System.out.println("### Chat between all three (the message prints out for each recipient, so they all print twice)");
        jack.sendMessage(chatServer, "How are you guys?", new User[]{john, jane});
        john.sendMessage(chatServer, "I am good Jack", new User[]{jack, jane});
        jane.sendMessage(chatServer, "I am good Jack", new User[]{jack, john});
        jack.sendMessage(chatServer, "Do you guys want to go to the movies later?", new User[]{john, jane});
        john.sendMessage(chatServer, "I would love to!", new User[]{jack, jane});
        jane.sendMessage(chatServer, "Absolutely!", new User[]{jack, john});

        System.out.println();
        System.out.println("### Chat blocked by John (no message due to block)");
        john.blockUser(jack);
        jack.sendMessage(chatServer, "How are you John?", john);

        System.out.println();
        System.out.println("### Messages between John and Jane");
        john.viewMessagesWith(chatServer, jane);

        System.out.println();
        System.out.println("### Messages between John and Jack and Jane");
        john.viewMessagesWith(chatServer, new User[] {jack, jane});


    }
}
