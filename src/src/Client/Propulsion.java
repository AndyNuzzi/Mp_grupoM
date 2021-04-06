package Client;

import java.io.Serializable;

public abstract class Propulsion implements Serializable {

    protected double speed;

    public String getName (){
        return this.getClass().getSimpleName();
    }

    public double getSpeed(){
        return this.speed;
    }

}
