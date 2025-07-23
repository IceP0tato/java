package examples.assignment.ex8.model.dto;

public class WaitingDto {
    // DB name : exam08
    // table name : list
    private int num; // auto_increment, primary key
    private String phone; // not null
    private int count; // not null

    public WaitingDto(int num, String phone, int count) {
        this.num = num;
        this.phone = phone;
        this.count = count;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
