package rmsp;

/**
 * Created by michal on 04.10.2015.
 */
public class Value {
    private double value;
    private double confidenceMin;
    private double confidenceMax;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getConfidenceMin() {
        return confidenceMin;
    }

    public void setConfidenceMin(double confidenceMin) {
        this.confidenceMin = confidenceMin;
    }

    public double getConfidenceMax() {
        return confidenceMax;
    }

    public void setConfidenceMax(double confidenceMax) {
        this.confidenceMax = confidenceMax;
    }
}
