package Client;

import java.io.Serializable;

public class Fighter extends Starship implements Serializable {
    private Weapon weapon1;
    private Weapon weapon2;
    private Defense defense;

    public Weapon getWeapon1() {
        return weapon1;
    }

    public Weapon getWeapon2() {
        return weapon2;
    }

    public Defense getDefense() {
        return defense;
    }

    public void setWeapon1(Weapon weapon1) {
        this.weapon1 = weapon1;
    }

    public void setWeapon2(Weapon weapon2) {
        this.weapon2 = weapon2;
    }

    public void setDefense(Defense defense) {
        this.defense = defense;
    }

    /**
     * Mostrará las defensas
     */
    private void printDefense() {
        System.out.println("Defense: " + defense.getName());
        System.out.println("Resistance: " + defense.getResistance());
        if (defense.getName().equals("Shield")) {
            System.out.println("Energy amount: " + ((Shield) defense).getEnergyAmount());
        } else {
            System.out.println("Material: " + ((Armor) defense).getMaterial());
            System.out.println("Weight: " + ((Armor) defense).getWeight());
        }
    }

    private void printWeapon() {
        System.out.println("Weapon1 :" + this.weapon1.getName());
        System.out.println("Power: " + this.weapon1.getPower());
        System.out.println("Weapon2 :" + this.weapon2.getName());
        System.out.println("Power: " + this.weapon2.getPower());
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
        this.printWeapon();
        this.printDefense();
    }

}
