package Serverside;

import java.util.*;

/**
 * Created by Jacaranda Perez
 * Date: 2020-11-14
 * Project: QuizKampen
 */

public class Game {

    private final Player playerX;
    private final Player playerY;
    private final List <Round> roundList = new ArrayList<>();

    public Game (Player player1, Player player2){
        this.playerX = player1;
        this.playerY = player2;

        /*Kommer förmodligen att försvinna med en shuffle eller
        liknandemen skriver såhär så vi förstår logiken*/

        Round round1 = new Round(List.of(QuestionDatabase.q1cult, QuestionDatabase.q2cult), Category.CULTURE);
        roundList.add(round1);
    }

    public Question getNextQuestion(Player player){
    return null; //Implement senare
    }


}
