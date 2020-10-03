import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {
        List<Integer> numbers = ReadFile.readDataFromFile("F:\\Desktop\\java\\CPT-course\\Lab_3\\2.bin");

        int dynamicSignalRange = DigitalSignalProcessing.getDynamicSignalRange(numbers);
        int signalEnergy = DigitalSignalProcessing.getSignalEnergy(numbers);
        double averageSignalPower = DigitalSignalProcessing.getAverageSignalPower(numbers);
        double valueOfSignalReadings = DigitalSignalProcessing.getAverageValueOfSignalReadings(numbers);
        double varianceOfSignalReadings = DigitalSignalProcessing.getVarianceOfSignalReadings(numbers);

        System.out.println("Dynamic signal range: " + dynamicSignalRange);
        System.out.println("Signal energy: " + signalEnergy);
        System.out.println("Average signal power: " + averageSignalPower);
        System.out.println("Value of signal readings: " + valueOfSignalReadings);
        System.out.println("Variance of signal readings: " + varianceOfSignalReadings);
    }

}
