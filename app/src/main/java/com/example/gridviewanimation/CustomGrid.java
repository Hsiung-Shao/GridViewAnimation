package com.example.gridviewanimation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.widget.LinearLayoutCompat;

public class CustomGrid extends BaseAdapter {
    Context context;
    int[] imageId;
    public int cols = 2;

    public CustomGrid(Context context, int[] imageId) {
        this.context = context;
        this.imageId = imageId;
    }

    @Override
    public int getCount() {
        return imageId.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView iv;
        View grid;
        int side = 300;
        int ds = 10;

        if (cols == 2) side = 500; else side = 300;

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(side,side);

        if (convertView == null) {
            iv = new ImageView(context);
            iv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            iv.setPadding(ds,ds,ds,ds);
        } else {
            iv = (ImageView) convertView;
        }
        iv.setLayoutParams(params);
        iv.setImageResource(imageId[position]);
        return iv;
    }
}
