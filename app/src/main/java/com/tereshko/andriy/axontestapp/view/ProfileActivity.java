package com.tereshko.andriy.axontestapp.view;
import android.os.Bundle;
import com.tereshko.andriy.axontestapp.R;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by andy on 27/10/20
 */

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.profile_activity_title);
        setContentView(R.layout.activity_profile);
    }


}