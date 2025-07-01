/* [실습2] *제출용
[ 문제] 아래 타입변환, 입력함수 관련 7문제
[ 제출방법 ] 코드가 작성된 파일이 위치한 깃허브 상세 주소를 제출하시오.

문제 1: a 와 b 두 변수의 합을 long 타입의 변수에 저장하여 그 결과를 출력하시오.
선언 코드 :
byte a = 10;
int b = 200;
출력 예시:
결과: 210

문제 2: 실수 3.141592를 double 타입 변수에 저장한 뒤, 이 변수를 int 타입으로 강제 변환하여 정수 부분만 출력하시오.
선언 코드 :
double z = 3.141592;
출력 예시:
원본 double 값: 3.141592
변환된 int 값: 3

문제 3: Scanner를 이용하여 사용자의 이름(String)과 나이(int)를 입력받아, "OOO님의 나이는 OO세 입니다." 형식으로 출력하는 코드를 작성하시오.
입력 예시:
이름을 입력하세요: 유재석
나이를 입력하세요: 51
출력 예시:
유재석님의 나이는 51세 입니다.

문제 4: Scanner를 이용해 게시물 번호(int), 제목(String), 내용(String)을 순서대로 입력받아 출력하시오.
요구 조건: 제목과 내용은 띄어쓰기가 포함될 수 있으므로 nextLine()을 사용하시오.
입력 예시:
게시물 번호: 1
제목: 자바는 재미있어요
내용: 정말입니다. 다들 동의하시죠?
출력 예시:
[ 1번 게시물 ]
제목: 자바는 재미있어요
내용: 정말입니다. 다들 동의하시죠?

문제 5: Scanner를 이용해 성별을 한 글자('남' 또는 '여')로 입력받아 char 타입 변수에 저장하고, 입력된 성별을 출력하시오.
요구 조건: Scanner에는 nextChar() 함수가 없으므로 next().charAt(0)을 활용하시오.
입력 예시:
성별을 입력하세요(남/여): 남
출력 예시:
입력하신 성별은 '남' 입니다.

문제 6: Scanner를 이용해 사용자의 키를 double 타입(예: 178.5)으로 입력받은 후, 이 값을 int 타입으로 강제 변환하여 "당신의 키는 약 OOOcm 이군요." 라고 정수 부분만 출력하시오.
입력 예시:
키를 입력하세요: 178.5
출력 예시:
당신의 키는 약 178cm 이군요.

문제 7: Scanner를 사용하여 아래 4가지 정보를 순서대로 입력받아 출력하는 코드를 작성하시오.
이름 (String), 나이 (int), 키 (double), 프로그래머 여부 (boolean)
입력 예시:
이름: 김자바
나이: 25
키: 165.8
프로그래머입니까? (true/false): true
출력 예시:
--- 자기소개 ---
이름: 김자바
나이: 25
키: 165.8cm
프로그래머 여부: true */

package d03;

import java.util.Scanner;

public class 실습2 {
    public static void main(String[] args) {
        // 문제 1
        byte a = 10;
        int b = 200;
        long result = a + b;
        System.out.println("결과: " + result);

        // 문제 2
        double z = 3.141592;
        System.out.println("원본 double 값: " + z);
        System.out.println("변환된 int 값: " + (int)z);

        // 문제 3
        /*
        Scanner scan = new Scanner(System.in);
        System.out.print("이름을 입력하세요: ");
        String name = scan.nextLine();
        System.out.print("나이를 입력하세요: ");
        int age = scan.nextInt();

        System.out.println(name + "님의 나이는 " + age + "세 입니다.");
        */

        // 문제 4
        /*
        Scanner scan = new Scanner(System.in);
        System.out.print("게시물 번호: ");
        int number = scan.nextInt();
        System.out.print("제목: ");
        scan.nextLine();
        String title = scan.nextLine();
        System.out.print("내용: ");
        String desc = scan.nextLine();

        System.out.println("[ " + number + "번 게시물 ]");
        System.out.println("제목: " + title);
        System.out.println("내용: " + desc);
        */

        // 문제 5
        /*
        Scanner scan = new Scanner(System.in);
        System.out.print("성별을 입력하세요(남/여): ");
        char gender = scan.next().charAt(0);

        System.out.println("입력하신 성별은 '" + gender + "' 입니다.");
        */

        // 문제 6
        /*
        Scanner scan = new Scanner(System.in);
        System.out.print("키를 입력하세요: ");
        double height = scan.nextDouble();
        System.out.println("당신의 키는 약 " + (int)height + "cm 이군요.");
        */

        // 문제 7
        Scanner scan = new Scanner(System.in);
        System.out.print("이름: ");
        String name = scan.nextLine();
        System.out.print("나이: ");
        int age = scan.nextInt();
        System.out.print("키: ");
        double height = scan.nextDouble();
        System.out.print("프로그래머입니까? (true/false): ");
        boolean isProgrammer = scan.nextBoolean();

        System.out.println("--- 자기소개 ---");
        System.out.println("이름: " + name);
        System.out.println("나이: " + age);
        System.out.println("키: " + height + "cm");
        System.out.println("프로그래머 여부: " + isProgrammer);
    }
}
