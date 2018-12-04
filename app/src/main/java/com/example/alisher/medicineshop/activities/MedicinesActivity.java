package com.example.alisher.medicineshop.activities;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.alisher.medicineshop.R;
import com.example.alisher.medicineshop.adapters.MedAdapter;
import com.example.alisher.medicineshop.entities.Medicine;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MedicinesActivity extends AppCompatActivity{

    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawarLayout;

    RecyclerView recyclerView;

    MedAdapter adapter;
    List<Medicine> medlist = new ArrayList<Medicine>();

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.medicines_layout);

        recyclerView = findViewById(R.id.recycleview);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        medlist.add(new Medicine(555,"Paracetamol","Lorem ipsum sapien etiam, nunc armet dolor atc", 500, "11234", "png", "useInCase", "con", "$0.5"));

        gettt();


        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem){
                int id = menuItem.getItemId();

                switch (id){
                    case R.id.profile:
                        Toast.makeText(MedicinesActivity.this, "Profile page", Toast.LENGTH_SHORT).show();
                    case R.id.medicines:
                        Intent intent2=new Intent(MedicinesActivity.this,MedicinesActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.pharmacies:
                        Intent intent1=new Intent(MedicinesActivity.this,PharmActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.doctors:
                        Intent intent=new Intent(MedicinesActivity.this,DoctorActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.clinic:
                        Intent intent0=new Intent(MedicinesActivity.this,ClinicActivity.class);
                        startActivity(intent0);
                        break;
                }
                return false;
            }
        });
/*
        mDrawarLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
*/

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawarLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



    public void onSetUpRecyclerView(List<Medicine> List1) {

        adapter = new MedAdapter(List1, this);
        recyclerView.setAdapter(adapter);
        /*
        adapter.setCallback(new MedAdapter.CallBack() {
            @Override
            public void selectedItem(Medicine iii) {

            }
        });
        */
    }

    private void gettt(){
        String myurl = "https://9151660d.ngrok.io/api/medicine";
        StringRequest stringRequest=new StringRequest(Request.Method.GET, myurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array = new JSONArray(response);
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject jj = array.getJSONObject(i);

                        int medID = jj.getInt("medicineID");
                        String name = jj.getString("name");
                        String des = jj.getString("description");
                        int quantity = jj.getInt("quantity");
                        String code = jj.getString("medicineCode");
                        String img = jj.getString("img");
                        String use_in_case = jj.getString("use_in_case");
                        String contradication = jj.getString("contradication");
                        String price = jj.getString("price");
                        medlist.add(new Medicine(medID,name,des,quantity,code,img,use_in_case,contradication,price));
                    }

                    adapter = new MedAdapter(medlist, MedicinesActivity.this);
                    recyclerView.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Volley.newRequestQueue(this).add(stringRequest);
    }


    public void jsonParse(){
        String myurl = "https://8d3c1c3e.ngrok.io/api/medicine";

        //RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                myurl,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("Response: ", response.toString());
                        // Do something with response
                        //mTextView.setText(response.toString());

                        // Process the JSON
                        try{
                            // Loop through the array elements
                            for(int i=0;i<response.length();i++){
                                // Get current json object
                                JSONObject jj = response.getJSONObject(i);
                                int medID = jj.getInt("medicineID");
                                String name = jj.getString("name");
                                String des = jj.getString("description");
                                int quantity = jj.getInt("quantity");
                                String code = jj.getString("medicineCode");
                                String img = jj.getString("img");
                                String use_in_case = jj.getString("use_in_case");
                                String contradication = jj.getString("contradication");
                                String price = jj.getString("price");

                                System.out.println("NSS: "+name);
                                medlist.add(new Medicine(medID,name,des,quantity,code,img,use_in_case,contradication,price));
                            }

                        }catch (JSONException e){
                            e.printStackTrace();
                            System.out.println("EROOOOORRRRR----------");
                        }
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error){
                        // Do something when error occurred
                        error.printStackTrace();
                        System.out.println("EROOOOORRRRR----------");
                    }
                }
        );
/*
        JsonArrayRequest request = new JsonArrayRequest(myurl, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for(int i=0; i<response.length(); i++){
                        JSONObject jj = response.getJSONObject(i);

                        int medID = jj.getInt("medicineID");
                        String name = jj.getString("name");
                        String des = jj.getString("description");
                        int quantity = jj.getInt("quantity");
                        String code = jj.getString("medicineCode");
                        String img = jj.getString("img");
                        String use_in_case = jj.getString("use_in_case");
                        String contradication = jj.getString("contradication");
                        String price = jj.getString("price");

                        medlist.add(new Medicine(medID,name,des,quantity,code,img,use_in_case,contradication,price));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                onSetUpRecyclerView(medlist);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, myurl, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray res) {
                        try {
                            for(int i=0; i<res.length(); i++){
                                JSONObject jj = res.getJSONObject(i);

                                int medID = jj.getInt("medicineID");
                                String name = jj.getString("name");
                                String des = jj.getString("description");
                                int quantity = jj.getInt("quantity");
                                String code = jj.getString("medicineCode");
                                String img = jj.getString("img");
                                String use_in_case = jj.getString("use_in_case");
                                String contradication = jj.getString("contradication");
                                String price = jj.getString("price");

                                medlist.add(new Medicine(medID,name,des,quantity,code,img,use_in_case,contradication,price));
                            }
                            onSetUpRecyclerView(medlist);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
                error.printStackTrace();
            }
        });
        */
    }

}
