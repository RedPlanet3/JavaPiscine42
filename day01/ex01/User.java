public class User {
    private int Identifier;
    private String Name;
    private int Balance;

    User(String Name, int Balance)
    {
        this.Identifier = UserIdsGenerator.getInstance().generateId();
        this.Name = Name;
        if (Balance < 0)
            this.Balance = 0;
        else
            this.Balance = Balance;
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
}
