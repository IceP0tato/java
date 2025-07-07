package d06;

public class Example2 {
    public static void main(String[] args) {
        Student s1 = new Student(); // 객체 생성
        System.out.println(s1); // 객체 주소값 반환
        System.out.println(s1.studentName);

        s1.studentName = "유재석";
        System.out.println(s1.studentName);

        ExClass bread1 = new ExClass();
        bread1.content = "팥";
        bread1.price = 1500;

        ExClass bread2 = new ExClass();
        bread2.content = "팥";
        bread2.price = 1000;

        ExClass bread3 = new ExClass();
        bread3.content = "슈크림";
        bread3.price = 1000;

        ExClass[] breadList = {bread1, bread2, bread3};
    }
}

class Student {
    int studentId;
    String studentName;
}
