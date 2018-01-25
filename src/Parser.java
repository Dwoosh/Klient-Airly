import org.json.JSONArray;
import org.json.JSONObject;

public class Parser {

    public int parse(String data, Printer printer){     //pobiera jsona w stringu i printer
        JSONObject object = new JSONObject(data);
        int n = 0;                                      //jesli argumentem podanym byly wspolrzedne
        if(object.has("id")) {                     //to json bedzie zawierac id najblizszego sensora
            n = object.getInt("id");               //wtedy pobieramy to id i zwracamy aby znowu polaczyc sie
            return n;                                   //ze strona i pobrac wlasciwe juz pomiary
        }
        //ustawienie wartosci w printerze
        printer.setAQI(object.getJSONObject("currentMeasurements").getFloat("airQualityIndex"));
        printer.setPM1(object.getJSONObject("currentMeasurements").getFloat("pm1"));
        printer.setPM25(object.getJSONObject("currentMeasurements").getFloat("pm25"));
        printer.setPM10(object.getJSONObject("currentMeasurements").getFloat("pm10"));
        printer.setPress(object.getJSONObject("currentMeasurements").getFloat("pressure"));
        printer.setHum(object.getJSONObject("currentMeasurements").getFloat("humidity"));
        printer.setTemp(object.getJSONObject("currentMeasurements").getFloat("temperature"));
        printer.setPLevel(object.getJSONObject("currentMeasurements").getInt("pollutionLevel"));
        JSONArray arr = object.getJSONArray("history");
        object = arr.getJSONObject(0);
        printer.setHistAQI(object.getJSONObject("measurements").getFloat("airQualityIndex"));
        printer.setHistPM1(object.getJSONObject("measurements").getFloat("pm1"));
        printer.setHistPM25(object.getJSONObject("measurements").getFloat("pm25"));
        printer.setHistPM10(object.getJSONObject("measurements").getFloat("pm10"));
        printer.setHistPress(object.getJSONObject("measurements").getFloat("pressure"));
        printer.setHistHum(object.getJSONObject("measurements").getFloat("humidity"));
        printer.setHistTemp(object.getJSONObject("measurements").getFloat("temperature"));
        printer.setHistPLevel(object.getJSONObject("measurements").getInt("pollutionLevel"));
        return n;
    }

}
