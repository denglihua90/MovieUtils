/**
  * Copyright      bejson.com
  */
package com.dlh.movieutils.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 *
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Director implements Parcelable {

    private long id;
    private String name;
    private String image_url;
    public void setId(long id) {
         this.id = id;
     }
     public long getId() {
         return id;
     }

    public void setName(String name) {
         this.name = name;
     }
     public String getName() {
         return name;
     }

    public void setImage_url(String image_url) {
         this.image_url = image_url;
     }
     public String getImage_url() {
         return image_url;
     }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.name);
        dest.writeString(this.image_url);
    }

    public void readFromParcel(Parcel source) {
        this.id = source.readLong();
        this.name = source.readString();
        this.image_url = source.readString();
    }

    public Director() {
    }

    protected Director(Parcel in) {
        this.id = in.readLong();
        this.name = in.readString();
        this.image_url = in.readString();
    }

    public static final Creator<Director> CREATOR = new Creator<Director>() {
        @Override
        public Director createFromParcel(Parcel source) {
            return new Director(source);
        }

        @Override
        public Director[] newArray(int size) {
            return new Director[size];
        }
    };
}