package br.com.planets.drivers.database;

/**
 * @author Rogério Alves
 */
public enum WeatherTypeEnum {

    RAIN("Iluvia"),
    DROUGHT("Sequía"),
    OPTIMAL_PRESSURE("Condiciones Óptimas"),
    UNKNONW("Desconocido")
    ;

    private String weatherType;

    public String getWeatherType() {
        return weatherType;
    }

    WeatherTypeEnum(final String weatherType) {
        this.weatherType = weatherType;
    }
}
