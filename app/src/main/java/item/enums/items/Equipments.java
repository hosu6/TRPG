package item.enums.items;

import item.enums.EquipTypes;
import item.interfaces.Item;
import status.BaseStatus;

public enum Equipments implements Item {
    // 각 장비 타입을 대표하는 아이템
    SWORD("검", "가장 대표적인 한손 무기.", 3.0, 50, EquipTypes.MAIN_HAND, new BaseStatus(0, 0, 1, 0, 0, 0, 0, 0, 10, 0, 0, 0, 0, 0)),
    SHIELD("방패", "공격을 막아내는 기본적인 방어구.", 5.0, 40, EquipTypes.OFF_HAND, new BaseStatus(2, 0, 0, 0, 0, 0, 0, 0, 0, 8, 10, 0, 0, 0)),
    GREAT_SWORD("대검", "강력한 위력을 지닌 양손 무기.", 7.5, 150, EquipTypes.TWO_HAND, new BaseStatus(0, 0, 5, 0, -1, 0, 0, 0, 25, 0, 0, 0, 0, 0)),
    BOW("활", "원거리 물리 공격이 가능한 양손 활.", 4.5, 100, EquipTypes.TWO_HAND, new BaseStatus(0, 0, 0, 0, 10, 0, 0, 0, 15, 0, 0, 0, 0, 0)),
    HELMET("투구", "머리를 보호하는 투구.", 3.5, 45, EquipTypes.HEAD, new BaseStatus(2, 0, 0, 0, -1, 0, 0, 0, 0, 6, 10, 0, 0, 0)),
    ARMOR("갑옷", "몸통을 보호하는 갑옷.", 15.0, 200, EquipTypes.TORSO, new BaseStatus(3, 0, 0, 0, -2, 0, 0, 0, 0, 20, 20, 0, 0, 0)),
    GREAVES("각반", "다리를 보호하는 갑옷.", 8.0, 120, EquipTypes.LEGS, new BaseStatus(2, 0, 0, 0, -1, 0, 0, 0, 0, 10, 10, 0, 0, 0)),
    GAUNTLETS("건틀릿", "손을 보호하는 장갑.", 2.0, 35, EquipTypes.HANDS, new BaseStatus(0, 0, 1, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0)),
    BOOTS("부츠", "발을 보호하고 이동을 돕는 신발.", 1.5, 30, EquipTypes.FEET, new BaseStatus(0, 0, 0, 2, 1, 0, 0, 0, 0, 3, 0, 0, 5, 5)),
    AMULET("목걸이", "마법의 힘이 깃든 목걸이.", 0.2, 100, EquipTypes.NECK, new BaseStatus(1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 5, 5, 5, 0)),
    RING("반지", "특별한 힘을 부여하는 반지.", 0.1, 150, EquipTypes.FINGER, new BaseStatus(0, 0, 3, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0)),
    ;

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