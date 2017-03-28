import java.io.IOException;

public class Command {

    private String command;

    public Command(String command) {
        this.command = command;
    }

    public Process execute() throws IOException {
        return Runtime.getRuntime().exec(command);
    }

    @Override
    public String toString() {
        return command;
    }
}
