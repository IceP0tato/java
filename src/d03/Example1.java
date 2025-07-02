package d03;

public class Example1 {
    public static void main(String[] args) {
        int degree = 5;
        if (degree <= 10) System.out.println("외투를 입으세요");

        int age = 10;
        if (age >= 19) {
            System.out.println("성인입니다.");
            System.out.println("19세 이상입니다.");
        }

        boolean check = false;
        if (check == true) {
            System.out.println("안녕하세요, 회원님");
        } else {
            System.out.println("비회원입니다.");
        }

        int money = 1750;
        if (money >= 3000) {
            System.out.println("택시 탑승");
        } else if (money >= 1700) {
            System.out.println("버스 탑승");
        } else if (money >= 1200) {
            System.out.println("자전거 탑승");
        } else {
            System.out.println("걸어가기");
        }

        if (money >= 3000) {
            System.out.println("택시 탑승");
        }
        if (money >= 1700) {
            System.out.println("버스 탑승");
        }
        if (money >= 1200) {
            System.out.println("자전거 탑승");
        }


        int age2 = 25;
        char gender = 'F';
        if (age2 >= 19) {
            System.out.println("성인");
            if (gender == 'M') {
                System.out.println("성인 남성");
            } else if (gender == 'F') {
                System.out.println("성인 여성");
            }
        } else {
            System.out.println("미성년자");
        }
    }
}
