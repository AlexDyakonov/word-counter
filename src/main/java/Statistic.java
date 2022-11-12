

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Statistic {

    public static String getFileName(){
        Scanner input = new Scanner(System.in);
        System.out.println("Input file name (with .txt): ");
        return ("src/main/java/" + input.nextLine());
    }

    public static HashMap<String, Integer> input() {
        HashMap<String, Integer> wordCount = new HashMap<>();

        try (FileReader file = new FileReader("src/main/java/input.txt")) {
            BufferedReader br = new BufferedReader(file);
            String line;
            while ((line = br.readLine()) != null) {
                String[] arrayOfString = line.toLowerCase().replaceAll("[+.^:,!?–]","").trim().split("\\s+");
                for (int i = 0; i < arrayOfString.length; i++){
                    if (!wordCount.containsKey(arrayOfString[i])){
                        wordCount.put(arrayOfString[i], 1);
                    }else {
                        wordCount.put(arrayOfString[i], wordCount.get(arrayOfString[i]) + 1);
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return wordCount;
    }

    public static void output(HashMap<String, Integer> input){
        try(FileWriter output = new FileWriter("src/main/java/output.txt"))
        {
            for (Map.Entry entry : input.entrySet()){
                output.write(entry.toString().replace("=", " ") + "\n");
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}