public class FireAttack extends Attack {
    private final String name = "Огненная атака";
    private int damage;
    private int turns;

    public FireAttack(int damage, int turns) {
        this.damage = damage;
        this.turns = turns;
    }

    @Override
    public void attack(Unit unit) {
        unit.onFireDamage(damage, turns);
    }
}
