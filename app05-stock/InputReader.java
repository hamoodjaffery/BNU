import java.util.Scanner;
/**
 * InputReader reads typed text input from the standard text terminal. 
 * The text typed by a user is returned.
 * 
 * @author  Hamood Jaffery
 * @date 19.Nov.2020
 */
public class InputReader
{
    private Scanner reader;

    /**
     * Create a new InputReader that reads text from the text terminal.
     */
    public InputReader()
    {
        reader = new Scanner(System.in);
    }

    /**
     * Read a line of text from standard input (the text terminal),
     * and return it as a String.
     *
     * @return  A String typed by the user.
     */
    public String getString(String prompt)
    {
        System.out.print(prompt);
        String inputLine = reader.nextLine();
        return inputLine;
    }
    
    /**
     * Read a line of text from standard input (the text terminal),
     * and return it as a String.
     *
     * @return  A String typed by the user.
     */
    public int getInt(String prompt)
    {
        System.out.print(prompt);
        int number = reader.nextInt();
        return number;
    }
}