import java.net.URL;

public class Main {
    public static void main(String[] args){
        try{
            int code = 0;                                                   //kod 'postępu'
            boolean argsNotRead = true;                                     //bool czy argumenty przeczytane
            Printer printer = new Printer();
            ArgAnalyzer analyzer = new ArgAnalyzer(args);
            URL obj;
            Parser parser = new Parser();
            do {
                if(argsNotRead){                                            //jesli argumenty nie byly czytane to czytaj
                    obj = new URL(analyzer.getUrl());
                    argsNotRead = false;
                }
                else obj = new URL(analyzer.setAndGetUrl(code));            //jesli byly przeczytane a nadal jestesmy w petli oznacza to
                CurlReader reader = new CurlReader(obj, analyzer.getKey()); //ze jako argumenty podane byly wspolrzedne. W tym wypadku czytamy
                reader.setResponse();                                       //z jsona id sensora ktory byl najblizej i drugi raz laczymy sie
                code = parser.parse(reader.getResponse(),printer);          //ze strona i pobieramy juz pomiary tego konkretnego sensora
            }while(code != 0);                                              //jesli argumentem byl sensor-id to code==0 jesli nie to code==sensor-id
            printer.printInfo(analyzer.isHistory());                        //wypisujemy dane
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

}
