package d22;

import java.util.ArrayList;
import java.util.Random;

public class Example2 {
    public static void main(String[] args) {
        // Random : 난수 클래스
        Random random = new Random();

        // random.nextInt() : 0 ~ (n-1) 까지 난수 생성 (int)
        int value1 = random.nextInt();
        System.out.println("value1 = " + value1);
        int value2 = random.nextInt(10) + 1; // 1~10
        System.out.println("value2 = " + value2);
        int value3 = random.nextInt(100); // 0~99
        System.out.println("value3 = " + value3);

        // random.nextDouble() : 0 ~ 1 사이의 난수 생성 (double)
        double value4 = random.nextDouble(); // 0~1
        System.out.println("value4 = " + value4);

        // random.nextBoolean() : true 또는 false
        boolean value5 = random.nextBoolean();
        System.out.println("value5 = " + value5);

        // 활용
        ArrayList<String> nameList = new ArrayList<>();
        nameList.add("유재석");
        nameList.add("강호동");
        nameList.add("신동엽");
        int randomIndex = random.nextInt(nameList.size());
        System.out.println("추첨된 이름 : " + nameList.get(randomIndex));

        String code = "";
        for (int i=1; i<=6; i++) {
            // a : 97 ~ z : 122
            Random rand = new Random();
            int val = rand.nextInt(26) + 97; // 97부터 122까지 (122-97 = 26)
            char str = (char)val;
            code += str;
        }
        System.out.println(code);

        // 아스키코드 패턴으로 난수 계산식을 만들지 못할 경우, 직접 난수에 넣을 데이터를 배열로 선언
        char[] ranStr = {'0', '1', '2', '3', 'A', 'a', '!'};
        String newPwd = "";
        for (int i=1; i<=6; i++) {
            Random rand = new Random();
            int index = rand.nextInt(ranStr.length);
            newPwd += ranStr[index];
        }
        System.out.println(newPwd);

        int dice = random.nextInt(6) + 1;
        System.out.println("주사위의 값 : " + dice);

        ArrayList<Integer> lottoList = new ArrayList<>();
        for (int i=1; i<=6; i++) {
            int lotto = random.nextInt(45) + 1;
            if (lottoList.contains(lotto)) { // 리스트에 로또 번호가 존재할 시
                i--;
                continue; // 반복문 무효 처리
            }
            lottoList.add(lotto);
            if (lottoList.size() == 6) break; // 번호가 6개 있으면 반복문 종료
        }
        System.out.println(lottoList);

        // 배열을 사용하지 않고 문자열에서 추출해 난수 생성
        String ranStr2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int strlen = ranStr2.length();
        int ranIndex = random.nextInt(strlen);
        char str = ranStr2.charAt(ranIndex);
        System.out.println(str);
    }
}
