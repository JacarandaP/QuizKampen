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


    public String getUserName(){
    return name;
    }

    public void setGame(Game game) {
        this.game = game;
    }

     /*Ej färdigt. Detta kan göras mycket snyggare men här ser jag att vi börjar ha kommunkationen mellan
     Server-Game-Player-Client. Vi kan antigen ha en protokoll eller ha det som i exemplet tictactoe. Det har
     egentligen inte en protokoll så men kommunikationen hanteras mellan playerserverside och game, ungefär som
     vi börjar göra här. Vi kan också antigen ha players socket här eller i Clienthandler. Men än så långe har vi två
     socket så en måste försvinna. Vi kan lämna det kvar i Client handler och ta bort här eller tvärtom.
      */

    public void run() {
        try {
            out.writeObject(getUserName() + " is connected");
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
