package Client;

public class CheckValoration extends ClientOperation{
    public CheckValoration (Client client){
        super ();
        // me traigo los datos del cliente
    }

    @Override
    public boolean doOperation() {
        // llamar al controller y que pase las valoraciones nuevas
        // y mostrar la valoracion media


        System.out.println(controller.getAverageValoration());
        // muestra por pantalla la valoración media calculada

        return false;
    }
}
