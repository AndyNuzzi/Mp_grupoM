package Client;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CheckCommentsTest {

    @Test
    public void doOperation() {
        Client client = new Client("client1", "earth", "species", "C0001",
                "clien", "Client1", "client@client.com");

        Comment comment = new Comment();
        comment.setIdClient(client.getIdNumber());
        comment.setIdSale("23456");
        comment.setComment("muy buena compra");

        List<Comment> comments = new ArrayList<Comment>();
        comments.add(comment);

        boolean yesT = false;

        if (comments != null && comments.size() > 0) {
            assertEquals("23456", comment.getIdSale());
            assertEquals(client.getIdNumber(), comment.getIdClient());
            assertEquals("muy buena compra",comment.getComment());
            yesT = true;
        }else{
            yesT = false;
        }
        assertTrue(yesT);
    }

}