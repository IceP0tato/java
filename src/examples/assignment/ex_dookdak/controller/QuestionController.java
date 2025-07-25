package examples.assignment.ex_dookdak.controller;

import examples.assignment.ex_dookdak.model.dao.QuestionDao;
import examples.assignment.ex_dookdak.model.dto.QuestionDto;

import java.util.ArrayList;

public class QuestionController {
    private QuestionController() {}
    private static final QuestionController instance = new QuestionController();
    public static QuestionController getInstance() {
        return instance;
    }
    private QuestionDao dao = QuestionDao.getInstance();

    public void addQuestion(int pId, String qUser, String qDesc, String qPw) {
        QuestionDto dto = new QuestionDto(0, pId, qUser, qDesc, qPw, null);
        dao.addQuestion(dto);
    }

    public ArrayList<QuestionDto> detailProduct(int pId) {
        return dao.detailProduct(pId);
    }
}
