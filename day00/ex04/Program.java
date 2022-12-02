import java.util.Scanner;

public class Program {
    public static boolean inStr(String str, char ch)
    {
        if (str == null)
            return false;
        for(int i = 0; i < str.length(); i++)
        {
            if (ch == str.charAt(i))
                return true;
        }
        return false;
    }

    public static int countChar(char[] str, char ch)
    {
        int count = 0;
        for(int i = 0; i < str.length; i++)
        {
            if (ch == str[i])
                count++;
        }
        return count;
    }

    public static char[] sortRate(String str)
    {
        char[] tmp = str.toCharArray();
        char buf;
        int sorted = 1;
        int i = 0;
        while (sorted != tmp.length)
        {
            if (tmp.length > i + 1) {
                if (tmp[i] > tmp[i + 1]) {
                    buf = tmp[i];
                    tmp[i] = tmp[i + 1];
                    tmp[i + 1] = buf;
                    sorted--;
                }
                else
                    sorted++;
                i++;
            }
            else if ((i == tmp.length - 1))
                i = 0;
        }
        return tmp;
    }

    public static String[] makeLine(char ch, int count, float delim)
    {
        String[] str = new String[12];

        int znak = (int)(count / delim);
        for (int j = 0; j < (10 - znak); j++)
            str[j] = " ";
        str[10 - znak] = "" + count;
        for(int i = 10 - znak + 1; i < 11; i++)
            str[i] = "#";
        str[11] = "" + ch;
        return str;
    }

    public static void diagram(String outPrint[][], int numOut)
    {
        for (int i = 0; i < 12; i++)
        {
            for (int j = 0; j < numOut; j++)
                System.out.print((outPrint[j][i].length() > 1 ? " " : "  ") + outPrint[j][i] + " ");
            System.out.println();
        }
    }

    public static void printRate(String[] rate)
    {
        char[] tmp;
        int tenSimb = 0;
        String outPrint[][] = new String[10][];
        float delim = 0;
        for(int i = 65534; i > -1 && tenSimb < 10; i--)
        {
            if (rate[i] == null) {
                continue;
            }
            if (rate[i].length() > 0)
            {
                if (outPrint[0] == null) {
                    delim = (float) i / 10;

                }
                tmp = sortRate(rate[i]);
                for (int j = 0; j < tmp.length; j++) {
                    outPrint[tenSimb] = makeLine(tmp[j], i, delim);
                    tenSimb++;
                    if (tenSimb == 10)
                        break;
                }
            }
            else {
                outPrint[tenSimb] = makeLine(rate[i].charAt(0), i, delim);
                tenSimb++;
            }
        }
        diagram(outPrint, tenSimb);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String inputStr = in.nextLine();
        char[] input = inputStr.toCharArray();
        String chars = null;
        int numRate;
        String[] rate = new String[65535];

        for(int i = 0; i < input.length; i++)
        {
            if(inStr(chars, input[i]))
                continue;
            else
            {
                chars+=input[i];
                numRate = countChar(input, input[i]);

                if (rate[numRate] == null)
                    rate[numRate] = "" + input[i];
                else
                    rate[numRate] += input[i];
            }
        }

        printRate(rate);
    }
}
