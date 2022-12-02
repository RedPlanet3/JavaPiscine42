public class Program {
    public static void main(String[] args) {
        User Sender = new User("Pol", 100);
        Sender.printConsole();
        User Recipient = new User("Nic", 5);
        Recipient.printConsole();
        TransactionsLinkedList trLinkList = new TransactionsLinkedList();

        Transaction tr1 = new Transaction(Sender, Recipient, "OUTCOME", -800);
        tr1.printConsole();
        Transaction tr2 = new Transaction(Sender, Recipient, "INCOME", 1000);
        tr2.printConsole();
        Transaction tr3 = new Transaction(Sender, Recipient, "INCOME", 3000);
        tr3.printConsole();

        trLinkList.addTransaction(tr1);
        trLinkList.addTransaction(tr2);
        trLinkList.addTransaction(tr3);
        trLinkList.printConsole();

        trLinkList.removeTransactionByID(tr3.getIdentifier());
        trLinkList.printConsole();

        trLinkList.removeTransactionByID(tr1.getIdentifier());
        trLinkList.printConsole();

        trLinkList.removeTransactionByID(tr2.getIdentifier());
        trLinkList.printConsole();

//        trLinkList.removeTransactionByID(tr2.getIdentifier());
//        trLinkList.printConsole();
        trLinkList.addTransaction(tr1);
        trLinkList.addTransaction(tr2);
        trLinkList.addTransaction(tr3);

        Transaction[] arrTr = trLinkList.toArray();
        System.out.println("arrTr.length: " + arrTr.length);
    }
}
