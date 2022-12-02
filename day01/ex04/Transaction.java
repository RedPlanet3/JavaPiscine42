import java.util.UUID;

public class Transaction {
    private UUID Identifier;
    private User Recipient;
    private User Sender;
    private enTransferCategory TransferCategory;
    private int TransferAmount;

    Transaction(User Sender, User Recipient, int TransferAmount)
    {
        this.Identifier = UUID.randomUUID();
        this.Sender = Sender;
        this.Recipient = Recipient;
        this.TransferAmount = TransferAmount;
//        this.setUsrTransfer();
    }

    public enTransferCategory getTransferCategory() {
        return TransferCategory;
    }

    public void setTransferCategory(enTransferCategory transferCategory) {
        TransferCategory = transferCategory;
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


    public int getTransferAmount() {
        return TransferAmount;
    }

    public void setTransferAmount(int TransferAmount) {
        if (this.TransferCategory.equals(enTransferCategory.CREDIT)) {
            if (TransferAmount < 0)
                this.TransferAmount = TransferAmount;
            else
                System.out.println("Wrong transferAmount! Set negative Amount");
        }
        else if (this.TransferCategory.equals(enTransferCategory.DEBIT)) {
            if (TransferAmount > 0)
                this.TransferAmount = TransferAmount;
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
