public class Player extends Unit {

    public Player() {
        setHealth(200);
        Attack basic = new BasicAttack(10);
        Attack fire = new FireAttack(5, 5);
        Skill fireBlast = new Skill("Огненная вспышка");
        fireBlast.addAttack(basic);
        fireBlast.addAttack(fire);
        addSkill(fireBlast);

        Skill sword = new Skill("Удар мечом");
        sword.addAttack(basic);
        addSkill(sword);
    }
}
