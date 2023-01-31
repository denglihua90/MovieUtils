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
public class Categories implements Parcelable {

    private int id;
    private int qipuId;
    private String name;
    private int subType;
    private long lastUpdateTime;
    private int display;
    private String subName;
    private long parentId;
    private String url;
    public void setId(int id) {
         this.id = id;
     }
     public int getId() {
         return id;
     }

    public void setQipuId(int qipuId) {
         this.qipuId = qipuId;
     }
     public int getQipuId() {
         return qipuId;
     }

    public void setName(String name) {
         this.name = name;
     }
     public String getName() {
         return name;
     }

    public void setSubType(int subType) {
         this.subType = subType;
     }
     public int getSubType() {
         return subType;
     }

    public void setLastUpdateTime(long lastUpdateTime) {
         this.lastUpdateTime = lastUpdateTime;
     }
     public long getLastUpdateTime() {
         return lastUpdateTime;
     }

    public void setDisplay(int display) {
         this.display = display;
     }
     public int getDisplay() {
         return display;
     }

    public void setSubName(String subName) {
         this.subName = subName;
     }
     public String getSubName() {
         return subName;
     }

    public void setParentId(long parentId) {
         this.parentId = parentId;
     }
     public long getParentId() {
         return parentId;
     }

    public void setUrl(String url) {
         this.url = url;
     }
     public String getUrl() {
         return url;
     }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeInt(this.qipuId);
        dest.writeString(this.name);
        dest.writeInt(this.subType);
        dest.writeLong(this.lastUpdateTime);
        dest.writeInt(this.display);
        dest.writeString(this.subName);
        dest.writeLong(this.parentId);
        dest.writeString(this.url);
    }

    public void readFromParcel(Parcel source) {
        this.id = source.readInt();
        this.qipuId = source.readInt();
        this.name = source.readString();
        this.subType = source.readInt();
        this.lastUpdateTime = source.readLong();
        this.display = source.readInt();
        this.subName = source.readString();
        this.parentId = source.readLong();
        this.url = source.readString();
    }

    public Categories() {
    }

    protected Categories(Parcel in) {
        this.id = in.readInt();
        this.qipuId = in.readInt();
        this.name = in.readString();
        this.subType = in.readInt();
        this.lastUpdateTime = in.readLong();
        this.display = in.readInt();
        this.subName = in.readString();
        this.parentId = in.readLong();
        this.url = in.readString();
    }

    public static final Creator<Categories> CREATOR = new Creator<Categories>() {
        @Override
        public Categories createFromParcel(Parcel source) {
            return new Categories(source);
        }

        @Override
        public Categories[] newArray(int size) {
            return new Categories[size];
        }
    };
}