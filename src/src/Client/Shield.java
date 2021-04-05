package Client;

import java.io.Serializable;

public class Shield extends Defense implements Serializable {

    private double energyAmount;

    public Shield(int resistance, double energyAmount) {
        super(resistance);
        this.energyAmount = energyAmount;
    }

    public double getEnergyAmount() {
        return this.energyAmount;
    }

}
