package com.kuliah.komsi.bookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private TextView mText1, mText2, mTextDesc;
    private ImageView mImage;
    ItemData data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mText1 = findViewById(R.id.text1);
        mText2 = findViewById(R.id.text2);
        mTextDesc = findViewById(R.id.textDesc);
        mImage = findViewById(R.id.image);

        Intent intent = getIntent();
        if (intent.hasExtra("DATA")){
            data = intent.getParcelableExtra("DATA");
            mText1.setText(data.itemTitle);
            mText2.setText(data.itemSubtitle);
            mTextDesc.setText(data.itemDescription);
        }
    }
}
