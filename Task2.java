package task2;

import javax.xml.bind.SchemaOutputResolver;
import java.net.SocketTimeoutException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        // Task 2.4 solving demonstration - all other files in this package are included for it
        Navigator helloCommand = new Navigator().registerCommand(new HelloCommand());
        Navigator helloSomeoneCommand = new Navigator().registerCommand(new HelloSomeoneCommand());
        Navigator repeatCommand = new Navigator().registerCommand(new RepeatCommand());
        // Task 2.5 solving demonstration - getUsage() & getInfo() methods in commands classes - it uses in help command executing
        // Task 2.6 solving demonstration is content of current main method;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hi! You can use commands from this list.");
        System.out.println("Variants:");
        System.out.println("1. hello;");
        System.out.println("2. helloSomeone;");
        System.out.println("3. repeat;");
        System.out.println("4. help;");
        System.out.println("Print <exit> for finishing a program.");
        while (true) {
            System.out.print("Enter a command: ");
            String rawCommand = scanner.nextLine();
            String[] command = rawCommand.trim().toLowerCase(Locale.ROOT).split(" ");
            switch (command[0]) {
                case "hello":
                    System.out.println("Hello command is running!");
                    helloCommand.run();
                    break;
                case "hellosomeone":
                    System.out.println("HelloSomeone command is running!");
                    helloSomeoneCommand.run();
                    break;
                case "repeat":
                    System.out.println("Repeat command is running!");
                    repeatCommand.run();
                    break;
                case "exit":
                    System.out.println("Program is over.");
                    System.exit(1);
                    break;
                case "help":
                    System.out.println("Hello command:");
                    helloCommand.helloGetInfo();
                    helloCommand.helloGetUsage();
                    System.out.println("Hello Someone command:");
                    helloSomeoneCommand.helloSomeoneGetInfo();
                    helloSomeoneCommand.helloSomeoneGetUsage();
                    System.out.println("Repeat command:");
                    repeatCommand.repeatGetInfo();
                    repeatCommand.repeatGetUsage();
                default:
                    System.out.println("Unknown command. Please, try again.");
                    break;
            }
        }
    }

    // task 2.3
    public static void repeatCommand() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter an argument: ");
            String arg = scanner.nextLine();
            String argument = arg.trim();
            System.out.print("Enter a number of repeats (this value must be a whole number & be greater than 0): ");
            int number = scanner.nextInt();
            if (number <= 0) throw new NoSuchElementException();
            for (int counter = 0; counter < number; counter++) {
                System.out.println(argument);
            }
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Incorrect enter.");
        }
    }

}
