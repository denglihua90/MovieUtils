package com.dlh.movieutils.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author: dlh
 * @description
 */
public class HomeBundleBean implements Parcelable {

    /**
     * channel_id
     * 爱奇艺电视剧列表 channel_id=2
     * 爱奇艺电影 channel_id=1
     * 爱奇艺动漫 channel_id=4
     * 爱奇艺综艺 channel_id=6
     * 爱奇艺网络电影 channel_id=1&three_category_id=27401
     */
    private int channel_id=2;
    private int data_type=1;
    private int mode=24;
    private int page_id=1;
    private int ret_num=48;
    private int three_category_id=27401;
    private String tabTitle;

    public String getTabTitle() {
        return tabTitle;
    }

    public void setTabTitle(String tabTitle) {
        this.tabTitle = tabTitle;
    }

    public int getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(int channel_id) {
        this.channel_id = channel_id;
    }

    public int getData_type() {
        return data_type;
    }

    public void setData_type(int data_type) {
        this.data_type = data_type;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public int getPage_id() {
        return page_id;
    }

    public void setPage_id(int page_id) {
        this.page_id = page_id;
    }

    public int getRet_num() {
        return ret_num;
    }

    public void setRet_num(int ret_num) {
        this.ret_num = ret_num;
    }

    public int getThree_category_id() {
        return three_category_id;
    }

    public void setThree_category_id(int three_category_id) {
        this.three_category_id = three_category_id;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.channel_id);
        dest.writeInt(this.data_type);
        dest.writeInt(this.mode);
        dest.writeInt(this.page_id);
        dest.writeInt(this.ret_num);
        dest.writeInt(this.three_category_id);
        dest.writeString(this.tabTitle);
    }

    public void readFromParcel(Parcel source) {
        this.channel_id = source.readInt();
        this.data_type = source.readInt();
        this.mode = source.readInt();
        this.page_id = source.readInt();
        this.ret_num = source.readInt();
        this.three_category_id = source.readInt();
        this.tabTitle = source.readString();
    }

    public HomeBundleBean() {
    }

    protected HomeBundleBean(Parcel in) {
        this.channel_id = in.readInt();
        this.data_type = in.readInt();
        this.mode = in.readInt();
        this.page_id = in.readInt();
        this.ret_num = in.readInt();
        this.three_category_id = in.readInt();
        this.tabTitle = in.readString();
    }

    public static final Parcelable.Creator<HomeBundleBean> CREATOR = new Parcelable.Creator<HomeBundleBean>() {
        @Override
        public HomeBundleBean createFromParcel(Parcel source) {
            return new HomeBundleBean(source);
        }

        @Override
        public HomeBundleBean[] newArray(int size) {
            return new HomeBundleBean[size];
        }
    };
}
