public class Printer {

    private float AQI;          //dane do wypisania
    private float PM1;
    private float PM25;
    private float PM10;
    private float Press;
    private float Hum;
    private float Temp;
    private int PLevel;
    private float histAQI;
    private float histPM1;
    private float histPM25;
    private float histPM10;
    private float histPress;
    private float histHum;
    private float histTemp;
    private int histPLevel;

    public void printInfo(boolean isHistory){           //wypisuje dane (opcjonalnie historie jesli byl podany argument)
        for(int i=0;i<36;i++)System.out.print("=");
        System.out.print("POGODA");
        for(int i=0;i<37;i++)System.out.print("=");
        System.out.println();
        for(int i=0;i<37;i++)System.out.print("=");
        System.out.print("DZIŚ");
        for(int i=0;i<38;i++)System.out.print("=");
        System.out.println();
        System.out.printf("%-12s","  \\  /");
        System.out.printf("%-18s %.2f %-7s","AirQualityIndex:",AQI,"");
        System.out.printf("%-18s %-9d %n","PollutionLevel:",PLevel);
        System.out.printf("%-12s","_ /\"\".-.");
        System.out.printf("%-18s %.2f %-7s","PM1:",PM1,"μg/m^3");
        System.out.printf("%-18s %-9.2f μg/m^3%n","PM2.5:",PM25);
        System.out.printf("%-12s","  \\_(   ).");
        System.out.printf("%-18s %.2f %-7s","PM10:",PM10,"μg/m^3");
        System.out.printf("%-18s %-9.2f Pa%n","Pressure:",Press);
        System.out.printf("%-12s","  /(___(__)");
        System.out.printf("%-18s %.2f %-7s","Humidity:",Hum,"%");
        System.out.printf("%-18s %-9.2f °C%n","Temperature:",Temp);
        for(int i=0;i<79;i++)System.out.print("=");
        System.out.println();
        if(isHistory){
            for(int i=0;i<36;i++)System.out.print("=");
            System.out.print("WCZORAJ");
            for(int i=0;i<36;i++)System.out.print("=");
            System.out.println();
            System.out.printf("%-12s","  \\  /");
            System.out.printf("%-18s %.2f %-7s","AirQualityIndex:",histAQI,"");
            System.out.printf("%-18s %-9d %n","PollutionLevel:",histPLevel);
            System.out.printf("%-12s","_ /\"\".-.");
            System.out.printf("%-18s %.2f %-7s","PM1:",histPM1,"μg/m^3");
            System.out.printf("%-18s %-9.2f μg/m^3%n","PM2.5:",histPM25);
            System.out.printf("%-12s","  \\_(   ).");
            System.out.printf("%-18s %.2f %-7s","PM10:",histPM10,"μg/m^3");
            System.out.printf("%-18s %-9.2f Pa%n","Pressure:",histPress);
            System.out.printf("%-12s","  /(___(__)");
            System.out.printf("%-18s %.2f %-7s","Humidity:",histHum,"%");
            System.out.printf("%-18s %-9.2f °C%n","Temperature:",histTemp);
            for(int i=0;i<79;i++)System.out.print("=");
            System.out.println();
        }
    }

    //SETTERY
    public void setAQI(float AQI) {
        this.AQI = AQI;
    }

    public void setHum(float hum) {
        Hum = hum;
    }

    public void setPLevel(int PLevel) {
        this.PLevel = PLevel;
    }

    public void setPM1(float PM1) {
        this.PM1 = PM1;
    }

    public void setPM10(float PM10) {
        this.PM10 = PM10;
    }

    public void setPM25(float PM25) {
        this.PM25 = PM25;
    }

    public void setPress(float press) {
        Press = press;
    }

    public void setTemp(float temp) {
        Temp = temp;
    }

    public void setHistAQI(float histAQI) {
        this.histAQI = histAQI;
    }

    public void setHistHum(float histHum) {
        this.histHum = histHum;
    }

    public void setHistPLevel(int histPLevel) {
        this.histPLevel = histPLevel;
    }

    public void setHistPM1(float histPM1) {
        this.histPM1 = histPM1;
    }

    public void setHistPM10(float histPM10) {
        this.histPM10 = histPM10;
    }

    public void setHistPM25(float histPM25) {
        this.histPM25 = histPM25;
    }

    public void setHistPress(float histPress) {
        this.histPress = histPress;
    }

    public void setHistTemp(float histTemp) {
        this.histTemp = histTemp;
    }
}
