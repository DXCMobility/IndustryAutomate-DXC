package Pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by pateniku on 2/6/2017.
 */
public class Generic_fan implements Parcelable {
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

    protected Generic_fan(Parcel in) {
        status = in.readString();
        value = in.readString();
    }
public Generic_fan(){}
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
    public static final Creator<Generic_fan> CREATOR = new Creator<Generic_fan>() {
        @Override
        public Generic_fan createFromParcel(Parcel in) {
            return new Generic_fan(in);
        }

        @Override
        public Generic_fan[] newArray(int size) {
            return new Generic_fan[size];
        }
    };
}