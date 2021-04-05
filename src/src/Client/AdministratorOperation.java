package Client;

import Controller.*;

public abstract class AdministratorOperation implements Operation{
    protected Controller controller;
    // intanciar el controller

    protected Administrator admin;

    public abstract boolean doOperation();
    //clase abstracta

}
