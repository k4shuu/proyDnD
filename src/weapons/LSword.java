package weapons;

public class LSword  extends Weapon {
    private boolean isTwoHanded;

    public LSword(String name, boolean GC, int mgcBonus, boolean isTwoHanded) {
        super(name, 1, isTwoHanded ? 10 : 6, weapons.typeDmg.SLASHING, GC, mgcBonus);
        this.isTwoHanded = isTwoHanded;
    }
}
