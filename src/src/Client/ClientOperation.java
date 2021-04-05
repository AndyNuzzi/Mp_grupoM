package Client;

import Controller.*;

public abstract class ClientOperation implements Operation{

    protected Controller controller;
    // instanciar el controller

    protected Client client;

    public ClientOperation(Client client){
        this.client = client;
        this.controller = new Controller();
    }

    public abstract boolean doOperation();
    //clase abstracta

}
