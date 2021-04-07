package Client;

import java.util.List;
import java.util.Scanner;

public class ValidateOffer extends AdministratorOperation{

    public ValidateOffer (Administrator administrator){
        super (administrator);
    }

    @Override
    // HAY QUE REVISAR ESTE METODO EN PROFUNDIDAD

    public boolean doOperation() { // valida las ofertas creadas

        // acceder a la lista de unchecked offers (llamar al controlador)
        // recoger la lista que me devuelven (la info de la oferta entera)
        // ir mostrando
        // y llamar al controller para validar (pasar)
        // si valido elimino la oferta de la lista de unchecked (controller.deleteFromUncheckedOffers(offer) --> devuelve un booleano)
            // añado la oferta (controller.addOffer(offer))
        // si no valido se sanciona al cliente y se elimina la oferta de unchecked offers

        // tiene que poder salir antes de seguir validando el resto de ofertas

        List <Offer> uncheckedOffers = controller.getUncheckedOffersList();

        System.out.println("--------------------  OFFERS  --------------------");
        for (Offer info: uncheckedOffers){
            System.out.println("--------------------------------------------------");
            System.out.println(info.getId());
            System.out.println(info.getStarshipIdList());
            System.out.println(info.getDateEnd());
            System.out.println(info.getPrice());
            System.out.println(info.getCreator());
            System.out.println("--------------------------------------------------");
        } // lista con las ofertas

        boolean validate = false;

        while (! validate){
            System.out.println("Which offer do you want to validate? (id)");
            Scanner scanner = new Scanner(System.in);
            String validation = scanner.nextLine();

        }
        return true;
    }
}
