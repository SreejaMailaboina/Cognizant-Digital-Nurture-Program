import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) {

        try {

            ServerSocket serverSocket = new ServerSocket(5000);

            System.out.println("Server started...");
            System.out.println("Waiting for client connection...");

            Socket socket = serverSocket.accept();

            System.out.println("Client connected!");

            BufferedReader input =
                    new BufferedReader(
                            new InputStreamReader(
                                    socket.getInputStream()));

            PrintWriter output =
                    new PrintWriter(
                            socket.getOutputStream(), true);

            BufferedReader console =
                    new BufferedReader(
                            new InputStreamReader(System.in));

            String message;

            while (true) {

                // Receive from Client
                message = input.readLine();

                if (message == null || message.equalsIgnoreCase("exit")) {
                    System.out.println("Client disconnected.");
                    break;
                }

                System.out.println("Client: " + message);

                // Send to Client
                System.out.print("Server: ");
                String reply = console.readLine();

                output.println(reply);

                if (reply.equalsIgnoreCase("exit")) {
                    break;
                }
            }

            socket.close();
            serverSocket.close();

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }
    }
}