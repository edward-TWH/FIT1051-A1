/**
 * This class represents a monster in a Labyrinth Battle Simulator. This class
 * is built as reference for the HD level task.
 *
 * @author FIT1051 Admin
 * @version 1.0 - A basic Monster class with a name field, constructors,
 * getters, setters and toString method
 */
public class Monster
{

    private String name;
    private int health;
    private int attack;
    private int defence;

    /**
     * Default constructor that sets the name of the Monster to unknown
     */
    public Monster()
    {
        name = "unknown";
        health = 100;
        attack = 10;
        defence = 10;
    }

    /**
     * Parameterized constructor that initializes the name of the Monster to the
     * parsed name
     *
     * @param name the name of the monster
     */
    public Monster(String name, int health, int attack, int defence)
    {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defence = defence;
    }

    public int getAttack()
    {
        return attack;
    }

    public int getDefence()
    {
        return defence;
    }

    public int getHealth()
    {
        return health;
    }

    /**
     * Accessor method for name of the monster
     *
     * @return name of the monster
     */
    public String getName()
    {
        return name;
    }

    public void setAttack(int attack)
    {
        this.attack = attack;
    }

    public void setDefence(int defence)
    {
        this.defence = defence;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

    /**
     * A basic mutator method for name of the monster, no guardian code.
     *
     * @param name new name for the monster
     */
    public void setName(String name)
    {
        this.name = name;
    }

    public int takeDamage(int opponentAttack)
    {
        int damageTaken = (opponentAttack - (int) (defence * 0.5));
        health -= damageTaken;
        return damageTaken;
    }

    /**
     * Returns a String containing the name of the playlist
     *
     * @return playlist name
     */
    public String toString()
    {
        return name + " (" + health + " HP, " + attack + "attack, " +
               defence + " defence)";
    }

}
