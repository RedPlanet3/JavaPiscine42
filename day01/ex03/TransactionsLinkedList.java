import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList{
    private TransactionsNode listOfTransactions;
    private TransactionsNode tail;
    private int size;

    public TransactionsLinkedList()
    {
        this.size = 0;
    };

    @Override
    public void addTransaction(Transaction data)
    {
        TransactionsNode tmp;
        if (listOfTransactions == null) {
            listOfTransactions = new TransactionsNode(data, null, null);
            tail = listOfTransactions;
        }
        else {
            tail.setNext(new TransactionsNode(data, tail, null));
            tail = tail.getNext();
        }
        this.size++;
    };

    @Override
    public void removeTransactionByID (UUID id) throws TransactionNotFoundException
    {
        TransactionsNode list = listOfTransactions;
        TransactionsNode tmp;
        if (list == null)
            throw new TransactionNotFoundException();

        if (list.getData().getIdentifier().equals(id)) {
            listOfTransactions = listOfTransactions.getNext();
            this.size--;
            return;
        }
        if (tail.getData().getIdentifier().equals(id)) {
            tail = tail.getPrew();
            tail.setNext(null);
            this.size--;
            return;
        }

        while (list.getNext() != null)
        {
            if (list.getNext().getData().getIdentifier().equals(id)) {
                if (list.getNext().getNext() != null) {
                    tmp = list.getNext();
                    list.setNext(tmp.getNext());
                    tmp.setPrew(null);
                    tmp.setNext(null);
                }
                else
                {
                    list.getNext().setPrew(null);
                    list.setNext(null);
                }
                this.size--;
                return;
            }
            list = list.getNext();
        }
        throw new TransactionNotFoundException();
    }

    @Override
    public Transaction[] toArray(){
        Transaction[] arrTrList = new Transaction[this.size];
        TransactionsNode tmp = this.listOfTransactions;
        for(int i = 0; i < this.size; i++)
        {
            arrTrList[i] = tmp.getData();
            tmp = tmp.getNext();
        }
        return arrTrList;
    }
    public void printConsole()
    {
        TransactionsNode tmp = this.listOfTransactions;
        System.out.println("Print Linked list: ");
        for (int i = 0; i < this.size; i++) {
            tmp.getData().printConsole();
            tmp = tmp.getNext();
        }
    }
}
