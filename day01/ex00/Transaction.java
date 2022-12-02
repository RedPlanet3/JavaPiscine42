import java.util.UUID;

public class Transaction {
    private UUID Identifier;
    private User Recipient;
    private User Sender;
    private String TransferCategory;
    private int TransferAmount;

    Transaction(User Sender, User Recipient, String TransferCategory, int TransferAmount)
    {
        this.Identifier = UUID.randomUUID();
        this.Sender = Sender;
        this.Recipient = Recipient;
        this.TransferCategory = TransferCategory;
        this.TransferAmount = 0;
        this.setTransferAmount(TransferAmount);

    }

    public UUID getIdentifier() {
        return Identifier;
    }

    public void setIdentifier(UUID identifier) {
        Identifier = identifier;
    }

    public User getRecipient() {
        return Recipient;
    }

    public void setRecipient(User recipient) {
        Recipient = recipient;
    }

    public User getSender() {
        return Sender;
    }

    public void setSender(User sender) {
        Sender = sender;
    }

    public String getTransferCategory() {
        return TransferCategory;
    }

    public void setTransferCategory(String transferCategory) {
        TransferCategory = transferCategory;
    }

    public int getTransferAmount() {
        return TransferAmount;
    }

    public void setTransferAmount(int transferAmount) {
        if (this.TransferCategory.equals("OUTCOME")) {
            if (transferAmount < 0)
            TransferAmount = transferAmount;
        else
            System.out.println("Wrong transferAmount! Set negative Amount");
        }
        else if (this.TransferCategory.equals("INCOME")) {
            if (transferAmount > 0)
                TransferAmount = transferAmount;
            else
                System.out.println("Wrong transferAmount! Set positive Amount");
        }

    }
    public void printConsole()
    {
        System.out.println(this.Sender.getName() +
                " -> " + this.Recipient.getName() +
                ", " + this.getTransferAmount() +
                ", " + this.getTransferCategory() +
                ", " + this.Identifier);
    }
}
