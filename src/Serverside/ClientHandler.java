package Serverside;

import java.io.*;
import java.net.Socket;

public class ClientHandler extends Thread {

    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        System.out.println("Client connected");
        String input;

        try (ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

             out.writeObject("Hur många bultar finns det i Ölandsbron?");
            out.writeObject("1. 1231231");

            Object fromClient;
            while ((fromClient = in.readObject()) != null) {
                System.out.println((String)fromClient);

//                input = in.readLine();
//                System.out.println(input);

            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }


}
