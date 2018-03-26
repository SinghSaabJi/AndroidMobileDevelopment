package com.example.msingh.cityviewer;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ImageGallery extends Activity {

    public static final String EXTRA_SPACE_PHOTO = "SpacePhotoActivity.SPACE_PHOTO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_gallery);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_images);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        ImageData photo = getIntent().getParcelableExtra(EXTRA_SPACE_PHOTO);

        ImageHeader images = new ImageHeader();
        images.images = getImageDatas(photo.mTitle);
        ImageGallery.ImageGalleryAdapter adapter = new ImageGallery.ImageGalleryAdapter(this, images );
        recyclerView.setAdapter(adapter);

    }

    public ImageData[] getImageDatas(String id) {

        return new ImageData[]{
                new ImageData("http://appdevelite.x10host.com/and/"+id+"1.jpg", "Img",0),
                new ImageData("http://appdevelite.x10host.com/and/"+id+"2.jpg", "Img",1),
                new ImageData("http://appdevelite.x10host.com/and/"+id+"3.jpg", "Img",2),
                new ImageData("http://appdevelite.x10host.com/and/"+id+"4.jpg", "Img",3),
                new ImageData("http://appdevelite.x10host.com/and/"+id+"5.jpg", "Img",4),
        };
    }

    private class ImageGalleryAdapter extends RecyclerView.Adapter<ImageGalleryAdapter.MyViewHolder>  {

        @Override
        public ImageGalleryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);

            // Inflate the layout
            View photoView = inflater.inflate(R.layout.item_photo, parent, false);

            ImageGalleryAdapter.MyViewHolder viewHolder = new ImageGalleryAdapter.MyViewHolder(photoView);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ImageGalleryAdapter.MyViewHolder holder, int position) {

            ImageData ImageData = mImageDatas[position];
            ImageView imageView = holder.mPhotoImageView;

            Glide.with(mContext)
                    .load(ImageData.mUrl)
                    .placeholder(R.drawable.ic_cloud_off_red)
                    .into(imageView);
        }

        @Override
        public int getItemCount() {
            return (mImageDatas.length);
        }

        public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            public ImageView mPhotoImageView;

            public MyViewHolder(View itemView) {

                super(itemView);
                mPhotoImageView = (ImageView) itemView.findViewById(R.id.iv_photo);
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View view) {

                int position = getAdapterPosition();
                if(position != RecyclerView.NO_POSITION) {
                    ImageHeader imageData = new ImageHeader();
                    imageData.images= mImageDatas;
                    imageData.currImagePosition = position;

                    Intent intent = new Intent(mContext, FullScreenActivity.class);
                    intent.putExtra(FullScreenActivity.EXTRA_SPACE_PHOTOS, imageData);
                    startActivity(intent);
                }
            }
        }

        private ImageData[] mImageDatas;
        private Context mContext;

        public ImageGalleryAdapter(Context context, ImageHeader ImageDatas) {
            mContext = context;
            mImageDatas = ImageDatas.images;
        }
    }
}
