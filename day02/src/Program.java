import java.io.IOException;

public class Program {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Wrong argument");
            System.exit(-1);
        }
        try {
            DictFull D = new DictFull(args[0], args[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
