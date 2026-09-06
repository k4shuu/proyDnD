# ProyDnD

An object-oriented Java application for modeling the core elements of a **Dungeons & Dragons 5e** game.

The project represents characters, ability scores, skills, classes, backgrounds, items, weapons, currencies, and inventories. It is designed as a foundation for a future combat and character-management system.

## Project status

Currently implemented:

- Basic entity and player model.
- Ability scores and modifier calculation.
- Skills, classes, and backgrounds represented with enums.
- Basic item and inventory system.
- PHB weapon catalog with categories, properties, damage, weight, and value.
- Currency conversion to copper pieces.
- Basic dice rolls.
- Damage, healing, and initiative in `Entity`.

The project is still under development. `Player` attack logic and several advanced D&D rules have not been implemented yet.

## Technologies

- Java 21 or higher.
- Object-oriented programming.
- Java collections (`List`, `Set`, `EnumSet`).
- Enums for representing fixed domain values.
- IntelliJ IDEA as the recommended development environment.

No frameworks or external dependencies are currently used.

## Project structure

```text
src/
├── Main.java
├── items/
│   ├── Category.java
│   ├── Currency.java
│   ├── DmgType.java
│   ├── Item.java
│   ├── Props.java
│   └── Weapon.java
├── model/
│   ├── Background.java
│   ├── Class.java
│   ├── Entity.java
│   ├── Inventory.java
│   ├── Player.java
│   ├── Skill.java
│   ├── Stat.java
│   └── Stats.java
└── util/
    └── Dice.java
```

## Architecture

The code is organized by responsibility:

- `model`: entities and character-related concepts.
- `items`: items, weapons, categories, properties, and currencies.
- `util`: reusable utilities such as dice rolls.

`Entity` is an abstract class that defines common behavior for game creatures. `Player` extends it and adds player-specific data such as the proficiency bonus and death saving throws.

`Inventory` manages objects of type `Item`. Since `Weapon` extends `Item`, weapons can be stored alongside other items. The association between a player and an inventory is planned for a future stage.

## Main features

### Ability scores

`Stats` manages Strength, Dexterity, Constitution, Intelligence, Wisdom, and Charisma.

Modifiers are calculated using the D&D 5e formula:

```text
floor((ability score - 10) / 2)
```

### Entities and players

`Entity` contains:

- Name.
- Maximum and current hit points.
- Armor Class.
- Ability scores.
- Initiative.
- Damage handling.
- Healing.
- Initiative rolls.

`Player` includes regular saving throws and death saving throws. Complete attack and combat-resolution logic is planned for future versions.

### Items and inventory

`Item` contains a name, weight, value, quantity, and description. It also calculates total weight and value based on the item quantity.

`Inventory` supports:

- Adding items.
- Removing items.
- Accessing stored items.
- Calculating total weight.

### Weapons

`Weapon` includes:

- Category: simple or martial, melee or ranged.
- Damage type.
- Damage dice.
- Magic bonus.
- Properties such as `LIGHT`, `FINESSE`, `REACH`, `THROWN`, and `TWO_HANDED`.
- A static catalog of available weapons.

### Currency

Values are stored as copper pieces (`CP`) to avoid floating-point precision issues:

```text
1 CP  = 1 copper piece
1 SP  = 10 copper pieces
1 GP  = 100 copper pieces
1 PP  = 1000 copper pieces
```

Electrum (`EP`) is not currently supported.

## Running the project

From the project root:

```bash
mkdir -p out
javac -d out $(find src -name "*.java")
java -cp out Main
```

The project can also be opened through `ProyDnD.iml` in IntelliJ IDEA. Make sure that `src` is marked as the **Sources Root**.

## Usage example

```java
Stats stats = new Stats(16, 14, 12, 10, 10, 8);
Player player = new Player("Arthas", 12, 16, stats, 2);
Inventory inventory = new Inventory();

Weapon weapon = Weapon.ALL_WEAPONS.get(1);
inventory.addItem(weapon);

System.out.println(player.getName());
System.out.println(weapon);
```

## Future goals

- Implement the combat system.
- Complete attacks, attack rolls, and damage resolution.
- Add critical hits and damage resistances.
- Implement conditions and status effects.
- Complete D&D 5e death saving throw rules.
- Associate each skill with its governing ability score.
- Add class and background proficiencies.
- Add equipped weapons, ammunition, and special properties.
- Add inventory carrying capacity.
- Create automated tests.
- Add character creation and progression systems.

## Learning objectives

This project demonstrates fundamental Java concepts:

- Inheritance and abstract classes.
- Encapsulation.
- Object composition.
- Enums with fields and constructors.
- Collections and streams.
- Separation of responsibilities through packages.
- Business-rule modeling.

## Author

Personal project developed as practice in Java and object-oriented programming.
