package com.example.easywallet;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.easywallet.DbHelper;
import com.example.easywallet.moneyitem;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Jack on 12/10/2017.
 */

public class Adapter extends ArrayAdapter<moneyitem> {

    private ArrayList<moneyitem> mMoneyitemlist;
    private Context mContext;
    private int mLayoutResID;


    public Adapter(@NonNull Context context, int layoutResId, @NonNull ArrayList<moneyitem> phoneItemList) {
        super(context, layoutResId, phoneItemList);

        this.mContext = context;
        this.mLayoutResID = layoutResId;
        this.mMoneyitemlist = phoneItemList;
    }
    @Nullable
    @Override
    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemLayout =  inflater.inflate(mLayoutResID, null);

        moneyitem item = mMoneyitemlist.get(position);

        ImageView inoutImageView = itemLayout.findViewById(R.id.Imageinout);
        TextView TitleTextView = itemLayout.findViewById(R.id.activities);
        TextView NumberTextView = itemLayout.findViewById(R.id.editText3);

        TitleTextView.setText(item.title);
        NumberTextView.setText(item.number);

        String pictureFilename = item.picture   ;

        AssetManager am = mContext.getAssets();
        try {
            InputStream stream = am.open(pictureFilename);
            Drawable drawable = Drawable.createFromStream(stream,null);
            inoutImageView.setImageDrawable(drawable);

        } catch (IOException e) {
            e.printStackTrace();

            File pictureFile = new File(mContext.getFilesDir(), pictureFilename);
            Drawable drawable = Drawable.createFromPath(pictureFile.getAbsolutePath());
            inoutImageView.setImageDrawable(drawable);
        }

        return itemLayout;
    }
}

