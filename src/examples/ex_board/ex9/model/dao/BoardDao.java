package examples.ex_board.ex9.model.dao;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import examples.ex_board.ex9.model.dto.BoardDto;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BoardDao {
    private BoardDao(){
        // 싱글톤 생성 시 csv 로드
        openCSV();
    }
    private static final BoardDao instance = new BoardDao();
    public static BoardDao getInstance(){
        return instance;
    }
    ArrayList<BoardDto> boardDB = new ArrayList<>();

    public boolean boardWrite(BoardDto boardDto) {
        boardDB.add(boardDto); // 리스트에 dto 저장
        // csv 저장
        saveCSV();
        return true;
    }

    public ArrayList<BoardDto> boardPrint() {
        return boardDB;
    }

    private String path = "src/examples/ex_board/ex9/data.csv";
    // csv 파일 연동
    public void openCSV() {
        File file = new File(path);
        if (file.exists()) { // 파일이 존재하면 정보 불러오기
            loadCSV();
        } else { // 파일이 없으면 파일 생성
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // csv 입력
    public void loadCSV() {
        try {
            FileReader fileReader = new FileReader(path); // 읽기 모드 객체 생성
            CSVReader csvReader = new CSVReader(fileReader); // CSV 객체 생성
            List<String[]> inData = csvReader.readAll(); // 모든 정보 읽어오기
            for (String[] row : inData) {
                String content = row[0];
                String writer = row[1];
                BoardDto boardDto = new BoardDto(content, writer); // 각 열들을 하나의 dto로 생성
                boardDB.add(boardDto); // dto를 리스트에 저장
            }
            csvReader.close(); // csvReader 닫기 (메모리 누수 방지)
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // csv 출력
    public void saveCSV() {
        try {
            FileWriter fileWriter = new FileWriter(path); // 쓰기 모드 객체 생성
            CSVWriter csvWriter = new CSVWriter(fileWriter); // CSV 객체 생성
            List<String[]> outData = new ArrayList<>(); // 빈 리스트 생성
            for (BoardDto boardDto : boardDB) {
                String[] row = {boardDto.getContent(), boardDto.getWriter()}; // 내용과 작성자를 행으로 구성
                outData.add(row);
            }
            csvWriter.writeAll(outData); // outData 내보내기
            csvWriter.close(); // csvWriter 닫기
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
