public class Warrior extends Unit {

    public Warrior() {
        setHealth(50);
        Attack basic = new BasicAttack(5);
        Skill warriorSkill = new Skill("Удар воина!!");
        warriorSkill.addAttack(basic);
        addSkill(warriorSkill);
    }
}
