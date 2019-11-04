package com.kuliah.komsi.bookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;

public class DetailActivity extends AppCompatActivity {
    private TextView mText1, mText2, mTextDesc;
    private TextView mPublisher, mPublishDate;
    private ImageView mImage;
    ItemData data;
    //Edittt

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mText1 = findViewById(R.id.text1);
        mText2 = findViewById(R.id.text2);
        mTextDesc = findViewById(R.id.textDesc);
        mImage = findViewById(R.id.image);
        mPublisher = findViewById(R.id.text3);
        mPublishDate = findViewById(R.id.text4);
        //Editttt

        Intent intent = getIntent();
        if (intent.hasExtra("DATA")){
            data = intent.getParcelableExtra("DATA");
            mText1.setText(data.itemTitle);
            mText2.setText(data.itemSubtitle);
            mTextDesc.setText(data.itemDescription);
            mPublisher.setText(data.itemPublisher);
            mPublishDate.setText(data.itemPublishDate);
            //Editttt setelah menambahkan pada ItemData
            new LoadImage(mImage).execute(data.itemImage);  //menampilkan image
        }
    }

    private class LoadImage extends AsyncTask<String, Void, Bitmap>{
        private ImageView imageView;
        public LoadImage(ImageView imageView){
            this.imageView = imageView;
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            URL url = null;
            Bitmap bmp = null;
            try{
                url = new URL(strings[0]);
                bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            }catch (IOException e){
                e.printStackTrace();
            }
            return bmp;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            imageView.setImageBitmap(bitmap);
        }
    }



}
