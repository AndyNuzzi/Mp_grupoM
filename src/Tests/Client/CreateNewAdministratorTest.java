package Client;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CreateNewAdministratorTest {

    @Test
    public void doOperation() {
        Administrator admin = new Administrator();

        admin.setName("administrator");
        admin.setPlanet("earth");
        admin.setSpecies("human");
        admin.setIdNumber("A0001");
        admin.setNick("admin");

        String password = "pass";
        String confirmPassword = "";

        String name = "administrator";
        String planet = "earth";
        String specie = "human";
        String idNumber = "A0001";
        String setNick = "admin";
        String email = "admin@admin.com";

        while (!password.equals(confirmPassword)) {
                confirmPassword = password;
        }
        admin.setPassword(confirmPassword);
        admin.setEmail("admin@admin.com");

        assertEquals(name, admin.getName());
        assertEquals(planet, admin.getPlanet());
        assertEquals(specie, admin.getSpecies());
        assertEquals(idNumber, admin.getIdNumber());
        assertEquals(setNick, admin.getNick());
        assertEquals(email, admin.getEmail());
        assertEquals(password, admin.getPassword());


       // return controller.createNewAdministrator(admin);
    }

}