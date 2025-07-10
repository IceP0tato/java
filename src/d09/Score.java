package d09;

public class Score {
    private int score;

    void setScore(int score) {
        if (score >= 0 && score <= 100) {
            this.score = score;
        } else System.out.println("유효하지 않은 점수입니다.");
    }

    int getScore() {
        return score;
    }
}
