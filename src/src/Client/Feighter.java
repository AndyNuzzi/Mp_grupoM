package Client;

import java.io.Serializable;

public class Feighter extends Starship implements Serializable {

    private int capacity;
    private Defense defense;

    public Feighter(String registerNumber, String owner, Propulsion[] propulsion, int crew, int capacity, Defense defense) {
        super(registerNumber, owner, propulsion, crew);
        this.capacity = capacity;
        this.defense = defense;
    }
}
