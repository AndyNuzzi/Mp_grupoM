package Client;

import java.io.Serializable;

public class Freighter extends Starship implements Serializable {
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

    public void setDefense(Defense defense) {
        this.defense = defense;
    }

    /**
     * Mostrará las defensas
     */
    private void printDefense() {
        System.out.println("Defense:" + defense.getName());
        System.out.println("Resistance: " + defense.getResistance());
        if (defense.getName().equals("Shield")) {
            System.out.println("Energy amount: " + ((Shield) defense).getEnergyAmount());
        } else {
            System.out.println("Material: " + ((Armor) defense).getMaterial());
            System.out.println("Weight: " + ((Armor) defense).getWeight());
        }
    }

    /**
     * Mostrara la nave espacial por pantalla
     */
    @Override
    public void print() {
        System.out.println("Register number: " + this.registerNumber);
        System.out.println("Owner: " + this.owner);
        super.printPropulsion();
        System.out.println("Crew: " + this.crew);
        System.out.println("Capacity: " + this.capacity);
        this.printDefense();
    }

}
