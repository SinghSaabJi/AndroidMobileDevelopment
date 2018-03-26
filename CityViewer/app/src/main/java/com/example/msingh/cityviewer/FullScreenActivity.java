package com.example.msingh.cityviewer;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

public class FullScreenActivity extends Activity {

    public static final String EXTRA_SPACE_PHOTOS = "SpacePhotoActivity.SPACE_PHOTOS";
    private ImageView mImageView;
    private  ImageHeader imagePhotos;
    private  int maxImages = 4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_detail);

        mImageView = (ImageView) findViewById(R.id.image);
        imagePhotos = getIntent().getParcelableExtra(EXTRA_SPACE_PHOTOS);

        SetImage();

        mImageView.setOnTouchListener(new OnSwipeTouchListener(FullScreenActivity.this) {

            @Override
            public void onClick() {
                super.onClick();
                // your on click here
            }

            @Override
            public void onDoubleClick() {
                super.onDoubleClick();
                // your on onDoubleClick here
            }

            @Override
            public void onLongClick() {
                super.onLongClick();
                // your on onLongClick here
            }

            @Override
            public void onSwipeUp() {
                super.onSwipeUp();
                // your swipe up here
            }

            @Override
            public void onSwipeDown() {
                super.onSwipeDown();
                // your swipe down here.
            }

            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
                // your swipe left here.
                SetNextImage("left");
            }

            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                // your swipe right here.
                SetNextImage("right");
            }
        });


    }

    private void SetImage() {
        Glide.with(this)
                .load(imagePhotos.images[imagePhotos.currImagePosition].mUrl)
                .asBitmap()
                .error(R.drawable.ic_cloud_off_red)
                .listener(new RequestListener<String, Bitmap>() {

                    @Override
                    public boolean onException(Exception e, String model, Target<Bitmap> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Bitmap resource, String model, Target<Bitmap> target, boolean isFromMemoryCache, boolean isFirstResource) {

                        onPalette(Palette.from(resource).generate());
                        mImageView.setImageBitmap(resource);

                        return false;
                    }

                    public void onPalette(Palette palette) {
                        if (null != palette) {
                            ViewGroup parent = (ViewGroup) mImageView.getParent().getParent();
                            parent.setBackgroundColor(palette.getDarkVibrantColor(Color.GRAY));
                        }
                    }
                })
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(mImageView);
    }

    private void SetNextImage(String direction){
        if(direction=="left"){
            if(imagePhotos.currImagePosition>=maxImages){
                imagePhotos.currImagePosition =0;
            }
            else{
                imagePhotos.currImagePosition++;
            }
        }
        else{
            if(imagePhotos.currImagePosition<=0){
                imagePhotos.currImagePosition = maxImages;
            }
            else{
                imagePhotos.currImagePosition--;
            }
        }
        SetImage();
    }
}
