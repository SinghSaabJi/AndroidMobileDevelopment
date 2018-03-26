package com.example.msingh.cityviewer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnOne(View view){
        String id = "";
        switch (view.getId()){
            case R.id.cv:
                id="BC";
                break;

            case R.id.cv2:
                // do your code
                id="BS";
                break;

            case R.id.cv3:
                // do your code
                id="CC";
                break;
            case R.id.cv4:
                // do your code
                id="CP";
                break;
            case R.id.cv5:
                // do your code
                id="GM";
                break;
            case R.id.cv6:
                // do your code
                id="GP";
                break;
            case R.id.cv7:
                // do your code
                id="MPV";
                break;
            case R.id.cv8:
                // do your code
                id="PA";
                break;
            case R.id.cv9:
                // do your code
                id="RT";
                break;
            case R.id.cv10:
                // do your code
                id="SP";
                break;

            default:
                break;
        }

        Intent galleryIntent = new Intent(MainActivity.this,ImageGallery.class);
        ImageData photoID = new ImageData(id,id,0);
        galleryIntent.putExtra(ImageGallery.EXTRA_SPACE_PHOTO, photoID);
        startActivity(galleryIntent);
    }
}
