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
public class Pingback  implements Parcelable {

    private long doc_id;
    public void setDoc_id(long doc_id) {
         this.doc_id = doc_id;
     }
     public long getDoc_id() {
         return doc_id;
     }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.doc_id);
    }

    public void readFromParcel(Parcel source) {
        this.doc_id = source.readLong();
    }

    public Pingback() {
    }

    protected Pingback(Parcel in) {
        this.doc_id = in.readLong();
    }

    public static final Creator<Pingback> CREATOR = new Creator<Pingback>() {
        @Override
        public Pingback createFromParcel(Parcel source) {
            return new Pingback(source);
        }

        @Override
        public Pingback[] newArray(int size) {
            return new Pingback[size];
        }
    };
}