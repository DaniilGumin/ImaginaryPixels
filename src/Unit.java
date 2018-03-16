import java.util.ArrayList;
import java.util.List;

public abstract class Unit implements NextTurnListener {
    private int health;
    private List<Skill> skills = new ArrayList<>();
    private int fireDamageTurns = 0;
    private int fireDamage = 0;
    private int freezeTurns = 0;

    public boolean isAlive() {
        return health > 0;
    }

    public void addSkill(Skill skill) {
        skills.add(skill);
    }

    public void attack(Unit unit, Skill skill) {
        if (!this.isFrozen()) {
            skill.attack(unit);
        }
    }


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void onDamage(int damage) {
        if (!isFrozen()) {
            health -= damage;
        }
    }

    public void onFireDamage(int damage, int turns) {
        if (freezeTurns > 0) {
            freezeTurns = 0;
            System.out.println("Разморожен");
        } else {
            fireDamageTurns = turns;
            fireDamage = damage;
        }
    }

    public void onFreeze(int turns) {
        if (fireDamageTurns > 0) {
            fireDamageTurns = 0;
            System.out.println("Горение остановлено");
        } else {
            freezeTurns = turns;
        }

    }

    public List<Skill> getSkills() {
        return skills;
    }

    public boolean isFrozen() {
        return freezeTurns > 0;
    }

    @Override
    public void onNextTurn() {
        if (fireDamageTurns > 0) {
            System.out.println("Герой получает " + fireDamage + " урон от огня.");
            health -= fireDamage;
            fireDamageTurns--;
        }
        if (isFrozen()) {
            System.out.println("Герой заморожен.");
            freezeTurns--;
        }
    }
}
