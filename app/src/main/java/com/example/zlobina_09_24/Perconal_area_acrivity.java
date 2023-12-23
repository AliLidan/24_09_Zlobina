package com.example.zlobina_09_24;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Perconal_area_acrivity extends AppCompatActivity {

    TextView textView;
    DB_helper db_helper;
    SQLiteDatabase db;

    Button photo;
    ImageButton btnback, btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_perconal_area);

        photo = findViewById(R.id.button2);

        btnback = findViewById(R.id.imageButton);
        btn = findViewById(R.id.imageButton2);

        textView = findViewById(R.id.textView);
        db_helper = new DB_helper(this);
        db = db_helper.getReadableDatabase();


        Cursor cursor = db.query(DB_helper.TABLE, null, null, null, null, null, null);
        if (cursor.moveToLast()) {
            @SuppressLint("Range")
            String name = cursor.getString(cursor.getColumnIndex(DB_helper.COLUMN_NAME));
            textView.setText(String.format("  " + name + "!"));
            textView.setTypeface(textView.getTypeface(), Typeface.BOLD);
        }

        cursor.close();
        db.close();
    }


    public void onClick (View v)
    {
        switch (v.getId()){
            case R.id.button2: // camera
                Intent intent2 = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivity(intent2);
                break;

            case R.id.imageButton: // back
                Intent intent = new Intent(this, Login_activity.class );
                startActivity(intent);
                break;

            case R.id.imageButton2: // menu-settings
                Intent intent3 = new Intent(this, Settings_activity.class );
                startActivity(intent3);
                break;

            default:
                Toast.makeText(getApplicationContext(),"ветка default",Toast.LENGTH_LONG).show();

        }
    }
}
