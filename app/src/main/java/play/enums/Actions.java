package play.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.HashMap;

@Getter
public enum Actions {
    ALL(new String[]{"all"}, "전체를 대상으로 설정"),
    EACH(new String[]{"each"}, "하나씩 유닛 컨트롤"),
    AUTO(new String[]{"auto"}, "자동 전투 진행"),
    ATTACK(new String[]{"attack", "at"}, "공격"),
    INFO(new String[]{"info", "i"}, "내 정보 확인"),
    ENEMY_INFO(new String[]{"enemy_info", "ei"}, "적 정보 확인"),
    SKILL(new String[]{"skill", "s"}, "스킬 사용"),
    DEFENSE(new String[]{"defense", "d"}, "방어"),
    ESCAPE(new String[]{"escape", "e"}, "도망"),
    QUIT(new String[]{"quit", "q"}, "종료"),
    HELP(new String[]{"help", "h"}, "도움말"),
    INVALID(new String[]{"invalid", "inv"}, "잘못된 명령"),
    ;
    private final String[] keys;
    private final String description;
    private static final HashMap<String, Actions> actions = new HashMap<>();

    Actions(String[] keys, String description) {
        this.keys = keys;
        this.description = description;
    }

    static {
        for (Actions action : Actions.values()) {
            for (String key : action.getKeys()) {
                actions.put(key, action);
            }
        }
    }

    public static Actions getAction(String key) {
        if (actions.containsKey(key)) return actions.get(key);
        return INVALID;
    }

    @Override
    public String toString() {
        return Arrays.toString(keys) + ":" + description;
    }
}
