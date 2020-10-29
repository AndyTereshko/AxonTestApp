package com.tereshko.andriy.axontestapp.viewModel;

import com.tereshko.andriy.axontestapp.model.NetworkAnswer;
import com.tereshko.andriy.axontestapp.model.Result;
import com.tereshko.andriy.axontestapp.network.Callback;
import com.tereshko.andriy.axontestapp.utils.UserTask;
import java.util.List;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import timber.log.Timber;

/**
 * Created by andy on 27/10/20
 */
public class UserListViewModel extends ViewModel {

    private MutableLiveData<List<Result>> users;
    private final MutableLiveData<Boolean> isNetworkErrorThrown = new MutableLiveData<>();

    public LiveData<List<Result>> getUsers() {
        isNetworkErrorThrown.setValue(false);//init
        if (users == null) {
            users = new MutableLiveData<>();
            loadUsers();
        }
        return users;
    }

    public void loadMoreUser(){
        loadUsers();
    }

    public LiveData<Boolean> getIsNetworkErrorThrown() {
        return isNetworkErrorThrown;
    }

    private void loadUsers() {
        UserTask.getUsers(new Callback<NetworkAnswer>() {
            @Override
            public void returnResult(NetworkAnswer networkAnswer) {
                users.setValue(networkAnswer.getResults());
                for (Result result: networkAnswer.getResults()) {
                    Timber.d("User: %s" , result.toString());
                }
            }

            @Override
            public void returnError(String message) {
                isNetworkErrorThrown.setValue(true);
                Timber.d("Network error: %s" , message);
            }
        });
    }

}
