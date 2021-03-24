package Client;

public class Shield extends Defense{

    private double energyAmount;

    public Shield(int resistance, double energyAmount) {
        super(resistance);
        this.energyAmount = energyAmount;
    }

    public double getEnergyAmount() {
        return this.energyAmount;
    }

}
