package sample.components;

import sample.components.Enums.Channels;

public class TV implements SmartComponent{
    private static TV instance;
    private boolean power;
    private Channels channel;
    private int volume;
    private final int MAX_VOLUME = 100;
    private final int MIN_VOLUME = 0;

    private TV() {
        this.power = false;
        this.channel = Channels.ABC;
        this.volume = 10;
    }

    public static TV getInstance() {
        if (instance == null) {
            instance = new TV();
        }
        return instance;
    }

    public void powerOn() {
        this.power = true;
    }

    public void powerOff() {
        this.power = false;
    }

    public boolean isPower() {
        return power;
    }

    private void setChannel(Channels channel) {
        this.channel = channel;
    }

    private void setVolume(int volume) {
        this.volume = volume;
    }

    public Channels switchChanel(Channels channel) {
        if (isPower()) {
            setChannel(channel);
            return this.channel;
        } else {
            throw new RuntimeException("Can not change channel, \ndevise is switched off");
        }
    }

    public int switchVolume(int volume) {
        if (isPower()) {
            if (volume <= MAX_VOLUME && volume >= MIN_VOLUME) {
                setVolume(volume);
                return this.volume;
            } else {
                throw new RuntimeException("Can not change volume, \nunreal volume");
            }
        } else {
            throw new RuntimeException("Can not change volume, \ndevise is switched off");
        }
    }


}
