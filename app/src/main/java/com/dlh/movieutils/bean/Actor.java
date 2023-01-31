/**
  * Copyright      bejson.com
  */
package com.dlh.movieutils.bean;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 *
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Actor implements Parcelable {

    private long id;
    private String name;
    private String image_url;
    private List<String> character;
    private Paopao_summary paopao_summary;
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

    public void setCharacter(List<String> character) {
         this.character = character;
     }
     public List<String> getCharacter() {
         return character;
     }

    public void setPaopao_summary(Paopao_summary paopao_summary) {
         this.paopao_summary = paopao_summary;
     }
     public Paopao_summary getPaopao_summary() {
         return paopao_summary;
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
        dest.writeStringList(this.character);
        dest.writeParcelable(this.paopao_summary, flags);
    }

    public void readFromParcel(Parcel source) {
        this.id = source.readLong();
        this.name = source.readString();
        this.image_url = source.readString();
        this.character = source.createStringArrayList();
        this.paopao_summary = source.readParcelable(Paopao_summary.class.getClassLoader());
    }

    public Actor() {
    }

    protected Actor(Parcel in) {
        this.id = in.readLong();
        this.name = in.readString();
        this.image_url = in.readString();
        this.character = in.createStringArrayList();
        this.paopao_summary = in.readParcelable(Paopao_summary.class.getClassLoader());
    }

    public static final Creator<Actor> CREATOR = new Creator<Actor>() {
        @Override
        public Actor createFromParcel(Parcel source) {
            return new Actor(source);
        }

        @Override
        public Actor[] newArray(int size) {
            return new Actor[size];
        }
    };
}