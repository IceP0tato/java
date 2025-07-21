package d16;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Example4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("입력: ");
        String str = scan.next();
        String path = "src/d16/test2.txt";

        try {
            FileOutputStream fout = new FileOutputStream(path);
            byte[] outByte = str.getBytes();
            fout.write(outByte);

            File file = new File(path); // File 클래스
            System.out.println(file.isFile()); // 파일 경로 여부 반환 (boolean)
            System.out.println(file.getName()); // 파일 이름 반환
            System.out.println(file.length()); // 파일 용량(byte) 반환
            System.out.println(file.exists()); // 파일 존재 여부 반환 (boolean)
            // file.delete(); // 지정한 경로에 파일 삭제
            // file.createNewFile(); // 지정한 경로에 파일 생성

            if (file.exists()) {
                FileInputStream fin = new FileInputStream(path);
                byte[] inByte = new byte[(int)file.length()]; // 파일 용량만큼 배열 길이 설정 (길이는 int만 가능)
                fin.read(inByte);

                String inStr = new String(inByte);
                System.out.println(inStr);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
