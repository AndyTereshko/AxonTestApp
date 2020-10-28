package com.tereshko.andriy.axontestapp.view;

import android.os.Bundle;
import android.widget.Toast;

import com.tereshko.andriy.axontestapp.BuildConfig;
import com.tereshko.andriy.axontestapp.R;
import com.tereshko.andriy.axontestapp.utils.Utils;
import com.tereshko.andriy.axontestapp.viewModel.UserListViewModel;

import androidx.lifecycle.ViewModelProvider;
import timber.log.Timber;

/**
 * Created by andy on 27/10/20
 */

public class UserListActivity extends ParentActivity {

    UserListViewModel userListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.user_list_activity_title);
        setContentView(R.layout.activity_user_list);
        //Timber logger init
        if(BuildConfig.DEBUG){
            Timber.plant(new Timber.DebugTree());
        }
        //view model init
        userListViewModel = new ViewModelProvider(this).get(UserListViewModel.class);
        registerListeners();
    }

    private void registerListeners(){
        //registering user list listener
        userListViewModel.getUsers().observe(this, user ->{
            //TODO: show list
        });
        //register error message listener
        userListViewModel.getIsNetworkErrorThrown().observe(this, isNetworkErrorOccurred -> {
            if(isNetworkErrorOccurred){
                String errorMessage;
                if (!Utils.isNetworkConnected(this))
                    errorMessage = getString(R.string.error_no_internet);
                else
                    errorMessage = getString(R.string.error_message);
                Toast toast = Toast.makeText(getApplicationContext(),
                        errorMessage, Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }


}