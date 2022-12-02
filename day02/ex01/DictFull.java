import java.io.*;
import java.util.*;

public class DictFull {
    HashMap<String, Integer> dict;
    HashMap<String, Integer>  vector1;
    HashMap<String, Integer>  vector2;

    DictFull(String file1, String file2) throws IOException {
        dict = new HashMap<>();

        fullDict(file1);
        fullDict(file2);

        vector1 = vectorFull(file1);
        vector2 = vectorFull(file2);

        System.out.println("Similarity = " + form());
    }

    private void writeFile() throws IOException {
        FileWriter writer = new FileWriter("dictionary.txt");
        for(Map.Entry<String, Integer> e: this.dict.entrySet())
        {
            writer.write(e.getKey() + "\n");
        }
        writer.flush();
        writer.close();

    }
    private void fullDict(String path) throws IOException {
        FileReader read = new FileReader(path);
        BufferedReader reader = new BufferedReader(read);
        String line = reader.readLine();
        while (line != null)
        {
            for (String word : line.split(" "))
            {
                this.dict.put(word, 0);
            }
            line = reader.readLine();
        }
        writeFile();
        reader.close();
    }
    private HashMap<String, Integer> vectorFull(String path) throws IOException {
        HashMap<String, Integer> tmp = new HashMap<>();
        tmp.putAll(this.dict);
        FileReader read = new FileReader(path);
        BufferedReader reader = new BufferedReader(read);
        String line = reader.readLine();
        while (line != null)
        {
            for (String word : line.split(" "))
            {
                tmp.put(word, tmp.get(word) + 1);
            }
            line = reader.readLine();
        }
        reader.close();
        return tmp;
    }
    private double form()
    {
        int Numerator = 0;
        double Denominator1 = 0;
        double Denominator2 = 0;
        double Den;
        double similarity;
        for(Map.Entry<String, Integer> e: this.dict.entrySet())
        {
            Numerator += this.vector1.get(e.getKey()) * this.vector2.get(e.getKey());
            Denominator1 += this.vector1.get(e.getKey()) * this.vector1.get(e.getKey());
            Denominator2 += this.vector2.get(e.getKey()) * this.vector2.get(e.getKey());
        }
        Den = Math.sqrt(Denominator1) + Math.sqrt(Denominator2);

        similarity = Numerator / Den;
        return similarity;
    }
}
