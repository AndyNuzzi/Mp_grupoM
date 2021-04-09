package Client;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Destroyer extends Starship implements Serializable{

    private List<Weapon> weapon = new ArrayList<Weapon>();
    private List<Defense> defense = new ArrayList<Defense>();

    public void addWeapon(Weapon weapon){
        this.weapon.add(weapon);
    }

    public boolean addDefense(Defense defense){
        if (this.checkDefenseNumber()){
            this.defense.add(defense);
            return this.checkDefenseNumber();
        } else {
            System.out.println(" No more Defenses can be added ");
            return false;
        }
    }

    private boolean checkDefenseNumber(){
        return this.defense.size() < 2;
    }

    public List <Weapon> getWeapon() {
        return this.weapon;
    }

    public List<Defense> getDefenses() {
        return this.defense;
    }

    /**
     * Mostrará el armamento de la nave
     */
    private void printWeapon() {
        for (Weapon weapon : this.getWeapon()){
            System.out.println("Weapon: " + weapon.getName());
            System.out.println("Power: " + weapon.getPower());
        }
    }

    /**
     * Mostrará las defensas
     */
    private void printDefense(){
        for (Defense defense: this.defense){
            System.out.println("Defense: " + defense.getName());
            System.out.println("Resistance: " + defense.getResistance());
            if (defense.getName().equals("Shield")){
                System.out.println("Energy amount: " + ((Shield) defense).getEnergyAmount());
            } else {
                System.out.println("Material: " + ( (Armor) defense).getMaterial());
                System.out.println("Weight: " + ((Armor) defense).getWeight());
            }
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
        this.printWeapon();
        this.printDefense();
    }

}
