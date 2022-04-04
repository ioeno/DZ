import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        System.out.println("Second task solving demonstration:");
        catLikeCommand();
        //System.out.println("Third task solving demonstration:");
        //printLongestLine();
        //System.out.println("Fourth task solving demonstration:");
        //countLines();
        //System.out.println("Fifth task solving demonstration:");
        //findLongestWordInEachLine();
    }

    // task 3.2
    public static void catLikeCommand() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter full filepath: ");
            String filepath = scanner.nextLine();
            File file = new File(filepath);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            int counter = 1;
            while ((line = reader.readLine()) != null) {
                System.out.println(counter + ") " + line);
                counter += 1;
            }
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Incorrect enter.");
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("File not found.");
        } catch (IOException ioException) {
            System.err.println("File reading error.");
        }
    }

    // task 3.3
    public static void printLongestLine() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter full filepath: ");
            String filepath = scanner.nextLine();
            File file = new File(filepath);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            String longestString = null;
            int maxLength = -1;
            while ((line = reader.readLine()) != null) {
                if (line.trim().length() > maxLength) {
                    longestString = line.trim();
                    maxLength = longestString.length();
                }
            }
            System.out.println("Longest line in file: " + longestString);
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("File not found.");
        } catch (IOException ioException) {
            System.err.println("File reading error.");
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Incorrect enter.");
        }
    }

    // task 3.4
    public static void countLines() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter full filepath: ");
            String filepath = scanner.nextLine();
            File file = new File(filepath);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            int counter = 1;
            FileWriter writer = new FileWriter("./out.txt", false);
            while ((line = reader.readLine()) != null) {
                counter += 1;
            }
            System.out.println(counter);
            writer.write(new String().valueOf(counter));
            writer.flush();
            System.out.println("Lines amount has been successfully written to file out.txt.");
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("File not found.");
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Incorrect enter.");
        } catch (IOException ioException) {
            System.err.println("File reading error.");
        }
    }

    // task 3.5
    public static void findLongestWordInEachLine() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter full filepath: ");
            String filepath = scanner.nextLine();
            File file = new File(filepath);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            int counter = 1;
            FileWriter writer = new FileWriter("./out.txt", false);
            while ((line = reader.readLine()) != null) {
                String[] wordsInLine = line.trim().split("\\W");
                int maxLength = -1;
                String longestString = null;
                for (String word : wordsInLine) {
                    if (word.length() > maxLength) {
                        longestString = word;
                        maxLength = word.length();
                    }
                }
                writer.write(longestString);
                writer.write("\n");
            }
            writer.flush();
            System.out.println("Longest word in each string has been successfully written to a file out.txt");
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Incorrect enter.");
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("File not found.");
        } catch (IOException ioException) {
            System.err.println("File reading error.");
        }
    }

}
