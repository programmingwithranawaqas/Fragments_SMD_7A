package com.example.fragments_smd_7a;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements ListFrag.OnItemClick {

    LinearLayout portrait, lanscape;
    TextView tvDetail;
    Fragment list_frag, detail_frag;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        portrait = findViewById(R.id.portrait);
        manager = getSupportFragmentManager();
        list_frag = manager.findFragmentById(R.id.listfrag);
        detail_frag = manager.findFragmentById(R.id.detailfrag);

        tvDetail = detail_frag.getView().findViewById(R.id.tvDetail);

        dummyMethodAddNewRecord();

        if (portrait != null)
        {
            manager.beginTransaction().show(list_frag).hide(detail_frag)
                    .commit();
        }
        else
        {
            manager.beginTransaction().show(list_frag).show(detail_frag)
                    .commit();
        }

    }

    @Override
    public void onClick(int index) {
        tvDetail.setText(MyApplication.details.get(index));
        if (portrait != null)
        {
            manager.beginTransaction().hide(list_frag).show(detail_frag)
                    .addToBackStack(null)
                    .commit();
        }

    }

    public void dummyMethodAddNewRecord()
    {
        MyApplication.items.add("New Item");
        MyApplication.details.add("Detail of New Item");
        ListFrag obj = (ListFrag) list_frag;
        obj.onDataChanged();
    }
}