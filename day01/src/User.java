public class User {
    private int Identifier;
    private String Name;
    private int Balance;
    private TransactionsList listOfUserTransactions;

    User(String Name, int Balance)
    {
        this.Identifier = UserIdsGenerator.getInstance().generateId();
        this.Name = Name;
        if (Balance < 0)
            this.Balance = 0;
        else
            this.Balance = Balance;
        listOfUserTransactions = new TransactionsLinkedList();
    }

    public int getIdentifier() {
        return Identifier;
    }

    public void setIdentifier(int identifier) {
        Identifier = identifier;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getBalance() {
        return Balance;
    }

    public void setBalance(int balance) {
        Balance = balance;
    }
    public void printConsole()
    {
        System.out.println("Identifier: " + this.Identifier + ", Name: " + this.Name + ", Balance: " + this.Balance);
    }

    public TransactionsList getListOfUserTransactions() {
        return listOfUserTransactions;
    }


    public void addTransactionList(Transaction transaction, enTransferCategory category)
    {
        transaction.setTransferCategory(category);
        if (category == enTransferCategory.CREDIT)
            transaction.setTransferAmount(transaction.getTransferAmount() * -1);
        this.listOfUserTransactions.addTransaction(transaction);
    }
    public void changeBalance(int balance, enTransferCategory category)
    {
        if (category == enTransferCategory.CREDIT)
        {
            if (this.Balance < balance)
                throw new IllegalTransactionException();
            else
                this.Balance -= balance;
        }
        if (category == enTransferCategory.DEBIT)
            this.Balance += balance;
    }
}
