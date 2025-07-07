package d06;

import java.util.Arrays;

public class Example1 {
    public static void main(String[] args) {
        int[] array1 = new int[3];
        String[] array2 = {"봄", "여름", "가을", "겨울"};

        System.out.println(array1); // 객체의 주소값 출력
        System.out.println(array2);

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));

        System.out.println(array1[0]);
        System.out.println(array2[0]);
        System.out.println(array1.length); // 배열 내 길이 반환
        System.out.println(array2.length);

        array1[0] = 10;
        System.out.println(array1[0]);
        array2[0] = "Spring";
        System.out.println(array2[0]);

        // array1[3] = 40; error: index out of bounds (삭제/추가 불가능)
        for (int i=0; i<=array1.length-1; i++) {
            int value = array1[i];
            System.out.println(value);
        }

        for (String value : array2) {
            System.out.println(value);
        } // 향상된 for문 (타입 변수명 : 배열명) [초기값: 정수 0, 실수 0.0, 논리 false, 객체(배열) null]
    }
}
