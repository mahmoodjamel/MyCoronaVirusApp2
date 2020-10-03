package com.ahmed00.mycoronavirusapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Objects;

public class CountryDActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_d);

        Intent intent = getIntent();
        int position = intent.getIntExtra("position",0);
        String c =AllCountryActivity.itemCS.get(position).getCountry();

        Objects.requireNonNull(getSupportActionBar()).setTitle("Country : "+c);

        TextView cases = findViewById(R.id.casesDTv);
        TextView recovered = findViewById(R.id.recoveredDTv);
        TextView dangerous = findViewById(R.id.dangerousDTv);
        TextView active = findViewById(R.id.activeDTv);
        TextView deaths = findViewById(R.id.deathsDTv);

        cases.setText(AllCountryActivity.itemCS.get(position).getCases());
        recovered.setText(AllCountryActivity.itemCS.get(position).getRecovered());
        dangerous.setText(AllCountryActivity.itemCS.get(position).getDangerous());
        active.setText(AllCountryActivity.itemCS.get(position).getActive());
        deaths.setText(AllCountryActivity.itemCS.get(position).getDeaths());


    }
}
