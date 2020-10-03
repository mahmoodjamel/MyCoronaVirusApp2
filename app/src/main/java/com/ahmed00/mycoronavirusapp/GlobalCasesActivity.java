package com.ahmed00.mycoronavirusapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class GlobalCasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_global_cases);

        final TextView c = findViewById(R.id.casesTv);
        final TextView d =  findViewById(R.id.deathsTv);
        final TextView r =  findViewById(R.id.recoveredTv);
        final TextView a =  findViewById(R.id.activeTv);
        final TextView da =  findViewById(R.id.dangerousTv);


        String url = "https://corona.lmao.ninja/v2/all/";
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response.toString());
                    c.setText(jsonObject.getString("cases"));
                    r.setText(jsonObject.getString("recovered"));
                    da.setText(jsonObject.getString("critical"));
                    a.setText(jsonObject.getString("active"));
                    d.setText(jsonObject.getString("deaths"));

                }catch (JSONException e) {
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

    }
}
