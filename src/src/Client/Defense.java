package Client;

public abstract class Defense {

    private int resistance;


    public Defense (int resistance){
        this.resistance = resistance;
    }

    public String getName (){
        return this.getClass().getSimpleName();
    }

    public int getResistance(){
        return this.resistance;
    }

}
