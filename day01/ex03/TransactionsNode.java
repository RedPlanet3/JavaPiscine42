public class TransactionsNode {
    private TransactionsNode prew;
    private TransactionsNode next;
    private Transaction data;
    TransactionsNode(Transaction data, TransactionsNode prew, TransactionsNode next)
    {
        this.data = data;
        this.next = next;
        this.prew = prew;
    }

    public Transaction getData() {
        return data;
    }

    public void setData(Transaction data) {
        this.data = data;
    }

    public TransactionsNode getPrew() {
        return prew;
    }

    public void setPrew(TransactionsNode prew) {
        this.prew = prew;
    }

    public TransactionsNode getNext() {
        return next;
    }

    public void setNext(TransactionsNode next) {
        this.next = next;
    }
}
