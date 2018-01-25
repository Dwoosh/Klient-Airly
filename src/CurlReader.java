import java.io.*;
import java.net.*;

public class CurlReader {

        private static String APIkey = "dcb03f4ace9b4fef90ab69e2d08a4755";  //apikey, jesli byl podany jako argument to zostaje zastapiony
        private URL obj;
        private String response;

        public CurlReader(URL o, String key){
            obj = o;
            response = null;
            if(!key.equals(""))APIkey = key;
        }

        public void setResponse() throws IOException{
            response = connectAndReadStream();
        }

        public String getResponse(){
            return response;
        }

        private String connectAndReadStream() throws IOException {              //laczy sie ze strona i pobiera jsona
            String result = null;
            StringBuffer sb = new StringBuffer();
            InputStream is = null;
            try {
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();   //otwarcie polaczenie
                con.setRequestProperty("Accept", "application/json");               //żądanie do api
                con.setReadTimeout(15*1000);                                        //czas na odpowiedz 15s
                con.setRequestMethod("GET");                                        //get z api
                con.setRequestProperty("apikey", APIkey);                           //autoryzacja kluczem
                con.connect();                                                      //polaczenie
                is = new BufferedInputStream(con.getInputStream());                 //pobieranie danych
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String inputLine = "";
                while ((inputLine = br.readLine()) != null) {
                    sb.append(inputLine);
                }
                result = sb.toString();
                con.disconnect();                                                   //rozlaczenie
            }
            catch(IOException ex){
                ex.printStackTrace();
                throw ex;
            }
            return result;
        }


}
