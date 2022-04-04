package task2;

public class HelloCommand extends MyCommands {
    @Override
    public void execute() {
        commands.helloCommand();
    }

    public void getUsage() {
        System.out.println("There are no parameters for this command.");
    }

    public void getInfo() {
        System.out.println("This command print \"Hello World\" text.");
    }

}
