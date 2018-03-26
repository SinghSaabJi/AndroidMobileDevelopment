package com.example.msingh.cityviewer;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;

public class ImageHeader implements Parcelable {

    public ImageData[] images;
    public int currImagePosition;

    public  ImageHeader(){

    }

    private ImageData[] toMyObjects(Object[] parcelables) {
        if (parcelables == null)
            return null;
        return Arrays.copyOf(parcelables, parcelables.length, ImageData[].class);
    }

    protected ImageHeader(Parcel in) {
        images = toMyObjects(in.readArray(ImageData.class.getClassLoader()));
        currImagePosition = in.readInt();
    }

    public static final Creator<ImageHeader> CREATOR = new Creator<ImageHeader>() {
        @Override
        public ImageHeader createFromParcel(Parcel in) {
            return new ImageHeader(in);
        }

        @Override
        public ImageHeader[] newArray(int size) {
            return new ImageHeader[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeArray(images);
        dest.writeInt(currImagePosition);
    }
}
