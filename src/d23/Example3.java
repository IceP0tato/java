package d23;

import java.util.*;

public class Example3 {
    public static void main(String[] args) {
        // Map : 여러 개의 엔트리(key, value)를 저장하는 구조 (JSON과 비슷함)
        // HashMap <key, value>
        Map<String, Integer> map = new HashMap<>();
        // .put(key, value) : map 객체 내의 key와 value 자료를 한 쌍(entry)으로 저장
        map.put("유재석", 95);
        map.put("강호동", 100);
        map.put("신동엽", 78);
        map.put("유재석", 67); // 속성명(key)은 중복 불가
        map.put("서장훈", 100); // 속성값(value)은 중복 가능
        System.out.println(map);
        // .get(key) : map 객체 내 지정한 key의 value 반환
        System.out.println(map.get("유재석"));
        // .size() : map 객체 내 entry 개수 반환
        System.out.println(map.size());
        // .remove(key) : map 객체 내 지정한 key의 entry 삭제
        map.remove("유재석");
        System.out.println(map);
        // .containsKey(key), .containsValue(value)
        System.out.println(map.containsKey("강호동"));
        System.out.println(map.containsValue(65));
        // .clear() : map 객체 내 모든 entry 삭제
        // map.clear();
        // .isEmpty() : map 객체 내 entry가 없으면 true, 1개 이상이면 false
        System.out.println(map.isEmpty());
        // .entrySet() : map 객체 내 모든 entry를 set 인터페이스로 반환
        System.out.println(map.entrySet());
        // .keySet() : map 객체 내 모든 key를 set 인터페이스로 변환
        System.out.println(map.keySet());
        // .values() : map 객체 내 모든 values를 list 인터페이스로 변환
        System.out.println(map.values());

        // Map 반복문 (인덱스가 없어서 일반 for 문은 불가)
        for (String key : map.keySet()) {
            System.out.println(key); // key
            System.out.println(map.get(key)); // value
        }

        map.keySet().forEach(key -> {
            System.out.println(key);
            System.out.println(map.get(key));
        });

        // HashMap : key, value로 구성된 entry 객체를 저장하는 구조
        HashMap<Integer, Object> hashMap = new HashMap<>();
        // HashTable : 동기화 메소드 제공 (멀티 스레드 플랫폼)
        Hashtable<Integer, Object> hashTable = new Hashtable<>();
        // TreeMap : key 기준으로 자동 정렬 (오름차순)
        TreeMap<Integer, Object> treeMap = new TreeMap();
        // Properties : 별도의 제네릭 없음 (주로 설정 파일에서 사용)
        Properties properties = new Properties();
        properties.put("홍길동", 100);

        Map<Integer, Object> map2;
        map2 = hashMap;
        map2 = treeMap;
        map2 = hashTable;

        // 활용 : JSON(Javascript 객체) <-> MAP/DTO(Java 객체)
    }
}
