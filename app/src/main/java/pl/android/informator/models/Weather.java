package pl.android.informator.models;

public class Weather {

    public static final String BURZA = "Burza";
    public static final String DESZCZ = "Opady deszczu";
    public static final String GRAD = "Grad";
    public static final String SLONCE = "Słoneczna pogoda";
    public static final String MZAWKA = "Mżawka";
    public static final String SNIEG = "Opady Śniegu";
    public static final String ZACHMURZONE_NIEBO = "Zachmurzone niebo";
    public static final String CZESCIOWE_ZACHMURZENIE = "Częściowe zachmurzenie";
    public static final String BEZCHMURNA_NOC = "Bezchmurna noc";
    public static final String MGLA = "Mgła";

    private String temp;
    private String tempMax;
    private String weatherType;
    private String humidity;
    private String pressure;




    public Weather(String temp, String tempMax, String weatherType, String humidity, String pressure) {
        this.temp = temp;
        this.tempMax = tempMax;
        this.weatherType = weatherType;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    public String getTemp() {
        return temp;
    }

    public String getTempMax() {
        return tempMax;
    }

    public String getWeatherType() {
        return weatherType;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getPressure() {
        return pressure;
    }
}
