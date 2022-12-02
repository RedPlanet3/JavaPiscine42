import java.util.UUID;

public interface TransactionsList {
    public void addTransaction(Transaction data);
    public void removeTransactionByID (UUID id);
    public Transaction[] toArray();
    public void printConsole();
}
