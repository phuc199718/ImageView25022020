package com.example.imageview25022020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView mImg;
    Button mBtnNext,mBtnPrevious,mBtnRandom,mBtnAutoNext,mBtnAutoPrevious,mBtnPauseAuto;
    ArrayList<Integer> mArrayImageIntegers;
    int mCount = 0;
    int mIndexRandom = 0;
    Random mRandom;
    CountDownTimer mCountDownTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImg = findViewById(R.id.imageview);
        mBtnNext = findViewById(R.id.buttonNext);
        mBtnPrevious = findViewById(R.id.buttonPrevious);
        mBtnRandom = findViewById(R.id.buttonRandom);
        mBtnAutoNext = findViewById(R.id.buttonAutoNext);
        mBtnAutoPrevious = findViewById(R.id.buttonAutoPrevious);
        mBtnPauseAuto = findViewById(R.id.buttonPauseAuto);

        // Tạo mảng hình
        mArrayImageIntegers = new ArrayList<>();
        mArrayImageIntegers.add(R.drawable.hinh1);
        mArrayImageIntegers.add(R.drawable.hinh2);
        mArrayImageIntegers.add(R.drawable.hinh3);
        mArrayImageIntegers.add(R.drawable.hinh4);
        mArrayImageIntegers.add(R.drawable.hinh5);

        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCount = mCount >= mArrayImageIntegers.size() - 1 ? 0 : ++mCount;
                mImg.setImageResource(mArrayImageIntegers.get(mCount));
            }
        });

        mBtnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCount = mCount <= 0 ? mArrayImageIntegers.size() - 1 : --mCount;
                mImg.setImageResource(mArrayImageIntegers.get(mCount));
            }
        });

        mBtnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRandom = new Random();
                mIndexRandom = mRandom.nextInt(mArrayImageIntegers.size());
                mCount = mIndexRandom;
                mImg.setImageResource(mArrayImageIntegers.get(mIndexRandom));
            }
        });

        mBtnAutoNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCountDownTimer = new CountDownTimer(4000,1000) {
                    @Override
                    public void onTick(long l) {
                        mCount = mCount >= mArrayImageIntegers.size() - 1 ? 0 : ++mCount;
                        mImg.setImageResource(mArrayImageIntegers.get(mCount));
                    }

                    @Override
                    public void onFinish() {
                        mCountDownTimer.start();
                    }
                };
                mCountDownTimer.start();
            }
        });
        // Task 1 : Lam chức năng auto previous
        mBtnAutoPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCountDownTimer = new CountDownTimer(4000,1000) {
                    @Override
                    public void onTick(long l) {
                        mCount = mCount <= 0 ? mArrayImageIntegers.size() - 1 : --mCount;
                        mImg.setImageResource(mArrayImageIntegers.get(mCount));
                    }

                    @Override
                    public void onFinish() {
                        mCountDownTimer.start();
                    }
                };
                mCountDownTimer.start();
            }
        });
        // Task 2 : làm chức năng pause auto
        mBtnPauseAuto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCountDownTimer.cancel();
            }
        });

    }
}
