package com.wallpapernote.plutopix.wallpaperorganizer;


public class ModelForAdapter {



    String text;
    int id;

    public String getText() {
        return text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ModelForAdapter(String text, int id){
        this.text = text;
        this.id = id;

    }
    public  ModelForAdapter(){}
}
