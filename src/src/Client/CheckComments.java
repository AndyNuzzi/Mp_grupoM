package Client;

import java.util.List;

public class CheckComments extends ClientOperation{
    public CheckComments (Client client){
        super ();
        // me traigo los datos del cliente
    }

    @Override
    public boolean doOperation() {
        // se encarga de mostrar la lista con los comentarios de un cliente

        List<Comment> comments = controller.getCommentsList();

        for (int i = 0; i < comments.size(); i++){
            Comment commentInfo = comments.get(i);
            comments.add(commentInfo);
        }
        return false;
    }
}
