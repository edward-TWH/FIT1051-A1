/**
 * The main driving class to the Labyrinth Battle Simulator.
 *
 * @author FIT1051, todo: <add your name here>
 * @version 1.0 - created a scaffold for Task 1 with a main method and to-do
 * tasks
 */
public class BattleSimulatorDriver
{

    /**
     * Main method, this is where execution starts
     *
     * @param args command line arguments
     */
    static void main(String[] args)
    {
        // creating an object of the BattleSimManager class so that we can
        // call the runSimulation method
        BattleSimManager battleSimManager = new BattleSimManager();
        // calling / invoking the runSimulation method
        battleSimManager.runSimulation();
    }


    // expected solution for A1Task1
    /*public void runSimulation()
    {

        String character1Name = "Warrior";
        int character1Health = 120;
        int character1Attack = 18;
        int character1Defence = 15;

        String character2Name = "Mage";
        int character2Health = 80;
        int character2Attack = 30;
        int character2Defence = 5;

        System.out.printf("%s (%d HP, %d attack %d defense)",
                          character1Name, character1Health, character1Attack,
                          character1Defence);

        System.out.println();

        System.out.printf("%s (%d HP, %d attack %d defense)",
                          character2Name, character2Health, character2Attack,
                          character2Defence);

        Character warrior = new Character("Warrior", 120,
                                             188, 15);

        Character mage = new Character("Mage", 80,
                                       30, 5);

        System.out.println(warrior);
        System.out.println(mage);


    }*/

}
