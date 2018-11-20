package Pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by pateniku on 2/6/2017.
 */

public class Assembly_cooling_fan implements Parcelable {
    private String status;

    private String value;

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    public String getValue ()
    {
        return value;
    }

    public void setValue (String value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [status = "+status+", value = "+value+"]";
    }

    protected Assembly_cooling_fan(Parcel in) {
        status = in.readString();
        value = in.readString();
    }
    public Assembly_cooling_fan(){}

    @Override
    public int describeContents() {
        return 0;
    }



    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(status);
        dest.writeString(value);
    }

    @SuppressWarnings("unused")
    public static final Creator<Assembly_cooling_fan> CREATOR = new Creator<Assembly_cooling_fan>() {
        @Override
        public Assembly_cooling_fan createFromParcel(Parcel in) {
            return new Assembly_cooling_fan(in);
        }

        @Override
        public Assembly_cooling_fan[] newArray(int size) {
            return new Assembly_cooling_fan[size];
        }
    };
}