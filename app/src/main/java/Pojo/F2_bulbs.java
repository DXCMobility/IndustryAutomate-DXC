package Pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by pateniku on 2/6/2017.
 */

public class F2_bulbs implements Parcelable {
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

    protected F2_bulbs(Parcel in) {
        status = in.readString();
        value = in.readString();
    }
        public F2_bulbs(){}
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
    public static final Creator<F2_bulbs> CREATOR = new Creator<F2_bulbs>() {
        @Override
        public F2_bulbs createFromParcel(Parcel in) {
            return new F2_bulbs(in);
        }

        @Override
        public F2_bulbs[] newArray(int size) {
            return new F2_bulbs[size];
        }
    };
}