package items;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public class Weapon extends Item {

    // Categoría del arma según el PHB
    public enum Category {
        SIMPLE_MELEE,
        SIMPLE_RANGED,
        MARTIAL_MELEE,
        MARTIAL_RANGED
    }

    // Propiedades de arma (PHB). No incluye el número de rango (ej. 20/60)
    // porque el formato pedido no tiene un campo para eso.
    public enum Props {
        AMMUNITION,
        FINESSE,
        HEAVY,
        LIGHT,
        LOADING,
        REACH,
        SPECIAL,
        THROWN,
        TWO_HANDED,
        VERSATILE
    }

    public enum DmgType {
        BLUDGEONING,
        PIERCING,
        SLASHING,
        NONE // para armas como la red, que no hacen daño de estos tipos
    }

    private final Category category;
    private final Set<Props> props;
    private final int qtyDice, typeDice;
    private int mgcBonus;
    private boolean GC; // Golpe Crítico especial / marcador custom (ajustar según se necesite)
    private final DmgType typeDmg;

    public Weapon(String name, double weight, double value,
                  Category category, Set<Props> props,
                  int qtyDice, int typeDice, int mgcBonus, boolean GC, DmgType typeDmg) {
        super(name, weight, value);
        this.category = category;
        this.props = props;
        this.qtyDice = qtyDice;
        this.typeDice = typeDice;
        this.mgcBonus = mgcBonus;
        this.GC = GC;
        this.typeDmg = typeDmg;
    }

    public boolean HasProp(Props p) {
        return this.props.contains(p);
    }

    // ---- Getters específicos de Weapon (name/weight/value ya vienen de Item) ----
    public Category getCategory() { return category; }
    public Set<Props> getProps() { return props; }
    public int getQtyDice() { return qtyDice; }
    public int getTypeDice() { return typeDice; }
    public int getMgcBonus() { return mgcBonus; }
    public void setMgcBonus(int mgcBonus) { this.mgcBonus = mgcBonus; }
    public boolean isGC() { return GC; }
    public void setGC(boolean GC) { this.GC = GC; }
    public DmgType getTypeDmg() { return typeDmg; }

    @Override
    public String toString() {
        return name + " (" + qtyDice + "d" + typeDice + " " + typeDmg + ")"
                + (mgcBonus != 0 ? " +" + mgcBonus : "")
                + " - " + weight + " lb, " + value + " gp";
    }

    // ---- Listado completo de armas de D&D 5e (PHB) ----
    // Peso (lb) y costo (gp) reales del Player's Handbook.
    public static final List<Weapon> ALL_WEAPONS = new ArrayList<>();

    static {
        // ===== ARMAS SIMPLES CUERPO A CUERPO =====
        ALL_WEAPONS.add(new Weapon("Club", 2, 0.1,
                Category.SIMPLE_MELEE, EnumSet.of(Props.LIGHT), 1, 4, 0, false, DmgType.BLUDGEONING));

        ALL_WEAPONS.add(new Weapon("Dagger", 1, 2,
                Category.SIMPLE_MELEE, EnumSet.of(Props.FINESSE, Props.LIGHT, Props.THROWN), 1, 4, 0, false, DmgType.PIERCING));

        ALL_WEAPONS.add(new Weapon("Greatclub", 10, 0.2,
                Category.SIMPLE_MELEE, EnumSet.of(Props.TWO_HANDED), 1, 8, 0, false, DmgType.BLUDGEONING));

        ALL_WEAPONS.add(new Weapon("Handaxe", 2, 5,
                Category.SIMPLE_MELEE, EnumSet.of(Props.LIGHT, Props.THROWN), 1, 6, 0, false, DmgType.SLASHING));

        ALL_WEAPONS.add(new Weapon("Javelin", 2, 0.5,
                Category.SIMPLE_MELEE, EnumSet.of(Props.THROWN), 1, 6, 0, false, DmgType.PIERCING));

        ALL_WEAPONS.add(new Weapon("Light Hammer", 2, 2,
                Category.SIMPLE_MELEE, EnumSet.of(Props.LIGHT, Props.THROWN), 1, 4, 0, false, DmgType.BLUDGEONING));

        ALL_WEAPONS.add(new Weapon("Mace", 4, 5,
                Category.SIMPLE_MELEE, EnumSet.noneOf(Props.class), 1, 6, 0, false, DmgType.BLUDGEONING));

        ALL_WEAPONS.add(new Weapon("Quarterstaff", 4, 0.2,
                Category.SIMPLE_MELEE, EnumSet.of(Props.VERSATILE), 1, 6, 0, false, DmgType.BLUDGEONING));

        ALL_WEAPONS.add(new Weapon("Sickle", 2, 1,
                Category.SIMPLE_MELEE, EnumSet.of(Props.LIGHT), 1, 4, 0, false, DmgType.SLASHING));

        ALL_WEAPONS.add(new Weapon("Spear", 3, 1,
                Category.SIMPLE_MELEE, EnumSet.of(Props.THROWN, Props.VERSATILE), 1, 6, 0, false, DmgType.PIERCING));

        // ===== ARMAS SIMPLES A DISTANCIA =====
        ALL_WEAPONS.add(new Weapon("Light Crossbow", 5, 25,
                Category.SIMPLE_RANGED, EnumSet.of(Props.AMMUNITION, Props.LOADING, Props.TWO_HANDED), 1, 8, 0, false, DmgType.PIERCING));

        ALL_WEAPONS.add(new Weapon("Dart", 0.25, 0.05,
                Category.SIMPLE_RANGED, EnumSet.of(Props.FINESSE, Props.THROWN), 1, 4, 0, false, DmgType.PIERCING));

        ALL_WEAPONS.add(new Weapon("Shortbow", 2, 25,
                Category.SIMPLE_RANGED, EnumSet.of(Props.AMMUNITION, Props.TWO_HANDED), 1, 6, 0, false, DmgType.PIERCING));

        ALL_WEAPONS.add(new Weapon("Sling", 0, 0.1,
                Category.SIMPLE_RANGED, EnumSet.of(Props.AMMUNITION), 1, 4, 0, false, DmgType.BLUDGEONING));

        // ===== ARMAS MARCIALES CUERPO A CUERPO =====
        ALL_WEAPONS.add(new Weapon("Battleaxe", 4, 10,
                Category.MARTIAL_MELEE, EnumSet.of(Props.VERSATILE), 1, 8, 0, false, DmgType.SLASHING));

        ALL_WEAPONS.add(new Weapon("Flail", 2, 10,
                Category.MARTIAL_MELEE, EnumSet.noneOf(Props.class), 1, 8, 0, false, DmgType.BLUDGEONING));

        ALL_WEAPONS.add(new Weapon("Glaive", 6, 20,
                Category.MARTIAL_MELEE, EnumSet.of(Props.HEAVY, Props.REACH, Props.TWO_HANDED), 1, 10, 0, false, DmgType.SLASHING));

        ALL_WEAPONS.add(new Weapon("Greataxe", 7, 30,
                Category.MARTIAL_MELEE, EnumSet.of(Props.HEAVY, Props.TWO_HANDED), 1, 12, 0, false, DmgType.SLASHING));

        ALL_WEAPONS.add(new Weapon("Greatsword", 6, 50,
                Category.MARTIAL_MELEE, EnumSet.of(Props.HEAVY, Props.TWO_HANDED), 2, 6, 0, false, DmgType.SLASHING));

        ALL_WEAPONS.add(new Weapon("Halberd", 6, 20,
                Category.MARTIAL_MELEE, EnumSet.of(Props.HEAVY, Props.REACH, Props.TWO_HANDED), 1, 10, 0, false, DmgType.SLASHING));

        ALL_WEAPONS.add(new Weapon("Lance", 6, 10,
                Category.MARTIAL_MELEE, EnumSet.of(Props.REACH, Props.SPECIAL), 1, 12, 0, false, DmgType.PIERCING));

        ALL_WEAPONS.add(new Weapon("Longsword", 3, 15,
                Category.MARTIAL_MELEE, EnumSet.of(Props.VERSATILE), 1, 8, 0, false, DmgType.SLASHING));

        ALL_WEAPONS.add(new Weapon("Maul", 10, 10,
                Category.MARTIAL_MELEE, EnumSet.of(Props.HEAVY, Props.TWO_HANDED), 2, 6, 0, false, DmgType.BLUDGEONING));

        ALL_WEAPONS.add(new Weapon("Morningstar", 4, 15,
                Category.MARTIAL_MELEE, EnumSet.noneOf(Props.class), 1, 8, 0, false, DmgType.PIERCING));

        ALL_WEAPONS.add(new Weapon("Pike", 18, 5,
                Category.MARTIAL_MELEE, EnumSet.of(Props.HEAVY, Props.REACH, Props.TWO_HANDED), 1, 10, 0, false, DmgType.PIERCING));

        ALL_WEAPONS.add(new Weapon("Rapier", 2, 25,
                Category.MARTIAL_MELEE, EnumSet.of(Props.FINESSE), 1, 8, 0, false, DmgType.PIERCING));

        ALL_WEAPONS.add(new Weapon("Scimitar", 3, 25,
                Category.MARTIAL_MELEE, EnumSet.of(Props.FINESSE, Props.LIGHT), 1, 6, 0, false, DmgType.SLASHING));

        ALL_WEAPONS.add(new Weapon("Shortsword", 2, 10,
                Category.MARTIAL_MELEE, EnumSet.of(Props.FINESSE, Props.LIGHT), 1, 6, 0, false, DmgType.PIERCING));

        ALL_WEAPONS.add(new Weapon("Trident", 4, 5,
                Category.MARTIAL_MELEE, EnumSet.of(Props.THROWN, Props.VERSATILE), 1, 6, 0, false, DmgType.PIERCING));

        ALL_WEAPONS.add(new Weapon("War Pick", 2, 5,
                Category.MARTIAL_MELEE, EnumSet.noneOf(Props.class), 1, 8, 0, false, DmgType.PIERCING));

        ALL_WEAPONS.add(new Weapon("Warhammer", 2, 15,
                Category.MARTIAL_MELEE, EnumSet.of(Props.VERSATILE), 1, 8, 0, false, DmgType.BLUDGEONING));

        ALL_WEAPONS.add(new Weapon("Whip", 3, 2,
                Category.MARTIAL_MELEE, EnumSet.of(Props.FINESSE, Props.REACH), 1, 4, 0, false, DmgType.SLASHING));

        // ===== ARMAS MARCIALES A DISTANCIA =====
        ALL_WEAPONS.add(new Weapon("Blowgun", 1, 10,
                Category.MARTIAL_RANGED, EnumSet.of(Props.AMMUNITION, Props.LOADING), 1, 1, 0, false, DmgType.PIERCING));

        ALL_WEAPONS.add(new Weapon("Hand Crossbow", 3, 75,
                Category.MARTIAL_RANGED, EnumSet.of(Props.AMMUNITION, Props.LIGHT, Props.LOADING), 1, 6, 0, false, DmgType.PIERCING));

        ALL_WEAPONS.add(new Weapon("Heavy Crossbow", 18, 50,
                Category.MARTIAL_RANGED, EnumSet.of(Props.AMMUNITION, Props.HEAVY, Props.LOADING, Props.TWO_HANDED), 1, 10, 0, false, DmgType.PIERCING));

        ALL_WEAPONS.add(new Weapon("Longbow", 2, 50,
                Category.MARTIAL_RANGED, EnumSet.of(Props.AMMUNITION, Props.HEAVY, Props.TWO_HANDED), 1, 8, 0, false, DmgType.PIERCING));

        ALL_WEAPONS.add(new Weapon("Net", 3, 1,
                Category.MARTIAL_RANGED, EnumSet.of(Props.SPECIAL, Props.THROWN), 0, 0, 0, false, DmgType.NONE));
    }

    // ---- Ejemplo de uso ----
    public static void main(String[] args) {
        for (Weapon w : ALL_WEAPONS) {
            System.out.println(w + " | Versatile? " + w.HasProp(Props.VERSATILE));
        }
    }
}