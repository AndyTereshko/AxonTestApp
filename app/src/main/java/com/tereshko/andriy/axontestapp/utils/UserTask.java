package com.tereshko.andriy.axontestapp.utils;

import com.tereshko.andriy.axontestapp.model.NetworkAnswer;
import com.tereshko.andriy.axontestapp.network.Callback;
import com.tereshko.andriy.axontestapp.network.NetworkUtils;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by andy on 27/10/20
 */
public class UserTask {

    public static void getUsers(final Callback<NetworkAnswer> networkAnswerCallback) {
        NetworkUtils.getUserApiInstance()
                .getUsers()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new DisposableObserver<NetworkAnswer>() {
                    @Override
                    public void onNext(@NonNull NetworkAnswer networkAnswer) {
                        networkAnswerCallback.returnResult(networkAnswer);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        networkAnswerCallback.returnError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

}
