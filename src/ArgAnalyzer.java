import java.util.regex.Pattern;

public class ArgAnalyzer {

    private String latitude;
    private String longitude;
    private String sensor;
    private String url = "";
    private String api = "";
    private boolean history = false;

    public ArgAnalyzer(String[] args){
        String lat = "";
        String lon = "";
        String id = "";
        String key = "";
        if(args.length < 2 || args.length > 7) throw new IllegalArgumentException("Podano niewłaściwe argumenty. Użycie: --longitude x " +
                "--latitude y lub --sensor-id x (opcjonalne argumenty: --apikey x, --history)");
        for(int i = 0; i < args.length; i++) {
            if(Pattern.matches("--latitude",args[i])){
                if(i+1 < args.length && Pattern.matches("\\d+\\.*\\d*",args[i+1]))lat = args[++i];
                else throw new IllegalArgumentException("Podano niewłaściwe argumenty. Użycie: --latitude x (x jest liczbą)");
            }
            else if(Pattern.matches("--longitude",args[i])){
                if(i+1 < args.length && Pattern.matches("\\d+\\.*\\d*",args[i+1]))lon = args[++i];
                else throw new IllegalArgumentException("Podano niewłaściwe argumenty. Użycie: --longitude x (x jest liczbą)");
            }
            else if(Pattern.matches("--sensor-id",args[i])){
                if(i+1 < args.length && Pattern.matches("\\d+",args[i+1]))id = args[++i];
                else throw new IllegalArgumentException("Podano niewłaściwe argumenty. Użycie: --sensor-id x (x jest liczbą)");
            }
            else if(Pattern.matches("--apikey",args[i])){
                if(i+1 < args.length && Pattern.matches("\\w+",args[i+1]))key = args[++i];
                else throw new IllegalArgumentException("Podano niewłaściwy apikey");
            }
            else if(Pattern.matches("--history",args[i])){
                history = true;
            }
            else throw new IllegalArgumentException("Podano niewłaściwe argumenty. Użycie: --longitude x " +
                    "--latitude y lub --sensor-id x (opcjonalne argumenty: --apikey x, --history)");
        }
        latitude = lat;
        longitude = lon;
        api = key;
        sensor = id;
    }

    public String getUrl() {            //jesli byl podany sensor-id jako argument to zwroci odpowiedni url
        if(!sensor.equals("")){
            url = "https://airapi.airly.eu/v1/sensor/measurements?sensorId=" + sensor;
        }
        else{
            url = "https://airapi.airly.eu/v1/nearestSensor/measurements?latitude="+latitude+
                    "&longitude="+longitude+"&maxDistance=1000";
        }
        return url;
    }

    public String setAndGetUrl(int n){
        url = "https://airapi.airly.eu/v1/sensor/measurements?sensorId=" + n;
        return url;
    }

    public String getKey(){
        return api;
    }

    public boolean isHistory(){return history;}

}
