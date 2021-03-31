package Client;

public abstract class Defense {

    protected int resistance;

    public String getName (){
        return this.getClass().getSimpleName();
    }

    public int getResistance(){
        return this.resistance;
    }

}
