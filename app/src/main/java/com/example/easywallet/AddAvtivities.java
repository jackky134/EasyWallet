package com.example.easywallet;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.File;

/**
 * Created by Jack on 12/10/2017.
 */

public class AddAvtivities extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inandoutcome);

   private static final String TAG =  AddAvtivities.class.getName();
        private EditText mdetail, mMoney;
        private ImageView mImageinout;
        private Button msave;



        mdetail = findViewById(R.id.edit_text_detail);
        mMoney = findViewById(R.id.money);
        mImageinout = findViewById(R.id.Imageinout);
        msave = findViewById(R.id.save);

        private void saveDataToDb() {
            String phoneTitle = mdetail.getText().toString();
            String Number = mMoney.getText().toString();


            ContentValues cv = new ContentValues();
            cv.put(DbHelper.COL_TITLE, phoneTitle);
            cv.put(DbHelper.COL_NUMBER, Number);


            DbHelper dbHelper = new DbHelper(this);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            long result = db.insert(DbHelper.TABLE_NAME, null, cv);
            if (result == -1) {
                //
            }
        }
}
