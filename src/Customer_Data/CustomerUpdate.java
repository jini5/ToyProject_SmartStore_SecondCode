package Customer_Data;
import java.util.InputMismatchException;
import java.util.Scanner;

import static Customer_Data.CustomerAdd.customerlist;
import static Customer_Data.Customer_Menu.CustomerMainMenu;

public class CustomerUpdate {
    public static int updateNo;

    public static void updateData() {
        if (customerlist.length == 0) {
            System.out.println("==================");
            System.out.println("고객 정보가 없습니다.");
            Customer_Menu.selectCustomerMenu();
        }
        Scanner sc = new Scanner(System.in);
        int updateNo = UpdateNo();
        System.out.println((updateNo + 1) + "번째 고객 정보 출력");
        System.out.println(customerlist[updateNo].showCustomer());
        selectUpdate();

    }

    public static int UpdateNo() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {

                System.out.println("=============================");
                System.out.println("몇 번째 고객을 수정하시겠습니까?");
                System.out.println("종료하시려면 0을 입력해주세요");
                System.out.print("입력: ");
                updateNo = Integer.parseInt(sc.next());
                updateNo= updateNo-1;
                if(updateNo == -1){
                    CustomerMainMenu();
                }
                if (updateNo < -1|| updateNo > customerlist.length) {
                    System.out.println("정보가 없습니다.");
                    throw new InputMismatchException();

                }
                return updateNo;
            }catch (InputMismatchException e) {
                System.out.println("다시 입력하세요");
            }catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("고객 정보가 없습니다.");
                CustomerMainMenu();
            }catch (NumberFormatException e ){
                System.out.println("다시 입력하세요");
            }
        }

    }





    // /////////////////

    public  static void selectUpdate(){
        Scanner sc = new Scanner(System.in);

        boolean result = true;

        while (result) {
            int menu = selectupdateMenu();
            try {
                if(menu == 1){
                System.out.println("수정할 이름을 작성해주세요");
                System.out.print("입력: ");
                String name = CustomerAdd.namerule();
                customerlist[updateNo].setCutomerName(name);
                break;
            }else if(menu ==2){
                System.out.println("수정할 ID를 작성해주세요");
                System.out.print("입력: ");
                String ID = CustomerAdd.IDrule();
                customerlist[updateNo].setCustomerID(ID);
                break;
            }
            else if(menu ==3){
                System.out.println("수정할 사용 시간을 작성해주세요");
                System.out.print("입력: ");
                int time = CustomerAdd.timerule();
                customerlist[updateNo].setUsingTime(time);
                break;
            }
            else if(menu ==4){
                System.out.println("수정할 사용 금액을 작성해주세요");
                System.out.print("입력: ");
                int pay = CustomerAdd.payrule();
                customerlist[updateNo].setTotalpay(pay);
                break;
            }
            else if(menu ==5){
                result = false;
                break;
            }
            System.out.println("다시 입력해주세요");

        }catch(InputMismatchException e) {
                System.out.println("다시 입력해주세요");
            }


    }

}

    private static int selectupdateMenu() {
        Scanner sc = new Scanner(System.in);
        while(true){
            try{
                System.out.println("==================");
                System.out.println("1. 고객 이름 수정");
                System.out.println("2. 고객 ID 수정");
                System.out.println("3. 고객 사용 시간 수정");
                System.out.println("4. 고객 사용 금액 수정");
                System.out.println("5. 뒤로가기");
                System.out.println("==================");
                System.out.print("입력: ");
                int menu = Integer.parseInt(sc.next());
                if(menu<0 || menu > 5){
                    throw new InputMismatchException();
                }return menu;
            }catch(NumberFormatException e){
                System.out.println("다시 입력하세요");
            }catch(InputMismatchException e){
                System.out.println("다시 입력하세요");
            }
        }
    }
}
