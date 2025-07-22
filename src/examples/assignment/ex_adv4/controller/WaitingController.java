package examples.assignment.ex_adv4.controller;

import examples.assignment.ex_adv4.model.dao.WaitingDao;
import examples.assignment.ex_adv4.model.dto.WaitingDto;

import java.util.ArrayList;

public class WaitingController {
    private WaitingController() {}
    private static final WaitingController instance = new WaitingController();
    public static WaitingController getInstance() {
        return instance;
    }
    private WaitingDao dao = WaitingDao.getInstance();

    public boolean waitingAdd(String phone, int count) {
        WaitingDto waitingDto = new WaitingDto(phone, count);
        boolean result = dao.waitingAdd(waitingDto);
        return result;
    }

    public ArrayList<WaitingDto> waitingShow() {
        ArrayList<WaitingDto> result = dao.waitingShow();
        return result;
    }
}
