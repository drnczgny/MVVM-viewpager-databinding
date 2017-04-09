package com.adrian.mvvm_viewpager_recyclerview_databinding.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.adrian.mvvm_viewpager_recyclerview_databinding.R;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.main.JsonPlaceholderActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnViewPager = (Button) findViewById(R.id.btnViewPager);

        btnViewPager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, JsonPlaceholderActivity.class);
                startActivity(intent);
            }
        });
    }
}
