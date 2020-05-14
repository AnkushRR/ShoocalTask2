package in.ankushrodewad.shoocaltask2;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class One implements Parcelable {

    private String from_et;
    private String from_spinner;
    private Two[] twos;

    protected One(Parcel in) {
        from_et = in.readString();
        from_spinner = in.readString();
        try {
            Class cls = Class.forName("in.ankushrodewad.shoocaltask2.Two");
            ClassLoader classLoader = cls.getClassLoader();
           // twos = (Two[]) in.readArray(classLoader);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static final Creator<One> CREATOR = new Creator<One>() {
        @Override
        public One createFromParcel(Parcel in) {
            return new One(in);
        }

        @Override
        public One[] newArray(int size) {
            return new One[size];
        }
    };

    public One(String a, String b, Two[] arr) {
        this.from_et = a;
        this.from_spinner = b;
        this.twos = arr;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(from_et);
        dest.writeString(from_spinner);
        dest.writeArray(twos);
    }
}
