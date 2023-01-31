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
public class Circle implements Parcelable {

    private int circle_id;
    private String circle_type;
    public void setCircle_id(int circle_id) {
         this.circle_id = circle_id;
     }
     public int getCircle_id() {
         return circle_id;
     }

    public void setCircle_type(String circle_type) {
         this.circle_type = circle_type;
     }
     public String getCircle_type() {
         return circle_type;
     }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.circle_id);
        dest.writeString(this.circle_type);
    }

    public void readFromParcel(Parcel source) {
        this.circle_id = source.readInt();
        this.circle_type = source.readString();
    }

    public Circle() {
    }

    protected Circle(Parcel in) {
        this.circle_id = in.readInt();
        this.circle_type = in.readString();
    }

    public static final Creator<Circle> CREATOR = new Creator<Circle>() {
        @Override
        public Circle createFromParcel(Parcel source) {
            return new Circle(source);
        }

        @Override
        public Circle[] newArray(int size) {
            return new Circle[size];
        }
    };
}