package Client;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SearchOfferTest {

    @Test
    public void doOperation(){

        boolean askAgain = true;
        String type = "";
        String shipElection = "3";

        String typeT = "freighter";

        while (askAgain) {
            askAgain = false;

            switch (shipElection) {
                case "1":
                    type = "spacestation";
                    break;
                case "2":
                    type = "destroyer";
                    break;
                case "3":
                    type = "freighter";
                    break;
                case "4":
                    type = "fighter";
                    break;
                default:
                    askAgain = true;
            }
        }
        assertFalse(askAgain);
        assertEquals(typeT, type);


    }
}