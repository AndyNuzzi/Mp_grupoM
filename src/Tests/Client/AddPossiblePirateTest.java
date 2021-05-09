package Client;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AddPossiblePirateTest {

    @Test
    public void doOperation() {
        Client client = new Client("client1", "earth", "species", "C0001",
                "clien", "Client1", "client@client.com");

        List<Client> clientList = new ArrayList<Client>();
        clientList.add(client);

        String pirateId = "C0001";
        String pirateIdT = null;
        String continueAdding = "n";
        boolean add = false;

        while (!add){
            String adding = "y";
            if (adding == "y"){
                pirateIdT = pirateId;
            }
            add = (continueAdding == "n");
        }
        assertEquals(pirateId, pirateIdT);
        assertTrue(add);
    }

}