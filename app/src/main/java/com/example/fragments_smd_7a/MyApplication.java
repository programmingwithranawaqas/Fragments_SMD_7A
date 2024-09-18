package com.example.fragments_smd_7a;

import android.app.Application;

import java.util.ArrayList;
import java.util.Arrays;

public class MyApplication extends Application {
    public static ArrayList<String> items;
    public static ArrayList<String> details;

    @Override
    public void onCreate() {
        super.onCreate();
        items = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.list_items_names)));
        details = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.list_items_description)));
    }
}
