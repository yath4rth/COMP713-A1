import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Peer {

    public static void main(String[] args) {

        int port = 5001;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Peer started.");
            System.out.println("Listening on port " + port);
            Socket socket = serverSocket.accept();
            System.out.println("A peer connected!");
        } catch (IOException e) {
            System.out.println("Could not start peer.");
        }
    }
}