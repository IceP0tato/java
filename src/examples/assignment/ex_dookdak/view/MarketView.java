package examples.assignment.ex_dookdak.view;

import examples.assignment.ex_dookdak.controller.ProductController;
import examples.assignment.ex_dookdak.controller.QuestionController;
import examples.assignment.ex_dookdak.model.dto.ProductDto;
import examples.assignment.ex_dookdak.model.dto.QuestionDto;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MarketView {
    private MarketView() {}
    private static final MarketView instance = new MarketView();
    public static MarketView getInstance() {
        return instance;
    }
    private ProductController pController = ProductController.getInstance();
    private QuestionController qController = QuestionController.getInstance();
    private Scanner scan = new Scanner(System.in);

    // Start
    public void index() {
        for (;;) {
            System.out.println("\n========================== 뚝딱마켓 ==========================");
            System.out.println("1. 중고 물품 등록    | 2. 전체 물품 목록 조회 | 3. 물품 정보 수정 | 4. 등록 물품 삭제");
            System.out.println("5. 익명 문의 남기기 | 6. 물품 상세 조회        | 7. 등록 랭킹 조회 | 8. 검색 조회");
            System.out.println("===========================================================");
            System.out.print("메뉴를 선택해주세요 > ");
            int select = scan.nextInt();

            if (select == 1) addProduct();
            else if (select == 2) viewProduct();
            else if (select == 3) updateProduct();
            else if (select == 4) deleteProduct();
            else if (select == 5) addQuestion();
            else if (select == 6) detailProduct();
            else if (select == 7) viewRanking();
            else if (select == 8) searchProduct();
            else {
                System.out.println("[경고] 존재하지 않는 기능입니다.");
            }
        }
    }

    // 중고 물품 등록
    private void addProduct() {
        System.out.println("======================== 중고 물품 등록 ========================");
        System.out.println("물품 등록에 앞서, 사용자 정보와 물품 정보를 입력받도록 하겠습니다.");
        try {
            System.out.print("닉네임을 입력해주세요 > ");
            scan.nextLine();
            String pUser = scan.nextLine();
            System.out.print("물품의 이름을 입력해주세요 > ");
            String pName = scan.nextLine();
            System.out.print("물품의 설명을 입력해주세요 > ");
            String pDesc = scan.nextLine();
            System.out.print("가격은 어느 정도로 하시겠어요? (숫자로만 입력해주세요) > ");
            int pPrice = scan.nextInt();
            System.out.print("비밀번호를 입력해주세요 (물품 정보 수정 및 삭제에 사용됩니다) > ");
            scan.nextLine();
            String pPw = scan.nextLine();

            // 입력되지 않은 내용 검사
            if (pUser.isEmpty() || pName.isEmpty() || pDesc.isEmpty() || pPw.isEmpty()) {
                System.out.println("[경고] 잘못 입력되었거나 입력되지 않은 내용이 있습니다. 다시 시도해주세요.");
                return;
            }
            pController.addProduct(pUser, pName, pDesc, pPrice, pPw);
            System.out.println("\n[안내] 물품이 등록되었습니다.");
        } catch (InputMismatchException e) {
            System.out.println("[경고] 잘못 입력되었거나 입력되지 않은 내용이 있습니다. 다시 시도해주세요.");
            scan = new Scanner(System.in);
        } catch (Exception e) {
            System.out.println("[경고] 알 수 없는 오류가 발생하였습니다. 관리자에게 문의해주세요.");
            throw new RuntimeException(e);
        }
    }

    // 전체 물품 목록 조회
    private void viewProduct() {
        System.out.println("========================== 물품 목록 ==========================");
        ArrayList<ProductDto> list = pController.viewProduct();
        for (ProductDto dto : list) {
            System.out.printf("%d. %s 님이 등록한 %s (%d원, %s) - %s 등록\n",
                    dto.getpId(), dto.getpUser(), dto.getpName(), dto.getpPrice(), dto.isSold()?"판매완료":"판매중", dto.getpDate());
        }
        System.out.println("============================================================");
    }

    // 물품 정보 수정
    private void updateProduct() {
        System.out.println("======================== 물품 정보 수정 ========================");
        try {
            System.out.print("수정하고 싶은 물품의 번호를 입력해주세요 > ");
            int pId = scan.nextInt();
            System.out.print("물품 등록 시에 작성했던 비밀번호를 입력해주세요 > ");
            scan.nextLine();
            String pPw = scan.nextLine();

            // pId, pPw 일치 여부 검사
            int check = pController.checkProduct(pId, pPw);
            if (check == 1) {
                System.out.println("[경고] 존재하지 않는 물품 번호입니다.");
                return;
            } else if (check == 2) {
                System.out.println("[경고] 비밀번호가 일치하지 않습니다.");
                return;
            }
            System.out.println("-------------------------------------------------------------------------------------------------------");
            // 판매 여부 검사 (isSold)
            System.out.print("혹시 판매가 완료되셨나요? (예/아니요) > ");
            String isSold = scan.nextLine();
            if (isSold.equals("예")) {
                pController.updateProduct(pId);
                System.out.println("\n[안내] 물품 정보가 수정되었습니다.");
            } else if (isSold.equals("아니요")) {
                System.out.print("물품의 이름을 입력해주세요 > ");
                String pName = scan.nextLine();
                System.out.print("물품의 설명을 입력해주세요 > ");
                String pDesc = scan.nextLine();
                System.out.print("가격은 어느 정도로 하시겠어요? (숫자로만 입력해주세요) > ");
                int pPrice = scan.nextInt();

                // 입력되지 않은 내용 검사
                if (pName.isEmpty() || pDesc.isEmpty()) {
                    System.out.println("[경고] 잘못 입력되었거나 입력되지 않은 내용이 있습니다. 다시 시도해주세요.");
                    return;
                }
                pController.updateProduct(pId, pName, pDesc, pPrice);
                System.out.println("\n[안내] 물품 정보가 수정되었습니다.");
            } else {
                System.out.println("[경고] 잘못 입력되었거나 입력되지 않은 내용이 있습니다. 다시 시도해주세요.");
            }
        } catch (InputMismatchException e) {
            System.out.println("[경고] 잘못 입력되었거나 입력되지 않은 내용이 있습니다. 다시 시도해주세요.");
            scan = new Scanner(System.in);
        } catch (Exception e) {
            System.out.println("[경고] 알 수 없는 오류가 발생하였습니다. 관리자에게 문의해주세요.");
            throw new RuntimeException(e);
        }
    }

    // 등록 물품 삭제
    private void deleteProduct() {
        System.out.println("======================== 등록 물품 삭제 ========================");
        try {
            System.out.print("수정하고 싶은 물품의 번호를 입력해주세요 > ");
            int pId = scan.nextInt();
            System.out.print("물품 등록 시에 작성했던 비밀번호를 입력해주세요 > ");
            scan.nextLine();
            String pPw = scan.nextLine();

            // pId, pPw 일치 여부 검사
            int check = pController.checkProduct(pId, pPw);
            if (check == 1) {
                System.out.println("[경고] 존재하지 않는 물품 번호입니다.");
                return;
            } else if (check == 2) {
                System.out.println("[경고] 비밀번호가 일치하지 않습니다.");
                return;
            }
            System.out.println("-------------------------------------------------------------------------------------------------------");
            System.out.println("선택한 물품이 목록에서 영구적으로 삭제되며, 복구할 수 없습니다.");
            System.out.print("정말로 삭제하시겠습니까? (예/아니요) > ");
            String delete = scan.nextLine();
            if (delete.equals("예")) {
                pController.deleteProduct(pId);
                System.out.println("\n[안내] 물품 정보가 삭제되었습니다.");
            } else if (delete.equals("아니요")) {
                return;
            } else {
                System.out.println("[경고] 잘못 입력되었거나 입력되지 않은 내용이 있습니다. 다시 시도해주세요.");
            }
        } catch (InputMismatchException e) {
            System.out.println("[경고] 잘못 입력되었거나 입력되지 않은 내용이 있습니다. 다시 시도해주세요.");
            scan = new Scanner(System.in);
        } catch (Exception e) {
            System.out.println("[경고] 알 수 없는 오류가 발생하였습니다. 관리자에게 문의해주세요.");
            throw new RuntimeException(e);
        }
    }

    // 익명 문의 남기기
    private void addQuestion() {
        System.out.println("========================== 익명 문의 ==========================");
        System.out.println("구매하고 싶은 물품이 있으나, 판매자에게 문의를 남기고 싶다면 이용해주세요.");
        try {
            System.out.print("구매하고 싶은 물품의 번호를 입력해주세요 > ");
            int pId = scan.nextInt();
            // 물품 존재 여부 검사
            boolean ExistPid = pController.checkProduct(pId);
            if (!ExistPid) {
                System.out.println("[경고] 존재하지 않는 물품 번호입니다.");
                return;
            }

            System.out.print("문의하는 분의 닉네임을 입력해주세요 > ");
            scan.nextLine();
            String qUser = scan.nextLine();
            System.out.print("내용을 남겨주세요 > ");
            String qDesc = scan.nextLine();
            System.out.print("비밀번호를 입력해주세요 (추후 문의 내용 수정 및 삭제에 사용됩니다) > ");
            String qPw = scan.nextLine();

            qController.addQuestion(pId, qUser, qDesc, qPw);
            System.out.println("\n[안내] 문의 내용이 등록되었습니다.");
        } catch (InputMismatchException e) {
            System.out.println("[경고] 잘못 입력되었거나 입력되지 않은 내용이 있습니다. 다시 시도해주세요.");
            scan = new Scanner(System.in);
        } catch (Exception e) {
            System.out.println("[경고] 알 수 없는 오류가 발생하였습니다. 관리자에게 문의해주세요.");
            throw new RuntimeException(e);
        }
    }

    // 물품 상세 조회
    private void detailProduct() {
        System.out.println("========================== 상세 조회 ==========================");
        System.out.println("특정 물품 및 문의 내용을 더 자세히 확인하고 싶을 때 사용하는 메뉴입니다.");
        try {
            System.out.print("확인하고 싶은 물품의 번호를 입력해주세요 > ");
            int pId = scan.nextInt();
            // 물품 존재 여부 검사
            boolean check = pController.checkProduct(pId);
            if (!check) {
                System.out.println("[경고] 존재하지 않는 물품 번호입니다.");
                return;
            }

            ProductDto product = pController.viewProduct(pId);
            ArrayList<QuestionDto> questionList = qController.detailProduct(pId);
            System.out.println("========================== 물품 정보 ==========================");
            System.out.printf("%d. %s 님이 등록한 %s (%d원, %s) - %s 등록\n",
                    product.getpId(), product.getpUser(), product.getpName(), product.getpPrice(), product.isSold()?"판매완료":"판매중", product.getpDate());
            System.out.printf("%s\n\n", product.getpDesc());
            System.out.println("문의 내용");
            int count = 0;
            for (QuestionDto dto : questionList) {
                System.out.printf("%d. %s : %s\n", ++count, dto.getqUser(), dto.getqDesc());
            }
            System.out.println("============================================================");
        } catch (InputMismatchException e) {
            System.out.println("[경고] 잘못 입력되었거나 입력되지 않은 내용이 있습니다. 다시 시도해주세요.");
            scan = new Scanner(System.in);
        } catch (Exception e) {
            System.out.println("[경고] 알 수 없는 오류가 발생하였습니다. 관리자에게 문의해주세요.");
            throw new RuntimeException(e);
        }
    }

    // 등록 랭킹 조회
    private void viewRanking() {
        System.out.println("========================== 등록 랭킹 ==========================");
        System.out.println("가장 많은 물품을 등록한 '열혈 사용자' TOP 10");
        ArrayList<ProductDto> list = pController.viewRanking();
        for (int i=0; i<=9; i++) {
            ProductDto dto = list.get(i);
            System.out.printf("%d. %s - %d회\n", i+1, dto.getpUser(), dto.getCount());
        }
        System.out.println("============================================================");
    }

    // 검색 조회 (FIXME)
    private void searchProduct() {
        System.out.println("========================== 검색 조회 ==========================");
        System.out.print("찾고 싶은 물품을 입력해주세요 > ");
        scan.nextLine();
        String search = scan.nextLine();

        ArrayList<ProductDto> list = pController.searchProduct(search);
        if (list.get(0).getpId() == -1) {
            System.out.println("\n[안내] 존재하지 않는 물품입니다.");
            return;
        }
        System.out.println("========================== 물품 목록 ==========================");
        for (ProductDto dto : list) {
            System.out.printf("%d. %s 님이 등록한 %s (%d원, %s) - %s 등록\n",
                    dto.getpId(), dto.getpUser(), dto.getpName(), dto.getpPrice(), dto.isSold()?"판매완료":"판매중", dto.getpDate());
        }
        System.out.println("============================================================");
    }
}
