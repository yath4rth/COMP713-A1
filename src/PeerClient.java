import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class PeerClient {
    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost", 5001);
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("Hello from Peer 2");
            System.out.println("Message sent.");

        } catch (IOException e) {
            System.out.println("Could not connect to Peer 1.");
        }
    }
}
