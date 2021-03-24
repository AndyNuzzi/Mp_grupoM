package Client;

public class Armor extends Defense{

    private String material;
    private int weigth;


    public Armor(int resistance, String material, int weigth) {
        super(resistance);
        this.material = material;
        this.weigth = weigth;
    }


    public String getMaterial(){
        return this.material;
    }


    public int getWeigth(){
        return this.weigth;
    }

}
