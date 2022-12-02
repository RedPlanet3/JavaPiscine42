import java.util.Scanner;

public class Program {
    public static int countNum(int n)
    {
        int ch = 0;
        while(n > 0) {
            n = n / 10;
            ch++;

        }
        return ch;
    }

    public static int sumNum(int num, int count)
    {
        int sum = 0;
        for(int i = 0; i < count; i++)
        {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static boolean simple(int num)
    {
        int calcSqrt = calcSqrt(num);
        for(int i = 2; i <= calcSqrt; i++)
        {
            if (num % i == 0)
                return (false);
        }
        return (true);
    }


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
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int ch = 0;
        while (num != 42)
        {

            if (simple(sumNum(num, countNum(num))))
                ch++;
            num = in.nextInt();;
        }
        System.out.println("Count of coffee - request - " + ch);
    }
}