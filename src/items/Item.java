package items;
public class Item {

    protected final String name;
    protected final int weight;   // peso en libras (lb)
    protected final int value;    // valor en piezas de oro (gp)
    protected int quantity;
    protected String description;

    public Item(String name, int weight, int value) {
        this(name, weight, value, 1, "");
    }

    public Item(String name, int weight, int value, int quantity, String description) {
        this.name = name;
        this.weight = weight;
        this.value = value;
        this.quantity = quantity;
        this.description = description;
    }

    public String getName() { return name; }
    public double getWeight() { return weight; }
    public double getValue() { return value; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    // Peso/valor total considerando la cantidad apilada en el inventario
    public double getTotalWeight() { return weight * quantity; }
    public double getTotalValue() { return value * quantity; }

    @Override
    public String toString() {
        return name + " (x" + quantity + ", " + weight + " lb c/u, " + value + " gp c/u)";
    }
}
