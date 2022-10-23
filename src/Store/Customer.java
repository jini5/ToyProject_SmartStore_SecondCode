package Store;


import groups.Group;
import groups.Groups;
import groups.MemberGrade;

import java.util.Objects;

public class Customer {

/////////////////////////////////



    private MemberGrade memberGrade = MemberGrade.NONE;

    private Customers customers = Customers.getInstance();
    private Group[] groups = Groups.getInstance().getGroups();



    ///////////////////////////////
    private String serialNo;
    private String cutomerName;
    private String customerID;
    private int usingTime;
    private int totalpay;


    /////////////////////////////////////////

    private static int serialCnt = 0 ;


    public String getSerialNo() {
        return serialNo;
    }

    public String getCutomerName() {
        return cutomerName;
    }

    public void setCutomerName(String cutomerName) {
        this.cutomerName = cutomerName;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public int getUsingTime() {
        return usingTime;
    }

    public void setUsingTime(int usingTime) {
        this.usingTime = usingTime;
    }

    public int getTotalpay() {
        return totalpay;
    }

    public void setTotalpay(int pay) {
        this.totalpay = pay;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return getTotalpay() == customer.getTotalpay() && Objects.equals(getCutomerName(), customer.getCutomerName()) && Objects.equals(getCustomerID(), customer.getCustomerID()) && Objects.equals(getUsingTime(), customer.getUsingTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCutomerName(), getCustomerID(), getUsingTime(), getTotalpay());
    }




    public Customer(String cutomerName, String customerID, int usingTime, int pay) {
        serialCnt++;
        this.cutomerName = cutomerName;
        this.customerID = customerID;
        this.usingTime = usingTime;
        this.totalpay = pay;
        serialNo = String.format("%04d",serialCnt);


        int none_num = groups[0].getCustomer_num();
        groups[0].setCustomer_num(none_num + 1);
    }

    public String showCustomer(){
        String info = "serialNO:"+serialNo+", 고객 이름: "+cutomerName+", 고객 아이디: "+customerID+", 고객 사용 시간: "+usingTime+"시간, 고객 사용 총액: "
                +totalpay+"원 입니다.";
        return info;
    }

    public String showCustomerGroup(){
        String info = "serialNO:"+serialNo+", 고객 이름: "+cutomerName+", 고객 아이디: "+customerID+", 고객 사용 시간: "+usingTime+"시간, 고객 사용 총액: "
                +totalpay+"원, 등급: "+ memberGrade +"등급 입니다.";
        return info;
    }

//////////////////////////////////////
public MemberGrade getGroupType() {
    return memberGrade;
}

    public Group findGroup() {
        for (int i = 0; i < 4; i++) {
            if (groups[i].getGrade() == this.memberGrade) return groups[i];
        }
        return null;
    }
public void setMemberGrade() {
    Group now_group = findGroup();
    now_group.setCustomer_num(now_group.getCustomer_num() - 1);

    int general_time = groups[1].getParam().getSpentTime();
    int general_payment = groups[1].getParam().getTotalPayment();
    int vip_time = groups[2].getParam().getSpentTime();
    int vip_payment = groups[2].getParam().getTotalPayment();
    int vvip_time = groups[3].getParam().getSpentTime();
    int vvip_payment = groups[3].getParam().getTotalPayment();

    if (groups[3].isInitialized() && usingTime >= vvip_time && totalpay >= vvip_payment) {
        this.memberGrade = MemberGrade.VVIP;
        groups[3].setCustomer_num(groups[3].getCustomer_num() + 1);
    }

    else if (groups[2].isInitialized() && usingTime >= vip_time && totalpay >= vip_payment) {
        this.memberGrade = MemberGrade.VIP;
        groups[2].setCustomer_num(groups[2].getCustomer_num() + 1);
    }

    else if (groups[1].isInitialized() && usingTime >= general_time && totalpay >= general_payment) {
        this.memberGrade = MemberGrade.GENERAL;
        groups[1].setCustomer_num(groups[1].getCustomer_num() + 1);
    }

    else {
        this.memberGrade = MemberGrade.NONE;
        groups[0].setCustomer_num(groups[0].getCustomer_num() + 1);
    }
}

    @Override
    public String toString() {
        return "Customer{" +
                "memberType=" + memberGrade +
                ", serialNo='" + serialNo + '\'' +
                ", cutomerName='" + cutomerName + '\'' +
                ", customerID='" + customerID + '\'' +
                ", usingTime=" + usingTime +
                ", totalpay=" + totalpay +
                '}';
    }


}
