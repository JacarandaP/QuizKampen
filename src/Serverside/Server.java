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
                Player playerX = new Player(serverSocket.accept(), "Player" + (numPlayers + 1));
                numPlayers++;
                Player playerY = new Player(serverSocket.accept(), "Player" + (numPlayers + 1));
                numPlayers++;

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
