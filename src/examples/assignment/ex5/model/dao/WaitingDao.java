package examples.assignment.ex5.model.dao;

import examples.assignment.ex5.model.dto.WaitingDto;

public class WaitingDao {
    private WaitingDto[] dto = new WaitingDto[100];

    private WaitingDao() {}
    private static final WaitingDao dao = new WaitingDao();
    public static WaitingDao getInstance() {
        return dao;
    }

    public boolean addWaiting(WaitingDto dto) {
        for (int i=0; i<this.dto.length; i++) {
            if (this.dto[i] == null) {
                this.dto[i] = dto;
                return true;
            }
        }
        return false;
    }

    public WaitingDto[] getWaitingList() {
        return dto;
    }
}
