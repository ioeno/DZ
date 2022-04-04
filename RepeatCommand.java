package task2;

public class RepeatCommand extends MyCommands {

    @Override
    public void execute() {
        commands.repeatCommand();
    }

    public void getUsage() {
        System.out.println("1st param - string for repeat,\n2nd param - amount of repeats");
    }

    public void getInfo() {
        System.out.println("This command repeats <param1> string <param2> times and prints it.");
    }

}