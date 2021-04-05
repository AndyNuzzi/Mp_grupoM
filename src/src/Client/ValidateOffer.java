package Client;

import java.util.List;
import java.util.Scanner;

import Controller.*;

public class ValidateOffer extends AdministratorOperation{
    @Override
    public boolean doOperation() {
        // llamar al metodo del controller?


        // acceder a la lista de unchecked offers (llamar al controlador)
        // recoger la lista que me devuelven (la info de la oferta entera)
        // ir mostrando
        // y llamar al controller para validar (pasar)
        // si valido elimino la oferta de la lista de unchecked (controller.deleteFromUncheckedOffers(offer) --> devuelve un booleano)
            // añado la oferta (controller.addOffer(offer))
        // si no valido se sanciona al cliente y se elimina la oferta de unchecked offers

        // tiene que poder salir antes de seguir validando el resto de ofertas

        List <Offer> unCheckedOffers = controller.getUnCheckedOffersList();
        //----------------------------------------------------------------------------------------
        for (int i = 0; i < unCheckedOffers.size(); i++){
            Offer unchecked = unCheckedOffers.get(i);
            System.out.println(unchecked);
        }

        boolean validate = false;
        while (! validate){
            System.out.println("Which offer do you want to validate? (id)");
            Scanner scanner = new Scanner(System.in);
            String validation = scanner.nextLine();

        }
        //----------------------------------------------------------------------------------------
        // HAY QUE REVISAR ESTE METODO EN PROFUNDIDAD
        return true;
    }
}
