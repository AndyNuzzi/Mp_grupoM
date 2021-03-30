package Client;

public class FighterBuilder extends StarshipBuilder {
    Fighter fighter = new Fighter(getResult().getWeapon1(), getResult().getWeapon2(), getResult().getDefense());

    public FighterBuilder() {

    }

    public void  weapons(){
    }
    public void defense(){
    }

    public Fighter getResult() {
        return fighter;
    }


}
