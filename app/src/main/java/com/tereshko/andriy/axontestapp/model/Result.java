package com.tereshko.andriy.axontestapp.model;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

/**
 * Created by andy on 27/10/20
 */
public class Result {

    @SerializedName("name")
    private Name name;
    @SerializedName("location")
    private Location location;
    @SerializedName("email")
    private String email;
    @SerializedName("dob")
    private Dob dob;
    @SerializedName("phone")
    private String phone;
    @SerializedName("picture")
    private UserPicture userPicture;

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Dob getDob() {
        return dob;
    }

    public void setDob(Dob dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserPicture getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(UserPicture userPicture) {
        this.userPicture = userPicture;
    }

    @Override
    public @NotNull String toString() {
        return "Result{" +
                "name=" + name.toString() +
                ", dob=" + dob.toString() +
                ", email='" + email + '\'' +
                ", location=" + location.toString() +
                ", phone='" + phone + '\'' +
                ", pictureURL='" + userPicture + '\'' +
                '}';
    }
}
