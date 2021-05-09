package Client;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CheckValorationTest {
    @Test
    public void doOperation() {

        Client client = new Client("client1", "earth", "species", "C0001",
                "clien", "Client1", "client@client.com");

        Comment comment = new Comment();
        int val = 5;
        comment.setValoration(val);

        boolean yesT = false;

        if (val != 0) {
            assertEquals(val, comment.getValoration());
            yesT = true;
        }else {
            yesT = false;
        }
        assertTrue(yesT);
    }

}