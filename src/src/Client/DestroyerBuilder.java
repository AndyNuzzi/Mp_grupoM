package Client;

public class DestroyerBuilder extends StarshipBuilder{
    private Destroyer destroyer= new Destroyer(getResult().getWeapon(), getResult().getDefenses());

    public void addWeapon(){
    }
    public void defense(){
    }
    public Destroyer getResult(){
        return destroyer;
    }
    public  DestroyerBuilder(){

    }




}
