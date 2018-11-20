package Pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by pateniku on 2/6/2017.
 */

public class Industry2 implements Parcelable {
    private F2_bulbs[] f2_bulbs;

    private Sound sound;

    public F2_bulbs[] getF2_bulbs ()
    {
        return f2_bulbs;
    }

    public void setF2_bulbs (F2_bulbs[] f2_bulbs)
    {
        this.f2_bulbs = f2_bulbs;
    }

    public Sound getSound ()
    {
        return sound;
    }

    public void setSound (Sound sound)
    {
        this.sound = sound;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [f2_bulbs = "+f2_bulbs+", sound = "+sound+"]";
    }

    protected Industry2(Parcel in) {
        sound = (Sound) in.readValue(Sound.class.getClassLoader());
    }
    public Industry2(){}
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(sound);
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