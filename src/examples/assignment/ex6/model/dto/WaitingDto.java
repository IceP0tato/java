package examples.assignment.ex6.model.dto;

public class WaitingDto {
    private String phone;
    private int count;

    public WaitingDto(String phone, int count) {
        this.phone = phone;
        this.count = count;
    }

    public String getPhone() {
        return phone;
    }

    public int getCount() {
        return count;
    }
}
