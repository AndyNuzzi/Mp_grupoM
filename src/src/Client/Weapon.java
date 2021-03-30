package Client;

public abstract class Weapon {

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
