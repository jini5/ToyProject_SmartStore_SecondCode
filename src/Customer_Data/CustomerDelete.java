package Customer_Data;

import Store.Customer;

import java.util.InputMismatchException;
import java.util.Scanner;

import static Customer_Data.CustomerAdd.Num;
import static Customer_Data.CustomerAdd.customerlist;
import static Customer_Data.CustomerView.viewToEdit;


public class CustomerDelete {
    public static int deleteNum;

    public static void deleteData() {
        viewToEdit();
        int num = Num;
        if (num >= 1) {
            System.out.println("몇번째 고객의 정보를 삭제 하시겠습니까?\n(1~" + num + ")");
            System.out.print("취소하시려면 0을 입력해주세요.");
            deleteNum = scannerInt() - 1;
            if (deleteNum >= 0 && deleteNum <= (num - 1)) {
                System.out.println("대상 고객의 정보를 삭제합니다.");
                delete();
            } else if (deleteNum == -1) {
                System.out.println("삭제를 취소합니다.");
            } else {
                System.out.println("옳바르지 않은 입력입니다. 다시 입력해주세요.");
                deleteData();
            }
        } else {
            System.out.println("고객의 정보가 없습니다.");
        }
    }

    public static void delete() {
        Customer[] deletelist = new Customer[(Num - 1)];
        for (int i = 0; i < deleteNum; i++) {
            deletelist[i] = customerlist[i];
        }
        for (int i = deleteNum; i < (Num - 1); i++) {
            deletelist[i] = customerlist[i + 1];
        }
        CustomerAdd.changeList(deletelist);
        System.out.println("성공적으로 삭제되었습니다.");
    }


    public static int scannerInt() {
        int a;
        try {
            Scanner sc = new Scanner(System.in);
            a = sc.nextInt();
        } catch (InputMismatchException ime) {
            a = -5;
        }
        return a;
    }


}