package sample.components;

public class Kettle implements SmartComponent{
    private static Kettle instance;
    private boolean power;
    private float temperature;
    private final float MAX_TEMPERATURE = 100;
    private final float MIN_TEMPERATURE = 0;
    private float time;

    private Kettle() {
        this.power = false;
        this.temperature = MAX_TEMPERATURE;
    }

    public static Kettle getInstance() {
        if (instance == null) {
            instance = new Kettle();
        }
        return instance;
    }

    public void powerOn() {
        this.power = true;
    }

    public void powerOff() {
        this.power = false;
    }

    private void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    private void setTime(float time) {
        this.time = time;
    }

    public boolean isPower() {
        return power;
    }

    public float heatUp(float temperature) {
        if (isPower()) {
            if (temperature <= MAX_TEMPERATURE && temperature >= MIN_TEMPERATURE) {
                setTemperature(temperature);
                return this.temperature;
            } else {
                throw new RuntimeException("Can not heat up, \nincorrect temperature");
            }
        } else {
            throw new RuntimeException("Can not heat up, \ndevise is switched off");
        }
    }

    public float boil() {
        if (isPower()) {
            setTemperature(MAX_TEMPERATURE);
            return this.temperature;
        } else {
            throw new RuntimeException("Can not boil, \ndevise is switched off");
        }
    }

    public float boil(float time) {
        if (isPower()) {
            setTemperature(MAX_TEMPERATURE);
            setTime(time);
            return this.time;
        } else {
            throw new RuntimeException("Can not boil, \ndevise is switched off");
        }
    }


}
