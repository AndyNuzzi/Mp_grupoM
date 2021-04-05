package Client;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Administrator extends User implements Serializable{

    public Administrator(String name, String planet, String species, String idNumber, String nick, String password, String email) {
        super(name, planet, species, idNumber, nick, password, email);
    }

    @Override
    public void doOperation() {
        AdministratorOperation op1 = new ValidateOffer();
        AdministratorOperation op2 = new DeletePossiblePirate();
        AdministratorOperation op3 = new CreateNewAdministrator();
        AdministratorOperation op4 = new AddPossibleSwindler();
        AdministratorOperation op5 = new DeletePossibleSwindler();
        AdministratorOperation op6 = new AddPossiblePirate();
        super.operations.add(op1);
        super.operations.add(op2);
        super.operations.add(op3);
        super.operations.add(op4);
        super.operations.add(op5);
        super.operations.add(op6);
        super.getOperation();
    }

}
