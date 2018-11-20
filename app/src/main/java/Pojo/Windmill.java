package Pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by pateniku on 2/6/2017.
 */

public class Windmill implements Parcelable {
    private String status;

    private String generated_power;

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    public String getGenerated_power ()
    {
        return generated_power;
    }

    public void setGenerated_power (String generated_power)
    {
        this.generated_power = generated_power;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [status = "+status+", generated_power = "+generated_power+"]";
    }

    protected Windmill(Parcel in) {
        status = in.readString();
        generated_power = in.readString();
    }
    public Windmill(){}

    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(status);
        dest.writeString(generated_power);
    }

    @SuppressWarnings("unused")
    public static final Creator<Windmill> CREATOR = new Creator<Windmill>() {
        @Override
        public Windmill createFromParcel(Parcel in) {
            return new Windmill(in);
        }

        @Override
        public Windmill[] newArray(int size) {
            return new Windmill[size];
        }
    };
}