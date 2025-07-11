package examples.assignment.ex5.controller;

import examples.assignment.ex5.model.dao.WaitingDao;
import examples.assignment.ex5.model.dto.WaitingDto;

public class WaitingController {
    private WaitingDao dao = WaitingDao.getInstance();

    private WaitingController() {}
    private static final WaitingController controller = new WaitingController();
    public static WaitingController getInstance() {
        return controller;
    }

    public boolean addWaiting(String phone, int count) {
        WaitingDto dto = new WaitingDto(phone, count);
        boolean result = dao.addWaiting(dto);
        return result;
    }

    public WaitingDto[] getWaitingList() {
        WaitingDto[] result = dao.getWaitingList();
        return result;
    }
}
