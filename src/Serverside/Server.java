package Serverside;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;

public class Server {

    private int port = 54321;
    private int numPlayers = 0;

    public Server() {
        System.out.println("Server started");

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {

               // new ClientHandler(serverSocket.accept()).start();
                Player playerX = new Player(serverSocket.accept(), "PlayerX");

                Player playerY = new Player(serverSocket.accept(), "PlayerY");
                Game game = new Game(playerX, playerY);
                playerX.setGame(game);
                playerY.setGame(game);
                playerX.start();
                playerY.start();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Server server = new Server();

    }
}
