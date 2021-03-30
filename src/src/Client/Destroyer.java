package Client;

import java.util.ArrayList;
import java.util.List;

public class Destroyer extends Starship{

    private List<Weapon> weapon = new ArrayList<Weapon>();
    private List<Defense> defense = new ArrayList<Defense>();

    // falta constructor

    public void addWeapon(Weapon weapon){
        this.weapon.add(weapon);
    }

    public void addDefense(Defense defense){
        if (this.checkDefenseNumber()){
            this.defense.add(defense);
        } else {
            System.out.println(" No more Defenses can be added ");
        }
    }

    private boolean checkDefenseNumber(){
        return this.defense.size() < 3;
    }

    public List <Weapon> getWeapon() {
        return this.weapon;
    }

    public List<Defense> getDefenses() {
        return this.defense;
    }
}
