/* [JAVA] 종합예제5 : boardService5 (생성자)
[ 목표 ] boardService4(종합예제4) 에서 객체 생성를 생성자로 변경 하시오.
[ 이하 조건 ] : boardService4 동일 */

package examples.ex_board.ex6;

import java.util.Scanner;

public class BoardService6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        for (;;) {
            System.out.println("============= My Community =============");
            System.out.println("  1.게시물쓰기 | 2.게시물출력");
            System.out.println("========================================");
            System.out.print("선택 > ");
            int num = scan.nextInt();

            if (num == 1) {
                System.out.print("작성자 : ");
                String writer = scan.next();
                System.out.print("내용 : ");
                String content = scan.next();

                boolean check = BoardController.doPost(content, writer);
                if (check) System.out.println("[안내] 글쓰기 성공");
                else System.out.println("[경고] 게시물을 등록할 공간이 부족합니다.");
            } else if (num == 2) {
                System.out.println("============= 게시물 목록 =============");
                Board[] boards = BoardController.doGet();
                for (int i=0; i<boards.length; i++) {
                    if (boards[i] != null) {
                        System.out.println("작성자 : " + boards[i].getWriter());
                        System.out.println("내용 : " + boards[i].getContent());
                        System.out.println("------------------------------------");
                    } else break;
                }
            }
        }
    }
}
