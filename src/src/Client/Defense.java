package Client;

import java.io.Serializable;

public abstract class Defense implements Serializable {

    protected int resistance;

    public String getName (){
        return this.getClass().getSimpleName();
    }

    public int getResistance(){
        return this.resistance;
    }

}
