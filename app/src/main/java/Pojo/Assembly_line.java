package Pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by pateniku on 2/6/2017.
 */

public class Assembly_line implements Parcelable {
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

    protected Assembly_line(Parcel in) {
        status = in.readString();
        value = in.readString();
    }
    public Assembly_line(){}
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
    public static final Creator<Assembly_line> CREATOR = new Creator<Assembly_line>() {
        @Override
        public Assembly_line createFromParcel(Parcel in) {
            return new Assembly_line(in);
        }

        @Override
        public Assembly_line[] newArray(int size) {
            return new Assembly_line[size];
        }
    };
}