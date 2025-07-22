package d17;

import au.com.bytecode.opencsv.CSVReader;

import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.List;

public class Example1 {
    public static void main(String[] args) {
        // OpenCSV 라이브러리
        try {
            String path = "src/d17/sample.csv";
            FileReader fileReader = new FileReader(path, Charset.forName("EUC-KR")); // 파일 읽기 모드 객체 생성
            CSVReader csvReader = new CSVReader(fileReader); // CSVReader로 파일 읽어오기
            List<String[]> data = csvReader.readAll(); // List: 인터페이스 타입 (ArrayList 구현체), .readAll(): 데이터를 List<String[]> 타입으로 반환
            for (int i=0; i<data.size(); i++) {
                String[] row = data.get(i);
                System.out.printf("업소명: %s, 지정메뉴: %s\n", row[1], row[3]);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
