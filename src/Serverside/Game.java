package Serverside;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Jacaranda Perez
 * Date: 2020-11-14
 * Project: QuizKampen
 */

public class Game {

    private Player playerX;
    private Player playerY;
    private final QuestionDatabase questionDatabase;
    private final int numberOfQuestions;
    private  List<Question> questionsInRound;
    private int currentRound = 1;
    private final int numberOfRounds;





    public Game() {

        questionDatabase = new QuestionDatabase();
        PropertyReader properties = new PropertyReader();
        numberOfQuestions = properties.getNumberOfQuestions();
        numberOfRounds = properties.getNumberOfRounds();
    }

    public List<Question> getQuestions(Category category){
        List<Question> questionsOfChosenCategory = new ArrayList<>(questionDatabase.getQuestionsByCategory(category));
        Collections.shuffle(questionsOfChosenCategory);
        return questionsOfChosenCategory.stream().limit(numberOfQuestions).collect(Collectors.toList());
    }


    public void playerIsConnected(Player player){
        if(playerX == null) {
            playerX = player;

        } else if(playerY == null){
            playerY = player;
            startGame();
        }
         else
             throw new IllegalStateException("Only two players allowed");
    }

    public void categorySelected(Category category){
        questionsInRound = getQuestions(category);
        playerX.getPlayerStatus().setQuestionToAnswer(questionsInRound.get(0));
        playerX.getPlayerStatus().setCurrentQuestionIndex(0);
        playerX.getPlayerStatus().setSelectingCategory(false);
        playerX.getPlayerStatus().setWaiting(false);
        playerX.getPlayerStatus().setSelectingAnswer(true);
        playerX.sendCurrentStatus();
        playerY.getPlayerStatus().setQuestionToAnswer(questionsInRound.get(0));
        playerY.getPlayerStatus().setCurrentQuestionIndex(0);
        playerY.getPlayerStatus().setSelectingCategory(false);
        playerY.getPlayerStatus().setWaiting(false);
        playerY.getPlayerStatus().setSelectingAnswer(true);
        playerY.sendCurrentStatus();
    }


    public void answerSelected(Player player, String answer){
        countRightAnswer(answer, player);
        int index = player.getPlayerStatus().getCurrentQuestionIndex();
        if (index == questionsInRound.size()-1 ) {
            Player otherPlayer = getOtherPlayer(player);
            if (otherPlayer.getPlayerStatus().isSelectingAnswer()) {
                player.getPlayerStatus().setWaiting(true);
                player.getPlayerStatus().setReasonForWaiting("Waiting for the other player to answer");
                player.getPlayerStatus().setSelectingAnswer(false);
                player.sendCurrentStatus();

            } else {
                player.getPlayerStatus().setSelectingAnswer(false);
                player.getPlayerStatus().setRoundFinished(true);

                otherPlayer.getPlayerStatus().setSelectingAnswer(false);
                otherPlayer.getPlayerStatus().setRoundFinished(true);
                otherPlayer.getPlayerStatus().setWaiting(false);
                player.getPlayerStatus().setYourOpponentsScore(otherPlayer.getPlayerStatus().getScore());
                otherPlayer.getPlayerStatus().setYourOpponentsScore(player.getPlayerStatus().getScore());

                if(currentRound == numberOfRounds) {

                    player.getPlayerStatus().setGameFinished(true);
                    otherPlayer.getPlayerStatus().setGameFinished(true);

                }

                player.sendCurrentStatus();
                otherPlayer.sendCurrentStatus();
            }
        }
        else {

            index ++;
            player.getPlayerStatus().setQuestionToAnswer(questionsInRound.get(index));
            player.getPlayerStatus().setCurrentQuestionIndex(index);
            player.sendCurrentStatus();
        }

    }

    public void playNexRound(){
        currentRound ++;
        playerX.getPlayerStatus().setSelectingAnswer(false);
        playerY.getPlayerStatus().setSelectingAnswer(false);
        playerX.getPlayerStatus().setWaiting(true);
        playerX.getPlayerStatus().setReasonForWaiting("Waiting for other player to select a category");
        playerX.getPlayerStatus().setRoundFinished(false);
        playerX.sendCurrentStatus();
        playerY.getPlayerStatus().setWaiting(false);
        playerY.getPlayerStatus().setCategoriesToSelectBetween(questionDatabase.getCategoryList());
        playerY.getPlayerStatus().setSelectingCategory(true);
        playerY.getPlayerStatus().setRoundFinished(false);
        playerY.sendCurrentStatus();
    }

    public Player getOtherPlayer(Player player) {
        if (player.equals(playerX)) {
            return playerY;
        } else if (player.equals(playerY)) {
            return playerX;
        }
        throw new IllegalArgumentException("Unknown player");
    }

    public void startGame(){
        playerX.getPlayerStatus().setWaiting(false);
        playerX.getPlayerStatus().setCategoriesToSelectBetween(questionDatabase.getCategoryList());
        playerX.getPlayerStatus().setSelectingCategory(true);
        playerX.sendCurrentStatus();

        playerY.getPlayerStatus().setWaiting(true);
        playerY.getPlayerStatus().setReasonForWaiting("Waiting for other player to select a category");
        playerY.sendCurrentStatus();
    }
    public void countRightAnswer(String answer, Player player) {
        if (player.getPlayerStatus().getQuestionToAnswer().isCorrectAnswer(answer)) {
                System.out.println(player.getUserName() + player.getPlayerStatus().getQuestionToAnswer().isCorrectAnswer(answer));
                player.getPlayerStatus().incrementScore();

            } else {
                System.out.println(player.getUserName() + " wrong answer");
            }
    }

   /* public void setOpponentScore(Player player){
        Player otherPlayer = getOtherPlayer(player);
        player.getPlayerStatus().setYourOpponentsScore(otherPlayer.getPlayerStatus().getScore());



    }*/
}




