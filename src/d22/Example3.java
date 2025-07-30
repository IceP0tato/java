package d22;

import java.util.ArrayList;

class Box1 {
    String content;
}

class Box2 {
    int content;
}

// 제네릭 타입
class Box<T> {
    T content;
}

class miniArrayList<E> {
    E[] data = (E[]) new Object[10];
}

// 관례적으로 제네릭 이름은 대문자 1개
class Dto<T, E> {
    T value1;
    E value2;
}

public class Example3 {
    public static void main(String[] args) {
        // Generic 타입 : 여러 가지 타입에서 동작할 수 있도록 만든 키워드
        // 클래스 정의할 때 변수 타입을 정하지 않고 인스턴스를 생성할 때 변수 타입 설정 (다양한 타입의 데이터 처리 가능)
        // 사용법 : < >
        // 컬렉션프레임워크 등에서 사용 (실무에서 중요함)
        // 특징 : 변수의 타입 유연성, 코드 중복 제거, 잘못된 타입 방지
        // 주의 : 기본 타입으로는 제네릭 타입 사용 불가, 기본타입 (int, double 등) -> 래퍼클래스 (Integer, Double 등)으로 바꿔야 함
        Box1 box1 = new Box1();
        box1.content = "안녕하세요.";
        String content1 = box1.content;

        Box2 box2 = new Box2();
        box2.content = 100;
        int content2 = box2.content;

        Box<String> box3 = new Box<>();
        box3.content = "안녕하세요.";
        Box<Integer> box4 = new Box<>();
        box4.content = 100;

        ArrayList<String> sList = new ArrayList<>();
        ArrayList<Integer> iList = new ArrayList<>();

        Dto<String, Integer> dto = new Dto<>();
        dto.value1 = "문자열";
        dto.value2 = 400;
        Dto<Double, Byte> dto2 = new Dto<>();
        dto2.value1 = 3.14;
        dto2.value2 = 99;
        Dto<Integer, ArrayList<String>> dto3 = new Dto<>();
        dto3.value1 = 3;
        dto3.value2 = new ArrayList<>();
    }
}
