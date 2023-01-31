package com.dlh.movieutils.ui.page.jx;

import java.io.Serializable;

/**
 * @author: dlh
 * @date:     /5/15
 * @description
 */
public class ParserBean implements Serializable {
    private String name;
    private String url;
    public ParserBean() {
    }
    public ParserBean(String name, String url) {
        this.name = name;
        this.url = url;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
