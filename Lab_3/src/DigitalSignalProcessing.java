import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DigitalSignalProcessing {

    /**
     * Середнє значення відліків сигналу
     */
    private static double m;

    /**
     * Динамічний діапазон сигналу Ds, який визначається в одиницях фізичного
     * виміру значень відліків сигналу, наприклад вольтах або амперах
     *
     * @param numbers - значення відліків оброблюваного сигналу
     * @return Ds = smax - smin
     */
    public static int getDynamicSignalRange(List<Integer> numbers) {
        int smin = numbers.stream().min(Comparator.comparingInt(o -> o)).get();
        int smax = numbers.stream().max(Comparator.comparingInt(o -> o)).get();
        return smax - smin;
    }

    /**
     * Енергія сигналу Еs = сума квадратів відліків
     *
     * @param numbers - значення відліків оброблюваного сигналу
     * @return Es
     */
    public static int getSignalEnergy(List<Integer> numbers) {
        int energy = numbers.stream().reduce(0, (a, b) -> a + b * b);
        return energy;
    }

    /**
     * Потужність сигналу Рs = (сума квадратів відліків)/кількість відліків
     *
     * @param numbers - значення відліків оброблюваного сигналу
     * @return Рs
     */
    public static double getAverageSignalPower(List<Integer> numbers) {
        double power = (double) numbers.stream().reduce(0, (a, b) -> a + b * b) / numbers.size();
        return power;
    }

    /**
     * Середнє значення відліків сигналу Ms = (сума відліків)/кількість відліків
     *
     * @param numbers - значення відліків оброблюваного сигналу
     * @return Ms
     */
    public static double getAverageValueOfSignalReadings(List<Integer> numbers) {
        double ms = (double) numbers.stream().reduce(0, Integer::sum) / numbers.size();
        DigitalSignalProcessing.m = ms;
        return ms;
    }

    /**
     * Дисперсія значень відліків сигналу ds
     *
     * @param numbers - значення відліків оброблюваного сигналу
     * @return ds
     */
    public static double getVarianceOfSignalReadings(List<Integer> numbers) {
        DigitalSignalProcessing.getAverageValueOfSignalReadings(numbers);
        double ds = numbers.stream().mapToDouble(v -> v).reduce(0, DigitalSignalProcessing::add) / numbers.size();
        return ds;
    }

    private static double add(double a, double b) {
        return a + (b - m) * (b - m);
    }


    /**
     * Функція автокореляції дискретного сигналу
     *
     * @param numbers - значення відліків оброблюваного сигналу
     * @return значення автокореляції
     */
    public static List<Double> getDiscreteSignalAutocorrelationFunction(List<Integer> numbers) {
        List<Double> autocorrelation = new ArrayList<>();
        double tmp;
        for (int t = 0; t <= 5; t++) {
            tmp = 0;
            for (int i = 0; i < numbers.size() - t - 1; i++) {
                tmp += (numbers.get(i + t) - m) * (numbers.get(i) - m);
            }
            autocorrelation.add(tmp / numbers.size() - t);
        }
        return autocorrelation;
    }


    /**
     * Інтервал кореляції:
     *
     * @return інтервал кореляції
     */
    public static double getCorrelationInterval(List<Integer> numbers, List<Double> autocorrelation) {
        double tau;
        double Rxxj = 0;
        double Rxx0 = 0;
        for (Double aDouble : autocorrelation) {
            Rxxj += aDouble;
        }
        for (int i = 0, t = 0; i < numbers.size() - t - 1; i++) {
            Rxx0 += (numbers.get(i + t) - m) * (numbers.get(i) - m);
        }
        tau = Rxxj / Rxx0;
        return tau;
    }

}