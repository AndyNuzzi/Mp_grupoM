package Client;

import java.util.List;

public class CheckNotifications extends ClientOperation{
    public CheckNotifications (Client client, Controller.Controller controller){
        super ();
        // me traigo los datos del cliente
    }

    @Override
    // VER QUE ES UNA NOTIFICACION
    public boolean doOperation() {
        // muestra todas las notificaciones de un cliente

        List<String> notifications = controller.getNotificationsList();

        for (int i = 0; i < notifications.size(); i++){
            String notifInfo = notifications.get(i);
            notifications.add(notifInfo);
        }
        // imprimo la lista con las notificaciones

        return true;
    }
}
