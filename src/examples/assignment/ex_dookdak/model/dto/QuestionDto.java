package examples.assignment.ex_dookdak.model.dto;

public class QuestionDto {
    private int qId, pId;
    private String qUser, qDesc, qPw, qDate;

    public QuestionDto() {
    }

    public QuestionDto(String qUser, String qDesc) {
        this.qUser = qUser;
        this.qDesc = qDesc;
    }

    public QuestionDto(int qId, int pId, String qUser, String qDesc, String qPw, String qDate) {
        this.qId = qId;
        this.pId = pId;
        this.qUser = qUser;
        this.qDesc = qDesc;
        this.qPw = qPw;
        this.qDate = qDate;
    }

    public int getqId() {
        return qId;
    }

    public void setqId(int qId) {
        this.qId = qId;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getqUser() {
        return qUser;
    }

    public void setqUser(String qUser) {
        this.qUser = qUser;
    }

    public String getqDesc() {
        return qDesc;
    }

    public void setqDesc(String qDesc) {
        this.qDesc = qDesc;
    }

    public String getqPw() {
        return qPw;
    }

    public void setqPw(String qPw) {
        this.qPw = qPw;
    }

    public String getqDate() {
        return qDate;
    }

    public void setqDate(String qDate) {
        this.qDate = qDate;
    }

    @Override
    public String toString() {
        return "QuestionDto{" +
                "qId=" + qId +
                ", pId=" + pId +
                ", qUser='" + qUser + '\'' +
                ", qDesc='" + qDesc + '\'' +
                ", qPw='" + qPw + '\'' +
                ", qDate='" + qDate + '\'' +
                '}';
    }
}
