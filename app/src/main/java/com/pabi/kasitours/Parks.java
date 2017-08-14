package com.pabi.kasitours;

/**
 * Created by Admin on 4/29/2017.
 */

public class Parks {

    public String name;

    public String image;
    public String txt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String description;

    public String getDescription() {return description; }

    public void setDescription(String description) { this.description = description; }

    public String getUrl() { return url; }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public String getTxt() {
        return txt;
    }

    public void setImage (String image) {
        this.image = image;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public Parks(String name, String description, String url, String image, String txt) {
        this.name = name;
        this.description = description;
        this.url = url;
        this.image = image;

    }

    public String url;

    public Parks() {
    }
}
