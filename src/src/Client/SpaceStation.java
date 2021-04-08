package Client;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class SpaceStation extends Starship implements Serializable{
    private int passengers;
    private List<Starship> starships = new ArrayList<Starship>();
    private List<Defense> defense = new ArrayList<Defense>();

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public void addStarShip(Starship starship){
        this.starships.add(starship);
    }

    public boolean addDefense(Defense defense){
        if (checkDefenseNumber()){
            this.defense.add(defense);
            return this.checkDefenseNumber();
        } else {
            System.out.println(" No more Defenses can be added ");
            return false;
        }
    }

    private boolean checkDefenseNumber(){
      return this.defense.size() < 3;
    }

    public int getPassengers() {
        return passengers;
    }

    public List<Starship> getStarships() {
        return this.starships;
    }

    public List<Defense> getDefenses() {
        return this.defense;
    }
}
