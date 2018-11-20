package Pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by pateniku on 2/6/2017.
 */

public class Power_consumption implements Parcelable {
    //private String status;

    private String value;

//    public String getStatus ()
//    {
//        return status;
//    }
//
//    public void setStatus (String status)
//    {
//        this.status = status;
//    }

    public String getValue ()
    {
        return value;
    }

    public void setValue (String value)
    {
        this.value = value;
    }

//    @Override
//    public String toString()
//    {
//        return "ClassPojo [status = "+status+", value = "+value+"]";
//    }


    @Override
    public String toString()
    {
        return "ClassPojo [ value = "+value+"]";
    }

    protected Power_consumption(Parcel in) {
        value = in.readString();
    }
    public Power_consumption(){}
    @Override
    public int describeContents() {
        return 0;
    }



    @Override
    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeString(status);
        dest.writeString(value);
    }

    @SuppressWarnings("unused")
    public static final Creator<Power_consumption> CREATOR = new Creator<Power_consumption>() {
        @Override
        public Power_consumption createFromParcel(Parcel in) {
            return new Power_consumption(in);
        }

        @Override
        public Power_consumption[] newArray(int size) {
            return new Power_consumption[size];
        }
    };
}