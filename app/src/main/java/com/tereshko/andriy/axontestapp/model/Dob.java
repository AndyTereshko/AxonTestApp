package com.tereshko.andriy.axontestapp.model;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

/**
 * Created by andy on 27/10/20
 */
public class Dob {

    @SerializedName("age")
    private String age;

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
                '}';
    }
}
