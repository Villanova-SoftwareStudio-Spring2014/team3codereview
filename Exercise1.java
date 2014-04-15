import java.nio.file.*;

public class Exercise1 {

    /**
     * @param args
     * 
     *            Write an example that counts the number of times a particular
     *            character, such as e, appears in a file. The character can be
     *            specified at the command line. You can use xanadu.txt as the
     *            input file.
     */
    public static void main(String[] args) {
        final String filename = "xanadu.txt";
        Path textFile = Paths.get(filename);

        Exercise1HelperMethods methods = new Exercise1HelperMethods();

        if (methods.isAccessible(textFile) && Files.isReadable(textFile)
                && methods.isCharacter(args)) {

            System.out.println(methods.countOccurrences(args, textFile));
        }

    }

}
