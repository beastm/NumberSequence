import java.io.*;
import java.util.List;
import java.util.Scanner;

/*FileController serves as a class, where all manipulations with files are handled - reading the context
* and creating (truncating) the file - meaning overwriting existing one with the same name*/

public class FileController {

    //reads a single line from  file specified by the path
    public String readFromFile(String path){
        File file = new File(path);

        try (Scanner scanner = new Scanner(file)){
            return scanner.nextLine(); // Assumes file has at least one line
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found" + path, e); // Handling of nonexistent file
        }
    }

/**
 * Creates a file with a specified name in the solution and writes a list of integers to it.
 **/
    public void createFile(String path, List<Integer> numbers){
        try {BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            for (int i = 0; i < numbers.size(); i++) {
                writer.write(String.valueOf(numbers.get(i)));
                if (i != numbers.size() - 1) {
                    writer.write(",");
                }
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException("Error creating file" + e.getMessage());
        }
    }
}
