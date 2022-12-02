import java.io.IOException;

public class Program {
    public static void main(String[] args) {
        try {
            SignatureCheck ch = new SignatureCheck("signatures.txt");
            ch.readInputFiles("answ.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
