package com.example.easywallet;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.easywallet.moneyitem;
import com.example.easywallet.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DbHelper mHelper;
    private SQLiteDatabase mDb;
    private Adapter mAdapter;
    private ArrayList<moneyitem> mMoneyItemList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHelper = new DbHelper(this);
        mDb = mHelper.getReadableDatabase();

        loadDataFromDb();

        mAdapter = new Adapter(
                this,
                R.layout.item,
                mMoneyItemList
        );

        ListView lv = findViewById(R.id.list_view);
        lv.setAdapter(mAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                moneyitem item = mMoneyItemList.get(position);
                String money = item.title;


            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int position, long l) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                System.out.print("ยืนยันที่จะลบรายการ"+""+"?");
                String[] items = new String[]{"NO", "YES"};

                dialog.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (i == 0) { // ไม่ลบ
                            return;

                        } else if (i == 1) { // ลบข้อมูล
                            moneyitem  item = mMoneyItemList.get(position);
                            int phoneId = item.id;

                            mDb.delete(
                                    DbHelper.TABLE_NAME,
                                    DbHelper.COL_ID + "=?",
                                    new String[]{String.valueOf(phoneId)}
                            );
                            loadDataFromDb();
                            mAdapter.notifyDataSetChanged();
                        }
                    }
                });
                return true;
            }
        });
    }

    private void loadDataFromDb() {
        Cursor cursor = mDb.query(
                DbHelper.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );

    }
}
