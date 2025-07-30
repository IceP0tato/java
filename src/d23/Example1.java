package d23;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Example1 {
    public static void main(String[] args) {
        // 컬렉션 프레임워크 : 자료수집 방법 (=자료구조)
        // 종류 : List, Set , Map 인터페이스
        // 구현체
        //  List : ArrayList, Vector, LinkedList 등
        //  Set : HashSet, TreeSet 등
        //  Map : HashMap, TableMap 등
        ArrayList<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        // List : 배열/링크 구조
        // .add(data) : 리스트 내 지정한 자료를 마지막 요소에 추가
        list2.add("유재석");
        list2.add("강호동");
        list2.add("신동엽");
        list2.add("유재석"); // 중복 허용
        list2.add(2, "서장훈"); // 리스트 내 지정한 인덱스의 자료를 추가
        System.out.println(list2);
        // .set(index, data) : 리스트 내 지정한 인덱스의 자료를 수정/변경
        list2.set(0, "유재석2");
        System.out.println(list2);
        // .get(index) : 리스트 내 지정한 인덱스의 자료를 호출/반환
        String result = list2.get(2);
        System.out.println(result);
        // .size() : 리스트 내 전체 요소/자료의 개수 반환
        int count = list2.size();
        System.out.println(count);
        // .contains(data) : 리스트 내 지정한 자료가 존재하면 true, 없으면 false
        boolean bool = list2.contains("서장훈");
        System.out.println(bool);
        // .indexOf(data) : 리스트 내 지정한 자료의 인덱스 반환, 없으면 -1
        int index = list2.indexOf("서장훈");
        System.out.println(index);
        // .remove(index) : 리스트 내 지정한 인덱스의 요소/항목 삭제
        list2.remove(2);
        System.out.println(list2);
        // .isEmpty() : 리스트 내 요소가 비어있으면 true, 1개 이상 존재하면 false
        System.out.println(list2.isEmpty());
        // .clear() : 리스트 내 모든 요소 삭제
        // list2.clear();
        // System.out.println(list2);

        // List 반복문 : 여러가지 자료들을 순서대로 호출/순회/확인하는 작업에 사용
        for (int i=0; i<list2.size(); i++) {
            System.out.println(list2.get(i));
        }

        for (String str : list2) {
            System.out.println(str);
        }

        // forEach (람다식 함수)
        list2.forEach((value) -> {
            System.out.println(value);
        });
        list2.forEach((str) -> {
            System.out.println(list2);
        });

        // ArrayList : 배열 구조로 사용되는 List 구현체 + 비동기화 (단일 스레드 플랫폼)
        ArrayList<Integer> arrayList = new ArrayList<>();

        // Vector : 배열 구조로 사용되는 List 구현체 + 메소드가 동기화 처리됨 (멀티 스레드 플랫폼)
        Vector<Integer> vector = new Vector<>();

        // LinkedList : 링크 구조로 사용되는 List 구현체 + 중간 삽입/삭제 효율성 극대화
        // 특정 인덱스가 삭제되는 등 중간에 변화가 생기면 남아있는 요소들의 연결이 변경됨 (값/주소값)
        LinkedList<Integer> linkedList = new LinkedList<>();

        List<Integer> integerList = arrayList;
        integerList = vector;
        integerList = arrayList;
    }
}
