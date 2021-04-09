package Client;

import java.io.Serializable;

public class Armor extends Defense implements Serializable {

    private String material;
    private int weight;


    public Armor(int resistance, String material, int weight) {
        this.resistance = resistance;
        this.material = material;
        this.weight = weight;
    }

    public String getMaterial(){
        return this.material;
    }

    public int getWeight(){
        return this.weight;
    }

}
