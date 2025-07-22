package examples.assignment.ex7.model.dao;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import examples.assignment.ex7.model.dto.WaitingDto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WaitingDao {
    private WaitingDao() { openCSV(); }
    private static final WaitingDao instance = new WaitingDao();
    public static WaitingDao getInstance() {
        return instance;
    }
    ArrayList<WaitingDto> waitingList = new ArrayList<>();
    String path = "src/examples/assignment/ex7/resources/list.csv";

    // 입력: phone, count 추가
    public boolean waitingAdd(WaitingDto waitingDto) {
        waitingList.add(waitingDto);
        saveCSV();
        return true;
    }

    // 출력: waitingList 반환
    public ArrayList<WaitingDto> waitingShow() {
        return waitingList;
    }

    // 생성: csv 파일이 없을 시 생성
    public void openCSV() {
        File file = new File(path);
        if (file.exists()) {
            loadCSV();
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // 입력: csv 불러오기
    public void loadCSV() {
        try {
            FileReader fileReader = new FileReader(path);
            CSVReader csvReader = new CSVReader(fileReader);
            List<String[]> inData = csvReader.readAll();
            for (String[] row : inData) {
                String phone = row[0];
                // String으로 저장된 데이터를 int로 변환하여 변수에 저장 및 삽입
                int count = Integer.parseInt(row[1]);
                WaitingDto waitingDto = new WaitingDto(phone, count);
                waitingList.add(waitingDto);
            }
            csvReader.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 출력: csv 작성
    public void saveCSV() {
        try {
            FileWriter fileWriter = new FileWriter(path);
            CSVWriter csvWriter = new CSVWriter(fileWriter);
            List<String[]> outData = new ArrayList<>();
            for (WaitingDto waitingDto : waitingList) {
                // String[]에 string, int를 넣을 수 없으므로, string, string으로 변환하여 삽입
                String[] row = { waitingDto.getPhone(), String.valueOf(waitingDto.getCount()) };
                outData.add(row);
            }
            csvWriter.writeAll(outData);
            csvWriter.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
