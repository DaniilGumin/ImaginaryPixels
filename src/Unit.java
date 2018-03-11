import java.util.ArrayList;
import java.util.List;

public abstract class Unit implements NextTurnListener {
    private int health;
    private List<Skill> skills = new ArrayList<>();
    private int fireDamageTurns = 0;
    private int fireDamage = 0;

    public boolean isAlive() {
        return health > 0;
    }

    public void addSkill(Skill skill) {
        skills.add(skill);
    }

    public void attack(Unit unit, Skill skill) {
        skill.attack(unit);
    }


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void onDamage(int damage) {
        health -= damage;
    }

    public void onFireDamage(int damage, int turns) {
        fireDamageTurns = turns;
        fireDamage = damage;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    @Override
    public void onNextTurn() {
        if (fireDamageTurns > 0) {
            health -= fireDamage;
            fireDamageTurns--;
        }
    }
}
