/**
  * Copyright      bejson.com
  */
package com.dlh.movieutils.bean;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;
import java.util.List;

/**
 *
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Tv implements Parcelable {

    private long albumId;
    private int sourceId;
    private String name;
    private String imageUrl;
    private int channelId;
    private String description;
    private int videoCount;
    private int latestOrder;
    private String period;
    private People people;
    private List<String> categories;
    private int exclusive;
    private int qiyiProduced;
    private String focus;
    private boolean isAdvance;
    private int payMark;
    private String payMarkUrl;
    private double score;
    private List<String> imageSize;
    private String title;
    private Pingback pingback;
    private String playUrl;

    public long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(long albumId) {
        this.albumId = albumId;
    }

    public int getSourceId() {
        return sourceId;
    }

    public void setSourceId(int sourceId) {
        this.sourceId = sourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getVideoCount() {
        return videoCount;
    }

    public void setVideoCount(int videoCount) {
        this.videoCount = videoCount;
    }

    public int getLatestOrder() {
        return latestOrder;
    }

    public void setLatestOrder(int latestOrder) {
        this.latestOrder = latestOrder;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public int getExclusive() {
        return exclusive;
    }

    public void setExclusive(int exclusive) {
        this.exclusive = exclusive;
    }

    public int getQiyiProduced() {
        return qiyiProduced;
    }

    public void setQiyiProduced(int qiyiProduced) {
        this.qiyiProduced = qiyiProduced;
    }

    public String getFocus() {
        return focus;
    }

    public void setFocus(String focus) {
        this.focus = focus;
    }

    public boolean isAdvance() {
        return isAdvance;
    }

    public void setAdvance(boolean advance) {
        isAdvance = advance;
    }

    public int getPayMark() {
        return payMark;
    }

    public void setPayMark(int payMark) {
        this.payMark = payMark;
    }

    public String getPayMarkUrl() {
        return payMarkUrl;
    }

    public void setPayMarkUrl(String payMarkUrl) {
        this.payMarkUrl = payMarkUrl;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public List<String> getImageSize() {
        return imageSize;
    }

    public void setImageSize(List<String> imageSize) {
        this.imageSize = imageSize;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Pingback getPingback() {
        return pingback;
    }

    public void setPingback(Pingback pingback) {
        this.pingback = pingback;
    }

    public String getPlayUrl() {
        return playUrl;
    }

    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.albumId);
        dest.writeInt(this.sourceId);
        dest.writeString(this.name);
        dest.writeString(this.imageUrl);
        dest.writeInt(this.channelId);
        dest.writeString(this.description);
        dest.writeInt(this.videoCount);
        dest.writeInt(this.latestOrder);
        dest.writeString(this.period);
        dest.writeParcelable(this.people, flags);
        dest.writeStringList(this.categories);
        dest.writeInt(this.exclusive);
        dest.writeInt(this.qiyiProduced);
        dest.writeString(this.focus);
        dest.writeByte(this.isAdvance ? (byte) 1 : (byte) 0);
        dest.writeInt(this.payMark);
        dest.writeString(this.payMarkUrl);
        dest.writeDouble(this.score);
        dest.writeStringList(this.imageSize);
        dest.writeString(this.title);
        dest.writeParcelable(this.pingback, flags);
        dest.writeString(this.playUrl);
    }

    public void readFromParcel(Parcel source) {
        this.albumId = source.readLong();
        this.sourceId = source.readInt();
        this.name = source.readString();
        this.imageUrl = source.readString();
        this.channelId = source.readInt();
        this.description = source.readString();
        this.videoCount = source.readInt();
        this.latestOrder = source.readInt();
        this.period = source.readString();
        this.people = source.readParcelable(People.class.getClassLoader());
        this.categories = source.createStringArrayList();
        this.exclusive = source.readInt();
        this.qiyiProduced = source.readInt();
        this.focus = source.readString();
        this.isAdvance = source.readByte() != 0;
        this.payMark = source.readInt();
        this.payMarkUrl = source.readString();
        this.score = source.readDouble();
        this.imageSize = source.createStringArrayList();
        this.title = source.readString();
        this.pingback = source.readParcelable(Pingback.class.getClassLoader());
        this.playUrl = source.readString();
    }

    public Tv() {
    }

    protected Tv(Parcel in) {
        this.albumId = in.readLong();
        this.sourceId = in.readInt();
        this.name = in.readString();
        this.imageUrl = in.readString();
        this.channelId = in.readInt();
        this.description = in.readString();
        this.videoCount = in.readInt();
        this.latestOrder = in.readInt();
        this.period = in.readString();
        this.people = in.readParcelable(People.class.getClassLoader());
        this.categories = in.createStringArrayList();
        this.exclusive = in.readInt();
        this.qiyiProduced = in.readInt();
        this.focus = in.readString();
        this.isAdvance = in.readByte() != 0;
        this.payMark = in.readInt();
        this.payMarkUrl = in.readString();
        this.score = in.readDouble();
        this.imageSize = in.createStringArrayList();
        this.title = in.readString();
        this.pingback = in.readParcelable(Pingback.class.getClassLoader());
        this.playUrl = in.readString();
    }

    public static final Creator<Tv> CREATOR = new Creator<Tv>() {
        @Override
        public Tv createFromParcel(Parcel source) {
            return new Tv(source);
        }

        @Override
        public Tv[] newArray(int size) {
            return new Tv[size];
        }
    };
}