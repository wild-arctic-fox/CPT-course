import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {

        if (args.length == 1) {
            List<Integer> numbers = ReadFile.readDataFromFile(args[0]);

            int dynamicSignalRange = DigitalSignalProcessing.getDynamicSignalRange(numbers);
            int signalEnergy = DigitalSignalProcessing.getSignalEnergy(numbers);
            double averageSignalPower = DigitalSignalProcessing.getAverageSignalPower(numbers);
            double valueOfSignalReadings = DigitalSignalProcessing.getAverageValueOfSignalReadings(numbers);
            double varianceOfSignalReadings = DigitalSignalProcessing.getVarianceOfSignalReadings(numbers);
            List<Double> autocorrelation = DigitalSignalProcessing.getDiscreteSignalAutocorrelationFunction(numbers);
            double correlationInterval = DigitalSignalProcessing.getCorrelationInterval(numbers, autocorrelation);

            System.out.println("Dynamic signal range: " + dynamicSignalRange);
            System.out.println("Signal energy: " + signalEnergy);
            System.out.println("Average signal power: " + averageSignalPower);
            System.out.println("Value of signal readings: " + valueOfSignalReadings);
            System.out.println("Variance of signal readings: " + varianceOfSignalReadings);
            for (int i = 0; i < autocorrelation.size(); i++) {
                System.out.println("t = " + i + " : autocorrelation = " + autocorrelation.get(i));
            }
            System.out.println("Correlation interval: " + correlationInterval);
        } else {
            System.err.println("Incorrect input data");
        }
    }
}
