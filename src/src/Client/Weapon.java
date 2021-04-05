package Client;

import java.io.Serializable;

public abstract class Weapon implements Serializable {

    protected int power;

    public String getName (){
        return this.getClass().getSimpleName();
    }

    public int getPower (){
        return this.power;
    }

}
