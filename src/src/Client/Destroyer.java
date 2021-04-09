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

    @Override
    public void print() {

    }
}
