package d01;

public class Example3 {
    public static void main(String[] args) { // main
        System.out.println("Hello"); // sout
        System.out.println("World");

        System.out.print("Hello");
        System.out.print("World");

        System.out.printf("%s", "Hello World"); // souf

        // 형식 문자: %s 문자열, %c 문자, %d 정수, %f 실수
        String name = "유재석";
        int age = 40;
        System.out.println();
        System.out.printf("저는 %s이고, 나이는 %d입니다.\n", name, age);
        System.out.println("저는 " + name + "이고, 나이는 " + age + "입니다.");
        System.out.printf("저는 %s이고, 나이는 %6d입니다.\n", name, age); // 6자리수 안에 정수 표현 (오른쪽 정렬)
        System.out.printf("저는 %s이고, 나이는 %-6d입니다.\n", name, age); // 6자리수 안에 정수 표현 (왼쪽 정렬)
        System.out.printf("저는 %s이고, 나이는 %06d입니다.\n", name, age); // 6자리수 안에 정수 표현 (빈 칸은 0으로 채우기)
        System.out.printf("저는 %s이고 신장은 %5.2f입니다.\n", name, 188.257); // 5자리수 안에 실수 표현 (소수점은 2개)

        // 이스케이프 문자: \n 줄바꿈, \t 들여쓰기, \\ '\' 출력, \' 작은따옴표 출력, \" 큰따옴표 출력
        System.out.println("Hello1\nHello2");
        System.out.println("Hello1\tHello2");
        System.out.println("Hello1\'Hello2\'");
        System.out.println("Hello1\"Hello2\"");
        System.out.println("Hello1\\Hello2");
    }
}
