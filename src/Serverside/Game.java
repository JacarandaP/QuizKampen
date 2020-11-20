package Serverside;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * Created by Jacaranda Perez
 * Date: 2020-11-14
 * Project: QuizKampen
 */

public class Game {

    private final Player playerX;
    private final Player playerY;
    QuestionDatabase questionDatabase;

    public Game(Player player1, Player player2) {
        this.playerX = player1;
        this.playerY = player2;
        questionDatabase = new QuestionDatabase();
    }

    public List<Question> getQuestions(Category category, int numberOfQuestions){
        List<Question> questionsOfChosenCategory = new ArrayList<>(questionDatabase.getQuestionsByCategory(category));
        Collections.shuffle(questionsOfChosenCategory);
        return questionsOfChosenCategory.stream().limit(numberOfQuestions).collect(Collectors.toList());
    }

}




