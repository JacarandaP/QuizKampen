package Serverside;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

    private int port = 54321;

    public Server() {
        System.out.println("Server started");

        try(ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                new ClientHandler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Server server= new Server();
    }
}
