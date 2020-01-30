package com.example.phoneintentexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main3Activity extends AppCompatActivity {

    EditText editTextWithGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent intentGroupToFirstActivity = new Intent();
        intentGroupToFirstActivity.putExtra("keyGroup", "Группа не выбрана!");
        setResult(RESULT_CANCELED,intentGroupToFirstActivity);
        editTextWithGroup = findViewById(R.id.editTextWithGroup);
    }

    public void onCloseActivity3(View view) {
        Intent intentGroupToFirstActivity_OK = new Intent();
        intentGroupToFirstActivity_OK.putExtra("keyGroup_OK","Группа: " + editTextWithGroup.getText().toString());
        setResult(RESULT_OK,intentGroupToFirstActivity_OK);
        this.finish();
    }
}
