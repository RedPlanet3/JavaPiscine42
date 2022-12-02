public class Program {
    public static void main(String[] args) {
        User Sender = new User("Pol", 100);
        Sender.printConsole();
        User Recipient = new User("Nic", 5);
        Recipient.printConsole();
        User Recipient2 = new User("Nicolay", -9);
        Recipient2.printConsole();
    }
}
