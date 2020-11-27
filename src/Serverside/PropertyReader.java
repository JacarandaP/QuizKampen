package Serverside;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    private int numberOfRounds;
    private int numberOfQuestions;

    public PropertyReader() {
        Properties p = new Properties();
        try {
            p.loadFromXML(new FileInputStream("src\\Resources\\properties.xml"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        numberOfRounds = Integer.parseInt(p.getProperty("roundsInput", "3"));
        numberOfQuestions = Integer.parseInt(p.getProperty("questionsInput", "2"));
    }

    public int getNumberOfRounds() {
        if (numberOfRounds > 1 && numberOfRounds <= 6) {
            return numberOfRounds;
        } else {
            System.out.println("Invalid number of rounds (between 2 & 6)");
            numberOfRounds = 4; // default
            return -1;
        }
    }

    public int getNumberOfQuestions() {
        if (numberOfQuestions > 1 && numberOfQuestions <= 4) {
            return numberOfQuestions;
        } else {
            System.out.println("Invalid number of questions (between 2 & 4)");
            numberOfQuestions = 3; // default
            return -1;
        }
    }

    public static void main(String[] args) {
        PropertyReader p  = new PropertyReader();
        System.out.println(p.getNumberOfQuestions());
    }
}

