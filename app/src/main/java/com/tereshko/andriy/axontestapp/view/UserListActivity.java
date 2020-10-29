package com.tereshko.andriy.axontestapp.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;
import com.tereshko.andriy.axontestapp.BuildConfig;
import com.tereshko.andriy.axontestapp.R;
import com.tereshko.andriy.axontestapp.model.Result;
import com.tereshko.andriy.axontestapp.utils.Utils;
import com.tereshko.andriy.axontestapp.view.adapter.UserRecyclerAdapter;
import com.tereshko.andriy.axontestapp.viewModel.UserListViewModel;
import java.util.ArrayList;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

/**
 * Created by andy on 27/10/20
 */

public class UserListActivity extends AppCompatActivity {

    UserListViewModel userListViewModel;
    UserRecyclerAdapter recyclerAdapter;
    List<Result> completeUserList = new ArrayList<>();
    boolean isLoading = true;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.user_list_RecyclerView)
    RecyclerView userListRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.user_list_activity_title);
        setContentView(R.layout.activity_user_list);
        ButterKnife.bind(this);
        //Timber logger init
        if(BuildConfig.DEBUG){
            Timber.plant(new Timber.DebugTree());
        }
        //view model init
        userListViewModel = new ViewModelProvider(this).get(UserListViewModel.class);
        initRecyclerView();
        registerListeners();
        initScrollListener();
    }

    private void initRecyclerView(){
        recyclerAdapter = new UserRecyclerAdapter(completeUserList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        userListRecyclerView.setLayoutManager(layoutManager);
        userListRecyclerView.setAdapter(recyclerAdapter);
        completeUserList.add(null);
    }

    private void initScrollListener() {
        userListRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) userListRecyclerView.getLayoutManager();
                if(!isLoading && linearLayoutManager!=null
                        && linearLayoutManager.findLastCompletelyVisibleItemPosition() == completeUserList.size()-1){
                    isLoading = true;
                    //adding null to list to show progress bar at the end of the list
                    completeUserList.add(null);
                    recyclerAdapter.notifyDataSetChanged();
                    userListViewModel.loadMoreUser();
                }

            }
        });
    }

    private void registerListeners(){
        //registering user list listener
        userListViewModel.getUsers().observe(this, users -> {
            //removing null item(that shows progress bar)
            completeUserList.remove(completeUserList.size()-1);
            recyclerAdapter.notifyItemRemoved(completeUserList.size());
            completeUserList.addAll(users);
            recyclerAdapter.notifyDataSetChanged();
            isLoading = false;
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