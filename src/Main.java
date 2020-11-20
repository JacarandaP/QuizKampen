import GUI.QuizGUI;
import Serverside.Question;
import Serverside.QuestionDatabase;

import java.util.Collections;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        QuizGUI quiz = new QuizGUI();
        QuestionDatabase qd = new QuestionDatabase();

        Scanner sc = new Scanner(System.in);

        while (true) {

            Question questionDatabase = qd.getRandomQuestion(0); //category //TODO varför skapas det en fråga i klienten? hur säkerställer man att motspelaren får samma fråga
            Collections.shuffle(questionDatabase.getAnswers());
            quiz.getQuestionText().setText(questionDatabase.getQuestionText());
            quiz.getA1().setText(questionDatabase.getAnswers().get(0));
            quiz.getA2().setText(questionDatabase.getAnswers().get(1));
            quiz.getA3().setText(questionDatabase.getAnswers().get(2));
            quiz.getA4().setText(questionDatabase.getAnswers().get(3));
            sc.nextLine();
            quiz.changeButtonsToDefaultColor();
        }

    }


}
