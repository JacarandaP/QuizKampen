package Clientside;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private final int port = 54321;
    private final String hostName = "127.0.0.1";

    public Client() {
        try (Socket socketToServer = new Socket(hostName, port);
             PrintWriter out = new PrintWriter(socketToServer.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socketToServer.getInputStream()))) {

            String input;

            while ((input = in.readLine()) != null) {
                System.out.println(input);

            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
    }
}
