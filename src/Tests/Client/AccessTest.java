package Client;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccessTest {

    @Test
    public void openSessionTest(){
        boolean passed = true;
        User user1 = null;
        user1 = openSession(user1);
        // 1 probamos con un null
        if (user1 != null)
            passed = false;
        User client = new Client();
        client = openSession(client);
        if (!client.getClass().getSimpleName().equals("Client"))
            passed = false;
        User administrator = new Administrator();
        administrator = openSession(administrator);
        if (!administrator.getClass().getSimpleName().equals("Administrator"))
            passed = false;
        assertTrue (passed);
    }

    public User openSession (User user){
        if (user != null) {
            if (user.getClass().getSimpleName().equals("Client")) {
                Client client = (Client) user;
                return client;
            } else if (user.getClass().getSimpleName().equals("Administrator")) {
                Administrator administrator = (Administrator) user;
                return administrator;
            } else {
                Kromagg kromagg = (Kromagg) user;
                return kromagg;
            }
        } else {
            return null;
        }
    }
}
