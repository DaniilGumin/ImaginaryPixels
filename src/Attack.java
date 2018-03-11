public abstract class Attack {
    private String name;

    public abstract void attack(Unit unit);

    public String getName() {
        return name;
    }
}
