package Exception;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Exception {
    public static int scannerInt(){
        int a;
        try{
            Scanner sc = new Scanner(System.in);
            a = sc.nextInt();
        }catch (InputMismatchException ime){
            a=-5;
        }
        return a;
    }
}
