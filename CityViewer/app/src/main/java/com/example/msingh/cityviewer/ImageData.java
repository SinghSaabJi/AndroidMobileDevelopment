package com.example.msingh.cityviewer;
import android.os.Parcel;
import android.os.Parcelable;

public class ImageData implements Parcelable {
    public String mUrl;
    public String mTitle;
    public int currPosition;

    public ImageData(String url, String title,int position) {
        mUrl = url;
        mTitle = title;
        currPosition = position;
    }


    protected ImageData(Parcel in) {
        mUrl = in.readString();
        mTitle = in.readString();
        currPosition = in.readInt();
    }

    public static final Creator<ImageData> CREATOR = new Creator<ImageData>() {
        @Override
        public ImageData createFromParcel(Parcel in) {
            return new ImageData(in);
        }

        @Override
        public ImageData[] newArray(int size) {
            return new ImageData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mUrl);
        parcel.writeString(mTitle);
        parcel.writeInt(currPosition);
    }
}
