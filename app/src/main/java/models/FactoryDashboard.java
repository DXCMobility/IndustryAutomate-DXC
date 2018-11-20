package models;

import java.util.ArrayList;

/**
 * Created by kumardev on 2/3/2017.
 */

public class FactoryDashboard {
    private String factory;
    private String status;
    private String power_consumption;
    private String temp;
    private String humidity;

    public ArrayList<String> getImages_text() {
        return images_text;
    }

    public void setImages_text(ArrayList<String> images_text) {
        this.images_text = images_text;
    }

    private ArrayList<String> images_text;

    public ArrayList<Integer> getImages() {
        return images;
    }

    public void setImages(ArrayList<Integer> images) {
        this.images = images;
    }

    private ArrayList<Integer> images;

    public FactoryDashboard(String factory, String power_consumption, String temp, String humidity, ArrayList<Integer> images,ArrayList<String> images_text) {
        this.factory=factory;
        this.power_consumption = power_consumption;
        this.temp = temp;
        this.humidity = humidity;
        this.images=images;
        this.images_text=images_text;
    }

    public  String getFactory()
    {
        return factory;
    }
    public String getStatus() {
        return status;
    }

    public void setFactory(String factory)
    {
        this.factory=factory;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPower_consumption() {
        return power_consumption;
    }

    public void setPower_consumption(String power_consumption) {
        this.power_consumption = power_consumption;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }
}
