package com.example.zlobina_09_24;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

public class Settings_activity extends AppCompatActivity {

    Switch ch1, ch2, ch3;

    ImageButton btn;
    ConstraintLayout bac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_settings);
        ch1 = findViewById(R.id.switch1);
        ch2 = findViewById(R.id.switch2);
        ch3 = findViewById(R.id.switch3);
        btn = findViewById(R.id.image_backing);
        bac = findViewById(R.id.backintent);
    }

    public void onClick(View v) {


        if (ch1.isChecked()) {
            bac.setBackgroundColor(Color.parseColor("#B8DF8E"));
        } else if (ch2.isChecked()) {
            bac.setBackgroundColor(Color.MAGENTA);
        } else if (ch3.isChecked()) {
            bac.setBackgroundColor(Color.YELLOW);
        } else {
            bac.setBackgroundColor(Color.WHITE);
        }
    }

    public void onClicked(View v) {
        switch (v.getId()) {
            case R.id.image_backing:
                Intent intent = new Intent(this, Perconal_area_acrivity.class);
                startActivity(intent);
                break;
            case R.id.button3:
                ch1.setChecked(false);
                ch2.setChecked(false);
                ch3.setChecked(false);

                Toast.makeText(getApplicationContext(), "Вы сбросили все настрйки!", Toast.LENGTH_LONG).show();
                break;
            default:
                Toast.makeText(getApplicationContext(), "Все!", Toast.LENGTH_LONG).show();

        }
    }
}