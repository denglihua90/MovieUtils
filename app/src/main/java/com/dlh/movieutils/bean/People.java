/**
  * Copyright      bejson.com
  */
package com.dlh.movieutils.bean;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class People implements Parcelable {

    private List<Director> director;
    private List<Main_charactor> main_charactor;
    private List<Screen_writer> screen_writer;
    private List<Actor> actor;
    public void setDirector(List<Director> director) {
         this.director = director;
     }
     public List<Director> getDirector() {
         return director;
     }

    public void setMain_charactor(List<Main_charactor> main_charactor) {
         this.main_charactor = main_charactor;
     }
     public List<Main_charactor> getMain_charactor() {
         return main_charactor;
     }

    public void setScreen_writer(List<Screen_writer> screen_writer) {
         this.screen_writer = screen_writer;
     }
     public List<Screen_writer> getScreen_writer() {
         return screen_writer;
     }

    public void setActor(List<Actor> actor) {
         this.actor = actor;
     }
     public List<Actor> getActor() {
         return actor;
     }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.director);
        dest.writeTypedList(this.main_charactor);
        dest.writeList(this.screen_writer);
        dest.writeList(this.actor);
    }

    public void readFromParcel(Parcel source) {
        this.director = source.createTypedArrayList(Director.CREATOR);
        this.main_charactor = source.createTypedArrayList(Main_charactor.CREATOR);
        this.screen_writer = new ArrayList<Screen_writer>();
        source.readList(this.screen_writer, Screen_writer.class.getClassLoader());
        this.actor = new ArrayList<Actor>();
        source.readList(this.actor, Actor.class.getClassLoader());
    }

    public People() {
    }

    protected People(Parcel in) {
        this.director = in.createTypedArrayList(Director.CREATOR);
        this.main_charactor = in.createTypedArrayList(Main_charactor.CREATOR);
        this.screen_writer = new ArrayList<Screen_writer>();
        in.readList(this.screen_writer, Screen_writer.class.getClassLoader());
        this.actor = new ArrayList<Actor>();
        in.readList(this.actor, Actor.class.getClassLoader());
    }

    public static final Creator<People> CREATOR = new Creator<People>() {
        @Override
        public People createFromParcel(Parcel source) {
            return new People(source);
        }

        @Override
        public People[] newArray(int size) {
            return new People[size];
        }
    };
}