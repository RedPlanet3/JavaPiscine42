public class Program {
    public static void main(String[] args) {
        TransactionsService service = new TransactionsService();
        User Pol = new User("Pol", 1000);
        Pol.printConsole();
        User Nic = new User("Nic", 5);
        Nic.printConsole();
        service.addUser(Pol);
        service.addUser(Nic);

        service.PerformingTransferTransaction(Pol.getIdentifier(), Nic.getIdentifier(), 800);

        Pol.printConsole();
        Nic.printConsole();

        Pol.getListOfUserTransactions().printConsole();
        Nic.getListOfUserTransactions().printConsole();

//        Transaction tr2 = new Transaction(Sender, Recipient, 1000);
//        tr2.printConsole();
//        Transaction tr3 = new Transaction(Sender, Recipient, 3000);
//        tr3.printConsole();
//
//        trLinkList.addTransaction(tr1);
//        trLinkList.addTransaction(tr2);
//        trLinkList.addTransaction(tr3);
//        trLinkList.printConsole();
//
//        trLinkList.removeTransactionByID(tr3.getIdentifier());
//        trLinkList.printConsole();
//
//        trLinkList.removeTransactionByID(tr1.getIdentifier());
//        trLinkList.printConsole();
//
//        trLinkList.removeTransactionByID(tr2.getIdentifier());
//        trLinkList.printConsole();
//
////        trLinkList.removeTransactionByID(tr2.getIdentifier());
////        trLinkList.printConsole();
//        trLinkList.addTransaction(tr1);
//        trLinkList.addTransaction(tr2);
//        trLinkList.addTransaction(tr3);
//
//        Transaction[] arrTr = trLinkList.toArray();
//        System.out.println("arrTr.length: " + arrTr.length);
    }
}
