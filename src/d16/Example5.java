package d16;

import java.io.File;
import java.io.FileInputStream;

public class Example5 {
    public static void main(String[] args) {
        try {
            String path = "src/d16/sample.csv";
            File file = new File(path);
            System.out.println(file.exists());

            if (file.exists()) {
                FileInputStream fin = new FileInputStream(path);
                byte[] bytes = new byte[(int)file.length()];
                fin.read(bytes);
                // 파일 내 한글 인코딩 (EUC-KR) 문제로 출력이 안 되면 String 생성자 인수로 추가
                String str = new String(bytes, "EUC-KR");
                // System.out.println(str);

                // csv : 속성(열) 구분 - ',' 행 구분 - '\n'
                // System.out.println(str.split("\n")[0]); // 지정한 구분 문자 기준으로 쪼개서 배열로 변환
                // System.out.println(str.split("\n")[1].split(",")[1]);

                String[] rowData = str.split("\n"); // 행 단위로 쪼개서 저장
                for (int i=0; i<rowData.length; i++) {
                    String row = rowData[i];
                    // System.out.println(row); // 한 줄씩 출력
                    String[] columnData = row.split(","); // 열 단위로 쪼개서 저장
                    System.out.printf("업소명: %s, 지정메뉴: %s\n", columnData[1], columnData[3]);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
