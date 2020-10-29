package com.tereshko.andriy.axontestapp.network.api;

import com.tereshko.andriy.axontestapp.model.NetworkAnswer;
import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by andy on 27/10/20
 */
public interface UserService {

    @GET("?results=20&inc=name,gender,dob,location,email,phone,picture&noinfo")
    Observable<NetworkAnswer> getUsers(); //TODO: use ResponseBody in case of empty response
}
