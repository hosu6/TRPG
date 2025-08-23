package skill.enums;

import lombok.Getter;

import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Getter
public enum Skills {
    BASIC_ATTACK("기본공격", "basic_attack", "기본공격", SkillTypes.DAMAGE, SkillAttribute.PHYSICAL, 10,
            createUnmodifiableMap(10, i -> i),
            createUnmodifiableMap(10, i -> 0),
            createUnmodifiableMap(10, i -> 0),
            createUnmodifiableMap(10, i -> 0),
            createUnmodifiableMap(10, i -> 0),
            createUnmodifiableMap(10, i -> 1),
            createUnmodifiableMap(10, i -> 1),
            createUnmodifiableMap(10, i -> 1)),
    HARD_ATTACK("강타", "hard_attack", "무기를 강하게 사용하는 공격", SkillTypes.DAMAGE, SkillAttribute.PHYSICAL, 10,
            createUnmodifiableMap(10, i -> 2 * i),
            createUnmodifiableMap(10, i -> 0),
            createUnmodifiableMap(10, i -> i),
            createUnmodifiableMap(10, i -> 1),
            createUnmodifiableMap(10, i -> 0),
            createUnmodifiableMap(10, i -> 2),
            createUnmodifiableMap(10, i -> 1),
            createUnmodifiableMap(10, i -> 1)),
    BREATH("브레스공격", "breath", "강렬한 화염을 내뿜는 용의 숨결", SkillTypes.DAMAGE, SkillAttribute.MAGIC, 10,
            createUnmodifiableMap(10, i -> 10 * i),
            createUnmodifiableMap(10, i -> 0),
            createUnmodifiableMap(10, i -> 5 * i),
            createUnmodifiableMap(10, i -> 5),
            createUnmodifiableMap(10, i -> 1),
            createUnmodifiableMap(10, i -> 5 * i),
            createUnmodifiableMap(10, i -> 5 * i),
            createUnmodifiableMap(10, i -> 5 * i)),
    INVALID("무효", "invalid", "무효한 스킬", SkillTypes.DAMAGE, SkillAttribute.PHYSICAL, 0,
            createUnmodifiableMap(10, i -> 0),
            createUnmodifiableMap(10, i -> 0),
            createUnmodifiableMap(10, i -> 0),
            createUnmodifiableMap(10, i -> 0),
            createUnmodifiableMap(10, i -> 0),
            createUnmodifiableMap(10, i -> 0),
            createUnmodifiableMap(10, i -> 0),
            createUnmodifiableMap(10, i -> 0)),
    ;

    private static Map<Integer, Integer> createUnmodifiableMap(int maxLevel, Function<Integer, Integer> valueMapper) {
        return IntStream.rangeClosed(1, maxLevel)
                .boxed()
                .collect(Collectors.toUnmodifiableMap(i -> i, valueMapper));
    }

    private final String name;
    private final String key;
    private final String description;
    private final SkillTypes type;
    private final SkillAttribute attribute;
    private final int maxLevel;
    private final Map<Integer, Integer> damagePerLevel;
    private final Map<Integer, Integer> healPerLevel;
    private final Map<Integer, Integer> costPerLevel;
    private final Map<Integer, Integer> cooldownPerLevel;
    private final Map<Integer, Integer> durationPerLevel;
    private final Map<Integer, Integer> rangePerLevel;
    private final Map<Integer, Integer> accuracyPerLevel;
    private final Map<Integer, Integer> criticalPerLevel;
    private final Map<Integer, Integer> emptyMap;
    private static final Map<String, Skills> skills = new java.util.HashMap<>();

    static {
        for (Skills skill : Skills.values()) {
            skills.put(skill.getKey(), skill);
        }
    }

    Skills(String name, String key, String description, SkillTypes type, SkillAttribute attribute, int maxLevel, Map<Integer, Integer> damagePerLevel, Map<Integer, Integer> healPerLevel, Map<Integer, Integer> costPerLevel, Map<Integer, Integer> cooldownPerLevel, Map<Integer, Integer> durationPerLevel, Map<Integer, Integer> rangePerLevel, Map<Integer, Integer> accuracyPerLevel, Map<Integer, Integer> criticalPerLevel) {
        this.name = name;
        this.key = key;
        this.description = description;
        this.type = type;
        this.attribute = attribute;
        this.maxLevel = maxLevel;
        this.emptyMap = IntStream.rangeClosed(1, maxLevel)
                .boxed()
                .collect(Collectors.toUnmodifiableMap(i -> i, i -> 0));
        this.damagePerLevel = Objects.requireNonNullElse(damagePerLevel, this.emptyMap);
        this.healPerLevel = Objects.requireNonNullElse(healPerLevel, this.emptyMap);
        this.costPerLevel = Objects.requireNonNullElse(costPerLevel, this.emptyMap);
        this.cooldownPerLevel = Objects.requireNonNullElse(cooldownPerLevel, this.emptyMap);
        this.durationPerLevel = Objects.requireNonNullElse(durationPerLevel, this.emptyMap);
        this.rangePerLevel = Objects.requireNonNullElse(rangePerLevel, this.emptyMap);
        this.accuracyPerLevel = Objects.requireNonNullElse(accuracyPerLevel, this.emptyMap);
        this.criticalPerLevel = Objects.requireNonNullElse(criticalPerLevel, this.emptyMap);
    }

    public static Skills getSkillByKey(String key) {
        if (skills.containsKey(key)) return skills.get(key);
        return INVALID;
    }
}
