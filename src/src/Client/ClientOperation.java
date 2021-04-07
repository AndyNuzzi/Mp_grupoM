package Client;

import Controller.*;

public abstract class ClientOperation implements Operation{

    protected Controller controller; // instanciar el controller

    protected Client client; // instanciar el cliente

    public ClientOperation(Client client){ //constructor
        this.client = client;
        this.controller = new Controller();
    }

    public abstract boolean doOperation(); // metodo abstracto

}
