package Serverside;

import java.util.List;

/**
 * Created by Jacaranda Perez
 * Date: 2020-11-14
 * Project: QuizKampen
 */

public class Round {
    private final List<Question> questionList;
    private final Category category;

    public Round(List<Question> questionList, Category category){
        this.questionList = questionList;
        this.category = category;
    }
}
