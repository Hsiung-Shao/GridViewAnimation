package com.example.gridviewanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    ImageSwitcher showImage;
    Button change;
    int[] imageIndex = {R.drawable.item01, R.drawable.item02, R.drawable.item03, R.drawable.item04, R.drawable.item05, R.drawable.item06,
                        R.drawable.item07, R.drawable.item08, R.drawable.item09, R.drawable.item10, R.drawable.item11, R.drawable.item12,};
    int[][] anim = {{R.anim.alpha_in, R.anim.alpha_out}, {R.anim.scale_in, R.anim.scale_out}, {R.anim.rotate_in, R.anim.rotate_out}};
    int cols = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showImage = findViewById(R.id.showImage);
        change = findViewById(R.id.changeButton);



        CustomGrid adapter = new CustomGrid(MainActivity.this, imageIndex);
        gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int type = (int) (Math.random() * 3);
                showImage.setInAnimation( AnimationUtils.loadAnimation(
                        getApplicationContext(), anim[type][0]));
                showImage.setOutAnimation( AnimationUtils.loadAnimation(
                        getApplicationContext(), anim[type][1]));
                showImage.setImageResource(imageIndex[i]);
            }
        });

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cols = 5 - cols;
                gridView.setNumColumns(cols);
                adapter.cols = cols;

            }
        });

        showImage.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView v = new ImageView(MainActivity.this);
                v.setBackgroundColor(0xFF000000);
                v.setScaleType(ImageView.ScaleType.FIT_CENTER);
                v.setLayoutParams(new ImageSwitcher.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));
                v.setBackgroundColor(Color.WHITE);
                return v;
            }
        });



    }


}