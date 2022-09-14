public class MeasurementDTO {
    private double value;

    private Boolean raining;

    private SensorDTO sensor;

    public MeasurementDTO() {
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Boolean getRaining() {
        return raining;
    }

    public void setRaining(Boolean raining) {
        this.raining = raining;
    }

    public SensorDTO getSensor() {
        return sensor;
    }

    public void setSensor(SensorDTO sensor) {
        this.sensor = sensor;
    }
//
//    @Override
//    public String toString() {
//        return "MeasurementDTO{" +
//                "value=" + value +
//                ", raining=" + raining +
//                ", sensor=" + sensor +
//                '}';
//    }
}
