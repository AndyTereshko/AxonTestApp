package com.tereshko.andriy.axontestapp.model;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

/**
 * Created by andy on 27/10/20
 */
public class Dob implements Serializable {

    @SerializedName("age")
    private String age;

    @SerializedName("date")
    private String dateOfBirth;

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public @NotNull String toString() {
        return "Dob{" +
                "age=" + age +
                "dateOfBirth=" + dateOfBirth +
                '}';
    }
}
