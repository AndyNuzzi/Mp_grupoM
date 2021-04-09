package Client;

import java.util.Scanner;

public class FreighterBuilder extends StarshipBuilder {

    Freighter freighter = new Freighter();

    /**
     * Pide y guarda la capacidad de la nave
     */
    public void capacity() {
        System.out.println(" Introduce the capacity of your freighter");
        Scanner scanner = new Scanner(System.in);
        freighter.setCapacity(scanner.nextInt());
    }

    public FreighterBuilder() {
        starship = freighter;
    }

    /**
     * Muestra el menu de seleccion de defensas
     */
    private void showDefenses() {
        System.out.println(" Select a Defense ");
        System.out.println(" 1 Shield ");
        System.out.println(" 2 Armor ");
        System.out.println("");
    }

    /**
     * Gestiona la seleccion de las defensas
     *
     * @return
     */
    public void defense() {
        Scanner scanner = new Scanner(System.in);
        Defense defense = null;
        do {
            this.showDefenses();
            int defenseOption = scanner.nextInt();
            switch (defenseOption) {
                case 1:
                    System.out.println(" Introduce the resistance of your Defense ");
                    int resistance = scanner.nextInt();
                    System.out.println(" Introduce the enegy amount of your Defense ");
                    double energyAmount = scanner.nextDouble();
                    defense = new Shield(resistance, energyAmount);
                    break;
                case 2:
                    System.out.println(" Introduce the resistance of your Defense ");
                    resistance = scanner.nextInt();
                    scanner = new Scanner(System.in);
                    System.out.println(" Introduce the material ");
                    String material = scanner.nextLine().toLowerCase();
                    System.out.println(" Introduce the weight of your Defense ");
                    int weight = scanner.nextInt();
                    defense = new Armor(resistance, material, weight);
                    break;
                default:
                    System.out.println(" Wrong option ");
                    defense = null;
            }
        } while (defense == null);
        freighter.setDefense(defense);
    }

    /**
     * Crea la nave y le envía la nave al controller
     *
     * @param owner
     * @return
     */
    @Override
    public Starship getResult(Client owner) {
        freighter.setRegisterNumber(super.registerNumber());
        freighter.setCrew(super.crew());
        freighter.setOwner(owner.getIdNumber());
        super.propulsion();
        this.capacity();
        this.defense();
        controller.createStarship((Starship) freighter);
        return freighter;
    }

}
