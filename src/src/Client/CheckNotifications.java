package Client;

import java.util.List;

public class CheckNotifications extends ClientOperation{
    public CheckNotifications (Client client){
        super (client);
    }

    @Override
    // VER QUE ES UNA NOTIFICACION --> AL MOSTRARLAS......
        // creo que deberian de ser ofertas, porque al subscribirte
        // a una nave te manda una notificacion con la offerta enseña ofertas

    public boolean doOperation() { // muestra todas las notificaciones de un cliente

        List<String> notificationsList = controller.getNotificationsList();

        System.out.println("---------------  NEW NOTIFICATION  ---------------");
        for (String notifInfo: notificationsList){
            System.out.println("--------------------------------------------------");
            System.out.println(notifInfo);
            System.out.println("--------------------------------------------------");
        } // lista con las notificaciones

        return true;
    }
}
