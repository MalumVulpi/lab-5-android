package com.example.tlb5;

public class Rest {

    private int imageResource;
    private String title;
    private String street;
    private String reit;
    private String time;

    public Rest() {
    }

    public Rest(int imageResource, String title, String street, String reit, String time) {
        this.imageResource = imageResource;
        this.title = title;
        this.street = street;
        this.reit = reit;
        this.time = time;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getTitle() {
        return title;
    }

    public String getStreet() {
        return street;
    }

    public String getReit() {
        return reit;
    }

    public String getTime() { return time; }

}
