package com.example.easywallet;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jack on 12/10/2017.
 */

    public class DbHelper extends SQLiteOpenHelper {

        private static final String DATABASE_NAME = "money.db";
        private static final int DATABASE_VERSION = 8;

        public static final String TABLE_NAME = "moneyinout";
        public static final String COL_ID = "_id";
        public static final String COL_TITLE = "title";
        public static final String COL_PICTURE = "picture";

        private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_TITLE + " TEXT, "
                + COL_PICTURE + " TEXT)";

        public DbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE);
            insertInitialData(db);
        }

        private void insertInitialData(SQLiteDatabase db) {
            ContentValues cv = new ContentValues();
            cv.put(COL_TITLE, "คุณพ่อให้เงิน");
            cv.put(COL_PICTURE, "ic_income.jpg");
            db.insert(TABLE_NAME, null, cv);

            cv = new ContentValues();
            cv.put(COL_TITLE, "จ่ายค่าหอ");
            cv.put(COL_PICTURE, "ic_expense.jpg");
            db.insert(TABLE_NAME, null, cv);

            cv = new ContentValues();
            cv.put(COL_TITLE, "ซื้อล็อตเตอรี่ 1 ชุด");
            cv.put(COL_PICTURE, "ic_expense.jpg");
            db.insert(TABLE_NAME, null, cv);

            cv = new ContentValues();
            cv.put(COL_TITLE, "ถูกล็อตเตอรี่รางวัลที่ 1");
            cv.put(COL_PICTURE, "ic_expense.jpg");
            db.insert(TABLE_NAME, null, cv);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }



