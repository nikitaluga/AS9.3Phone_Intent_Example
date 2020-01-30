package com.example.phoneintentexample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textViewGroup;

    private static final int CODEFORSECONDACTIVITY = 1;
    private static final int CODEFORTHIRDACTIVITY = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textViewGroup = findViewById(R.id.textView);
    }

    public void onClick(View view) {
        Intent intent = new Intent(this,Main2Activity.class);
        startActivityForResult(intent,CODEFORSECONDACTIVITY);
    }

    public void onClick2(View view) {
        Intent intent = new Intent(this,Main3Activity.class);
        startActivityForResult(intent,CODEFORTHIRDACTIVITY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == CODEFORSECONDACTIVITY) {
            if(resultCode == RESULT_CANCELED) {
                textView2.setText(null);
                textView3.setText(null);
                textView4.setText(data.getStringExtra("key"));
                textView4.setTextColor(Color.parseColor("#FF0000"));
            } else if(resultCode == RESULT_OK) {
                textView2.setText(data.getStringExtra("key"));
                textView2.setTextColor(Color.parseColor("#8A2BE2"));
                textView3.setText(data.getStringExtra("key2"));
                textView3.setTextColor(Color.parseColor("#8A2BE2"));
                textView4.setText(data.getStringExtra("key3"));
                textView4.setTextColor(Color.parseColor("#8A2BE2"));
            }
        }
        if (requestCode == CODEFORTHIRDACTIVITY) {
            if (resultCode == RESULT_CANCELED) {
                textViewGroup.setText(data.getStringExtra("keyGroup"));
                textViewGroup.setTextColor(Color.parseColor("#FF0000"));
            } else if(resultCode == RESULT_OK) {
                textViewGroup.setText(data.getStringExtra("keyGroup_OK"));
            }
        }
    }


}
