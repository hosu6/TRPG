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
    private final int atk; //attack(장비에 종속된 스테이터스)
    private final int def; //defence(장비에 종속된 스테이터스)

    private final int bonusMaxHp;
    private final int bonusMaxMp;
    private final int bonusMaxSp;
    private final int bonusMaxWeight;

    public static final BaseStatus EMPTY_BASE_STATUS = new BaseStatus(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    private static final double SCALE = 0.2;
    private static final double RANDOM_SCALE = 5;

    public static BaseStatus tankStatusAtLevel(int level) {
        return new BaseStatus(
                (int) (SCALE * 39 + (0.5 + Math.random()) * RANDOM_SCALE) * level,
                (int) (SCALE * 1 + (0.5 + Math.random()) * RANDOM_SCALE) * level,
                (int) (SCALE * 1 + (0.5 + Math.random()) * RANDOM_SCALE) * level,
                (int) (SCALE * 6 + (0.5 + Math.random()) * RANDOM_SCALE) * level,
                (int) (SCALE * 1 + (0.5 + Math.random()) * RANDOM_SCALE) * level,
                (int) (SCALE * 1 + (0.5 + Math.random()) * RANDOM_SCALE) * level,
                (int) (SCALE * 1 + (0.5 + Math.random()) * RANDOM_SCALE) * level,
                (int) (SCALE * 1 + (0.5 + Math.random()) * RANDOM_SCALE) * level,
                (int) (SCALE * 7 + (0.5 + Math.random()) * RANDOM_SCALE) * level,
                (int) (SCALE * 20 + (0.5 + Math.random()) * RANDOM_SCALE) * level,
                0,
                0,
                0,
                0
        );
    }

    public static BaseStatus meleeDpsStatusAtLevel(int level) {
        return new BaseStatus(
                (int) (SCALE * 25 + (0.5 + Math.random()) * RANDOM_SCALE) * level,
                (int) (SCALE * 1 + (0.5 + Math.random()) * RANDOM_SCALE) * level,
                (int) (SCALE * 36 + (0.5 + Math.random()) * RANDOM_SCALE) * level,
                (int) (SCALE * 6 + (0.5 + Math.random()) * RANDOM_SCALE) * level,
                (int) (SCALE * 1 + (0.5 + Math.random()) * RANDOM_SCALE) * level,
                (int) (SCALE * 1 + (0.5 + Math.random()) * RANDOM_SCALE) * level,
                (int) (SCALE * 1 + (0.5 + Math.random()) * RANDOM_SCALE) * level,
                (int) (SCALE * 1 + (0.5 + Math.random()) * RANDOM_SCALE) * level,
                (int) (SCALE * 6 + (0.5 + Math.random()) * RANDOM_SCALE) * level,
                (int) (SCALE * 5 + (0.5 + Math.random()) * RANDOM_SCALE) * level,
                0,
                0,
                0,
                0
        );
    }

    public static BaseStatus rangedDpsStatusAtLevel(int level) {
        return new BaseStatus(
                (int) (SCALE * 25 + (0.5 + Math.random()) * RANDOM_SCALE) * level,
                (int) (SCALE * 1 + (0.5 + Math.random()) * RANDOM_SCALE) * level,
                (int) (SCALE * 16 + (0.5 + Math.random()) * RANDOM_SCALE) * level,
                (int) (SCALE * 6 + (0.5 + Math.random()) * RANDOM_SCALE) * level,
                (int) (SCALE * 21 + (0.5 + Math.random()) * RANDOM_SCALE) * level,
                (int) (SCALE * 1 + (0.5 + Math.random()) * RANDOM_SCALE) * level,
                (int) (SCALE * 1 + (0.5 + Math.random()) * RANDOM_SCALE) * level,
                (int) (SCALE * 1 + (0.5 + Math.random()) * RANDOM_SCALE) * level,
                (int) (SCALE * 1 + (0.5 + Math.random()) * RANDOM_SCALE) * level,
                (int) (SCALE * 5 + (0.5 + Math.random()) * RANDOM_SCALE) * level,
                0,
                0,
                0,
                0
        );
    }

    public static BaseStatus casterStatusAtLevel(int level) {
        return new BaseStatus(
                (int) (SCALE * 25 + (0.5 + Math.random()) * RANDOM_SCALE) * level,
                (int) (SCALE * 26 + (0.5 + Math.random()) * RANDOM_SCALE) * level,
                (int) (SCALE * 1 + (0.5 + Math.random()) * RANDOM_SCALE) * level,
                (int) (SCALE * 6 + (0.5 + Math.random()) * RANDOM_SCALE) * level,
                (int) (SCALE * 1 + (0.5 + Math.random()) * RANDOM_SCALE) * level,
                (int) (SCALE * 16 + (0.5 + Math.random()) * RANDOM_SCALE) * level,
                (int) (SCALE * 1 + (0.5 + Math.random()) * RANDOM_SCALE) * level,
                (int) (SCALE * 1 + (0.5 + Math.random()) * RANDOM_SCALE) * level,
                (int) (SCALE * 1 + (0.5 + Math.random()) * RANDOM_SCALE) * level,
                (int) (SCALE * 5 + (0.5 + Math.random()) * RANDOM_SCALE) * level,
                0,
                0,
                0,
                0
        );
    }

    public static BaseStatus rogueStatusAtLevel(int level) {
        return new BaseStatus(
                (int) (SCALE * 25 + (0.5 + Math.random()) * RANDOM_SCALE) * level,
                (int) (SCALE * 1 + (0.5 + Math.random()) * RANDOM_SCALE) * level,
                (int) (SCALE * 11 + (0.5 + Math.random()) * RANDOM_SCALE) * level,
                (int) (SCALE * 6 + (0.5 + Math.random()) * RANDOM_SCALE) * level,
                (int) (SCALE * 21 + (0.5 + Math.random()) * RANDOM_SCALE) * level,
                (int) (SCALE * 1 + (0.5 + Math.random()) * RANDOM_SCALE) * level,
                (int) (SCALE * 6 + (0.5 + Math.random()) * RANDOM_SCALE) * level,
                (int) (SCALE * 1 + (0.5 + Math.random()) * RANDOM_SCALE) * level,
                (int) (SCALE * 1 + (0.5 + Math.random()) * RANDOM_SCALE) * level,
                (int) (SCALE * 5 + (0.5 + Math.random()) * RANDOM_SCALE) * level,
                0,
                0,
                0,
                0
        );
    }

    public BaseStatus(int vit, int arc, int str, int sta, int agi, int wis, int luk, int cha, int atk, int def, int bonusMaxHp, int bonusMaxMp, int bonusMaxSp, int bonusMaxWeight) {
        this.vit = vit;
        this.arc = arc;
        this.str = str;
        this.sta = sta;
        this.agi = agi;
        this.wis = wis;
        this.luk = luk;
        this.cha = cha;
        this.atk = atk;
        this.def = def;
        this.bonusMaxHp = bonusMaxHp;
        this.bonusMaxMp = bonusMaxMp;
        this.bonusMaxSp = bonusMaxSp;
        this.bonusMaxWeight = bonusMaxWeight;
    }

    public BaseStatus copy() {
        return new BaseStatus(vit, arc, str, sta, agi, wis, luk, cha, atk, def, bonusMaxHp, bonusMaxMp, bonusMaxSp, bonusMaxWeight);
    }

    public BaseStatus copyWithScale(double scale) {
        return new BaseStatus(
                (int) (vit * scale),
                (int) (arc * scale),
                (int) (str * scale),
                (int) (sta * scale),
                (int) (agi * scale),
                (int) (wis * scale),
                (int) (luk * scale),
                (int) (cha * scale),
                (int) (atk * scale),
                (int) (def * scale),
                (int) (bonusMaxHp * scale),
                (int) (bonusMaxMp * scale),
                (int) (bonusMaxSp * scale),
                (int) (bonusMaxWeight * scale)
        );
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
                this.atk + other.atk,
                this.def + other.def,
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

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }
}
