import java.util.Scanner;

public class ConsoleIO
{

    private final Scanner input;


    public ConsoleIO()
    {
        input = new Scanner(System.in);
    }

    public void close()
    {
        input.close();
    }

    public void display(String message)
    {
        System.out.println(message);
    }


    public int getIntInput(String message, int min, int max)
    {
        System.out.println(message);
        return Integer.parseInt((input.nextLine()));
    }

    public String getStringInput(String message)
    {
        System.out.println(message);
        return input.nextLine();
    }
}
