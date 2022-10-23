package Store;

import Summary.CustomerNameComparator;
import Summary.CustomerSpentTimeComparator;
import Summary.CustomerTotalPaymentComparator;
import groups.Group;
import groups.Groups;

import java.util.Arrays;

import static Customer_Data.CustomerAdd.Num;
import static Customer_Data.CustomerAdd.customerlist;

public class Customers {
    private static Customer[] customers = new Customer[0];

    private static int customerNum = 0;

    static Group[] groups = Groups.getInstance().getGroups();

    private static final Customers CUSTOMERS = new Customers(); // 싱글톤 패턴

    private Customers() {

    }

    public static Customers getInstance() {
        return CUSTOMERS;
    }


    /**
     * 고객 목록 정렬, 출력
     */

    // 이름순 정렬
    public static void sortByCustomerName(int isAscending) {
        if (isAscending == 0) return;
        Customer[] temp = new Customer[Num];
        System.arraycopy(customerlist, 0, temp, 0, Num);
        new CustomerNameComparator(isAscending);
        Arrays.sort(temp, new CustomerNameComparator(isAscending));
        printCustomerSummary(temp);
    }

    // 총 이용시간순 정렬
    public static void sortByCustomerSpentTIme(int isAscending) {
        if (isAscending == 0) return;
        Customer[] temp = new Customer[Num];
        System.arraycopy(customerlist, 0, temp, 0, Num);

        Arrays.sort(temp, new CustomerSpentTimeComparator(isAscending));
        printCustomerSummary(temp);
    }

    // 총 결제금액순 정렬
    public static void sortByCustomerTotalPayment(int isAscending) {
        if (isAscending == 0) return;
        Customer[] temp = new Customer[Num];
        System.arraycopy(customerlist, 0, temp, 0, Num);

        Arrays.sort(temp, new CustomerTotalPaymentComparator(isAscending));
        printCustomerSummary(temp);
    }

    public static void printCustomerSummary(Customer[] customerlist) {
        for (Group group : groups) {
            String label = group.getGrade().getLabel();
            System.out.println("==============================");
            System.out.println(label + " 그룹 : " + group.getCustomer_num() + "명");
            if (group.isInitialized()) System.out.println("[조건] " + group.getParam());
            else System.out.println("[조건] 아직 존재하지 않습니다." );
            for (Customer customer : customerlist) {
                if (customer.getGroupType() == group.getGrade()) System.out.println(customer);
            }
            System.out.println("");
        }
    }



    /**
     * getter, setter
     */

    public static Customer[] getCustomers() {
        return customerlist;
    }

    public static void setCustomers_memberGrade() {
        for (Customer customer : customerlist)
            customer.setMemberGrade();
    }

}
