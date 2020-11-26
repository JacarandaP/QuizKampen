package Serverside;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by Jacaranda Perez
 * Date: 2020-11-26
 * Project: QuizKampen
 */

public class Score implements Serializable {
    static Player playerX;
    static Player playerY;
    private int scoreX;
    private int scoreY;
    private String answer;
    private String playerScore = "playerScoreFile.txt";


    public void score (Player player, String answer){
        this.answer = answer;

    }

    public Player getPlayerX() {
        return playerX;
    }

    public void setPlayerX(Player playerX) {
        this.playerX = playerX;
    }

    public Player getPlayerY() {
        return playerY;
    }

    public void setPlayerY(Player playerY) {
        this.playerY = playerY;
    }

    public int getScoreX() {
        return scoreX;
    }


   /* public String toString() {
        return playerX + " Score: " + scoreX + "\n" +
                playerY + " Score: " + scoreY;
    }
    */

    public String returnNameScore(){
        return playerX.getName() + " Score: " + scoreX + "\n" +
                playerY.getName() + " Score: " + scoreY;
    }

    public int getScoreY() {
        return scoreY;
    }
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void countRightAnswer(String answer, String name){

        if (name.equalsIgnoreCase("playerX")) {
            if(playerX.getPlayerStatus().getQuestionToAnswer().isCorrectAnswer(answer)) {
                System.out.println("X: " + playerX.getPlayerStatus().getQuestionToAnswer().isCorrectAnswer(answer));
                scoreX ++;

            } else {
                System.out.println("falseX");
            }
        } else if (name.equalsIgnoreCase("playerY")) {
            if(playerY.getPlayerStatus().getQuestionToAnswer().isCorrectAnswer(answer)){
                System.out.println("Y: " + playerY.getPlayerStatus().getQuestionToAnswer().isCorrectAnswer(answer));
                scoreY ++;
            } else {
                System.out.println("falseY");
            }
        }


    }

    /*public void writeScoreToText(String playerScoreInfo) {
        String dataLine = playerScoreInfo;
        Path p = Paths.get(playerScore);
        try {
            Files.writeString(p, dataLine, StandardOpenOption.APPEND, StandardOpenOption.CREATE);
        } catch (IOException e) {
            System.out.println("Score couldn't be saved");
            e.printStackTrace();
        }

    }*/
}


