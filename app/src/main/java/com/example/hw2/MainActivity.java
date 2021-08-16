package com.example.hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {
    EditText editText1, editText2, editText3;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = findViewById(R.id.login_et);
        editText2 = findViewById(R.id.theme_tv);
        editText3 = findViewById(R.id.message_tv);
        btn = findViewById(R.id.main_button);
    }

    public void click(View view) {
        if (!(editText1.getText().toString().isEmpty()) && !(editText2.getText().toString().isEmpty()) &&
                !(editText3.getText().toString().isEmpty())) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("playin/Text");
            intent.putExtra(Intent.EXTRA_EMAIL,new String[]{
                    editText1.getText().toString()
            });
            intent.putExtra(Intent.EXTRA_SUBJECT,editText2.getText().toString());
            intent.putExtra(Intent.EXTRA_TEXT,editText3.getText().toString());
            startActivity(intent);
        } else {
            Toast.makeText(this, "Заполните поля", Toast.LENGTH_SHORT).show();
        }


    }
}