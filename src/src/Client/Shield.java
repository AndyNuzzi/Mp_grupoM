package Client;

public class Shield extends Defense{

    private double energyAmount;

    public Shield(int resistance, double energyAmount) {
        this.resistance = resistance;
        this.energyAmount = energyAmount;
    }

    public double getEnergyAmount() {
        return this.energyAmount;
    }

}
