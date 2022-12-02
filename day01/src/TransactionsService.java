import java.util.UUID;

public class TransactionsService {
    private UsersList usrList;
    private TransactionsList trList;
    TransactionsService(){
        this.usrList = new UsersArrayList();
        this.trList = new TransactionsLinkedList();
    }

    public void addUser(User user)
    {
        usrList.addUser(user);
    }

    //• Retrieving a user’s balance
    public int RetrievingUserBalance(User user)
    {
        return user.getBalance();
    }

    public void setUsrTransfer(User Sender, User Recipient, int TransferAmount)
    {
        Sender.changeBalance(TransferAmount, enTransferCategory.CREDIT);
        Recipient.changeBalance(TransferAmount, enTransferCategory.DEBIT);

    }

    public void PerformingTransferTransaction(int idSender, int idRecipient, int amount)
    {

        UUID idTrans;
        User sender = usrList.RetrieveUserByID(idSender);
        User recipient = usrList.RetrieveUserByID(idRecipient);
        setUsrTransfer(sender, recipient, amount);

        Transaction sendTransaction = new Transaction(sender,recipient, amount);
        idTrans = sendTransaction.getIdentifier();
        Transaction recTransaction = new Transaction(sender,recipient, amount);
        recTransaction.setIdentifier(idTrans);
        trList.addTransaction(sendTransaction);
        trList.addTransaction(recTransaction);
        sender.addTransactionList(sendTransaction, enTransferCategory.CREDIT);
        recipient.addTransactionList(recTransaction, enTransferCategory.DEBIT);
    }

    //• Retrieving transfers of a specific user (an ARRAY of transfers is returned). Removing a transaction by ID for a specific user (transaction ID and user ID are
    //            specified)
    public Transaction[] RetrievingTransfersOfASpecificUser(int idUser, UUID idTran)
    {
        Transaction tmp;
        User user = usrList.RetrieveUserByID(idUser);
        tmp = user.getListOfUserTransactions().findTransaction(idTran);
        enTransferCategory cat = tmp.getTransferCategory();
        user.getListOfUserTransactions().removeTransactionByID(idTran);
        trList.removeTransactionByIDAndCategory(idTran, cat);
        return user.getListOfUserTransactions().toArray();
    }



    public Transaction[] CheckValidityOfTransactions()
    {
        TransactionsNode list = trList.getNode();
        enTransferCategory cat = trList.getNode().getData().getTransferCategory();
        TransactionsList arr = new TransactionsLinkedList();

        while (list != null)
        {
            Transaction tr = trList.findTransaction(list.getData().getIdentifier());
            if (tr != null && tr.getTransferCategory() != cat) {
                arr.addTransaction(tr);
            }
            list = list.getNext();
        }
        return arr.toArray();

    }

}
