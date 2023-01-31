package com.dlh.movieutils.bean;

import java.util.List;

/**
 * @author: dlh
 *
 * @description
 */
public class PalyTvBean {

    private String albumId;
    private List<Epsodelist> epsodelist;

    private List<Vipprevuelist> vipprevuelist;

    private int size;
    private int page;
    private int total;
    private int part;
    private int latestOrder;
    private int videoCount;
    private boolean hasMore;

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public List<Epsodelist> getEpsodelist() {
        return epsodelist;
    }

    public void setEpsodelist(List<Epsodelist> epsodelist) {
        this.epsodelist = epsodelist;
    }

    public List<Vipprevuelist> getVipprevuelist() {
        return vipprevuelist;
    }

    public void setVipprevuelist(List<Vipprevuelist> vipprevuelist) {
        this.vipprevuelist = vipprevuelist;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPart() {
        return part;
    }

    public void setPart(int part) {
        this.part = part;
    }

    public int getLatestOrder() {
        return latestOrder;
    }

    public void setLatestOrder(int latestOrder) {
        this.latestOrder = latestOrder;
    }

    public int getVideoCount() {
        return videoCount;
    }

    public void setVideoCount(int videoCount) {
        this.videoCount = videoCount;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }
}
