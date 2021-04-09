package Client;

import Controller.*;

public abstract class ClientOperation implements Operation{

    protected Controller controller;
    protected Client client;


    /**
     * El constructor inicializará tanto el cliente como el controller
     *
     * @param client
     */
    public ClientOperation(Client client){
        this.client = client;
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
