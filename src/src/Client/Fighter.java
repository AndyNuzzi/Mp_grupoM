package Client;

public class Fighter extends Starship{
   private Weapon weapon1;
   private Weapon weapon2;
   private Defense defense;

   public Fighter(Weapon weapon1, Weapon weapon2, Defense defense){

   }

    public Weapon getWeapon1() {
        return weapon1;
    }

    public Weapon getWeapon2() {
        return weapon2;
    }

    public Defense getDefense() {
        return defense;
    }

    public void setWeapon1(Weapon weapon1) {
        this.weapon1 = weapon1;
    }

    public void setWeapon2(Weapon weapon2) {
        this.weapon2 = weapon2;
    }

    public void setDefense(Defense defense) {
        this.defense = defense;
    }





}
