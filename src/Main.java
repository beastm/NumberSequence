public class Main {

    /*Odd-Even number sequence handler - done according the task I got from e-mail. Data from text files must be written in CSV
    * convention, where delimiter must be coma ",". Examples: (1,2,3,4,5,6,7) or (1000,1001,1002,1003) or (1,1,1,1)
    * - all without brackets in single line format
    *  Text files must be saved inside the application folder.
    * for option to load sequence from txt file in the first step:
    * the path to the required txt file must be typed, Ex: "C:\Foo\Bar\Baz.txt"
    * if the sequence contains only even numbers and the count of the numbers is odd, the sequence in output would be empty - []
    * Example: input - (2,4,6), output ()*/

    public static void main(String[] args) {
        UI ui = new UI();
        ui.start();
    }
}