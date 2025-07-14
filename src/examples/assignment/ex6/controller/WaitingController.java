package examples.assignment.ex6.controller;

import examples.assignment.ex6.model.dao.WaitingDao;
import examples.assignment.ex6.model.dto.WaitingDto;

import java.util.ArrayList;

public class WaitingController {
    private WaitingDao dao = WaitingDao.getInstance();

    private WaitingController() {}
    private static final WaitingController instance = new WaitingController();
    public static WaitingController getInstance() {
        return instance;
    }

    public boolean addWaiting(String phone, int count) {
        boolean result = dao.addWaiting(phone, count);
        return result;
    }

    public ArrayList<WaitingDto> getWaitingList() {
        return dao.getWaitingList();
    }
}
