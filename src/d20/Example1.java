package d20;

class BookDto {

}

class BoardDto {
    @Override
    public String toString() {
        return "BoardDto{}";
    }
}

public class Example1 {
    public static void main(String[] args) {
        // toString() : 인스턴스/자료 주소(메모리 위치) 반환 -> 주로 오버라이딩해서 인스턴스의 상태(정보) 반환
        Object o1 = 3;
        Object o2 = 3.14;
        Object o3 = true;
        Object o4 = "유재석";
        Object o5 = new Object();
        Object o6 = new int[] {1, 2, 3};
        Object o7 = new BookDto();
        Object o8 = new BoardDto();
        System.out.println(o7.toString());
        System.out.println(o8.toString());

        // == : 변수가 갖는 주소 비교, .equals() : 주소가 갖는 객체 비교
        Object o9 = new BookDto();
        Object o10 = new BookDto();
        System.out.println(o9.equals(o10)); // false
        Object o11 = o9;
        System.out.println(o9 == o11); // true
        String str1 = new String("유재석");
        String str2 = new String("유재석");
        System.out.println(str1 == str2); // false
        System.out.println(str1.equals(str2)); // true

        // .hashCode() : 객체의 주소값을 정수로 반환
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
        System.out.println(o9.hashCode());
        System.out.println(o10.hashCode());
        System.out.println(o11.hashCode());
    }
}
