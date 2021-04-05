package Client;

public abstract class Propulsion {

    protected double speed;


    public String getName (){
        return this.getClass().getSimpleName();
    }

    public double getSpeed(){
        return this.speed;
    }

}
