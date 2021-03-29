package Client;

import java.io.Serializable;

public class Fighter extends Starship implements Serializable {
    private Weapon weapon1;
    private Weapon weapon2;
    private Defense defense;

    public Fighter(String registerNumber, String owner, Propulsion[] propulsion, int crew, Weapon weapon1, Weapon weapon2, Defense defense) {
        super(registerNumber, owner, propulsion, crew);
        this.weapon1 = weapon1;
        this.weapon2 = weapon2;
        this.defense = defense;
    }
}
