package Client;

public abstract class Propulsion {

    private double speed;

    public Propulsion(double speed){
        this.speed = speed;
    }

    public String getName (){
        return this.getClass().getSimpleName();
    }

    public double getSpeed(){
        return this.speed;
    }

}
