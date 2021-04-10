package Client;


import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ValidateOffer extends AdministratorOperation{

    public ValidateOffer (Administrator administrator){
        super (administrator);
    }

    @Override
    public boolean doOperation() {
        /**
         * doOperation de la clase ValidateOffer valida las ofertas creadas
         */

        List <Offer> uncheckedOffers = controller.getUncheckedOffersList();

        if (uncheckedOffers != null && !uncheckedOffers.isEmpty()) {
            boolean validate = false;

            while (!validate) {
                Offer info = uncheckedOffers.remove(0);
                System.out.println("--------------------  OFFERS  --------------------");
                System.out.println("--------------------------------------------------");
                List<String> l = info.getStarshipIdList();
                List<String> lcopy = clone(l);
                List<Starship> starships = controller.getStarship(lcopy);
                for (Starship s: starships){
                    System.out.println("Starship: " + s.getName());
                    s.print();
                    System.out.println("--------------------------------------------------");
                }
                System.out.println("Offer Id: " + info.getId());
                System.out.println("Date end: " + info.getDateEnd());
                System.out.println("Price: " + info.getPrice());
                System.out.println("Creator: " + info.getCreator());
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

    private List<String> clone(List<String> l) {
        List<String> sol = new LinkedList<>();
        for (String s: l){
            sol.add(s);
        }
        return sol;
    }
}
