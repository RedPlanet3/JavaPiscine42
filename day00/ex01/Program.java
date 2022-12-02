
import java.util.Scanner;

public class Program {

    private static int calcSqrt(int num)
    {
        long start = 1;
        long fin = num;
        long med;
        long answ = 0;
        while (start <= fin)
        {
            med = (fin + start)/2;
            if (med * med < num)
            {
                start = med + 1;
                answ = med;
            }
            else if (med * med > num)
                fin = med - 1;
            else
                return (int)med;
        }
        return (int) answ;
    }
    public static void main(String[] args) {
        int ch = 0;
        Scanner in = new Scanner(System.in);
        final int num = in.nextInt();
        if (num < 2) {
            System.out.println("theIllegalArgument");
            System.exit(-1);
        }
        int calcSqrt = calcSqrt(num);
        for(int i = 2; i <= calcSqrt; i++)
        {
            ch++;

            if (num % i == 0)
            {
                System.out.println(false + " " + ch);
                System.exit(0);
            }
        }
        System.out.println(true + " " + ch);
        System.exit(0);
    }
}
