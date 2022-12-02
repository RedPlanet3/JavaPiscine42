import java.io.IOException;
import java.text.NumberFormat;

public class Program {
    public static void main(String[] args) throws InterruptedException {
        int count = 0;
        if (args.length < 1) {

            System.out.println("Wrong arg!");
            System.exit(-1);
        }
        if (!args[0].substring(0, "--count=".length()).equals("--count=")) {
            System.out.println("Wrong arg!");
            System.exit(-1);
        }
        else
        {
            try {
                count = Integer.parseInt(args[0].substring("--count=".length()));

            }
            catch (NumberFormatException e)
            {
                System.out.println("Wrong arg!");
                System.exit(-1);
            }
        }

        MyThread egg = new MyThread("Egg", count);
        MyThread hen = new MyThread("Hen", count);
        egg.start();
        hen.start();

        egg.join();
        hen.join();
        
        for(int i = 0; i < count; i++){
            System.out.println("Human");
        }
    }
}
