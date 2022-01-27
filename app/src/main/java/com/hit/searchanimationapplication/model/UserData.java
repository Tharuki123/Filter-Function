package com.hit.searchanimationapplication.model;

public class UserData {
    String usern;
    String description;
    int image;

    public String getUsern() {
        return usern;
    }

    public void setUsern(String usern) {
        this.usern = usern;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public UserData(String usern, String description, int image) {
        this.usern = usern;
        this.description = description;
        this.image = image;
    }
}
