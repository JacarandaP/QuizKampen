package Serverside;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler extends Thread {

    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        System.out.println("Client connected");

        try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            String input;

            for (int i = 0; i < 5; i++) {
                out.println("Hur många bultar finns det i Ölandsbron?");
                out.println("1. 1231231");
                out.println("2. 2342342");
                out.println("3. 131223");
                out.println("4. 9824294");
            }


            while ((input = in.readLine()) != null) {
//                input = in.readLine();
//                System.out.println(input);

            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


}
