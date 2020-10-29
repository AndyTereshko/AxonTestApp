package com.tereshko.andriy.axontestapp.model;

import android.os.Build;
import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.NotNull;
import java.util.Objects;
import androidx.annotation.RequiresApi;

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

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return Objects.equals(name, result.name) &&
                Objects.equals(location, result.location) &&
                Objects.equals(email, result.email) &&
                Objects.equals(dob, result.dob) &&
                Objects.equals(phone, result.phone) &&
                Objects.equals(userPicture, result.userPicture);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(name, location, email, dob, phone, userPicture);
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
