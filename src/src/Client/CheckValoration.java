package Client;

import Controller.*;

public class CheckValoration extends ClientOperation{
    public CheckValoration (Client client){
        super ();
        // me traigo los datos del cliente
    }

    @Override
    public boolean doOperation() {
        // llamar al controller y que pase las valoraciones nuevas
        // y mostrar la valoracion media


        System.out.println(controller.getAverageValoration(client.getIdNumber()));
        // muestra por pantalla la valoración media calculada

        return false;
    }
}
