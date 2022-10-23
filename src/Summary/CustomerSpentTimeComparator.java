package Summary;


import Store.Customer;

import java.util.Comparator;

public class CustomerSpentTimeComparator implements Comparator<Customer> {
    int sign = 1;

    public CustomerSpentTimeComparator(int isAscending) {
        sign *= isAscending;
    }

    @Override
    public int compare(Customer o1, Customer o2) {

        int customerTime1 = o1.getUsingTime();
        int customerTime2 = o2.getUsingTime();

        if (customerTime1 == customerTime2)
            return o1.getSerialNo().compareTo(o2.getSerialNo());
        else return sign * (customerTime1 - customerTime2);
    }
}