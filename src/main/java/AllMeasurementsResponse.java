import java.util.List;

public class AllMeasurementsResponse {
    List<MeasurementDTO> allMeasurements;

    public List<MeasurementDTO> getAllMeasurements() {
        return allMeasurements;
    }

    public void setAllMeasurements(List<MeasurementDTO> allMeasurements) {
        this.allMeasurements = allMeasurements;
    }
}
