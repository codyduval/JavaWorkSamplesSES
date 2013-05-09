import java.io.*;
import java.util.Scanner;

public class TextGeneratorApplication {

    public static void main(String[] args) {
        Scanner s = null;
        String filename = "star_trek.txt";

        try {
            s = new Scanner(new BufferedReader(new FileReader(filename)));
            NGramTextGenerator generator = new NGramTextGenerator(); 
            while (s.hasNext()) {
                generator.addWord(s.next());
            }
            generator.printRandomText();
        } catch (FileNotFoundException exception) {
            System.out.println("File " + filename + " not found! Bailing");
        }
        finally {
            if (s != null) {
                s.close();
            }
        }
    }
}