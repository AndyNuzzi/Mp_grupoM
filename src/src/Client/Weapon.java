package Client;

import java.io.Serializable;

public abstract class Weapon implements Serializable {

    private int power;

    public Weapon (int power){
        this.power = power;
    }

    public String getName (){
        return this.getClass().getSimpleName();
    }

    public int getPower (){
        return this.power;
    }

}
