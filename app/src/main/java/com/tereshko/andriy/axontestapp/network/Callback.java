package com.tereshko.andriy.axontestapp.network;

/**
 * Created by andy on 27/10/20
 */
public abstract class Callback<T> {
    public abstract void returnResult(T t);
    public abstract void returnError(String message);
}
