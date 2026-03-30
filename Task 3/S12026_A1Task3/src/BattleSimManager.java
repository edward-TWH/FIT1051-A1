/**
 * The BattleSimManager class is responsible for managing the overall battle
 * simulation. It handles player creation, monster initialization, and running
 * the simulation flow including battles.
 *
 * @author FIT1051 Admin
 * @version 1.0 - created the basic scaffold for the class
 */
public class BattleSimManager
{
    private final ConsoleIO console;
    private Character player;
    private Monster monster;

    /**
     * Default constructor that initializes a new player and a default Goblin
     * monster with 70 HP, 20 attack and 4 defense.
     */
    public BattleSimManager()
    {
        player = new Character();
        monster = new Monster("Goblin", 70, 20, 4);
        console = new ConsoleIO();
    }

    /**
     * Constructs a BattleSimManager with a specified player. A default Goblin
     * monster with 70 HP, 20 attack and 4 defense is also initialized.
     *
     * @param player the player character
     */
    public BattleSimManager(Character player, ConsoleIO console)
    {
        this.player = player;
        this.monster = new Monster("Goblin", 70, 20, 4);
        this.console = console;
    }

    /**
     * Simulates a battle between the player and the monster.
     *
     * @return the Character who wins the battle
     */
    public String battle()
    {
        String victor = player.getName();
        int damageDealt = 0;

        damageDealt = player.takeDamage(monster.getAttack());
        console.display(monster.getName() + " attacks for " + damageDealt +
                        " to the player.");

        damageDealt = monster.takeDamage(player.getAttack());
        console.display(player.getName() + " attacks for " + damageDealt +
                        " to the monster.");

        if (monster.getHealth() > player.getHealth())
        {
            victor = monster.getName();
        }
        return victor;
    }

    private void createPlayerCharacter()
    {
        String name = console.getStringInput("What is your name adventurer: ");
        if (name.isBlank() || name.length() < 3)
        {
            terminateProgram("That name doesn’t sound like a true adventurer!");
        }

        int health = console.getIntInput("Enter your character's health: ", 1, 100);
        if (health < 1 || health > 100)
        {
            terminateProgram("That health won't keep you alive in the labyrinth");
        }

        int attack = console.getIntInput("Enter your character's attack: ", 1, 100);
        if (attack < 1 || attack > 100)
        {
            terminateProgram("That attack doesn't look reasonable!");
        }

        int defense = console.getIntInput("Enter your character's defense: ", 1, 100);
        if (defense < 1 || defense > 100)
        {
            terminateProgram("That defense doesn't look reasonable!");
        }

        player.setName(name);
        player.setHealth(health);
        player.setAttack(attack);
        player.setDefence(defense);
    }

    private void displayMenu()
    {
        String menu = """
                      Choose an option:
                      1. Create a character
                      2. Exit
                      """;

        console.display(menu);
    }

    private void displayWelcomeMessage()
    {
        String message = """
                         Welcome to the Labyrinth!
                         
                         You find yourself trapped in a mysterious maze made up of interconnected rooms.
                         Each room may contain hidden dangers… or a path to safety.
                         
                         Explore carefully:
                         
                         Move through rooms using the available exits (North, East, South, West)
                         Watch out for monsters lurking in the shadows
                         Choose your path wisely — not all routes lead forward
                         
                         Your goal is simple:
                         Find your way from Room 1 to Room 10 and escape the labyrinth.
                         
                         Good luck, adventurer… you’ll need it.
                         """;
        console.display(message);
    }

    /**
     * Returns the current monster.
     *
     * @return the monster opponent
     */
    public Monster getMonster()
    {
        return monster;
    }

    /**
     * Returns the player character.
     *
     * @return the player
     */
    public Character getPlayer()
    {
        return player;
    }

    /**
     * Runs the simulation by displaying a menu and processing user input.
     */
    public void runSimulation()
    {
        displayWelcomeMessage();

        displayMenu();

        int userChoice = console.getIntInput("Enter your choice (1-2): ",
                                             1, 2);
        switch (userChoice)
        {
            case 1:
                createPlayerCharacter();
                String victor = battle();
                int hp = victor.equals(player.getName()) ?
                        player.getHealth() :
                        victor.length();
                console.display(victor + " wins the battle with " + hp +
                                "remaining hp.");

                break;
            case 2:
                terminateProgram("Thanks for playing!");
                break;
            default:
                terminateProgram("That is not a valid choice.");
        }
    }

    /**
     * Sets the monster opponent.
     *
     * @param monster the monster to set
     */
    public void setMonster(Monster monster)
    {
        this.monster = monster;
    }

    /**
     * Sets the player character.
     *
     * @param player the player to set
     */
    public void setPlayer(Character player)
    {
        this.player = player;
    }

    private void terminateProgram(String message)
    {
        console.display(message);
        console.display("Terminating the program");
        System.exit(0);
    }

    /**
     * Returns a string representation of the battle setup.
     *
     * @return a string showing the player and monster
     */
    @Override
    public String toString()
    {
        return player + " fights " + monster;
    }
}
