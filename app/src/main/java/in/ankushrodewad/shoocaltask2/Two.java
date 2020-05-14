package in.ankushrodewad.shoocaltask2;

import android.os.Parcel;
import android.os.Parcelable;

public class Two implements Parcelable {

    private String a;
    private String b;
    private boolean c;

    public Two(String a, String b, boolean c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Two() {
    }

    protected Two(Parcel in) {
        a = in.readString();
        b = in.readString();
        c = in.readByte() != 0;
    }

    public static final Creator<Two> CREATOR = new Creator<Two>() {
        @Override
        public Two createFromParcel(Parcel in) {
            return new Two(in);
        }

        @Override
        public Two[] newArray(int size) {
            return new Two[size];
        }
    };

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public boolean isC() {
        return c;
    }

    public void setC(boolean c) {
        this.c = c;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(a);
        dest.writeString(b);
        dest.writeByte((byte) (c ? 1 : 0));
    }
}
