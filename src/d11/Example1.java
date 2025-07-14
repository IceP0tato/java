package d11;

import java.util.ArrayList;

public class Example1 {
    public static void main(String[] args) {
        // ArrayList : 가변 길이의 배열, 다양한 메소드/기능 제공
        ArrayList<String> listObj = new ArrayList<>();

        // 요소 추가
        listObj.add("유재석");
        System.out.println("listObj = " + listObj);

        listObj.add("강호동");
        listObj.add("신동엽");
        System.out.println("listObj = " + listObj);

        // 요소 추가 (인덱스)
        listObj.add(1, "박명수");
        System.out.println("listObj = " + listObj);

        // 요소 수정
        listObj.set(1, "이명수");
        System.out.println("listObj = " + listObj);

        // 크기 확인
        System.out.println(listObj.size());

        // 특정 요소 반환
        System.out.println(listObj.get(1));

        // 요소 삭제
        listObj.remove(1);
        System.out.println("listObj = " + listObj);

        // 일반 for문
        for (int i=0; i<listObj.size(); i++) {
            System.out.println(listObj.get(i));
        }

        // 향상된 for문
        for (String str : listObj) {
            System.out.println(str);
        }

        Member m1 = new Member("강호동", 10);
        Member m2 = new Member("신동엽", 20);
        Member m3 = new Member("유재석", 30);
        ArrayList<Member> memberList = new ArrayList<>();

        memberList.add(m1);
        memberList.add(m2);
        memberList.add(m3);
        for (int i=0; i<memberList.size(); i++) {
            Member m = memberList.get(i);
            System.out.println("name : " + m.name);
            System.out.println("age : " + m.age);
        }
    }
}

class Member {
    String name;
    int age;

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
