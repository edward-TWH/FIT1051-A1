import java.lang.reflect.Array;
import java.util.Arrays;

public class Room
{
    private int id;
    private int[] exits;
    private Monster monster;

    public Room()
    {
        this.id = 0;
        this.exits = new int[4];
        this.monster = new Monster();

        for (int i = 0; i < 4; i++)
        {
            this.exits[i] = 0;
        }
    }

    public Room(int id, int[] exits, Monster monster)
    {
        this.id = id;
        this.exits = exits;
        this.monster = monster;
    }

    public int[] getExits()
    {
        return this.exits;
    }

    public int getId()
    {
        return this.id;
    }

    public Monster getMonster()
    {
        return this.monster;
    }

    public void setExits(int[] newExits)
    {
        this.exits = newExits;
    }

    public void setId(int newId)
    {
        this.id = newId;
    }

    public void setMonster(Monster newMonster)
    {
        this.monster = newMonster;
    }

    public String toString()
    {
        String output = "Room %s (Exits %s, Monster %s)";
        return String.format(output, this.id,
                Arrays.toString(this.exits), this.monster);
    }

}
