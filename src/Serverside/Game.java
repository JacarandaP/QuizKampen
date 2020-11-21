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


    public Game() {

        questionDatabase = new QuestionDatabase();
        PropertyReader properties = new PropertyReader();
        numberOfQuestions = properties.getNumberOfQuestions();
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
        int index = player.getPlayerStatus().getCurrentQuestionIndex();
        if (index == questionsInRound.size()-1 ){
           Player otherPlayer = getOtherPlayer(player);
                // check if it is waiting: int indexForOtherPlayer = otherPlayer.getPlayerStatus().getCurrentQuestionIndex();




        }

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


}




