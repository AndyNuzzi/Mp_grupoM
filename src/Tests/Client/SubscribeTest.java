package Client;


import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SubscribeTest {
    @Test
    public void doOperation(){

        String typeOfShip = "2";
        String subscribe = "Destroyer";
        String continueAdding = "n";

        String subscribeT = null;

        boolean chooseShip = false;

        while (! chooseShip) {
            switch (typeOfShip) {
                case "1":
                    subscribeT = "SpaceStation";
                    break;
                case "2":
                    subscribeT = "Destroyer";
                    break;
                case "3":
                    subscribeT = "Freighter";
                    break;
                case "4":
                    subscribeT = "Fighter";
                    break;
            }
            chooseShip = (continueAdding == "n");
        }
        assertEquals(subscribe, subscribeT);
        assertTrue(chooseShip);

    }

}