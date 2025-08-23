package scenario.scenarioList;

import exception.abstracts.PrintException;
import exception.scenario.QuitException;
import play.ActionGroup;
import play.Play;
import play.PlayStatus;
import play.enums.Actions;
import scenario.Scenario;
import skill.enums.Skills;
import unit.Unit;
import unit.UnitBox;

import java.util.Optional;

public class BattleScenario extends Scenario {
    public BattleScenario(UnitBox players, UnitBox monsters) {
        super("BattleScenario", "전투 시나리오", () -> {
            Play.println("다음 적대 유닛과 전투를 시작합니다.");
            Play.println(monsters.toString());
            Actions mode = Play.readAction(new ActionGroup(Actions.AUTO, Actions.EACH, Actions.QUIT));


            while (!monsters.isAllDead() && !players.isAllDead() && mode != Actions.QUIT) {
                try {
                    if (mode == Actions.AUTO) {
                        Play.println("플레이어의 턴입니다.");
                        players.attackTargets(monsters);
                        if (players.isAllDead() || monsters.isAllDead()) break;
                        Play.println("몬스터의 턴입니다.");
                        monsters.attackTargets(players);
                        if (players.isAllDead() || monsters.isAllDead()) break;
                        continue;
                    }
                    players.updateControllableUnitBox();
                    while (true) {
                        Optional<Unit> optionalPlayer = players.getControllableUnit();
                        if (optionalPlayer.isEmpty()) break;
                        Unit player = optionalPlayer.get();
                        Play.println("플레이어의 턴입니다.\n선택된 플레이어");
                        Play.println(player.unitInfo());
                        Actions action = Actions.INVALID;
                        while (action != Actions.ATTACK) {
                            action = Play.readAction(new ActionGroup(Actions.ATTACK, Actions.QUIT, Actions.SKILL, Actions.INFO, Actions.ENEMY_INFO));
                            if (action == Actions.QUIT) throw new QuitException("도망을 시도합니다.");
                            switch (action) {
                                case ATTACK -> {
                                    Play.println("공격할 타겟을 선택하세요");
                                    monsters.printAllUnits();
                                    int targetIndex = Play.readInt(1, monsters.size());
                                    Play.println("사용할 스킬을 선택하세요");
                                    Skills skills = Play.readSkill(player.getSkillBox());
                                    player.getSkillBox().useSkill(skills, player, monsters.getUnit(targetIndex - 1));
                                    Play.println("공격당한 타깃 정보");
                                    Play.println(monsters.getUnit(targetIndex - 1).unitInfo());
                                }
                                case INFO -> {
                                    players.printAllUnits();
                                    continue;
                                }
                                case ENEMY_INFO -> {
                                    monsters.printAllUnits();
                                    continue;
                                }
                            }
                        }
                    }
                    Play.println("적대 유닛의 턴입니다.");
                    monsters.attackTargets(players);
                    players.updateControllableUnitBox();
                } catch (QuitException e) {
                    Play.println(e.getMessage());
                    break;
                } catch (PrintException e) {
                    Play.println(e.getMessage());
                }
            }
            Play.println("전투가 종료되었습니다.");
            if (players.isAllDead()) {
                PlayStatus.scenariosOnReady.push(new DeadScenario());
            } else if (monsters.isAllDead()) {
                Play.println("전투에서 승리했습니다!");
            }
        });
    }
}
