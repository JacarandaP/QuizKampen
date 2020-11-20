package Serverside;

import java.io.*;
import java.net.Socket;
import java.util.List;

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


    public void run() {
        try (ObjectInputStream in = new ObjectInputStream(s.getInputStream());)
        {
            out.writeObject(getUserName() + " is connected");

            Object fromClient;
            fromClient = in.readObject();

            while ((fromClient = in.readObject()) != null) {
               //System.out.println((String)fromClient);
                    if(fromClient instanceof Category) {

                        List<Question> listToBeSent = game.getQuestions((Category) fromClient);

                        listToBeSent.forEach((temp) -> {
                            System.out.println(temp);

                        });
                    } else {
                        System.out.println(fromClient);
                    }

            }


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }






}
