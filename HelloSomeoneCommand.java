package task2;

public class HelloSomeoneCommand extends MyCommands {
    @Override
    public void execute() {
        commands.helloSomeoneCommand();
    }

    public void getUsage() {
        System.out.println("There are 1 string parameter for this command - it allows say hello \"to parameter\"");
    }

    public void getInfo() {
        System.out.println("This command prints \"Hello + <parameter>\".");
    }

}