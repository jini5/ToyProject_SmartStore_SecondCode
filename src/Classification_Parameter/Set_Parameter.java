package Classification_Parameter;

import Store.Customers;
import groups.MemberGrade;

import java.util.Locale;

import static Classification_Parameter.Classification_Menu.*;


public class Set_Parameter {
    public static void setParameter() { // GradeMenu 1번 - 분류 기준 초기 설정
        while (true) {
            String input = selectGrade().toUpperCase(Locale.ROOT);
            if (input.equals("END")) return;

            if (input.equals("GENERAL") || input.equals("VIP") || input.equals("VVIP")) {
                MemberGrade memberGrade = null;

                for (MemberGrade mg : MemberGrade.values()) {
                    if (mg.name().equals(input)) memberGrade = mg;
                }

                if (isGradeExist(memberGrade)) {
                    System.out.println("해당 등급 분류 기준이 이미 존재합니다.\n");
                    continue;
                }
                groups[memberGrade.getIndex()].setInitialized(true);
                Customers.setCustomers_memberGrade();
                selectParameter(memberGrade);
            } else {
                System.out.println("다시 입력하세요.");
            }
        }
    }

}



