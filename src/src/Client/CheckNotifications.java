package Client;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class CheckNotifications extends ClientOperation{
    public CheckNotifications (Client client){
        super (client);
    }

    @Override
    // VER QUE ES UNA NOTIFICACION --> AL MOSTRARLAS......
        // creo que deberian de ser ofertas, porque al subscribirte
        // a una nave te manda una notificacion con la offerta enseña ofertas

    public boolean doOperation() { // muestra todas las notificaciones de un cliente

        List<Notification> notificationsList = client.getNotificationList();

        if (notificationsList != null && notificationsList.size() > 0) {
            System.out.println("---------------  NEW NOTIFICATION  ---------------");
            for (Notification not: notificationsList){
                System.out.println("--------------------------------------------------");
                not.print();
                System.out.println("--------------------------------------------------");
            }
            //Eliminar notificaciones
        } else {
            System.out.println("There aren't notifications available.");
        }

        if (notificationsList.size()!= 0) {
            System.out.println("Delete notifications? y/n");
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            if (input.toLowerCase().equals("y")) {
                controller.deleteNotification(client);
            }
        }
        return true;
    }
}
