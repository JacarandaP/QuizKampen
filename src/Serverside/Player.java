package Serverside;

import java.io.*;
import java.net.Socket;

/**
 * Created by Max Erling
 * Date: 2020-11-13
 * Copyright: MIT
 * Class: Java20B
 */
public class Player extends Thread implements Serializable {
    private String name;
    private Socket s;
    private Game game;
    ObjectOutputStream out;

    public Player(Socket socket, String name) {
        this.name = name;
        this.s = socket;
        String welcomeMessage = "Waiting for both players to connect";


        try  {
            out = new ObjectOutputStream(s.getOutputStream());
            out.writeObject(welcomeMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getPlayerName(){
    return name;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void run() {
        try {
            out.writeObject(getPlayerName() + " is connected");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Question question1 = game.getNextQuestion(this);
        try {
            out.writeObject(question1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }






}
