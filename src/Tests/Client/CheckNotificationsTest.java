package Client;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CheckNotificationsTest {

    @Test
    public void doOperation() {

        Client client = new Client("client1", "earth", "species", "C0001",
                "clien", "Client1", "client@client.com");

        String message = "tiene una notificacion";
        Notification notification = new Notification();
        notification.setMessage(message);

        List<Notification> notificationsList = new ArrayList<Notification>();
        notificationsList.add(notification);

        boolean yesT = false;

        if (notificationsList != null && notificationsList.size() > 0) {
            assertEquals("tiene una notificacion", notification.getMessage());
            yesT = true;
        }else{
            yesT = false;
        }
        assertTrue(yesT);
    }

}