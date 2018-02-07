// Some Java's library privided by NetBeans to enable methods and statments below

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

//PartA:  

public class AS_Telephone_Mapper_A {

    @SuppressWarnings("empty-statement")
    
    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);
        
        // prompt user for dictionary file
        
        System.out.print("Enter name of dictionary file: ");
        String fName = input.nextLine();

        //Creating files short3 and short4
        
        // instantiate PhoneMapper for 3-letter words from dictionary file
        
        PhoneMapper myMap3 = new PhoneMapper(fName, 3);
        String[] w3 = myMap3.getArray();
        
        // instantiate PhoneMapper for 4-letter words from dictionary file

        PhoneMapper myMap4 = new PhoneMapper(fName, 4);
        String[] w4 = myMap4.getArray();

        //Create and store in file_1
        
        FileWriter fileWriter1 = new FileWriter("short3");

        BufferedWriter bufferedWriter1 = new BufferedWriter(fileWriter1);
        for (int i = 0; i < myMap3.numWords; i++) {
            bufferedWriter1.newLine();
            bufferedWriter1.write(w3[i]);
        }

        bufferedWriter1.close();
        
        //Create and store in file_2
        
        FileWriter fileWriter2 = new FileWriter("short4");

        BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2);
        for (int i = 0; i < myMap4.numWords; i++) {
            bufferedWriter2.newLine();
            bufferedWriter2.write(w4[i]);
        }

        bufferedWriter2.close();
        /*
        System.out.print("Enter a test word (3 letters): ");
        String s = input.nextLine();
        int testNum = 1;//myMap3.findTelNum(s);
        System.out.println("Test word maps to " + testNum);

        System.out.println("Enter telephone number ");
        System.out.println("(7 digits, no 0's or 1's, negative to quit): ");

        int telNum = input.nextInt();
        while (telNum >= 0) { // process each non-negative number
            int firstPart = telNum / 10000;

            String[] results = myMap3.findWords(firstPart);

            System.out.println("Options for first 3 digits:");
            for (int i = 0; i < results.length; i++) {
                System.out.println(results[i]);
            }
            System.out.print("enter=" + " telephone=" + " ");
            telNum = input.nextInt();
        }
*/
    }
}

//Part B 

class PhoneMapper {

    final int MAXWORDS = 20000; // max number of words from dictionary
    String[] wordList = new String[MAXWORDS]; // list of dictionary words
    int numWords = 0; // number of words of correct length
    // extracted from dictionary
    int cnt = 0;

    PhoneMapper(String fileName, int wordLength) throws Exception {

        // fileName: name of dictionary file
        
        FileReader fileReader
                = new FileReader(fileName);

        // Always wrap FileReader in BufferedReader.
      
        
        BufferedReader bufferedReader
                = new BufferedReader(fileReader);

        String line;
        
        // read dictionary file
        
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
            if (line.length() == wordLength) { // wordLength: length of words to extract
                wordList[cnt] = line; // add each word of length wordLength to wordList[]
                cnt++;
                numWords = cnt; 
            }
        }
    }

    public String[] getArray() {
        return wordList;
    }

    // return array of words mapped to num
    
    String[] findWords(int num) {
        String[] nString = new String[0];

        return nString;
    }
} 
