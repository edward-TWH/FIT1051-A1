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
}
