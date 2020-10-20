package sample.components;

import sample.components.Enums.CoffeeDrinkTypes;

public class CoffeeMachine {
    private static CoffeeMachine instance;
    private int sugar;
    private static final int MIN_SUGAR_GRAM = 0;
    private static final int MAX_SUGAR_GRAM = 100;
    private CoffeeDrinkTypes type;

    private CoffeeMachine() {
        this.sugar = 20;
        this.type = CoffeeDrinkTypes.Espresso;
    }

    public int getSugar() {
        return sugar;
    }

    public CoffeeDrinkTypes getType() {
        return type;
    }

    public static CoffeeMachine getInstance() {
        if (instance == null) {
            instance = new CoffeeMachine();
        }
        return instance;
    }

    private void setSugar(int sugar) {
        this.sugar = sugar;
    }

    private void setType(CoffeeDrinkTypes type) {
        this.type = type;
    }


    public void makeCoffee(CoffeeDrinkTypes coffeeDrinkType, int sugar) {
        if (sugar >= MIN_SUGAR_GRAM && sugar <= MAX_SUGAR_GRAM) {
            setSugar(sugar);
            setType(coffeeDrinkType);
        } else {
            throw new RuntimeException("Can not make coffee,\nincorrect amount of sugar");
        }
    }
}
