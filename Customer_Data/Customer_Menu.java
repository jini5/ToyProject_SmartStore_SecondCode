package Customer_Data;

import Store.Main;

import java.util.Scanner;


public class Customer_Menu {


    /////////////////////////////////////////////
    public static void CustomerMainMenu(){
        System.out.println("");
        System.out.println("==============================");
        System.out.println(" 1. 고객 정보 추가");
        System.out.println(" 2. 고객 정보 보기");
        System.out.println(" 3. 고객 정보 수정");
        System.out.println(" 4. 고객 정보 삭제");
        System.out.println(" 5. 메인메뉴");
        System.out.println("==============================");
        System.out.print("메뉴를 선택해주세요:");
        selectCustomerMenu();
    }


    /////////////////메뉴////////////////////////
    public static void selectCustomerMenu() {
        Scanner sc = new Scanner(System.in);
        String menuNum = sc.next();
        boolean status = false;
        switch (menuNum) {
            case "1":
                CustomerAdd.addData();
                break;
            case "2":
                System.out.println("고객 정보를 출력합니다.");
                CustomerView.viewData();
                break;
            case "3":
                System.out.println("고객 정보를 변경합니다.");
                CustomerUpdate.updateData();
                break;
            case "4":
                System.out.println("고객 정보를 삭제합니다.");
                CustomerDelete.deleteData();
                break;
            case "5":
                System.out.println("메인메뉴로 돌아갑니다.");
                status = true;
                break;
            default:
                System.out.println("올바른 형식이 아닙니다. 다시 입력해 주세요.");
                selectCustomerMenu();
                break;
        }
        if (status) {
            Main.mainMenu();
        } else if (!status) {
            CustomerMainMenu();
        }
    }
}
