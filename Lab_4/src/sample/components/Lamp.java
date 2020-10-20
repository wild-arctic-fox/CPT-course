package sample.components;

import sample.components.Enums.Color;

public class Lamp implements SmartComponent{
    private static Lamp instance;
    private boolean power;
    private float brightness;
    private Color color;

    private Lamp() {
        this.power = false;
        this.brightness = 50;
        this.color = Color.White;
    }

    public static Lamp getInstance() {
        if (instance == null) {
            instance = new Lamp();
        }
        return instance;
    }

    public boolean isPower() {
        return power;
    }

    public float getBrightness() {
        return brightness;
    }

    public Color getColor() {
        return color;
    }

    public void powerOn() {
        this.power = true;
    }

    public void powerOff() {
        this.power = false;
    }

    private void setBrightness(float brightness) {
        this.brightness = brightness;
    }

    private void setColor(Color color) {
        this.color = color;
    }

    public float changeBrightness(float brightness) {
        if (isPower()) {
            setBrightness(brightness);
            return this.brightness;
        } else {
            throw new RuntimeException( "Can not change brightness, \ndevise is switched off");
        }
    }

    public Color changeColor(Color color) {
        if (isPower()) {
            setColor(color);
            return this.color;
        } else {
            throw new RuntimeException( "Can not change color, \ndevise is switched off");
        }
    }
}
