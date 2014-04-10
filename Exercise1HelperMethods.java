import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

public class Exercise1HelperMethods {

    public Exercise1HelperMethods() {

    }

    public int countOccurrences(String[] args, Path textFile) {

        char userInput = args[0].charAt(0);
        int letterCount = 0;

        Charset charset = Charset.forName("US-ASCII");

        try (BufferedReader reader = Files.newBufferedReader(textFile, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == userInput) {
                        letterCount++;
                    }

                }
            }
            System.out.println(letterCount);
        }
        catch (IOException e) {
            System.out.println("Error - File does not exist");
            e.printStackTrace();
        }

        return letterCount;
    }

    public boolean isAccessible(Path textFilePath) {

        boolean returnValue = false;

        if (Files.exists(textFilePath)) {
            returnValue = true;
        }
        else if (Files.notExists(textFilePath)) {
            System.out
                    .println("File does not exist. Please check path and try again.");
            returnValue = false;
        }
        else {
            System.out
                    .println("File may or may not exist.  (It is possible that this program does not have access to the file.) Check path, permissions and file's current status and try again.");

            returnValue = false;
        }

        return returnValue;
    }

    public boolean isCharacter(String[] args) {
        if (args.length == 1 && args[0].length() == 1) {
            return true;
        }
        else {
            System.out
                    .println("User did not enter a single character to search.  Please try again.");
            return false;
        }

    }

}
