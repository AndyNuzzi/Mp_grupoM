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

        List<Notification> notificationsList = client.getNotificationList();

        if (notificationsList!=null){
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



        return true;
    }
}
