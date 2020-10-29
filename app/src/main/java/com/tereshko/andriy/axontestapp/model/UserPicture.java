package com.tereshko.andriy.axontestapp.model;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

/**
 * Created by andy on 28/10/20
 */
public class UserPicture implements Serializable {

    @SerializedName("large")
    private String pictureURL;

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    @Override
    public @NotNull String toString() {
        return "UserPicture{" +
                "pictureURL='" + pictureURL + '\'' +
                '}';
    }
}
