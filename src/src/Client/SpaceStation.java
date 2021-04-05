package Client;

import java.io.Serializable;
import java.util.List;

public class SpaceStation extends Starship implements Serializable {

    private int passengers;
    private List<Starship> starships;
    private Defense [] defense = new Defense[3];

    public SpaceStation(String registerNumber, String owner, Propulsion[] propulsion, int crew, int passengers, List<Starship> starships, Defense[] defense) {
        super(registerNumber, owner, propulsion, crew);
        this.passengers = passengers;
        this.starships = starships;
        this.defense = defense;
    }
}
