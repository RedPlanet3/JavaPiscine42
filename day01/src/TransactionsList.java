import java.util.UUID;

public interface TransactionsList {
    public void addTransaction(Transaction data);
    public void removeTransactionByID (UUID id);
    public Transaction[] toArray();
    public void printConsole();
    public Transaction findTransaction(UUID id);
    public void removeTransactionByIDAndCategory (UUID id, enTransferCategory category);
    public TransactionsNode getNode();

}
