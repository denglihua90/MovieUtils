/**
  * Copyright      bejson.com
  */
package com.dlh.movieutils.bean;
import java.util.Date;
import java.util.List;

/**
 *
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Epsodelist  extends  SingleChoice{
    private long albumId;
    private long tvId;
    private int channelId;
    private String description;
    private String subtitle;
    private String vid;
    private String name;
    private String playUrl;
    private long issueTime;
    private long publishTime;
    private int contentType;
    private int payMark;
    private String payMarkUrl;
    private String imageUrl;
    private String duration;
    private String period;
    private boolean exclusive;
    private int order;
    private boolean effective;
    private boolean qiyiProduced;
    private String focus;
    private String shortTitle;
    private People people;
    private int interactionType;
    private int isEnabledInteraction;
    private List<String> imageSize;
    private List<String> imageProductionType;
    private String orderName;

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public void setTvId(long tvId) {
         this.tvId = tvId;
     }
     public long getTvId() {
         return tvId;
     }

    public long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(long albumId) {
        this.albumId = albumId;
    }

    public void setDescription(String description) {
         this.description = description;
     }
     public String getDescription() {
         return description;
     }

    public void setSubtitle(String subtitle) {
         this.subtitle = subtitle;
     }
     public String getSubtitle() {
         return subtitle;
     }

    public void setVid(String vid) {
         this.vid = vid;
     }
     public String getVid() {
         return vid;
     }

    public void setName(String name) {
         this.name = name;
     }
     public String getName() {
         return name;
     }

    public void setPlayUrl(String playUrl) {
         this.playUrl = playUrl;
     }
     public String getPlayUrl() {
         return playUrl;
     }

    public void setIssueTime(long issueTime) {
         this.issueTime = issueTime;
     }
     public long getIssueTime() {
         return issueTime;
     }

    public void setPublishTime(long publishTime) {
         this.publishTime = publishTime;
     }
     public long getPublishTime() {
         return publishTime;
     }

    public void setContentType(int contentType) {
         this.contentType = contentType;
     }
     public int getContentType() {
         return contentType;
     }

    public void setPayMark(int payMark) {
         this.payMark = payMark;
     }
     public int getPayMark() {
         return payMark;
     }

    public void setPayMarkUrl(String payMarkUrl) {
         this.payMarkUrl = payMarkUrl;
     }
     public String getPayMarkUrl() {
         return payMarkUrl;
     }

    public void setImageUrl(String imageUrl) {
         this.imageUrl = imageUrl;
     }
     public String getImageUrl() {
         return imageUrl;
     }

    public void setDuration(String duration) {
         this.duration = duration;
     }
     public String getDuration() {
         return duration;
     }

    public void setPeriod(String period) {
         this.period = period;
     }
     public String getPeriod() {
         return period;
     }

    public void setExclusive(boolean exclusive) {
         this.exclusive = exclusive;
     }
     public boolean getExclusive() {
         return exclusive;
     }

    public void setOrder(int order) {
         this.order = order;
     }
     public int getOrder() {
         return order;
     }

    public void setEffective(boolean effective) {
         this.effective = effective;
     }
     public boolean getEffective() {
         return effective;
     }

    public void setQiyiProduced(boolean qiyiProduced) {
         this.qiyiProduced = qiyiProduced;
     }
     public boolean getQiyiProduced() {
         return qiyiProduced;
     }

    public void setFocus(String focus) {
         this.focus = focus;
     }
     public String getFocus() {
         return focus;
     }

    public void setShortTitle(String shortTitle) {
         this.shortTitle = shortTitle;
     }
     public String getShortTitle() {
         return shortTitle;
     }

    public void setPeople(People people) {
         this.people = people;
     }
     public People getPeople() {
         return people;
     }

    public void setInteractionType(int interactionType) {
         this.interactionType = interactionType;
     }
     public int getInteractionType() {
         return interactionType;
     }

    public void setIsEnabledInteraction(int isEnabledInteraction) {
         this.isEnabledInteraction = isEnabledInteraction;
     }
     public int getIsEnabledInteraction() {
         return isEnabledInteraction;
     }

    public void setImageSize(List<String> imageSize) {
         this.imageSize = imageSize;
     }
     public List<String> getImageSize() {
         return imageSize;
     }

    public void setImageProductionType(List<String> imageProductionType) {
         this.imageProductionType = imageProductionType;
     }
     public List<String> getImageProductionType() {
         return imageProductionType;
     }

    public void setOrderName(String orderName) {
         this.orderName = orderName;
     }
     public String getOrderName() {
         return orderName;
     }

}