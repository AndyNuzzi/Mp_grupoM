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

    /**
     * Mostrará las naves espaciales
     */
    private void printStarships (){
        for (Starship starship: this.starships){
            starship.print();
        }
    }

    private void printDefense (){
        for (Defense defense: this.defense){
            defense.getResistance();
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
        System.out.println("Owner: " + this.crew);
        System.out.println("Owner: " + this.passengers);
        this.printStarships();


    }


}
