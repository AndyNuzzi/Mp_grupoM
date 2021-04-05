package Client;

import Controller.*;

public abstract class ClientOperation implements Operation{

    protected Controller controller;
    // instanciar el controller

    protected Client client;

    public abstract boolean doOperation();
    //clase abstracta

}
