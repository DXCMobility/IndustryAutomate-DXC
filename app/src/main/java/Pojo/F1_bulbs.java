package Pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by pateniku on 2/6/2017.
 */

public class F1_bulbs implements Parcelable {
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
    public  F1_bulbs(){}
    protected F1_bulbs(Parcel in) {
        status = in.readString();
        value = in.readString();
    }


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
    public static final Creator<F1_bulbs> CREATOR = new Creator<F1_bulbs>() {
        @Override
        public F1_bulbs createFromParcel(Parcel in) {
            return new F1_bulbs(in);
        }

        @Override
        public F1_bulbs[] newArray(int size) {
            return new F1_bulbs[size];
        }
    };
}