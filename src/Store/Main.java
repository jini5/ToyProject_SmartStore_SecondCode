package Store;

import Classification_Parameter.Classification_Menu;
import Customer_Data.Customer_Menu;
import Summary.SummaryMain;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] srgs){
        System.out.println("===========================================");
        System.out.println("제목: 스마트 스토어 고객 세분화 토이프로젝트");
        System.out.println("시작날짜 : 2022-10-07");
        System.out.println("Copyright 2022 Hyeonjin All rights reserved.");
        System.out.println("===========================================");
        System.out.println("\n");
        mainMenu();
    }








    //////////////////////////////////////////////////////////
    public static int selectMenu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("========================");
                System.out.println("1. 고객 분류");
                System.out.println("2. 고객 정보 관리");
                System.out.println("3. 요약");
                System.out.println("4. 프로그램 종료");
                System.out.println("========================");
                System.out.print("메뉴 선택: ");
                int menu = Integer.parseInt(sc.next());
                if (menu < 0 || menu > 4) {
                    throw new InputMismatchException();
                }
                return menu;
            } catch (InputMismatchException e) {
                System.out.println("다시 입력하세요");
                System.out.println();
            } catch (NumberFormatException e) {
                System.out.println("다시 입력하세요");
                System.out.println();
            } catch (NegativeArraySizeException e) {

                System.out.println("다시 입력하세요");
                System.out.println();
            }
        }
    }
    //////////////////////////////////////////////////////////
    public static void mainMenu() {

        int menu = selectMenu();
        switch (menu) {
            case 1:
                Classification_Menu.classifiCationMenu();
                break;
            case 2:
                Customer_Menu.CustomerMainMenu();
                break;
            case 3:
                SummaryMain.SummaryMenu();
                break;
            case 4:
                System.out.println("프로그램을 종료합니다.");
                break;
        }

    }


}


