package com.wallpapernote.plutopix.wallpaperorganizer;


public class DataObject {
    private int imageId;
    private int imageId2;
    private int imageId3;
    private int imageId4;
    private String imageName;
    private String imageName2;
    private String imageName3;

    public int getImageId4() {
        return imageId4;
    }

    public void setImageId4(int imageId4) {
        this.imageId4 = imageId4;
    }

    public String getImageName4() {
        return imageName4;
    }

    public void setImageName4(String imageName4) {
        this.imageName4 = imageName4;
    }

    private String imageName4;

    public int getImageId2() {
        return imageId2;
    }

    public void setImageId2(int imageId2) {
        this.imageId2 = imageId2;
    }

    public int getImageId3() {
        return imageId3;
    }

    public void setImageId3(int imageId3) {
        this.imageId3 = imageId3;
    }

    public String getImageName2() {
        return imageName2;
    }

    public void setImageName2(String imageName2) {
        this.imageName2 = imageName2;
    }

    public String getImageName3() {
        return imageName3;
    }

    public void setImageName3(String imageName3) {
        this.imageName3 = imageName3;
    }

    public DataObject(int imageId, String imageName,int imageId2, String imageName2,int imageId3, String imageName3, int imageId4, String imageName4) {
        this.imageId = imageId;
        this.imageName = imageName;
        this.imageId2 = imageId2;
        this.imageName2 = imageName2;
        this.imageId3 = imageId3;
        this.imageName3 = imageName3;
        this.imageId4 = imageId4;
        this.imageName4 = imageName4;
    }
    public int getImageId() {
        return imageId;
    }
    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
    public String getImageName() {
        return imageName;
    }
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
