public class Character
{

    private String name;
    private int health;
    private int attack;
    private int defence;

    public Character()
    {
        this.name = "unknown";
        this.health = 0;
        this.attack = 0;
        this.defence = 0;
    }

    public Character(String name, int health, int attack, int defence)
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

    public void setHel()
    {

    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return name + " (" + health + "HP, " +
                attack + " attack, " +
                defence + " armor)";
    }
}
