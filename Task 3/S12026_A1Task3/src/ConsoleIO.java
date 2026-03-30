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
        int output = 0;
        boolean isNotValid;

        do
        {
           try
           {
               System.out.println(message);
               output = Integer.parseInt(input.nextLine());

               // input should fall within min and max range
               isNotValid = (output < min || output > max) ?
                       true : false;
           }

           catch (Exception e)
           {
               isNotValid = true;
           }
        } while (isNotValid);

        return output;
    }

    public String getStringInput(String message)
    {
        String output = "";
        boolean isNotValid;

        do
        {
            try
            {
                System.out.println(message);
                output = input.nextLine().strip();

                // input should not be empty and have more than 3 characters
                isNotValid = (output.isBlank() || output.length() < 3) ?
                        true : false;
            }

            catch (Exception e)
            {
                isNotValid = true;
            }
        } while (isNotValid);

        return output;
    }
}
