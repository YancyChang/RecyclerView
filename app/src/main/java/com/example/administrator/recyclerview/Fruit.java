package com.example.administrator.recyclerview;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2017/7/22.
 */

public class Fruit implements Parcelable {
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(ImageId);
    }
    public static final Parcelable.Creator<Fruit> CREATOR=new Parcelable.Creator<Fruit>(){
        @Override
        public Fruit[] newArray(int size) {
            return new Fruit[size];
        }

        @Override
        public Fruit createFromParcel(Parcel source) {
            return null;
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    private String name;
    private Integer ImageId;

    public Fruit(String name, int imageId) {
        this.name = name;
        ImageId = imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return ImageId;
    }
}
