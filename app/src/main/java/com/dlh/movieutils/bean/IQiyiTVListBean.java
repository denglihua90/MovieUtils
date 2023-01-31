/**
  * Copyright      bejson.com
  */
package com.dlh.movieutils.bean;

/**
 *
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class IQiyiTVListBean<T> {

    private String code;
    private T data;
    public void setCode(String code) {
         this.code = code;
     }
     public String getCode() {
         return code;
     }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}