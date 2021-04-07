package Client;

import java.io.Serializable;

public class Armor extends Defense implements Serializable {

    private String material;
    private int weigth;


    public Armor(int resistance, String material, int weigth) {
        this.resistance = resistance;
        this.material = material;
        this.weigth = weigth;
    }

    public String getMaterial(){
        return this.material;
    }

    public int getWeight(){
        return this.weight;
    }

}
