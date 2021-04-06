package Client;

import Controller.*;

public abstract class AdministratorOperation implements Operation{
    protected Controller controller;
    // intanciar el controller

    protected Administrator admin;

    public AdministratorOperation(){}
    public AdministratorOperation(Administrator admin){
        this.admin = admin;
        this.controller = new Controller();
    }

    public abstract boolean doOperation();
    //clase abstracta

}
