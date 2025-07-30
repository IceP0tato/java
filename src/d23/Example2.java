package d23;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Example2 {
    public static void main(String[] args) {
        // Set : 집합 구조 (인덱스 없음, 중복 불허) - 순서 보장 없이 요소들을 저장하는 구조
        // HashSet
        // .add(data) : 집합 내 지정한 자료 추가
        Set<String> set1 = new HashSet<>();
        set1.add("유재석");
        set1.add("강호동");
        set1.add("신동엽");
        set1.add("유재석"); // 이미 존재하는 자료는 중복이므로 불가능
        System.out.println(set1);
        // .size() : 집합 내 자료/요소 개수 반환
        System.out.println(set1.size());
        // .contains(data) : 집합 내 자료가 존재하면 true, 없으면 false
        System.out.println(set1.contains("유재석"));
        // .remove(data) : 집합 내 자료가 존재하면 삭제
        set1.remove("강호동");
        System.out.println(set1);
        // .isEmpty() : 집합 내 자료가 하나도 없으면 true, 1개 이상이면 false
        System.out.println(set1.isEmpty());
        // .clear() : 집합 내 모든 자료 삭제
        // set1.clear();

        // Set 반복문 (인덱스가 없어서 일반 for 문은 불가)
        for (String str : set1) {
            System.out.println(str);
        }

        set1.forEach(str -> {
            System.out.println(str);
        });

        // HashSet : 중복 없는 여러 개 요소 저장 + 빠름
        HashSet<Integer> hashSet = new HashSet<>();
        // TreeSet : 중복 없는 여러 개 요소 저장 + 저장한 자료들을 자동으로 정렬(오름차순)
        TreeSet<Integer> treeSet = new TreeSet<>();
        // LinkedHashSet : 중복 없는 여러 개 요소 저장 + 링크 구조 + 순서 보장 + 느림
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();

        Set<Integer> set2;
        set2 = hashSet;
        set2 = treeSet;
        set2 = linkedHashSet;

        // 활용 : JDBC (ResultSet)
    }
}
