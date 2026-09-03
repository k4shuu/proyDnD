package model;

public class Player extends Entity {
    private int profBonus, salvFails, salvSucc;
    private Class dClass;
    private Background bckg;

    public Player(String name, int hpMax, int AC, Stats stats, int profBonus) {
        super(name, hpMax, AC, stats);
        this.profBonus = profBonus;
        this.salvFails = 0;
        this.salvSucc = 0;
    }

    @Override
    public boolean alive(){
        return getHpCurrent() > 0 || salvFails < 3;
    }

    public boolean salvThrow(int DC, Stat stat){
        return util.Dice.roll(20) + getStats().getModif(stat) > DC;
    }

    public void deathSalvThrow(){
        int roll = util.Dice.roll(20);
        if (roll + getStats().getModif(Stat.CONSTITUTION) > 10) {
            salvSucc++;
        } else {
            salvFails++;
        }
    }

    @Override
    public void attack(Entity target) {
        // Implement player attack logic here
    }
}
