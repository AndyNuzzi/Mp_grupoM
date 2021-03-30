package Client;

public class SpaceStation extends Starship{
    private int passengers;
    private Starship[] starships ;
    private Defense[] defenses= new Defense[3];

    public SpaceStation(int passengers, Starship[] starships, Defense[] defenses){
        this.passengers=passengers;
        this.defenses=defenses;
        this.starships=starships;
    }
    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public void addStarShip(Starship[] starship){
    //logica añadir nave espacial
    }
    public void addDefense(Defense[] defense){
    //logica añadir defensas
    }
    private boolean checkDefenseNumber(){
      return   this.defenses==defenses;
    }

    public int getPassengers() {
        return passengers;
    }

    public Starship[] getStarships() {
        return starships;
    }

    public Defense[] getDefenses() {
        return defenses;
    }
}
