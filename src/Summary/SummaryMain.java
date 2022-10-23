package Summary;

import Store.Customers;
import Store.Main;

import java.util.InputMismatchException;
import java.util.Scanner;

import static Exception.Exception.scannerInt;


public class SummaryMain {
    public static void SummaryMenu(){
        boolean result = true;

        while(result){
            int menu = selectMenu();
            switch (menu) {
                case 1:
                    //CustomerView.viewData();;
                    Customers.printCustomerSummary(Customers.getCustomers());
                    break;
                case 2:
                    Customers.sortByCustomerName(isAscending());//이름
                    break;
                case 3:
                    Customers.sortByCustomerSpentTIme(isAscending());//시간
                    break;
                case 4:
                    Customers.sortByCustomerTotalPayment(isAscending());//금액
                    break;
                case 5:
                    System.out.println("뒤로가기");
                    result =false;
                    Main.mainMenu();
                    break;
            }
        }

    }




    private static int selectMenu() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            try {

                System.out.println("====================");
                System.out.println("1. 등록 순으로 보기");
                System.out.println("2. 이름 순으로 보기");
                System.out.println("3. 사용 시간 순으로 보기");
                System.out.println("4. 사용 금액 순으로 보기");
                System.out.println("5. 뒤로가기");
                System.out.println("====================");
                System.out.print("메뉴 선택: ");
                int menu = Integer.parseInt(sc.next());
                if(menu<0 || menu > 5){
                    throw new InputMismatchException();
                }return menu;
            }catch(InputMismatchException e){
                System.out.println("==========================");
                System.out.println("다시 입력하세요");
            }catch(NumberFormatException e){
                System.out.println("==========================");
                System.out.println("다시 입력하세요");
            }catch (NegativeArraySizeException e){
                System.out.println("==========================");
                System.out.println("다시 입력하세요");
            }
        }
    }


    public static int isAscending(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("\'0\'을 입력하면 메뉴로 되돌아갑니다.");
            System.out.print("어떤 순서로 정렬하시겠습니까? \n" +
                    "1: 오름차순(ASCENDING)\n" +
                    "2: 내림차순(DESCENDING)\n" +
                    "입력: ");

            int input = scannerInt();
            System.out.println();

            if(input == 0){
                return 0;
            }else if(input==1){
                return 1;
            }else if(input ==2){
                return -1;
            }else {
                System.out.println("다시 입력해주세요");
            }

        }
    }





}
