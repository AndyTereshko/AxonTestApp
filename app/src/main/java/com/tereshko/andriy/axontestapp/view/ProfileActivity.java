package com.tereshko.andriy.axontestapp.view;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tereshko.andriy.axontestapp.R;
import com.tereshko.andriy.axontestapp.model.Result;
import com.tereshko.andriy.axontestapp.utils.Utils;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by andy on 27/10/20
 */

public class ProfileActivity extends AppCompatActivity {

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.user_profile_item_picture)
    ImageView picture;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.user_profile_full_name)
    TextView fullNameTextView;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.user_profile_age)
    TextView ageTextView;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.user_profile_cell_phone)
    TextView phoneTextView;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.user_profile_date_of_birth)
    TextView dateOfBirthTextView;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.user_profile_email)
    TextView emailTextView;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.user_profile_gender)
    TextView genderTextView;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.user_profile_location)
    TextView locationTextView;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.call_button)
    ImageButton callButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.profile_activity_title);
        setContentView(R.layout.activity_profile);
        Intent intent = getIntent();
        Result clickedUser = (Result)intent.getSerializableExtra(Utils.userObject);
        ButterKnife.bind(this);
        initViews(clickedUser);
        callButton.setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_DIAL);
            i.setData(Uri.parse("tel:"+clickedUser.getPhone()));
            startActivity(i);
        });
    }

    private void initViews(Result clickedUser){
        Picasso.get().load(clickedUser.getUserPicture().getPictureURL()).into(picture);
        fullNameTextView.setText(String.format("%s %s", clickedUser.getName().getFirstName(), clickedUser.getName().getSurname()));
        ageTextView.setText(String.format("%s %s", clickedUser.getDob().getAge(), formattedYears(clickedUser.getDob().getAge())));
        genderTextView.setText(String.format("%s", translatedGender(clickedUser.getGender())));
        dateOfBirthTextView.setText(String.format("%s", formattedDate(clickedUser.getDob().getDateOfBirth())));
        phoneTextView.setText(String.format("%s", clickedUser.getPhone()));
        emailTextView.setText(String.format("%s", clickedUser.getEmail()));
        locationTextView.setText(String.format("%s, %s", clickedUser.getLocation().getCity(), clickedUser.getLocation().getCountry()));
    }

    private String formattedYears(String age){
        String yearsOld = "";
        if(age.equals("1"))
            yearsOld = getString(R.string.year_old);
        else if(age.equals("0"))
            ageTextView.setVisibility(View.INVISIBLE);
        else
            yearsOld = getString(R.string.years_old);
        return yearsOld;
    }

    private String translatedGender(String gender){
        if(gender.equals("male"))
            return getString(R.string.gender_male);
        else if(gender.equals("female"))
            return getString(R.string.gender_female);
        else
            return getString(R.string.unknown);
    }

    private String formattedDate(String date){
        if(date!=null&&date.length()>=11){
            return date.substring(0,10);
        }
        else
            return getString(R.string.unknown);
    }
}