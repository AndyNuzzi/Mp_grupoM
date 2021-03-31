package Client;

public abstract class Weapon {

    protected int power;

    public String getName (){
        return this.getClass().getSimpleName();
    }

    public int getPower (){
        return this.power;
    }

}
