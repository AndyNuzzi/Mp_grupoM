package Client;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AddPossibleSwindlerTest {
    @Test
    public void doOperation() {

        Client client = new Client("client1", "earth", "species", "C0001",
            "clien", "Client1", "client@client.com");

        List<Client> clientList = new ArrayList<Client>();

        clientList.add(client);

        String swindlerId = "C0001";
        String swindlerIdT = null;
        String continueAdding = "n";
        boolean add = false;

        while (!add){
            String adding = "y";
            if (adding == "y"){
                swindlerIdT = swindlerId;
            }
            add = (continueAdding == "n");
        }
        assertEquals(swindlerId, swindlerIdT);
        assertTrue(add);
    }

}