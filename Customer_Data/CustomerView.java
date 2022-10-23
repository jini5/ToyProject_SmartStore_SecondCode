package Customer_Data;

import static Customer_Data.CustomerAdd.Num;
import static Customer_Data.CustomerAdd.customerlist;


public class CustomerView {

    public  static void viewData(){

        if(customerlist.length==0){
            System.out.println("고객의 정보가 없습니다.");
        }else{
            System.out.println("=========고객 정보=========");
            for(int i = 0; i< customerlist.length; i++){
                System.out.println(customerlist[i].showCustomer());
            }
            System.out.println("==============================");

        }

    }

    public  static  void viewToEdit(){
        System.out.println("==============================");
        int num = Num;
        for(int i=0;i<num;i++){
            System.out.println("NO: "+(i+1)+"  "+customerlist[i].showCustomer());
        }
        System.out.println("==============================");
    }

}
