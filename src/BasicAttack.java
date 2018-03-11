public class BasicAttack extends Attack {
    private final String name = "Обычная атака";
    private int damage;

    public BasicAttack(int damage) {
        this.damage = damage;
    }

    @Override
    public void attack(Unit unit) {
        unit.onDamage(damage);
    }
}
