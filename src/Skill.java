import java.util.ArrayList;
import java.util.List;

public class Skill {
    private String name;
    private List<Attack> attacks = new ArrayList<>();

    public Skill(String name) {
        this.name = name;
    }

    public void addAttack(Attack attack) {
        attacks.add(attack);
    }

    public void attack(Unit unit) {
        for (Attack attack : attacks) {
            attack.attack(unit);
        }
    }

    public String getName() {
        return name;
    }
}
