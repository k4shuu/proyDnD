package weapons;

public class GSword  extends Weapon {
    private boolean isTwoHanded;

    public GSword(String name, boolean GC, int mgcBonus) {
        super(name, 2, 6, weapons.typeDmg.SLASHING, GC, mgcBonus);
    }
}
