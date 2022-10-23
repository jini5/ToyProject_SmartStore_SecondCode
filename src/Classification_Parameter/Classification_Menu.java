package Classification_Parameter;

import Exception.Exception;
import Exception.InputRangeException;
import Store.Customers;
import Store.Main;
import groups.Group;
import groups.Groups;
import groups.MemberGrade;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Classification_Menu {
    static Group[] groups = Groups.getInstance().getGroups();

    public static void classifiCationMenu(){
        int menu = classifiCationSelect();
        boolean status=false;
        switch (menu){
            case 1:
                //Set_Parameter.settingParameter();//분류기준 설정
                Set_Parameter.setParameter();
                break;
            case 2:
                //Update_Parameter.updateParameter();//분류기준 수정
                View_Parameter.viewParameter();
                break;
            case 3:
                //View_Parameter.viewParameter();//분류기준 출력
                Update_Parameter.editParameter();
                break;
            case 4:
                status = true;
                break;
        }

        if(status){
            Main.mainMenu();
        }else if(!status){
            classifiCationMenu();
        }

    }


    public static int classifiCationSelect(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println();
                System.out.println("==============================");
                System.out.println(" 1. 분류기준 설정");
                System.out.println(" 2. 분류기준 확인");
                System.out.println(" 3. 분류기준 수정");
                System.out.println(" 4. 뒤로가기");
                System.out.println("==============================");
                System.out.print("메뉴 선택: ");
                int select = Exception.scannerInt();
                if (select < 1 || select > 4)
                    throw new InputRangeException();
                return select;
            } catch (NumberFormatException e) {
                System.out.println("다시 입력하세요.");
            } catch (InputRangeException e) {
                System.out.println("다시 입력하세요.");
            }
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////


    public static String selectGrade() {
        Scanner sc = new Scanner(System.in);
        int menu =selectmenu();

        String input;
        if(menu == 1){
            input = "GENERAL";
            return input;
        }else if(menu == 2){
            input = "VIP";
            return input;
        }else if(menu == 3){
            input = "VVIP";
            return input;
        }else if(menu == 4){
            input ="end";
            return input;
        }

        return null;
    }

    public static int selectmenu(){
        while (true) {
            Scanner sc = new Scanner(System.in);
            try {

                System.out.println("** 등급을 선택하세요. **");
                System.out.println("1. GENERAL");
                System.out.println("2. VIP");
                System.out.println("3. VVIP");
                System.out.println("4. 뒤로가기");
                System.out.println("====================");
                System.out.print("메뉴 선택: ");
                int menu = Integer.parseInt(sc.next());
                if (menu < 1 || menu>4) {
                    throw new InputMismatchException();
                }
                return menu;
            } catch (InputMismatchException e) {
                System.out.println("==========================");
                System.out.println("다시 입력하세요");
            } catch (NumberFormatException e) {
                System.out.println("==========================");
                System.out.println("다시 입력하세요");
            } catch (NegativeArraySizeException e) {
                System.out.println("==========================");
                System.out.println("다시 입력하세요");
            }
        }

    }



    public static void selectParameter(MemberGrade memberGrade) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("==============================");
            System.out.println("1. 최소 이용 시간");
            System.out.println("2. 최소 결제 금액");
            System.out.println("3. 돌아가기");
            System.out.println("==============================");

            int input = sc.nextInt();
            System.out.println();

            if (input == 1) { // 시간
                while (true) {
                    try {
                        editSpentTime(groups[memberGrade.getIndex()]);
                        Customers.setCustomers_memberGrade();
                        break;
                    } catch (InputMismatchException inputMismatchException) {
                        System.out.println("0 이상의 정수를 입력해주세요.\n");
                    }
                }
            } else if (input == 2) { // 금액
                while (true) {
                    try {
                        editTotalPayment(groups[memberGrade.getIndex()]);
                        Customers.setCustomers_memberGrade();
                        break;
                    } catch (InputMismatchException inputMismatchException) {
                        sc = new Scanner(System.in);
                        System.out.println("0 이상의 정수를 입력해주세요.\n");
                    } catch (InputRangeException e) {
                        System.out.println("다시 입력하세요.");
                    }
                }
            } else if (input == 3) { // 나가기
                return;
            } else {
                System.out.println("다시 입력하세요.\n");
            }
        }
    }

    public static boolean isGradeExist(MemberGrade memberGrade) {
        if (groups[memberGrade.getIndex()].isInitialized()) return true;
        else return false;
    }

    public static void editSpentTime(Group group) throws InputRangeException, InputMismatchException {
        Scanner sc = new Scanner(System.in);
        System.out.print(group.getGrade().getLabel() + "등급의 최소 사용 시간을 입력하세요 : ");
        int time = sc.nextInt();
        System.out.println();
        group.getParam().setSpentTime(time);
    }

    public static void editTotalPayment(Group group) throws InputRangeException, InputMismatchException{
        Scanner sc = new Scanner(System.in);
        System.out.print(group.getGrade().getLabel() + "등급의 최소 사용 금액을 입력하세요 : ");
        int money = sc.nextInt();
        System.out.println();
        group.getParam().setTotalPayment(money);
    }

}
