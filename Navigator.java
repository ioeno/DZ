package task2;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Navigator {
    private final List<MyCommands> commands = new LinkedList<>();
    private final List<MyCommands> path = new LinkedList<>();

    public Navigator registerCommand(MyCommands command) {
        commands.add(command);
        return this;
    }

    public void run() {
        for(MyCommands command : commands) {
            command.execute();
            ((LinkedList)path).addFirst(command);
        }
        commands.clear();
    }

    public void runBack() {
        for(MyCommands command : path) {
            command.execute();
        }
        path.clear();
    }

    public void helloGetUsage() {
        Command command = new HelloCommand();
        command.getUsage();
    }

    public void helloSomeoneGetUsage() {
        Command command = new HelloSomeoneCommand();
        command.getUsage();
    }

    public void repeatGetUsage() {
        Command command = new RepeatCommand();
        command.getUsage();
    }

    public void helloGetInfo() {
        Command command = new HelloCommand();
        command.getInfo();
    }

    public void helloSomeoneGetInfo() {
        Command command = new HelloSomeoneCommand();
        command.getInfo();
    }

    public void repeatGetInfo() {
        Command command = new RepeatCommand();
        command.getInfo();
    }

}

