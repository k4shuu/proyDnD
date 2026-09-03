package weapons;

public abstract class Weapon {
    private String name;
    private final int qtyDice, typeDice;
    private int mgcBonus;
    private boolean GC;
    private typeDmg typeDmg;


    public Weapon(String name, int qtyDice, int typeDice, typeDmg typeDmg, boolean GC, int mgcBonus) {
        this.name = name;
        this.qtyDice = qtyDice;
        this.typeDice = typeDice;
        this.typeDmg = typeDmg;
        this.GC = GC;
        this.mgcBonus = mgcBonus;
    }

    public Weapon(String name, int qtyDice, int typeDice, typeDmg typeDmg, boolean GC) {
        this(name, qtyDice, typeDice, typeDmg, GC, 0);
    }

    public void Enchant(int lvl) {
        setMgcBonus(lvl);
    }

    public void setMgcBonus(int mgcBonus) {
        this.mgcBonus = mgcBonus;
    }
}
