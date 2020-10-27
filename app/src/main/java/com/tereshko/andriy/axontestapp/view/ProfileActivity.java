package com.tereshko.andriy.axontestapp.view;
import android.os.Bundle;
import com.tereshko.andriy.axontestapp.R;

/**
 * Created by andy on 27/10/20
 */

public class ProfileActivity extends ParentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.profile_activity_title);
        setContentView(R.layout.activity_profile);
    }


}