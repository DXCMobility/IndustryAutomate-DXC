package Pojo;

/**
 * Created by kumardev on 4/5/2017.
 */

public class IndustryResponse {
    private Assembly_cooling_fan assembly_cooling_fan;
    private  Assembly_line assembly_line;
    private Generic_fan generic_fan;
    private Humidity humidity;
    private Power_consumption power_consumption;
    private Temp temp;

    public IndustryResponse() {
    }

    public Assembly_cooling_fan getAssembly_cooling_fan() {
        return assembly_cooling_fan;
    }

    public void setAssembly_cooling_fan(Assembly_cooling_fan assembly_cooling_fan) {
        this.assembly_cooling_fan = assembly_cooling_fan;
    }

    public Assembly_line getAssembly_line() {
        return assembly_line;
    }

    public void setAssembly_line(Assembly_line assembly_line) {
        this.assembly_line = assembly_line;
    }

    public Generic_fan getGeneric_fan() {
        return generic_fan;
    }

    public void setGeneric_fan(Generic_fan generic_fan) {
        this.generic_fan = generic_fan;
    }

    public Humidity getHumidity() {
        return humidity;
    }

    public void setHumidity(Humidity humidity) {
        this.humidity = humidity;
    }

    public Power_consumption getPower_consumption() {
        return power_consumption;
    }

    public void setPower_consumption(Power_consumption power_consumption) {
        this.power_consumption = power_consumption;
    }

    public Temp getTemp() {
        return temp;
    }

    public void setTemp(Temp temp) {
        this.temp = temp;
    }
}
