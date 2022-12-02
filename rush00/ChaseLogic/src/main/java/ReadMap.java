import java.io.*;

public class ReadMap {
    int[][] arr;
    public ReadMap(String path) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(path));
        String  str = reader.readLine().strip();
        int count = str.split(" ").length;
        arr = new int[count][count];
            String line = reader.readLine();
            int i = 0;
            int j = 0;
        while (line != null)
        {
            i = 0;
            for (String word : line.substring(2).split(" "))
            {
                if (!word.equals("0"))
                    arr[i][j] = 1;
                i++;
            }
            line = reader.readLine();
            j++;
        }
        reader.close();
    }
    public int[][] arrOut()
    {
        return this.arr;
    }
}
