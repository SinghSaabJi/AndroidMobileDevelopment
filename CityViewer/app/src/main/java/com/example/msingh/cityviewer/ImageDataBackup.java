package com.example.msingh.cityviewer;
import android.os.Parcel;
import android.os.Parcelable;

public class ImageDataBackup implements Parcelable {
    private String mUrl;
    private String mTitle;
    public int currPosition;

    public ImageDataBackup(String url, String title,int position) {
        mUrl = url;
        mTitle = title;
        currPosition = position;
    }

    protected ImageDataBackup(Parcel in) {
        mUrl = in.readString();
        mTitle = in.readString();
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

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public static  ImageData[] getImageDatas(String id) {

        return new ImageData[]{
                new ImageData("http://appdevelite.x10host.com/"+id+"1.jpg", "Img",0),
                new ImageData("http://appdevelite.x10host.com/"+id+"2.jpg", "Img",1),
                new ImageData("http://appdevelite.x10host.com/"+id+"3.jpg", "Img",2),
                new ImageData("http://appdevelite.x10host.com/"+id+"4.jpg", "Img",3),
                new ImageData("http://appdevelite.x10host.com/"+id+"5.jpg", "Img",4),
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mUrl);
        parcel.writeString(mTitle);
    }
}
