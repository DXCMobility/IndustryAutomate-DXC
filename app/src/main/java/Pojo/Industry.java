package Pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by pateniku on 2/6/2017.
 */

public class Industry implements Parcelable {
    private Assembly_cooling_fan assembly_cooling_fan;

    private Humidity humidity;

    private Assembly_line assembly_line;

    private Temp temp;

    private F1_bulbs[] f1_bulbs;

    private Generic_fan generic_fan;
    private String power_consumption;

    private Windmill windmill;

    private Industry2 industry2;

    public Assembly_cooling_fan getAssembly_cooling_fan ()
    {
        return assembly_cooling_fan;
    }

    public void setAssembly_cooling_fan (Assembly_cooling_fan assembly_cooling_fan)
    {
        this.assembly_cooling_fan = assembly_cooling_fan;
    }

    public Humidity getHumidity ()
    {
        return humidity;
    }

    public void setHumidity (Humidity humidity)
    {
        this.humidity = humidity;
    }

    public Assembly_line getAssembly_line ()
    {
        return assembly_line;
    }

    public void setAssembly_line (Assembly_line assembly_line)
    {
        this.assembly_line = assembly_line;
    }

    public Temp getTemp ()
    {
        return temp;
    }
    public void setTemp (Temp temp)
    {
        this.temp = temp;
    }

    public F1_bulbs[] getF1_bulbs ()
    {
        return f1_bulbs;
    }

    public void setF1_bulbs (F1_bulbs[] f1_bulbs)
    {
        this.f1_bulbs = f1_bulbs;
    }
    public void setIndustry2 (Industry2 industry2){this.industry2 = industry2;}
    public Generic_fan getGeneric_fan ()
    {
        return generic_fan;
    }
    public Windmill getWindmill(){return windmill;}
    public Industry2 getIndustry2(){return industry2;}

    public String getPower_consumption() {
        return power_consumption;
    }

    public void setPower_consumption(String power_consumption) {
        this.power_consumption = power_consumption;
    }

    public void setGeneric_fan (Generic_fan generic_fan)
    {
        this.generic_fan = generic_fan;
    }
    public  void setWindmill(Windmill windmill){this.windmill = windmill;}
    @Override
    public String toString()
    {
        return "ClassPojo [assembly_cooling_fan = "+assembly_cooling_fan+", humidity = "+humidity+", assembly_line = "+assembly_line+", temp = "+temp+", f1_bulbs = "+f1_bulbs+", generic_fan = "+generic_fan+"]";
    }

    protected Industry(Parcel in) {
        assembly_cooling_fan = (Assembly_cooling_fan) in.readValue(Assembly_cooling_fan.class.getClassLoader());
        humidity = (Humidity) in.readValue(Humidity.class.getClassLoader());
        assembly_line = (Assembly_line) in.readValue(Assembly_line.class.getClassLoader());
        temp = (Temp) in.readValue(Temp.class.getClassLoader());
        generic_fan = (Generic_fan) in.readValue(Generic_fan.class.getClassLoader());
        windmill = (Windmill) in.readValue(Windmill.class.getClassLoader());
        industry2 = (Industry2) in.readValue(Industry2.class.getClassLoader());
    }
    public Industry()
    {}

    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(assembly_cooling_fan);
        dest.writeValue(humidity);
        dest.writeValue(assembly_line);
        dest.writeValue(temp);
        dest.writeValue(generic_fan);
        dest.writeValue(windmill);
        dest.writeValue(industry2);
    }

    @SuppressWarnings("unused")
    public static final Creator<Industry> CREATOR = new Creator<Industry>() {
        @Override
        public Industry createFromParcel(Parcel in) {
            return new Industry(in);
        }

        @Override
        public Industry[] newArray(int size) {
            return new Industry[size];
        }
    };
}