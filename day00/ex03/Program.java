import java.util.Scanner;

public class Program {
    public static int minTest(Scanner in) {
    int num;
    int min = in.nextInt();
        for (int i = 0; i < 4; i++)
        {
            num = in.nextInt();
            if (num < min)
                min = num;
        }
        return min;
    }

    public static void printLine(long answ, int ch)
    {
        int line;
        for (int j = 1; j < ch + 1; j++) {
            line = (int) (answ % 10);
            answ /= 10;
            System.out.printf("Week " + j);
            for (int i = 0; i < line; i++)
                System.out.printf("=");
            System.out.println(">");
        }
    }
    public static long decPow(int ch)
    {
        long answ = 1;
        if (ch != 1) {
            for (int i = 1; i < ch; i++)
                answ *= 10;
        }
        return answ;
    }

    public static void main(String[] args) {
        long answ = 0;
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int ch = 0;
        while (!str.equals("42") && ch < 18)
        {
            ch++;
            if (str.equals("Week " + ch))
            {
                answ = answ + (decPow(ch) * minTest(in));
                str = in.nextLine();
            }
            else
            {
                System.out.println("IllegalArgument");
                System.exit(-1);
            }
            str = in.nextLine();
        }
        printLine(answ, ch);
    }
}
