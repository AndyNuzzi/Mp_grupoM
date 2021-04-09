package Client;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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

        if (uncheckedOffers != null && !uncheckedOffers.isEmpty()) {
            boolean validate = false;
            while (!validate) {
                System.out.println("--------------------  OFFERS  --------------------");
                Offer info = uncheckedOffers.remove(0);
                System.out.println("--------------------------------------------------");
                System.out.println(info.getId());
                System.out.println(info.getStarshipIdList());
                System.out.println(info.getDateEnd());
                System.out.println(info.getPrice());
                System.out.println(info.getCreator());
                System.out.println("--------------------------------------------------");

                System.out.println("Validate offer? y/n");
                Scanner scanner = new Scanner(System.in);
                String validation = scanner.nextLine();
                controller.deleteFromUncheckedOffers(info);
                if ("y".equals(validation.toLowerCase())) {
                    controller.addOffer(info);
                }
                else{
                    Client c = controller.getClient(info.getCreator());
                    if (c.isWarning()){
                        c.setWarning(false);
                        c.setBanned(LocalDate.now().plusDays(5));
                    }
                    else {
                        c.setWarning(true);
                        Notification not = new Notification("Your offer was not validated. Next time you will be banned for 5 days.");
                        c.addNotification(not);
                    }
                    controller.actualizateClient(c);
                }

                uncheckedOffers = controller.getUncheckedOffersList();
                if (!uncheckedOffers.isEmpty()) {
                    System.out.println("Do you want to validate one more offer? y/n");
                    String result = scanner.nextLine();
                    validate = "n".equals(result.toLowerCase());
                }
                else{
                    System.out.println("There aren't new offers waiting for validation");
                    validate = true;
                }
            }
        } else{
            System.out.println("There aren't new offers waiting for validation");
        }
        return true;
    }
}
