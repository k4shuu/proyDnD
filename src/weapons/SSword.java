package weapons;

public class SSword extends Weapon {
    public SSword(String name, boolean GC, int mgcBonus) {
        super(name, 1, 6, weapons.typeDmg.SLASHING, GC, mgcBonus);
    }
}
