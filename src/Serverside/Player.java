package Serverside;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Max Erling
 * Date: 2020-11-13
 * Copyright: MIT
 * Class: Java20B
 */
public class Player extends Thread {
    private String name;
    private Socket s;
    private PrintWriter out;


    public Player(Socket socket, String name) {
        this.name = name;
        this.s = socket;

        try  {
            out = new PrintWriter(s.getOutputStream(),true);
            out.println("Waiting for both to connect");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public void run() {
        out.println(name + " is connected");

    }






}
