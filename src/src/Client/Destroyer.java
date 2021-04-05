package Client;

import java.io.Serializable;

public class Destroyer extends Starship implements Serializable {

    private Weapon [] weapons = new Weapon[2];
    private Defense [] defenses = new Defense[2];

    public Destroyer(String registerNumber, String owner, Propulsion[] propulsion, int crew, Weapon[] weapons, Defense[] defenses) {
        super(registerNumber, owner, propulsion, crew);
        this.weapons = weapons;
        this.defenses = defenses;
    }
}
