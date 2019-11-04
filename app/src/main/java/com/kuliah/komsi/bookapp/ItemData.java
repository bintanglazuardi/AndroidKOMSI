package com.kuliah.komsi.bookapp;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemData implements Parcelable {
    public String itemTitle;
    public String itemSubtitle;
    public String itemImage;
    public String itemDescription;
    public String itemPublisher;
    public String itemPublishDate;
    //Editt

    protected ItemData(Parcel in) {
        itemTitle = in.readString();
        itemSubtitle = in.readString();
        itemImage = in.readString();
        itemDescription = in.readString();
        itemPublisher = in.readString();
        itemPublishDate = in.readString();
        //Editttt
    }

    public ItemData() {

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(itemTitle);
        dest.writeString(itemSubtitle);
        dest.writeString(itemImage);
        dest.writeString(itemDescription);
        dest.writeString(itemPublisher);
        dest.writeString(itemPublishDate);
        //Editttt
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ItemData> CREATOR = new Creator<ItemData>() {
        @Override
        public ItemData createFromParcel(Parcel in) {
            return new ItemData(in);
        }

        @Override
        public ItemData[] newArray(int size) {
            return new ItemData[size];
        }
    };
}
