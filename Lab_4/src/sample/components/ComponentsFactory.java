package sample.components;

public class ComponentsFactory {

    public static Lamp createLamp() {
        return Lamp.getInstance();
    }

    public static CoffeeMachine createCoffeeMachine() {
        return CoffeeMachine.getInstance();
    }

    public static Kettle createKettle() {
        return Kettle.getInstance();
    }

    public static TV createTV() {
        return TV.getInstance();
    }

    public static Microwave createMicrowave() {
        return Microwave.getInstance();
    }
}
