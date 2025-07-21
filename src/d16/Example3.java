package d16;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Example3 {
    public static void main(String[] args) {
        // 파일 입출력
        String path = "src/d16/test1.txt"; // 파일의 위치 (상대/절대경로)

        try {
            FileOutputStream fout = new FileOutputStream(path); // 파일 쓰기
            fout.write("안녕하세요.".getBytes()); // 파일에 내용 쓰기 (.getBytes(): 문자열 -> 바이트 변환 함수)
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다.");
        } catch (IOException e) {
            System.out.println("입출력 과정에 오류가 발생하였습니다.");
        }

        try {
            FileInputStream fin = new FileInputStream(path); // 파일 읽기
            byte[] bytes = new byte[42];
            fin.read(bytes); // 파일의 내용 읽기 (읽어서 bytes 배열 안에 저장)
            System.out.println(new String(bytes)); // 내용 출력 (bytes 배열을 문자열로 변환해 내용 출력)
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다.");
        } catch (IOException e) {
            System.out.println("입출력 과정에 오류가 발생하였습니다.");
        }
    }
}
