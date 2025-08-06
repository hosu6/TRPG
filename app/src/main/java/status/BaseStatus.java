package status;

public class BaseStatus {
    private final int vit; //vitality
    private final int arc; //arcane power
    private final int str; //strength
    private final int sta; //stamina
    private final int agi; //agility
    private final int wis; //wisdom
    private final int luk; //luck
    private final int cha; //charisma

    private final int bonusMaxHp;
    private final int bonusMaxMp;
    private final int bonusMaxSp;
    private final int bonusMaxWeight;

    public static final BaseStatus EMPTY_BASE_STATUS = new BaseStatus(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    public BaseStatus(int vit, int arc, int str, int sta, int agi, int wis, int luk, int cha, int bonusMaxHp, int bonusMaxMp, int bonusMaxSp, int bonusMaxWeight) {
        this.vit = vit;
        this.arc = arc;
        this.str = str;
        this.sta = sta;
        this.agi = agi;
        this.wis = wis;
        this.luk = luk;
        this.cha = cha;
        this.bonusMaxHp = bonusMaxHp;
        this.bonusMaxMp = bonusMaxMp;
        this.bonusMaxSp = bonusMaxSp;
        this.bonusMaxWeight = bonusMaxWeight;
    }

    @Override
    public BaseStatus clone() {
        return new BaseStatus(vit, arc, str, sta, agi, wis, luk, cha, bonusMaxHp, bonusMaxMp, bonusMaxSp, bonusMaxWeight);
    }

    // 새로운 Status 객체를 반환하는 add 메서드 (원본을 변경하지 않음)
    public BaseStatus add(BaseStatus other) {
        return new BaseStatus(
                this.vit + other.vit,
                this.arc + other.arc,
                this.str + other.str,
                this.sta + other.sta,
                this.agi + other.agi,
                this.wis + other.wis,
                this.luk + other.luk,
                this.cha + other.cha,
                this.bonusMaxHp + other.bonusMaxHp,
                this.bonusMaxMp + other.bonusMaxMp,
                this.bonusMaxSp + other.bonusMaxSp,
                this.bonusMaxWeight + other.bonusMaxWeight
        );
    }

    public int getVit() {
        return vit;
    }

    public int getArc() {
        return arc;
    }

    public int getStr() {
        return str;
    }

    public int getSta() {
        return sta;
    }

    public int getAgi() {
        return agi;
    }

    public int getWis() {
        return wis;
    }

    public int getLuk() {
        return luk;
    }

    public int getCha() {
        return cha;
    }

    public int getBonusMaxHp() {
        return bonusMaxHp;
    }

    public int getBonusMaxMp() {
        return bonusMaxMp;
    }

    public int getBonusMaxWeight() {
        return bonusMaxWeight;
    }

    public int getBonusMaxSp() {
        return bonusMaxSp;
    }
}
