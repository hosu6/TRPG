package item.enums;

public enum EquipTypes {
    // 무기/방패 장착 슬롯
    MAIN_HAND,      // 주 손 (한손검, 완드 등)
    OFF_HAND,       // 보조 손 (방패)
    TWO_HAND,       // 양손 (양손검, 활, 창 등)

    // 방어구 장착 슬롯
    HEAD,           // 투구
    TORSO,          // 몸통 (상의)
    LEGS,           // 다리 (하의)
    HANDS,          // 손 (장갑)
    FEET,           // 발 (신발)

    // 장신구 장착 슬롯
    NECK,           // 목 (목걸이)
    FINGER,         // 손가락 (반지)

    // 장착 불가능
    NOT_EQUITABLE   // 장착할 수 없는 아이템 (물약, 음식, 재료 등)
    ;
}
