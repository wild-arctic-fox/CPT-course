package sample.components;

import sample.components.Enums.MicrowaveModes;

import java.util.Date;

public class
Microwave  implements SmartComponent{
    private static Microwave instance;
    private int time;
    private int temperature;
    private boolean power;
    private boolean stop;
    private MicrowaveModes currentMode;
    private static final int MIN_TEMPERATURE = 40;
    private static final int MAX_TEMPERATURE = 200;
    private boolean working;

    private Microwave() {
        this.power = false;
        this.stop = false;
        this.currentMode = MicrowaveModes.Fan_oven;
        this.working = false;
    }

    public static Microwave getInstance() {
        if (instance == null) {
            instance = new Microwave();
        }
        return instance;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public boolean setStop() {
        this.stop = !this.stop;
        if (this.stop) {
            setWorking(false);
        } else {
            setWorking(true);
        }
        return this.stop;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }


    public void useMicrowave(int time) {
        if (isPower()) {
            if (time > 10) {
                setWorking(true);
                setTime(time);
            }
        }
    }

    public void powerOn() {
        this.power = true;
    }

    public void powerOff() {
        this.power = false;
    }

    public void setCurrentMode(MicrowaveModes currentMode) {
        this.currentMode = currentMode;
    }

    public boolean isPower() {
        return power;
    }

    public MicrowaveModes getCurrentMode() {
        return currentMode;
    }

}
