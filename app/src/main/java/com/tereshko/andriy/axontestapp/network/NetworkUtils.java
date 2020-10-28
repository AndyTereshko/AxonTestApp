package com.tereshko.andriy.axontestapp.network;

import com.tereshko.andriy.axontestapp.network.api.UserService;

/**
 * Created by andy on 27/10/20
 */
public class NetworkUtils {

    private static UserService userService;

    public static UserService getUserApiInstance() {
        if (userService == null)
            userService = RetrofitAdapter.getInstance().create(UserService.class);
        return userService;
    }
}
