package Client;

import java.util.Scanner;
// eliminar los controllers de las clases

public class CreateOffer extends ClientOperation{
    public CreateOffer (Client client, Controller.Controller controller){
        super ();
        //
        // me traigo los datos del cliente
    }

    @Override
    public boolean doOperation() {

        // preparar el switch para la eleccion de naves

        Offer offer = new Offer();
        // creo el objeto tipo oferta

        Director director = new Director();
        // instanciar la clase director que es la que se encarga de introducir naves en las ofertas


        return true;

    }
}
