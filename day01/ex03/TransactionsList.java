import java.util.UUID;

public interface TransactionsList {
    public void addTransaction(Transaction data);
    public void removeTransactionByID (UUID id); //in this case, UUID string identifier is used
    public Transaction[] toArray(); //ex. Transaction[] toArray()
}
