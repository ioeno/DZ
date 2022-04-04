import java.io.*;
import java.util.*;

public class Task1 {

    public static void main(String[] args) {
        System.out.println("First task solving demonstration:");
        reverse();
        //System.out.println("Second task solving demonstration:");
        //arrayDequeSort();
        //System.out.println("Third task solving demonstration:");
        //reverseOrder();
        //System.out.println("Fourth task solving demonstration:");
        //printSortedStrings();
        //System.out.println("Fifth task solving demonstration:");
        //printUniqueWords();
        //System.out.println("Sixth task solving demonstration:");
        //printUniqueWordsWithCounting();

    }

    //  task 1.1
    public static void reverse() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter full filepath: ");
            String filepath = scanner.nextLine();
            File file = new File(filepath);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            FileWriter writer = new FileWriter("./out.txt", false);
            String line;
            Stack stack = new Stack();
            while (!(line = reader.readLine()).equals("0")) {
                stack.push(Integer.valueOf(line));
            }
            System.out.println("Reversed file content has been successfully written to file out.txt (on parent directory).");
            while (!stack.empty()) {
                Integer num = (Integer) stack.pop();
                System.out.println(num);
                writer.write(num.toString());
                writer.append("\n");
            }
            writer.flush();
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("File not found.");
        } catch (IOException ioException) {
            System.err.println("File working error.");
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Incorrect enter.");
        }
    }

    // task 1.2
    public static void arrayDequeSort() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter full filepath: ");
            String filepath = scanner.nextLine();
            File file = new File(filepath);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            int counter = 0;
            int amount = Integer.valueOf(reader.readLine());
            ArrayDeque arrayDeque = new ArrayDeque<>();
            while (counter < amount) {
                arrayDeque.add(Integer.valueOf(reader.readLine()));
                counter += 1;
            }
            Integer[] array = (Integer[]) arrayDeque.toArray(new Integer[0]);
            Arrays.sort(array);
            System.out.println("Sorted file content:");
            for (int i = 0; i < array.length; i++) {
                System.out.println(array[i]);
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("File not found.");
        } catch (IOException ioException) {
            System.err.println("File reading error.");
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Incorrect enter.");
        }
    }

    // task 1.3
    public static void reverseOrder() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter full filepath: ");
            String filepath = scanner.nextLine();
            File file = new File(filepath);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            LinkedList linkedList = new LinkedList();
            while (!(line = reader.readLine()).equals("0")) {
                linkedList.add(Integer.valueOf(line));
            }
            System.out.println("Reversed file content:");
            Collections.reverse(linkedList);
            System.out.println(linkedList);
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("File not found.");
        } catch (IOException ioException) {
            System.err.println("File reading error.");
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Incorrect enter.");
        }
    }

    // task 1.4
    public static void printSortedStrings() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter full filepath: ");
            String filepath = scanner.nextLine();
            File file = new File(filepath);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            Set<String> treeSet = new TreeSet<String>(new Comparator<String>() {
                public int compare(String one, String other) {
                    return one.length() - other.length();
                }
            });
            while ((line = reader.readLine()) != null) {
                treeSet.add(line.trim());
            }
            System.out.println("Strings of file in in ascending order of length:");
            for (String string : treeSet) {
                System.out.println(string);
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("File not found.");
        } catch (IOException ioException) {
            System.err.println("File reading error.");
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Incorrect enter.");
        }
    }

    // task 1.5
    public static void printUniqueWords() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter full filepath: ");
            String filepath = scanner.nextLine();
            File file = new File(filepath);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            String str = stringBuilder.toString();
            HashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
            String[] words = str.split("\\W");
            for (String word : words) {
                if (map.containsKey(word)) {
                    map.put(word, map.get(word) + 1);
                } else map.put(word, 1);
            }
            System.out.println("Unique words from file has been written to a file out.txt in current directory.");
            FileWriter writer = new FileWriter("./out.txt", false);
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1) {
                    writer.write(entry.getKey());
                    writer.append("\n");
                }
            }
            writer.flush();
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("File not found.");
        } catch (IOException ioException) {
            System.err.println("File reading error.");
        }
    }

    // task 1.6
    public static void printUniqueWordsWithCounting() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter full filepath: ");
            String filepath = scanner.nextLine();
            File file = new File(filepath);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            String str = stringBuilder.toString();
            HashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
            String[] words = str.split("\\W");
            for (String word : words) {
                if (map.containsKey(word)) {
                    map.put(word, map.get(word) + 1);
                } else map.put(word, 1);
            }
            System.out.println("Unique words from file has been written to a file out.txt in current directory.");
            System.out.println("The number of times each of the words occurred is written to the right of the word after a space");
            FileWriter writer = new FileWriter("./out.txt", false);
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    writer.write(entry.getKey());
                    writer.append(" ");
                    writer.append(entry.getValue().toString());
                    writer.append("\n");
            }
            writer.flush();
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("File not found.");
        } catch (IOException ioException) {
            System.err.println("File reading error.");
        }
    }

}
