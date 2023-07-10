import java.io.*;
import java.util.*;
public  class Random {
    public static void main(String args[]){
        List<String> lst=new ArrayList<>();
        for(int j=0;j<50000;j++) {
            String str = "";
            int a;
            char c;
            int len = (int) (5 + (Math.random() * 10));
            for (int i = 0; i < len; i++) {
                a = (int) (65 + (Math.random() * 25));
                c = (char) a;
                str += (c + "");
            }
            len = (int) (5 + (Math.random() * 10));
            for (int i = 0; i < len; i++) {
                a = (int) (97 + (Math.random() * 25));
                c = (char) a;
                str += (c + "");
            }
            len = (int) (5 + (Math.random() * 10));
            for (int i = 0; i < len; i++) {
                a = (int) (0 + (Math.random() * 9));
                c = (char) ('0' + a);
                str += (c + "");
            }
            String[] str2 = {"@", "#", "$", "%", "&"};
            len = (int) (5 + (Math.random() * 10));
            for (int i = 0; i < len; i++) {
                a = (int) (0 + (Math.random() * 4));
                str += str2[a];
            }

            if(!lst.contains(str)){
                lst.add(str);
            }
            else{
                j--;
            }
        }

        System.out.println(lst.size());
        String currentDir = System.getProperty("user.dir");
        System.out.println(currentDir);


        String fileName = currentDir+"/src/sheik.txt";
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for(int i=0;i<50000;i++) {

                bufferedWriter.write(lst.get(i));
                bufferedWriter.newLine();
            }// Add a new line after the text
            bufferedWriter.close(); // Close the writer

            System.out.println("File is written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}