import java.util.List;
import java.util.Scanner;


/*
*User interaction class administrates the interaction through the console. Handles inputs and gives back outputs.
*
*
*
* */

public class UI {

    private final Scanner scanner = new Scanner(System.in);
    private final FileController fileController = new FileController();
    private final SequenceHandler sequenceHandler = new SequenceHandler();

    /* void start - initiates interaction loop. Asks user to provide input.
    * Processes given inputs*/
    public void start(){
        System.out.println("Type sequence of numbers, separated by comma or enter the file directory");

        String input = scanner.nextLine();
        processInput(input);
    }
/*
* processInput - main goal to parse and detect which type of input is given:
* if it is a path, or if it is a single number sequence*/


    private void processInput(String input){
        if(input.matches("^[a-zA-Z]:\\\\.*$")) { // Checks if the input matches a file path pattern.
            // Reads the file content, processes the sequence, and handles output.
            List<Integer> sequence = sequenceHandler.processSequence(fileController.readFromFile(input)); //assigns red and parsed sequence to list from txt
            handleOutput(input, sequence);
        } else if (input.matches("^\\d+(,\\d+)*$")) {// Checks if the input is a numeric sequence.
            // Processes the input directly as a sequence and handles output.
            List<Integer> sequence = sequenceHandler.processSequence(input); // assigns parsed sequence from string input
            handleOutput(input, sequence);
        } else { //If input does not match completely, sends user to retype the input in the correct way
            System.out.println("Wrong pattern, please try again");
            start();
        }
    }

    /*
    * handleOutput - function used to give back output. It asks gives user option:
    * type a file name to store the sequence in txt format, or press enter and give default output through the console*/
    private void handleOutput(String pathInput, List<Integer> sequence){
        System.out.println("Enter the file name to save in it or press Enter to display in console as default");
        String pathOutput = scanner.nextLine();

        if(pathOutput.isEmpty()){ // checks for the console output default option - nothing is given
            System.out.println("Output of sequence: " + sequence );
        } else if(pathOutput.matches("^[^<>:\"/\\\\|?*]+$")) { // checks the pattern of the while with regex, so txt file name has allowed set of symbols
            fileController.createFile(pathOutput, sequence);
        } else { // if input pattern is wrong, asks user to try again
            System.out.println("Invalid file name. Please try again");
            handleOutput(pathInput, sequence);
        }
    }
}
