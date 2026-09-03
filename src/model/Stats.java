package model;

public class Stats {
    private int Str;
    private int Dex;
    private int Con;
    private int Int;
    private int Wis;
    private int Car;

    public Stats(int str, int dex, int con, int anInt, int wis, int car) {
        this.Str = str;
        this.Dex = dex;
        this.Con = con;
        this.Int = anInt;
        this.Wis = wis;
        this.Car = car;
    }

    public int getModif(Stat stat){
        return switch (stat) {
            case STRENGTH -> Math.floorDiv(Str - 10, 2);
            case DEXTERITY -> Math.floorDiv(Dex - 10, 2);
            case CONSTITUTION -> Math.floorDiv(Con - 10, 2);
            case INTELLIGENCE -> Math.floorDiv(Int - 10, 2);
            case WISDOM -> Math.floorDiv(Wis - 10, 2);
            case CHARISMA -> Math.floorDiv(Car - 10, 2);
            default -> throw new IllegalArgumentException("Unknown stat: " + stat);
        };
    }

    public int getStat(Stat stat){
        return switch (stat) {
            case STRENGTH -> Str;
            case DEXTERITY -> Dex;
            case CONSTITUTION -> Con;
            case INTELLIGENCE -> Int;
            case WISDOM -> Wis;
            case CHARISMA -> Car;
            default -> throw new IllegalArgumentException("Unknown stat: " + stat);
        };
    }

    public void setStat(Stat stat, int value){
        switch (stat) {
            case STRENGTH -> Str = value;
            case DEXTERITY -> Dex = value;
            case CONSTITUTION -> Con = value;
            case INTELLIGENCE -> Int = value;
            case WISDOM -> Wis = value;
            case CHARISMA -> Car = value;
            default -> throw new IllegalArgumentException("Unknown stat: " + stat);
        }
    }
}
