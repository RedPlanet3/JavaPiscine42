public class Program {
    public static void main(String[] args) {
        User Sender = new User(1,"Pol", 100);
        Sender.printConsole();
        User Recipient = new User(1, "Nic", 5);
        Recipient.printConsole();
        Transaction tr1 = new Transaction(Sender, Recipient, "OUTCOME", -800);
        tr1.printConsole();
        Transaction tr2 = new Transaction(Sender, Recipient, "INCOME", 1000);
        tr2.printConsole();
        Transaction tr3 = new Transaction(Sender, Recipient, "INCOME", -1000);
    }
}
