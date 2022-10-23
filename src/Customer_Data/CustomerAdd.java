package Customer_Data;

import Store.Customer;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CustomerAdd {

    static boolean result = true;
    //public static int Num=0;
    //public static Customer[] customerlist = new Customer[Num];

    public static int Num = 11;
    public static Customer[] customerlist = {
            new Customer("bca",null,60,200000),
            new Customer("abc",null,55,150000),
            new Customer("A",null,0,0),
            new Customer("B",null,5,1000),
            new Customer("C",null,9,120000),
            new Customer("d",null,10,100000),
            new Customer("e",null,15,150000),
            new Customer("f",null,19,500000),
            new Customer("g",null,20,500000),
            new Customer("h",null,25,550000),
           new Customer("i",null,50,1000000)
    };


    //////////////고객 정보 추가////////////////////
    public static void addData(){
        int size = HowsizeAdd();
        CustomerAdd.listAdd(size);

        for (int i = 0; i<size;i++) {
            String name = null;
            String ID = null;
            int time = 0;
            int pay = 0;
            boolean result = true;

            while (result) {

                Scanner sc = new Scanner(System.in);
                System.out.println();
                System.out.println((i + 1) + "번째 손님 정보를 입력합니다.");
                int menu = selectMenu(); //메뉴 입력

                switch (menu) {
                    case 1:
                        System.out.println();
                        System.out.println((i + 1) + "번째 고객의 이름을 입력해주세요");
                        name = namerule();
                        break;
                    case 2:
                        System.out.println();
                        System.out.println((i + 1) + "번째 고객의 아이디를 입력해주세요");
                        ID = IDrule();
                        break;
                    case 3:
                        System.out.println();
                        System.out.println((i + 1) + "번째 고객의 사용시간을 입력해주세요");
                        time = timerule();
                        break;
                    case 4:
                        System.out.println();
                        System.out.println((i + 1) + "번째 고객의 사용금액을 입력해주세요");
                        pay = payrule();
                        break;
                    case 5:
                        System.out.println((i + 1) + "번째 고객의 정보 입력을 종료합니다.\n");
                        result = false;
                        break;
                    default:
                        System.out.println("다시 입력해 주세요.");

                }

            }
            customerlist[Num+i] = new Customer(name, ID,time, pay);


        }
        Num += size;
        System.out.println("정보 입력 완료.");
    }
    ////////////////////////////////////////////////////////////////
    private static int selectMenu() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            try {

                System.out.println("====================");
                System.out.println("1. 고객 이름 입력");
                System.out.println("2. 고객 ID 입력");
                System.out.println("3. 고객 사용 시간 입력");
                System.out.println("4. 고객 사용 금액 입력");
                System.out.println("5. 정보 입력 종료");
                System.out.println("====================");
                System.out.print("메뉴 선택: ");
                int menu = Integer.parseInt(sc.next());
                if (menu < 1) {
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

    ////////////////////////////////////////////////////////////////


    ////////////////////데이터 크기 늘리기/////////////////////////////
    public static void listAdd(int size) {

        if(size == 0){
            Customer_Menu.CustomerMainMenu();
        }

        Customer[] newCustomerList = new Customer[Num+size];
        for(int i =0;i<customerlist.length;i++){
            newCustomerList[i]=customerlist[i];
        }
        customerlist = newCustomerList;

    }
    //////////////////////////////////



    ////////////////사이즈입력////////////////
    public static int HowsizeAdd(){
        Scanner sc = new Scanner(System.in);
        while(true){
            try{
                System.out.println("==========================");
                System.out.println("몇명의 고객을 입력하시겠습니까?");
                System.out.println("종료하시려면 0을 입력해주세요");
                System.out.print("입력: ");
                int size = Integer.parseInt(sc.next());
                if(size<0){
                    throw new InputMismatchException();
                }return size;
            }catch (InputMismatchException e){
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

    /////////////이름 규칙/////////////////
    public static String namerule(){

        Scanner sc = new Scanner(System.in);
        while(true){
            try{
                String RULE = "^[a-zA-Z]{3,}$";
                System.out.println("3글자 이상 알파벳으로 입력해주세요");
                System.out.print("입력: ");
                String namerule = sc.next();
                if (namerule == null || namerule.equals(""))
                    throw new InputMismatchException();
                if (Pattern.matches(RULE, namerule)) {
                    return namerule;
                }
            }catch (InputMismatchException e){
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

    ////////////////아이디 규칙///////////////////////
    public static String IDrule(){
        Scanner sc = new Scanner(System.in);
        while(true){
            try{
                String RULE = "^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$";
                String RULENum= "^[0-9_]$";

                System.out.println("5 ~ 12 글자로 입력해주세요");
                System.out.println("알파벳 / 숫자 / _가능");
                System.out.print("입력: ");
                String idrule = sc.next();
                String first = String.valueOf(idrule.charAt(0));
                if(idrule == null || idrule.equals(""))
                    throw new InputMismatchException();
                if(Pattern.matches(RULENum,first) )
                    throw new InputMismatchException();
                if(Pattern.matches(RULE, idrule)) {
                    return idrule;
                }
            }catch (InputMismatchException e){
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

    /////////////////이용시간 규칙/////////////////////////
    public static int timerule(){
        Scanner sc = new Scanner(System.in);
        while(true){
            try{
                System.out.println("==========================");
                System.out.println("고객 이용 시간을 입력해주세요");
                System.out.print("입력: ");
                int time = Integer.parseInt(sc.next());
                if(time<1){
                    throw new InputMismatchException();
                }return time;
            }catch (InputMismatchException e){
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

    ///////////////////고객 사용 금액///////////////////////////
    public static int payrule(){
        Scanner sc = new Scanner(System.in);
        while(true){
            try{
                System.out.println("==========================");
                System.out.println("고객 사용 금액을 입력해주세요");
                System.out.print("입력: ");
                int pay = Integer.parseInt(sc.next());
                if(pay<1){
                    throw new InputMismatchException();
                }return pay;
            }catch (InputMismatchException e){
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


    public static Customer[] changeList(Customer[] arr){
        Num--;
        customerlist=null;
        customerlist = arr;
        return customerlist;
    }

    public static int getNum() {
        return Num;
    }
}
