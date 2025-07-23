package examples.assignment.ex8.controller;

import examples.assignment.ex8.model.dao.WaitingDao;
import examples.assignment.ex8.model.dto.WaitingDto;

import java.util.ArrayList;

public class WaitingController {
    private WaitingController() {}
    private static final WaitingController instance = new WaitingController();
    public static WaitingController getInstance() {
        return instance;
    }
    WaitingDao dao = WaitingDao.getInstance();

    public boolean waitingInsert(String phone, int count) {
        WaitingDto dto = new WaitingDto(0, phone, count);
        return dao.waitingInsert(dto);
    }

    public ArrayList<WaitingDto> waitingSelect() {
        return dao.waitingSelect();
    }

    public boolean waitingDelete(int num) {
        return dao.waitingDelete(num);
    }

    public boolean waitingUpdate(int num, int count) {
        WaitingDto dto = new WaitingDto(num, null, count);
        return dao.waitingUpdate(dto);
    }
}
