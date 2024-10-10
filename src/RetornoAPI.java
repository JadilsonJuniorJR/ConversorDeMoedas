import java.util.Map;
public class RetornoAPI {
    private final double conversion_rate;

    public RetornoAPI(double conversionRate) {
        conversion_rate = conversionRate;
    }

    public double getConversionRate() {
        return conversion_rate;
    }

}
