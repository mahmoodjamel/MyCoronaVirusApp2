package com.ahmed00.mycoronavirusapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AllCountryActivity extends AppCompatActivity {


    public static List<ItemC> itemCS;
    ItemC itemC;
    ItemCSAdapter itemCSAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_country);

        final ListView listView = findViewById(R.id.listview);
        itemCS = new ArrayList<>();


        String url = "https://corona.lmao.ninja/v2/countries/";
StringRequest request = new StringRequest
        (Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length() ;  i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String countryName = jsonObject.getString("country");
                        String cases = jsonObject.getString("cases");
                        String deaths = jsonObject.getString("deaths");
                        String recovered = jsonObject.getString("recovered");
                        String active = jsonObject.getString("active");
                        String dangerous = jsonObject.getString("critical");
    JSONObject flagObject = jsonObject.getJSONObject("countryInfo");
                        String flag = flagObject.getString("flag");
                        itemC = new ItemC(flag, countryName, cases, deaths, recovered, active, dangerous);
                        itemCS.add(itemC);
                    }
  itemCSAdapter = new ItemCSAdapter(getApplicationContext(), itemCS);
                    listView.setAdapter(itemCSAdapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

RequestQueue requestQueue = Volley.newRequestQueue(Objects.requireNonNull(getApplicationContext()));
        requestQueue.add(request);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(getApplicationContext(), CountryDActivity.class).putExtra("position", i));
            }
        });


    }
}
