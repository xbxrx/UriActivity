package com.example.uriactivity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView tx;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        button=findViewById(R.id.button);
        tx=findViewById(R.id.hobby);
        final ValueAnimator animator = ValueAnimator.ofFloat(0,360);
        animator.setDuration(500);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(final ValueAnimator animation) {

                        button.setRotation((float)animation.getAnimatedValue());
            }
        });
        animator.setRepeatCount(10);
        animator.setRepeatMode(ValueAnimator.REVERSE);

        animator.start();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                button.animate().rotation(360).setDuration(500).start();
                if (animator.isRunning())
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                        animator.pause();
                    }
                else {
                    if (animator.isStarted())
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            animator.resume();
                        }
                    else
                        animator.start();
                }
            }
        });


    }
}