package item.enums.items;

import item.enums.EquipTypes;
import item.interfaces.Item;
import status.BaseStatus;

public enum Equipments implements Item {
    // --- 무기 (Weapons) ---
    // 주무기 (Main Hand)
    RUSTY_SWORD("녹슨 검", "가장 기본적인 검. 날이 많이 무뎌져 있다.", 2.5, 5, EquipTypes.MAIN_HAND, new BaseStatus(0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0)),
    IRON_DAGGER("철 단검", "빠른 공격이 가능한 평범한 단검.", 0.8, 15, EquipTypes.MAIN_HAND, new BaseStatus(0, 0, 0, 0, 2, 0, 0, 0, 5, 0, 0, 0, 0, 0)),
    STEEL_MACE("강철 메이스", "단단한 갑옷을 부수는 데 효과적인 둔기.", 4.0, 45, EquipTypes.MAIN_HAND, new BaseStatus(0, 0, 2, 0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0)),
    ELVEN_SHORT_SWORD("엘프의 숏소드", "가볍고 날렵한 엘프들의 검.", 1.5, 120, EquipTypes.MAIN_HAND, new BaseStatus(0, 0, 0, 0, 5, 0, 2, 0, 12, 0, 0, 0, 0, 0)),
    WAND_OF_SPARKS("불꽃의 완드", "작은 불꽃을 발사하는 초보 마법사의 완드.", 0.5, 30, EquipTypes.MAIN_HAND, new BaseStatus(0, 3, 0, 0, 0, 1, 0, 0, 4, 0, 0, 10, 0, 0)),
    WARHAMMER_OF_THE_FORGE("대장간의 워해머", "강력한 파괴력을 지닌 망치.", 5.5, 150, EquipTypes.MAIN_HAND, new BaseStatus(0, 0, 5, 0, -1, 0, 0, 0, 18, 0, 0, 0, 0, 0)),
    FLAME_TONGUE("화염의 혀", "칼날이 언제나 불타오르는 마법 검.", 2.8, 450, EquipTypes.MAIN_HAND, new BaseStatus(0, 5, 0, 0, 0, 0, 0, 0, 25, 0, 10, 0, 0, 0)),

    // 보조무기 (Off Hand)
    WOODEN_SHIELD("나무 방패", "가볍지만 방어력은 기대하기 어려운 방패.", 3.0, 10, EquipTypes.OFF_HAND, new BaseStatus(0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 5, 0, 0, 0)),
    IRON_KITE_SHIELD("철제 카이트 쉴드", "전투에서 흔히 사용되는 튼튼한 방패.", 6.0, 60, EquipTypes.OFF_HAND, new BaseStatus(1, 0, 0, 0, 0, 0, 0, 0, 0, 10, 10, 0, 0, 0)),
    ORB_OF_FROST("서리의 보주", "냉기 마법을 증폭시키는 마력의 보주.", 1.0, 200, EquipTypes.OFF_HAND, new BaseStatus(0, 10, 0, 0, 0, 5, 0, 0, 0, 1, 0, 30, 0, 0)),
    TOME_OF_SHADOWS("그림자의 마도서", "어둠의 지식이 담긴 흑마법사의 책.", 1.2, 220, EquipTypes.OFF_HAND, new BaseStatus(0, 8, 0, 0, 0, 8, 0, 0, 0, 2, 0, 25, 0, 0)),

    // 양손무기 (Two Hand)
    GOBLIN_SPEAR("고블린의 창", "조잡하게 만들어졌지만 의외로 위협적인 창.", 2.0, 8, EquipTypes.TWO_HAND, new BaseStatus(0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, 0, 0, 0)),
    OAK_LONGBOW("참나무 장궁", "탄력이 좋은 참나무로 만든 장거리 활.", 2.2, 75, EquipTypes.TWO_HAND, new BaseStatus(0, 0, 0, 0, 3, 0, 0, 0, 10, 0, 0, 0, 0, 0)),
    DWARVEN_BATTLE_AXE("드워프의 전투도끼", "묵직한 무게로 모든 것을 파괴하는 도끼.", 8.5, 180, EquipTypes.TWO_HAND, new BaseStatus(0, 0, 8, -2, -2, 0, 0, 0, 28, 0, 0, 0, 0, 0)),
    CLAYMORE("클레이모어", "보병들이 사용하는 거대한 양손 대검.", 7.0, 160, EquipTypes.TWO_HAND, new BaseStatus(0, 0, 5, 0, -1, 0, 0, 0, 25, 0, 0, 0, 0, 0)),
    STAFF_OF_THE_APPRENTICE("수습생의 지팡이", "마력의 흐름을 돕는 수련용 지팡이.", 1.8, 40, EquipTypes.TWO_HAND, new BaseStatus(0, 5, 0, 0, 0, 3, 0, 0, 5, 0, 0, 15, 0, 0)),

    // --- 방어구 (Armor) ---
    // 머리 (Head)
    LEATHER_HELM("가죽 투구", "간단한 보호를 제공하는 가죽 소재의 투구.", 0.8, 12, EquipTypes.HEAD, new BaseStatus(0, 0, 0, 1, 1, 0, 0, 0, 0, 2, 0, 0, 5, 0)),
    MAGE_HOOD("마법사 후드", "마력의 집중을 돕는 부드러운 천으로 된 후드.", 0.4, 25, EquipTypes.HEAD, new BaseStatus(0, 2, 0, 0, 0, 2, 0, 0, 0, 1, 0, 10, 0, 0)),
    IRON_HELM("철 투구", "머리를 안전하게 보호하는 병사들의 표준 투구.", 3.5, 50, EquipTypes.HEAD, new BaseStatus(2, 0, 0, 0, -1, 0, 0, 0, 0, 6, 10, 0, 0, 0)),
    DRAGONSCALE_HELM("용비늘 투구", "마법 저항력이 뛰어난 투구.", 4.0, 800, EquipTypes.HEAD, new BaseStatus(5, 5, 0, 0, 0, 0, 0, 0, 0, 12, 20, 20, 0, 0)),

    // 몸통 (Torso)
    PADDED_TUNIC("누비 갑옷", "두꺼운 천을 덧대어 만든 기본적인 상의.", 3.0, 20, EquipTypes.TORSO, new BaseStatus(1, 0, 0, 2, 0, 0, 0, 0, 0, 5, 0, 0, 10, 0)),
    CHAINMAIL_ARMOR("사슬 갑옷", "작은 강철 고리를 엮어 만든 갑옷.", 12.0, 150, EquipTypes.TORSO, new BaseStatus(0, 0, 3, 0, -2, 0, 0, 0, 0, 15, 0, 0, 0, 0)),
    STEEL_BREASTPLATE("강철 흉갑", "가슴과 등을 보호하는 단단한 강철 판금 갑옷.", 18.0, 350, EquipTypes.TORSO, new BaseStatus(5, 0, 0, 0, -3, 0, 0, 0, 0, 25, 30, 0, 0, 0)),
    ROBE_OF_THE_ARCHMAGE("대마법사의 로브", "엄청난 마력이 깃든 로브.", 2.5, 1200, EquipTypes.TORSO, new BaseStatus(5, 20, 0, 0, 0, 15, 0, 0, 0, 8, 0, 100, 0, 0)),

    // 다리 (Legs)
    CLOTH_LEGGINGS("천 바지", "가장 기본적인 하의.", 0.5, 3, EquipTypes.LEGS, new BaseStatus(0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 3, 0)),
    LEATHER_TROUSERS("가죽 바지", "질긴 가죽으로 만들어 활동성이 좋다.", 1.5, 30, EquipTypes.LEGS, new BaseStatus(0, 0, 0, 2, 2, 0, 0, 0, 0, 3, 0, 0, 5, 0)),
    PLATE_GREAVES("판금 각반", "다리를 보호하는 무거운 강철 각반.", 10.0, 200, EquipTypes.LEGS, new BaseStatus(3, 0, 0, 0, -2, 0, 0, 0, 0, 12, 15, 0, 0, 0)),
    SILK_PANTS_OF_MANA("마나의 비단 바지", "마나 회복 속도를 높여주는 바지.", 0.8, 400, EquipTypes.LEGS, new BaseStatus(0, 5, 0, 0, 1, 5, 0, 0, 0, 2, 0, 50, 0, 0)),

    // 손 (Hands)
    RAGGED_GLOVES("누더기 장갑", "보온 외에는 쓸모가 없는 낡은 장갑.", 0.2, 2, EquipTypes.HANDS, new BaseStatus(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)),
    LEATHER_GAUNTLETS("가죽 건틀릿", "손을 보호하고 무기를 쥐기 쉽게 해주는 건틀릿.", 0.7, 25, EquipTypes.HANDS, new BaseStatus(0, 0, 1, 0, 1, 0, 0, 0, 0, 2, 0, 0, 0, 0)),
    STEEL_GAUNTLETS("강철 건틀릿", "완벽한 손 보호를 제공하는 판금 장갑.", 2.5, 90, EquipTypes.HANDS, new BaseStatus(1, 0, 2, 0, -1, 0, 0, 0, 0, 5, 0, 0, 0, 0)),

    // 발 (Feet)
    LEATHER_BOOTS("가죽 장화", "장거리 이동에 적합한 튼튼한 가죽 장화.", 1.2, 28, EquipTypes.FEET, new BaseStatus(0, 0, 0, 3, 1, 0, 0, 0, 0, 2, 0, 0, 10, 5)),
    STEEL_SABATONS("강철 판금 신발", "발을 보호하는 무거운 신발.", 4.5, 110, EquipTypes.FEET, new BaseStatus(2, 0, 0, 0, -2, 0, 0, 0, 0, 6, 0, 0, 0, 0)),
    BOOTS_OF_SPEED("신속의 장화", "착용자의 이동 속도를 비약적으로 향상시킨다.", 1.0, 550, EquipTypes.FEET, new BaseStatus(0, 0, 0, 5, 10, 0, 0, 0, 0, 3, 0, 0, 20, 0)),

    // --- 장신구 (Accessories) ---
    // 목 (Neck)
    SIMPLE_AMULET("간단한 아뮬렛", "행운을 빌며 누군가 조각한 목걸이.", 0.1, 15, EquipTypes.NECK, new BaseStatus(1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 5, 0, 0, 0)),
    NECKLACE_OF_PROTECTION("보호의 목걸이", "사악한 기운으로부터 착용자를 보호한다.", 0.2, 250, EquipTypes.NECK, new BaseStatus(3, 0, 0, 0, 0, 3, 0, 0, 0, 3, 10, 10, 0, 0)),
    PENDANT_OF_COURAGE("용기의 펜던트", "사자의 문양이 새겨진 펜던트. 두려움을 줄여준다.", 0.3, 300, EquipTypes.NECK, new BaseStatus(0, 0, 3, 3, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0)),

    // 손가락 (Finger)
    COPPER_RING("구리 반지", "녹이 슨 구리 반지.", 0.1, 1, EquipTypes.FINGER, new BaseStatus(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)),
    SILVER_RING_OF_STRENGTH("힘의 은반지", "착용자의 근력을 약간 상승시킨다.", 0.1, 320, EquipTypes.FINGER, new BaseStatus(0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)),
    GOLDEN_RING_OF_REGENERATION("재생의 금반지", "상처의 회복 속도를 높여준다.", 0.2, 900, EquipTypes.FINGER, new BaseStatus(10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 50, 0, 0, 0)),
    SIGNET_RING_OF_THE_KINGDOM("왕국의 인장 반지", "높은 신분을 증명한다.", 0.2, 1500, EquipTypes.FINGER, new BaseStatus(0, 0, 0, 0, 0, 2, 2, 10, 0, 0, 0, 0, 0, 0)),

    // 아무것도 장착 안한 상태
    NONE("없음", "비어있는 슬롯", 0, 0, EquipTypes.NOT_EQUITABLE, BaseStatus.EMPTY_BASE_STATUS);

    private String name;
    private String info;
    private double weight;
    private int value;
    private EquipTypes equipType;
    private BaseStatus status;

    Equipments(String name, String info, double weight, int value, EquipTypes equipType, BaseStatus status) {
        this.name = name;
        this.info = info;
        this.weight = weight;
        this.value = value;
        this.equipType = equipType;
        this.status = status;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public String getInfo() {
        return "";
    }

    @Override
    public int getValue() {
        return 0;
    }

    @Override
    public double getWeight() {
        return 0;
    }

    public EquipTypes getEquipType() {
        return equipType;
    }

    public BaseStatus getStatus() {
        return status;
    }
}