import java.io.*;
import java.util.*;

public class SignatureCheck {

    private Map<String, LinkedList<Integer>> signatureMap;
    private int maxLenVal = 100;

    SignatureCheck(String readPath) throws IOException {
        signatureMap = new HashMap<>();
        fullSignatureMap(readPath);
    }

    private void fullSignatureMap(String path) throws IOException {
        FileReader read = new FileReader(path);
        BufferedReader reader = new BufferedReader(read);
        String line = reader.readLine();
        LinkedList<Integer> val = new LinkedList<>();

        int a = 0x0;

        while (line != null)
        {
            val = new LinkedList<>();
            for(String strr: (line.split(",")[1]).split(" "))
            {
                if (!strr.isEmpty() && strr.length() > 0) {
                    a = (Integer.parseInt(strr, 16));
                    val.add(a);
                }
            }
            this.signatureMap.put(line.split(",")[0], val);
            line = reader.readLine();
        }
        read.close();
    }

    public void readInputFiles(String outFile) throws IOException {
        FileWriter writer = new FileWriter(outFile);
        ArrayList<Integer> listData;
        FileInputStream inputStream;
        while(true) {
            writer = new FileWriter(outFile,true);
            String input = new BufferedReader(new InputStreamReader(System.in)).readLine();
            if (input.contains("42"))
                System.exit(0);
            if (input.isEmpty())
                continue;
                inputStream = new FileInputStream(input);

            listData = new ArrayList<Integer>();
            int i = 0;
            while (inputStream.available() > 0 && i < this.maxLenVal) {
                listData.add(inputStream.read());
                i++;
            }
            inputStream.close();
            writer.write(checkFileSignature(listData) + "\n");
            writer.flush();
            writer.close();
        }
    }

    private boolean compareList(ArrayList<Integer> listFile, LinkedList<Integer> listMap)
    {
        for (int i = 0; i < listMap.size(); i++)
        {
            if (i < listFile.size() && i < listMap.size())
            {
                if (!listMap.get(i).equals(listFile.get(i))) {
                    return  false;
                }
            }
            else
                return  false;
        }
        return true;
    }


    private String checkFileSignature(ArrayList<Integer> listData)  {
        boolean find = false;
//        printArrayList(listData);

        for (Map.Entry<String,LinkedList<Integer>> entry :this.signatureMap.entrySet())
        {
            for(int j = 0; j < listData.size(); j++)
            {
                if (entry.getValue().get(0).equals(listData.get(j)))
                {
                    find = compareList(listData, entry.getValue());
                }
            }
            if (find)
            {
                System.out.println("PROCESSED");
                return entry.getKey();
            }
        }
        System.out.println("UNDEFINED");
        return null;
    }
}
