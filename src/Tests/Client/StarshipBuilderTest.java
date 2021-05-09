package Client;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions .*;

public class StarshipBuilderTest {

    // haremos una prueba de caja blanca del método propulsión weapon y defense.

    public Propulsion propulsion() {
        Propulsion propulsion = null;
        int option = 1;
        double speed = 400;
        switch (option) {
            case 1:
                propulsion = new FTLEngine(speed);
                break;
            case 2:
                propulsion = new SolarSails(speed);
                break;
            case 3:
                propulsion = new IonEngine(speed);
                break;
            case 4:
                propulsion = new TraceCompressor(speed);
                break;
            case 5:
                propulsion = new WarpEngine(speed);
                break;
            default:
                break;
        }
        return propulsion;
    }

    public Weapon weapon() {
        Weapon weapon = null;
        int power = 200;
        int option = 1;
        switch (option) {
            case 1:
                weapon = new PEM(power);
                break;
            case 2:
                weapon = new LaserBeam(power);
                break;
            case 3:
                weapon = new ThermonuclearMissiles(power);
                break;
            case 4:
                weapon = new PlasmaCannons(power);
                break;
            default:
                break;
        }
        return weapon;
    }

    public Defense defense() {
        Defense defense = null;
        int option = 1;
        int resistance = 300;
        switch (option) {
            case 1:
                double energyAmount = 3213;
                defense = new Shield(resistance, energyAmount);
                break;
            case 2:
                int weight = 321;
                String material = "Steal";
                defense = new Armor(resistance, material, weight);
                break;
        }
        return defense;
    }

    @Test
    public void createDestroyerTest() {

        // Creación de destroyer
        Destroyer destroyer = new Destroyer();

        // Insertamos los elementos

        // lo introducimos a mano
        destroyer.setRegisterNumber("F1234FFF");
        // lo introducimos también a mano
        destroyer.setCrew(12);

        // Como nos llegaría de otra parte del programa, lo introducimos manualmente
        destroyer.setOwner("2312313");

        destroyer.addPropulsion(this.propulsion());
        destroyer.addWeapon(this.weapon());
        destroyer.addDefense(this.defense());


        boolean same = true;

        // comprobamos que los atributos son iguales
        if (!destroyer.getRegisterNumber().equals("F1234FFF"))
            same = false;
        if (destroyer.getCrew() != 12)
            same = false;
        if (!destroyer.getOwner().equals("2312313"))
            same = false;
        if (!destroyer.getPropulsion().get(0).getName().equals("FTLEngine") || destroyer.getPropulsion().get(0).getSpeed() != 400)
            same = false;
        if (!destroyer.getWeapon().get(0).getName().equals("PEM") || destroyer.getWeapon().get(0).getPower() != 200)
            same = false;
        if (!destroyer.getDefenses().get(0).getName().equals("Shield") || destroyer.getDefenses().get(0).getResistance() != 300)
            same = false;
        Shield shield = (Shield) destroyer.getDefenses().get(0);
        if (shield.getEnergyAmount() != 3213)
            same = false;

        assertTrue (same);

    }

}
