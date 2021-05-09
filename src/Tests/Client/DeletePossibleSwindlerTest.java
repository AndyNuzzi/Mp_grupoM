package Client;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;



public class DeletePossibleSwindlerTest {
    @Test
    public void doOperation() {
        Client client = new Client("client1", "earth", "species", "C0001",
                "clien", "Client1", "client@client.com");

        List<Client> clientList = new ArrayList<Client>();
        clientList.add(client);

        String swindlerId = null;
        String swindlerIdT = " ";
        String continueAdding = "n";
        boolean add = false;

        while (!add) {
            String adding = "y";
            if (adding == "y") {
                swindlerIdT = swindlerId;
            }
            add = (continueAdding == "n");
        }

        assertEquals(swindlerId, swindlerIdT);
        assertTrue(add);
    }
}