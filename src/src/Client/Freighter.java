package Client;

public class Freighter extends Starship{
    private int capacity;
    private Defense defense;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Defense getDefense() {
        return defense;
    }

    public void setDefense(Defense defense)  {
        this.defense = defense;
    }

}