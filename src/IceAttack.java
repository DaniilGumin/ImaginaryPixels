public class IceAttack extends Attack {
    private final String name = "Заморозка";
    private int turns;


    public IceAttack(int turns) {
        this.turns = turns;
    }

    @Override
    public void attack(Unit unit) {
        unit.onFreeze(turns);
    }
}

