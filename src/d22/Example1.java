package d22;

import java.util.Arrays;

public class Example1 {
    public static void main(String[] args) {
        // 아스키코드 : 영문, 숫자, 특수문자 (128문자를 표현하는 규칙, 7비트)
        // 유니코드 : 전세계 공용어 (한글 포함)
        char str1 = 'A';
        char[] str2 = {'유', '재', '석'};
        char str3 = 65;
        System.out.println(str3); // A
        char[] str4 = {74, 65, 86, 65};
        System.out.println(Arrays.toString(str4)); // [J, A, V, A]
        char str5 = '김';
        System.out.println((int)str5); // 44068

        // String 클래스
        String str6 = "유재석";
        String str7 = "유재석"; // 문자열이 같을 경우 동일한 객체로 취급
        String str8 = new String("유재석"); // new String 사용 시 문자열이 같아도 다른 객체로 취급
        System.out.println(str6 == str7); // true
        System.out.println(str6 == str8); // false
        System.out.println(str6.equals(str7)); // true
        System.out.println(str6.equals(str8)); // true
        // 문자는 불변 (수정할 수 없음)

        // A.concat(str) : 문자열 연결 메소드
        String str9 = "자바".concat("프로그램");
        System.out.println(str9);

        // StringBuilder : 문자열을 단계적으로 연결하는 메소드를 제공하는 클래스 (메모리 효율이 좋음)
        StringBuilder builder = new StringBuilder();
        builder.append("자바");
        builder.append("프로그램");
        System.out.println(builder);

        // String.format("%s", "String");
        String str10 = String.format("%s%s", "자바", "프로그램");
        System.out.println(str10);

        // 연결연산자
        String str11 = "";
        str11 += "자바";
        str11 += "프로그램";
        System.out.println(str11);

        // JDBC SQL
        String name = "유재석";
        String sql1 = "insert into table(name) values("+name+")"; // 비권장
        String sql2 = String.format("insert into table(name) values(%s)", name);
        String sql3 = "";
        sql3 += "insert into ";
        sql3 += "table(name) ";
        sql3 += "values("+name+")"; // 비권장
        StringBuilder sql4 = new StringBuilder();
        sql4.append("insert into table(name) ");
        sql4.append("values("+name+")");

        // .charAt(n) : 지정한 인덱스 번호의 문자 1개 반환 메소드
        char gender = "012345-1234567".charAt(7);
        System.out.println(gender); // 1
        // 문자 1개 입력 : scan.next().charAt(0)

        // .length() : 문자열 내 문자 수 반환 메소드
        System.out.println("012345-1234567".length()); // 14

        // .replace(aStr, bStr) : 지정한 문자열 내 기존 문자열(aStr)을 새로운 문자열(bStr)로 생성 후 반환 메소드
        // .replaceAll(aStr, bStr) : 해당하는 문자열을 모두 replace
        String str12 = "자바프로그램".replace("자바", "JAVA");
        System.out.println(str12); // JAVA프로그램
        // HTML의 <br/> 을 JAVA의 \n 으로 바꾸는 등으로 활용 가능
        String htmlData = "유재석<br/>안녕하세요";
        String newData = htmlData.replaceAll("<br/>", "\n");
        System.out.println(newData);

        // .substring(sIndex, [eIndex]) : 시작 인덱스부터 끝 인덱스까지 문자열 추출 (eIndex : 생략 가능, 없으면 끝까지)
        String str13 = "012345-1234567".substring(0, 6);
        System.out.println(str13); // 012345
        String str14 = "012345-1234567".substring(7);
        System.out.println(str14); // 1234567

        // .split(str) : 지정한 문자열 내 구분문자 기준으로 잘라서 배멸로 반환 메소드
        String[] str15 = "012345-1234567".split("-");
        System.out.println(str15[0]);
        System.out.println(str15[1]);
        // CSV 형식을 다룰 때 활용

        // .indexOf(str) : 지정한 문자열 내 찾을 문자열이 존재하면 찾은 인덱스, 없으면 -1 반환
        int findIndex = "자바 프로그래밍 언어".indexOf("프로");
        System.out.println(findIndex); // 3

        // .contains(str) : 지정한 문자열 내 찾을 문자열이 존재하면 true, 없으면 false 반환
        boolean findBool = "자바 프로그래밍 언어".contains("프로");
        System.out.println(findBool);

        // .getBytes() : 지정한 문자열을 byte[] 타입으로 반환 메소드
        byte[] str16 = "자바 프로그래밍 언어".getBytes();
        System.out.println(Arrays.toString(str16));
        String str17 = new String(str16);
        System.out.println(str17);
        // 파일 처리, 네트워크 등에 활용
    }
}
