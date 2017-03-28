import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class PipeOperatorMain {
    public static void main(String[] args) throws IOException {
        String command = "sort -> more";
        List<String> commands = Arrays.asList(command.split("->"));
        BufferedReader result = PipeOperator.operate(commands);
        String line;
        System.out.println("------------------------------------------------------------------------------------");
        while ((line = result.readLine()) != null) {
            System.out.println("line = " + line);
        }
        System.out.println("------------------------------------------------------------------------------------");
    }
}
