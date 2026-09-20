import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Peer {

    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Usage: java Peer <peerId> <port>");
            return;
        }

        String peerId = args[0];
        int port = Integer.parseInt(args[1]);
        int[] lamportClock = {0};

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Peer " + peerId + " started.");
            System.out.println("Listening on port " + port);

            Thread listener = new Thread(() -> {

                while (true) {
                    try {
                        Socket socket = serverSocket.accept();
                        System.out.println("A peer connected!");
                        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        String message = reader.readLine();
                        if (message != null) {
                            System.out.println("Message received: " + message);
                            String[] parts = message.split("\\|");
                            int receivedClock = Integer.parseInt(parts[1].trim());
                            lamportClock[0] = Math.max(lamportClock[0], receivedClock) + 1;
                            System.out.println("Lamport clock updated to "+lamportClock[0]);
                        }
                        socket.close();
                    } catch (Exception ex) {
                        System.out.println("Connection failed.");
                    }
                }
            });
            listener.start();
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("> ");
                String command = scanner.nextLine();
                if(command.startsWith("clock"))
                {
                    System.out.println("Current Lamport clock: "+lamportClock[0]);
                }
                if (command.startsWith("connect")) {
                    System.out.println("Current Lamport clock: "+lamportClock[0]);
                    int targetPort = Integer.parseInt(command.substring(8));
                    Socket socket = new Socket("localhost", targetPort);
                    System.out.println("Connected to peer on port " + targetPort);

                    System.out.println("Message: ");
                    String message = scanner.nextLine();

                    lamportClock[0]++;

                    PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                    writer.println("Peer"+peerId+"|"+lamportClock[0]+"|"+message);
                    System.out.println("Sent at Lamport time "+lamportClock[0]);
                    socket.close();
                }
            }
        } catch (Exception e) {
            System.out.println("Peer start failed. "+ e);
        }
    }
}