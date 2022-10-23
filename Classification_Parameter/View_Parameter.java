package Classification_Parameter;

import groups.Group;
import groups.Groups;
import groups.MemberGrade;

import java.util.Locale;

import static Classification_Parameter.Classification_Menu.isGradeExist;
import static Classification_Parameter.Classification_Menu.selectGrade;

public class View_Parameter {

    static Group[] groups = Groups.getInstance().getGroups();



    public static void viewParameter() {
        while (true) {
            String input = selectGrade().toUpperCase(Locale.ROOT);
            if (input.equals("END")) return;

            if (input.equals("GENERAL") || input.equals("VIP") || input.equals("VVIP")) {
                MemberGrade memberGrade = null;

                for (MemberGrade mg : MemberGrade.values()) {
                    if (mg.name().equals(input)) memberGrade = mg;
                }

                if (!isGradeExist(memberGrade)) {
                    System.out.println("해당 등급 분류 기준이 존재하지 않습니다.\n");
                    continue;
                }

                Group group = groups[memberGrade.getIndex()];
                System.out.println("[그룹] " + memberGrade.getLabel());
                System.out.println("이용 시간 : " + group.getParam().getSpentTime());
                System.out.println("사용 금액 : " + group.getParam().getTotalPayment() + "\n");
            } else {
                System.out.println("다시 입력하세요.\n");
            }
        }
    }





}
