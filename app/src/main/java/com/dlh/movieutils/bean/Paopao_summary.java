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
public class Paopao_summary implements Parcelable {

    private long circle_id;
    public void setCircle_id(long circle_id) {
         this.circle_id = circle_id;
     }
     public long getCircle_id() {
         return circle_id;
     }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.circle_id);
    }

    public void readFromParcel(Parcel source) {
        this.circle_id = source.readLong();
    }

    public Paopao_summary() {
    }

    protected Paopao_summary(Parcel in) {
        this.circle_id = in.readLong();
    }

    public static final Creator<Paopao_summary> CREATOR = new Creator<Paopao_summary>() {
        @Override
        public Paopao_summary createFromParcel(Parcel source) {
            return new Paopao_summary(source);
        }

        @Override
        public Paopao_summary[] newArray(int size) {
            return new Paopao_summary[size];
        }
    };
}