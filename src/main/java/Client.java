import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Client {
    static RestTemplate restTemplate = new RestTemplate();

    static String sensorRegistrationUrl = "http://localhost:8080/sensors/registration";
    static String measurementAddUrl = "http://localhost:8080/measurements/add";
    static String measurementsGetUrl = "http://localhost:8080/measurements";

    public static void main(String[] args) {

        String sensorName = "Sensor3";

//        registerSensor(sensorName);
//        //регистрация сенсора
//
//        add1000measurements(sensorName);
//        //добавление 1000 измерений

        printAllMeasurements(getAllMeasurements());
        //печатаем данные всехизмерений
    }

    private static void registerSensor(String sensorName) {
        Map<String, String> sensorReg = new HashMap<>();
        sensorReg.put("name", sensorName);
        HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(sensorReg);

        String response = restTemplate.postForObject(sensorRegistrationUrl, httpEntity, String.class); //может ответ не должен быть сенсордто

        System.out.println(response);
    }

    private static void add1000measurements(String sensorName) {
        Map<String, Object> measurementAdd = new HashMap<>();
        Random random = new Random();

        for (int i = 0; i < 1000; i++) {
            double value = random.nextInt(201) - 100;
            boolean isRaining = random.nextBoolean();

            measurementAdd.put("value", value);
            measurementAdd.put("raining", isRaining);
            measurementAdd.put("sensor", Map.of("name", sensorName));

            HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<>(measurementAdd);

            String response = restTemplate.postForObject(measurementAddUrl, httpEntity, String.class);
        }
    }

    private static List<MeasurementDTO> getAllMeasurements() {
        AllMeasurementsResponse response = restTemplate.getForObject(measurementsGetUrl, AllMeasurementsResponse.class);
        return response.getAllMeasurements();
    }

    private static void printAllMeasurements(List<MeasurementDTO> allMeasurements) {
        for (MeasurementDTO measurementDTO: allMeasurements) {
            String isRaining = measurementDTO.getRaining() ? "no rain" : "rain";
            System.out.println("Measurement value: " + measurementDTO.getValue() +  ", " + isRaining + ", Sensor name: " + measurementDTO.getSensor().getName());
        }
    }
}
