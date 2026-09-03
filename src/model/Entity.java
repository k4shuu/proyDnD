package model;

public abstract class Entity {
    private String name;
    private int hpMax,hpCurrent, armorClass , initiative;
    private Stats stats;

    public Entity(String name, int hpMax, int AC, Stats stats) {
        this.name = name;
        this.hpMax = hpMax;
        this.hpCurrent = hpMax;
        this.armorClass = AC;
        this.stats = stats;
        this.initiative = 0;
    }
    public boolean alive(){
        return this.hpCurrent>0;
    }
    public void takeDamage(int dmg){
        this.hpCurrent = Math.max(0, this.hpCurrent - dmg);
    }
    public abstract void attack(Entity target);

    public String getName() {
        return name;
    }

    public int getHpMax() {
        return hpMax;
    }

    public int getHpCurrent() {
        return hpCurrent;
    }

    public int getAC() {
        return armorClass;
    }

    public Stats getStats() {
        return stats;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative() {
        this.initiative = util.Dice.roll(20) + stats.getModif(Stat.DEXTERITY);
    }
}
