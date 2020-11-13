package Serverside;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

    private int port = 54321;
    private int numPlayers = 0;

    public Server() {
        System.out.println("Server started");

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                //new ClientHandler(serverSocket.accept()).start();
                Player player = new Player(serverSocket.accept(), "Player" + (numPlayers + 1));
                numPlayers++;
                Player opponent = new Player(serverSocket.accept(), "Player" + (numPlayers + 1));

                player.start();
                opponent.start();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
    }
}
