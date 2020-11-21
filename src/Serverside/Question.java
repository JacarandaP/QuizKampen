package Serverside;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Question implements Serializable {
    private Category category;
    private String questionText;
    private List<String> answers = new ArrayList<>();
    private String correctAnswer;

    public Question(Category category, String questionText, String answer1, String answer2, String answer3, String correctAnswer) {
        this.category = category;
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        answers.add(answer1);
        answers.add(answer2);
        answers.add(answer3);
        answers.add(correctAnswer);
    }

    public List<String> getAnswers() {
        return answers;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public boolean isCorrectAnswer(String answer) {
        return answer.equals(correctAnswer);
    }

    public String getQuestionText() {
        return questionText;
    }

    public Category getCategory()
    {return this.category;}


    @Override
    public String toString() {
        return "Question{" +
                "category=" + category +
                ", questionText='" + questionText + '\'' +
                ", answers=" + answers +
                ", correctAnswer='" + correctAnswer + '\'' +
                '}';
    }
}
