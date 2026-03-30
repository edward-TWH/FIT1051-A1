import java.util.Scanner;

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
    }

    /**
     * Constructs a BattleSimManager with a specified player. A default Goblin
     * monster with 70 HP, 20 attack and 4 defense is also initialized.
     *
     * @param player the player character
     */
    public BattleSimManager(Character player)
    {
        this.player = player;
        this.monster = new Monster("Goblin", 70, 20, 4);
    }

    /**
     * Simulates a battle between the player and the monster.
     *
     * @return the Character who wins the battle
     */
    public String battle()
    {
        // calculate damage after defence is considered
        int damageToMonster = (int) (player.getAttack() -
                0.5 * monster.getDefence());
        int damageToPlayer = (int) (monster.getAttack() -
                0.5 * player.getDefence());

        /*
        if the calculated damage after defence is negative, we don't need to
        change the health of the defender
        */
        if (damageToMonster > 0)
        {
            monster.setHealth(monster.getHealth() - damageToMonster);
        }
        if (damageToPlayer > 0)
        {
            player.setHealth(player.getHealth() - damageToPlayer);
        }

        // the winner is the one with higher health
        return player.getHealth() >= monster.getHealth() ?
                player.getName() : monster.getName();
    }

    /**
     * Prompts the user to create a character, allowing them to specify
     * its name, health, attack and defence.
     */
    private void createCharacter()
    {
        Scanner scanner = new Scanner(System.in);

        String name = "";
        int health = 0, attack = 0, defence = 0;
        try
        {
            System.out.println("Enter character name: ");
            name = scanner.next();
            if (name.length() < 3 && !name.isBlank())
            {
                throw new Exception("Invalid character name");
            }

            System.out.println("Enter character health: ");
            health = scanner.nextInt();
            if (health < 0 || health > 100)
            {
                throw new Exception("Invalid character health value");
            }

            System.out.println("Enter character attack: ");
            attack = scanner.nextInt();
            if (attack < 0 || attack > 100)
            {
                throw new Exception("Invalid character attack value");
            }

            System.out.println("Enter character defence: ");
            defence = scanner.nextInt();
            if (defence < 0 || defence > 100)
            {
                throw new Exception("Invalid character defence value");
            }

            this.player = new Character(name, health, attack, defence);
        } catch (Exception e)
        {
            System.out.printf(e + "\nCharacter could not be created.");
        }
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
        Scanner scanner = new Scanner(System.in);

        System.out.println(
                "Menu options:\n" +
                        "0. Exit\n" +
                        "1. Create a character\n"
        );

        System.out.println("Enter option number: ");
        int input = scanner.nextInt();

        switch (input)
        {
            case 0:
                System.exit(0);
                break;
            case 1:
                this.createCharacter();
                break;
        }
        String winner = battle();
        System.out.println("Winner of simulated battle is " + winner);
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
