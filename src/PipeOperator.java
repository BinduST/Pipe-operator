import java.io.*;
import java.util.List;

public class PipeOperator {

    public static BufferedReader operate(List<String> commands) throws IOException {
        BufferedWriter processInput;
        Process process = Runtime.getRuntime().exec(commands.get(0));
        BufferedReader processOutput = new BufferedReader(new InputStreamReader(process.getInputStream()));
        commands = commands.subList(1, commands.size());
        for (String command : commands) {
            process = Runtime.getRuntime().exec(command);
            processInput = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
            pipe(processOutput, processInput);
            processOutput = new BufferedReader(new InputStreamReader(process.getInputStream()));
        }
        return processOutput;
    }

    private static void pipe(BufferedReader processOutput, BufferedWriter processInput) {
        String line;
        try {
            while ((line = processOutput.readLine()) != null) {
                processInput.write(line);
                processInput.newLine();
            }
            processInput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



