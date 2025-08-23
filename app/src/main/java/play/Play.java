package play;


import play.enums.Actions;
import skill.SkillBox;
import skill.enums.Skills;

import java.util.Scanner;

public class Play {
    public static Scanner scanner = new Scanner(System.in);

    public static Actions readAction(ActionGroup possibleActions) {
        while (true) {
            println("사용가능한 명령어는 다음과 같습니다.");
            println(possibleActions.toString());
            print("명령어를 입력하세요: ");
            Actions action = possibleActions.getAction(scanner.nextLine());
            if (action == Actions.INVALID) Play.println("할 수 없는 명령입니다.");
            else return action;
        }
    }

    public static Actions readAction() {
        while (true) {
            print("명령어를 입력하세요: ");
            Actions action = Actions.getAction(scanner.nextLine());
            if (action == Actions.INVALID) Play.println("할 수 없는 명령입니다.");
            else return action;
        }
    }

    public static Skills readSkill() {
        while (true) {
            print("사용할 스킬 키를 입력하세요: ");
            String skillKey = scanner.nextLine();
            Skills skill = Skills.getSkillByKey(skillKey);
            if (skill == Skills.INVALID) Play.println("존재하지 않는 스킬입니다.");
            else return skill;
        }
    }

    public static Skills readSkill(SkillBox skillBox) {
        while (true) {
            println("선택 가능한 스킬은 다음과 같습니다");
            println(skillBox.availableSkillToString());
            print("사용할 스킬을 선택하세요: ");
            String skillKey = scanner.nextLine();
            Skills skill = skillBox.getAvailableSkillByKey(skillKey);
            if (skill == Skills.INVALID) Play.println("사용할 수 없는 스킬입니다.");
            else return skill;
        }
    }

    public static String readString() {
        return scanner.nextLine();
    }

    public static int readInt(int min, int max) {
        String input;
        int result;
        while (true) {
            println("선택할 수 있는 옵션 범위는 " + min + "부터 " + max + "까지입니다.");
            print("선택할 옵션 번호를 입력하세요: ");
            input = scanner.nextLine();
            try {
                result = Integer.parseInt(input);
                if (result < min || result > max) {
                    Play.println("범위 내의 숫자를 입력하세요.");
                } else {
                    return result;
                }
            } catch (NumberFormatException e) {
                Play.println("올바른 숫자를 입력하세요.");
            }
        }
    }

    public static int readInt() {
        print("선택할 옵션 번호를 입력하세요: ");
        String input;
        while (true) {
            input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                Play.println("올바른 숫자를 입력하세요.");
            }
        }
    }

    public static void println(String message) {
        System.out.println(message);
    }

    public static void print(String message) {
        System.out.print(message);
    }
}
