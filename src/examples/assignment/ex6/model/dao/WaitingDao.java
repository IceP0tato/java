package examples.assignment.ex6.model.dao;

import examples.assignment.ex6.model.dto.WaitingDto;

import java.util.ArrayList;

public class WaitingDao {
    private ArrayList<WaitingDto> dto = new ArrayList<>();

    private WaitingDao() {}
    private static final WaitingDao instance = new WaitingDao();
    public static WaitingDao getInstance() {
        return instance;
    }

    public boolean addWaiting(String phone, int count) {
        boolean result = false;
        WaitingDto input = new WaitingDto(phone, count);
        dto.add(input);
        result = true;
        return result;
    }

    public ArrayList<WaitingDto> getWaitingList() {
        return dto;
    }
}
