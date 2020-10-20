package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.components.*;
import sample.components.Enums.Channels;
import sample.components.Enums.CoffeeDrinkTypes;
import sample.components.Enums.Color;
import sample.components.Enums.MicrowaveModes;


public class Controller {

    @FXML
    public Slider coffeeSugar;
    @FXML
    public ChoiceBox coffeeType;
    @FXML
    public Button kettleBtn;
    @FXML
    public Slider kettleTemp;
    @FXML
    public CheckBox kettlePower;
    @FXML
    public TextArea kettleTime;
    @FXML
    public Button lampBtn;
    @FXML
    public Slider lampBri;
    @FXML
    public CheckBox lampPower;
    @FXML
    public ChoiceBox lampColor;
    @FXML
    public Button tvBtn;
    @FXML
    public Slider tvVolume;
    @FXML
    public CheckBox tvPower;
    @FXML
    public ChoiceBox tvChannels;
    @FXML
    public CheckBox microwavePower;
    @FXML
    public ChoiceBox microMode;
    @FXML
    public Slider microwaveTemp;
    @FXML
    public Button microwaveBtn;
    @FXML
    public CheckBox microwaveStop;
    @FXML
    public TextArea info;
    @FXML
    public TextField microTime;
    @FXML
    private Button coffeeBtn;

    private Kettle kettle = ComponentsFactory.createKettle();
    private Lamp lamp = ComponentsFactory.createLamp();
    private CoffeeMachine coffeeMachine = ComponentsFactory.createCoffeeMachine();
    private TV tv = ComponentsFactory.createTV();
    private Microwave microwave = ComponentsFactory.createMicrowave();


    @FXML
    private void clickCoffee(ActionEvent event) {
        try {
            String msg = "Coffee";
            String type = (String) this.coffeeType.getValue();
            int sugar = (int) this.coffeeSugar.getValue();
            coffeeMachine.makeCoffee(CoffeeDrinkTypes.valueOf(type), sugar);
            msg += "\nType: " + coffeeMachine.getType().toString() +
                    "\nSugar: " + coffeeMachine.getSugar();
            this.info.setText(msg);
        } catch (RuntimeException e) {
            this.info.setText(e.getMessage());
        }
    }

    @FXML
    public void clickLamp(ActionEvent actionEvent) {
        try {
            String msg = "Lamp";
            String color = (String) this.lampColor.getValue();
            float bri = (float) Math.floor(this.lampBri.getValue());
            msg += "\nBrightness: " + lamp.changeBrightness(bri);
            msg += "\nColor: " + lamp.changeColor(Color.valueOf(color));
            this.info.setText(msg);
        } catch (RuntimeException e) {
            this.info.setText(e.getMessage());
        }
    }

    @FXML
    public void clickKettle(ActionEvent actionEvent) {
        try {
            String msg;
            float time;
            float temp = (float) this.kettleTemp.getValue();
            if (temp == 100) {
                try {
                    time = Float.parseFloat(this.kettleTime.getText());
                } catch (RuntimeException e) {
                    time = -1;
                }
                if (time > 0) {
                    msg = "Boiling \nTime : " + kettle.boil(Float.parseFloat(this.kettleTime.getText())) +
                            "\nTemperature : " + kettle.boil();
                    this.info.setText(msg);
                } else {
                    msg = "Boiling \nTemperature : " + kettle.boil();
                    this.info.setText(msg);
                }
            } else {
                msg = "Heating Up\nTemperature : " + kettle.heatUp(temp);
                this.info.setText(msg);
            }
        } catch (RuntimeException e) {
            this.info.setText(e.getMessage());
        }
    }

    @FXML
    public void clickTV(ActionEvent actionEvent) {
        try {
            String msg = "TV";
            String chanel = (String) this.tvChannels.getValue();
            int volume = (int) (this.tvVolume.getValue());
            msg += "\nVolume: " + tv.switchVolume(volume);
            msg += "\nChannel: " + tv.switchChanel(Channels.valueOf(chanel));
            this.info.setText(msg);
        } catch (RuntimeException e) {
            this.info.setText(e.getMessage());
        }
    }

    @FXML
    public void clickMicrowave(ActionEvent actionEvent) {
        try {
            String msg = "Microwave";
            String mode = (String) this.microMode.getValue();
            int temp = (int) (this.microwaveTemp.getValue());
            int time = (Integer.parseInt(this.microTime.getText()));
            microwave.setCurrentMode(MicrowaveModes.valueOf(mode));
            microwave.setWorking(true);
            microwave.useMicrowave(time);
            microwave.setTemperature(temp);
            msg += "\nTime: " + microwave.getTime();
            msg += "\nTemperature: " + microwave.getTemperature();
            msg += "\nMode: " + microwave.getCurrentMode();
            this.info.setText(msg);
        } catch (RuntimeException e) {
            this.info.setText(e.getMessage());
        }
    }

    @FXML
    public void checkKettlePower(ActionEvent actionEvent) {
        if ((this.kettlePower.isSelected())) {
            kettle.powerOn();
        } else {
            kettle.powerOff();
        }
    }

    @FXML
    public void checkLampPower(ActionEvent actionEvent) {
        if ((this.lampPower.isSelected())) {
            lamp.powerOn();
        } else {
            lamp.powerOff();
        }
    }

    @FXML
    public void checkTVPower(ActionEvent actionEvent) {
        if ((this.tvPower.isSelected())) {
            tv.powerOn();
        } else {
            tv.powerOff();
        }
    }

    @FXML
    public void checkMicrowavePower(ActionEvent actionEvent) {
        if ((this.microwavePower.isSelected())) {
            microwave.powerOn();
        } else {
            microwave.powerOff();
        }
    }

    @FXML
    public void checkMicrowaveStop(ActionEvent actionEvent) {
        if ((this.microwavePower.isSelected())) {
            if ((this.microwaveStop.isSelected())) {
                microwave.setStop();
            }
        }
    }
}
