package Client;

import Controller.*;

public abstract class AdministratorOperation implements Operation {

    protected Controller controller;

    protected Administrator admin;

    /**
     * El constructor inicializará tanto el cliente como el controller
     *
     * @param admin
     */
    public AdministratorOperation(Administrator admin) {
        this.admin = admin;
        this.controller = new Controller();
    }

    /**
     * En cada doOperation sobrescribiremos este método, en cada uno añadiremos a la lista de operaciones
     * las operaciones necesarias
     *
     * @return
     */
    public abstract boolean doOperation();

}
