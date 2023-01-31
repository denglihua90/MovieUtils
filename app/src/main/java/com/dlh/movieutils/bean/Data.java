/**
  * Copyright      bejson.com
  */
package com.dlh.movieutils.bean;
import java.util.List;

/**
 *
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Data {

    private String card_type;
    private Pingback pingback;
    private String session;
    private int has_next;
    private List<Tv> list;
    private int service_latency;
    private String result_num;
    public void setCard_type(String card_type) {
         this.card_type = card_type;
     }
     public String getCard_type() {
         return card_type;
     }

    public void setPingback(Pingback pingback) {
         this.pingback = pingback;
     }
     public Pingback getPingback() {
         return pingback;
     }

    public void setSession(String session) {
         this.session = session;
     }
     public String getSession() {
         return session;
     }

    public void setHas_next(int has_next) {
         this.has_next = has_next;
     }
     public int getHas_next() {
         return has_next;
     }

    public void setList(List<Tv> list) {
         this.list = list;
     }
     public List<Tv> getList() {
         return list;
     }

    public void setService_latency(int service_latency) {
         this.service_latency = service_latency;
     }
     public int getService_latency() {
         return service_latency;
     }

    public void setResult_num(String result_num) {
         this.result_num = result_num;
     }
     public String getResult_num() {
         return result_num;
     }

}