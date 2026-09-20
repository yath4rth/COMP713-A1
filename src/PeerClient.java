import java.io.IOException;
import java.net.Socket;

public class PeerClient {
    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost", 5001);

            System.out.println("Connected to Peer 1.");

        } catch (IOException e) {
            System.out.println("Could not connect to Peer 1.");
        }
    }
}
