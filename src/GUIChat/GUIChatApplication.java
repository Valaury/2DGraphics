
package GUIChat;
import static GUIChat.ChatClient.dout;
import static GUIChat.ChatServer.dout;
public class GUIChatApplication {

    
    public static void main(String[] args) {
        ChatServer server = new ChatServer();
        server.show(true);
        ChatClient client = new ChatClient();
        client.show(true);
        
    }
    
}
