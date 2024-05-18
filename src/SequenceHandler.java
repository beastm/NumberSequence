import java.util.ArrayList;
import java.util.List;


/*SequenceHandler class is responsible for the all mid-interactions with sequences:
* Parsing, Adding to the list, Sorting (odd/even), Measuring a size of a sequence*/

public class SequenceHandler {

    //Processes a sequence of integers from given string input
    public List<Integer> processSequence(String input) {
        List<Integer> sequence = parseInput(input); //assigns parsed value
        return fillSequence(sequence);
    }

    //Basic parsing function, parses (splits) string input from comma "," delimiter, and returns a list of integers for further interactions
    private List<Integer> parseInput(String input) {
        List<Integer> result = new ArrayList<>();
        String[] inputs = input.split(","); //splits the input string from ","
        for(String a : inputs) {
            result.add(Integer.parseInt(a));
        }
        return result;
    }

    //fillSequence checks the length of the list and depending on that selects which sequence must be filled
    private List <Integer> fillSequence(List <Integer> sequence){
        if(sequence.size() % 2 == 0) {
            return returnEven(sequence);
        }else {
            return returnOdd(sequence);
        }
    }

    //function responsible for adding just Even numbers in the list
    private List <Integer> returnOdd (List <Integer> sequence) {
        List<Integer> result = new ArrayList<>();
        for (Integer number : sequence) {
            if(number % 2 == 1) { //Check if the integers are odd
                result.add(number);
            }
        }
        return result;
    }

    //function responsible for adding just ODD numbers in the list
    private List <Integer> returnEven(List <Integer> sequence) {
        List<Integer> result = new ArrayList<>();
        for (Integer number : sequence) {
            if(number % 2 == 0) { //Check if the integers are even
                result.add(number);
            }
        }
        return result;
    }
}
