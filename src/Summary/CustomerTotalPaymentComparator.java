package Summary;
import Store.Customer;

import java.util.Comparator;

public class CustomerTotalPaymentComparator implements Comparator<Customer> {
    int sign = 1;

    public CustomerTotalPaymentComparator(int isAscending) {
        sign *= isAscending;
    }

    @Override
    public int compare(Customer o1, Customer o2) {

        int customerPayment1 = o1.getTotalpay();
        int customerPayment2 = o2.getTotalpay();

        if (customerPayment1 == customerPayment2)
            return o1.getSerialNo().compareTo(o2.getSerialNo());
        else return sign * (customerPayment1 - customerPayment2);
    }
}
