package com.example.zlobina_09_24;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login_activity extends AppCompatActivity {


    EditText nameBox, email;
    DB_helper sqlHelper;
    SQLiteDatabase db;
    long userId = 0;


    Button btn;
    @Override
    @SuppressLint("Range")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
        btn = findViewById(R.id.btn_log);

        nameBox = findViewById(R.id.Login);
        email = findViewById(R.id.email);

        sqlHelper = new DB_helper(this);

        db = sqlHelper.getWritableDatabase();

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            userId = extras.getLong("id");
        }

        if (userId > 0) {
            // Fetch existing name from database for editing
            Cursor cursor = db.query(DB_helper.TABLE, null, DB_helper.COLUMN_ID + "=?",
                    new String[]{String.valueOf(userId)}, null, null, null);
            if (cursor.moveToFirst()) {
                nameBox.setText(cursor.getString(cursor.getColumnIndex(DB_helper.COLUMN_NAME)));
            }
            cursor.close();
        }
    }

 /*   public void onClicked1 (View view)
    {
        if (view.getId() == R.id.button)
        {
            Intent intent = new Intent(this, login_activity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(getApplicationContext(), "something wrong with activity! Hey!", Toast.LENGTH_LONG).show();
        }

    }*/

    public void onClicked(View view) {
        ContentValues cv = new ContentValues();
        cv.put(DB_helper.COLUMN_NAME, nameBox.getText().toString());

        if (userId > 0) {
            // Update existing entry
            db.update(DB_helper.TABLE, cv, DB_helper.COLUMN_ID + "=?",
                    new String[]{String.valueOf(userId)});
        } else {
            // Insert new entry
            db.insert(DB_helper.TABLE, null, cv);
        }

        Intent i = new Intent(this, Perconal_area_acrivity.class);
        startActivity(i);
    }
}