package com.tereshko.andriy.axontestapp.view;
import android.os.Bundle;

import com.tereshko.andriy.axontestapp.R;

/**
 * Created by andy on 27/10/20
 */

public class UserListActivity extends ParentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.user_list_activity_title);
        setContentView(R.layout.activity_user_list);
    }
}