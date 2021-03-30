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
        // suponemos que tenemos en la clase User List <Operations>
        // creamos todas las operaciones
        // y las añadimos
    }


    //OPCION:

    // CLASE PADRE OPERATION

    // O ADMINISTRATOR OPERATION Y CLIENT OPERATION HEREDAN DE OPERATION

    // O DIRECTAMENTE TODAS LAS OPERACIONES

    // ASI EL CONVERTIR A OPERACION ES IGUAL EN TODOS

    // SOLO CAMBIA EL METER OPERACION

}
