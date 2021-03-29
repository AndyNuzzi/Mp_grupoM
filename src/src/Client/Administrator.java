package Client;

import java.util.ArrayList;
import java.util.List;

public class Administrator extends User{

    private List<AdministratorOperation> operations = new ArrayList<AdministratorOperation>();

    public Administrator(String name, String planet, String species, String idNumber, String nick, String password, String email) {
        super(name, planet, species, idNumber, nick, password, email);
    }

    @Override
    public void setOption() {
        // creacion de las operaciones y lo metemos en la lista
    }

    @Override
    public void doOperation() {
        this.setOption();
    }

    //OPCION:

    // CLASE PADRE OPERATION

    // O ADMINISTRATOR OPERATION Y CLIENT OPERATION HEREDAN DE OPERATION

    // O DIRECTAMENTE TODAS LAS OPERACIONES

    // ASI EL CONVERTIR A OPERACION ES IGUAL EN TODOS

    // SOLO CAMBIA EL METER OPERACION

}
