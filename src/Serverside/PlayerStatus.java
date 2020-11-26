package Serverside;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PlayerStatus implements Serializable {

    private boolean selectingCategory;
    private boolean selectingAnswer;

    private boolean roundFinished;
    private boolean gameFinished;

    private boolean waiting;
    private String reasonForWaiting;

    private List<Category> categoriesToSelectBetween;
    private Question questionToAnswer;
    private Integer currentQuestionIndex = null;
    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Integer getCurrentQuestionIndex() {
        return currentQuestionIndex;
    }

    public void setCurrentQuestionIndex(Integer currentQuestionIndex) {
        this.currentQuestionIndex = currentQuestionIndex;
    }

    public boolean isWaiting() {
        return waiting;
    }

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }


    public void setReasonForWaiting(String reasonForWaiting){
        this.reasonForWaiting = reasonForWaiting;
    }

    public String getReasonForWaiting(){
        return reasonForWaiting;
    }

    public boolean isSelectingCategory() {
        return selectingCategory;
    }

    public void setSelectingCategory(boolean selectingCategory) {
        this.selectingCategory = selectingCategory;
    }

    public boolean isSelectingAnswer() {
        return selectingAnswer;
    }

    public void setSelectingAnswer(boolean selectingAnswer) {
        this.selectingAnswer = selectingAnswer;
    }

    public boolean isRoundFinished() {
        return roundFinished;
    }

    public void setRoundFinished(boolean roundFinished) {
        this.roundFinished = roundFinished;
    }

    public boolean isGameFinished() {
        return gameFinished;
    }

    public void setGameFinished(boolean gameFinished) {
        this.gameFinished = gameFinished;
    }

    public List<Category> getCategoriesToSelectBetween() {
        return categoriesToSelectBetween;
    }

    public void setCategoriesToSelectBetween(List<Category> categoriesToSelectBetween) {
        this.categoriesToSelectBetween = categoriesToSelectBetween;
    }

    public Question getQuestionToAnswer() {
        return questionToAnswer;
    }

    public void setQuestionToAnswer(Question questionToAnswer) {
        this.questionToAnswer = questionToAnswer;
    }


    @Override
    public String toString() {
        return "PlayerStatus{" +
                "selectingCategory=" + selectingCategory +
                ", selectingAnswer=" + selectingAnswer +
                ", roundFinished=" + roundFinished +
                ", gameFinished=" + gameFinished +
                ", waiting=" + waiting +
                ", reasonForWaiting='" + reasonForWaiting + '\'' +
                ", categoriesToSelectBetween=" + categoriesToSelectBetween +
                ", questionToAnswer=" + questionToAnswer +
                ", currentQuestionIndex=" + currentQuestionIndex +
                ", score=" + score +
                '}';
    }
}
