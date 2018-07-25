package com.example.animationtest;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author 淡然爱汝不离
 */
public class DrawableAnimationActivity extends AppCompatActivity {

    @BindView(R.id.start_drawable_animation)
    TextView startDrawableAnimation;
    @BindView(R.id.stop_drawable_animation)
    TextView stopDrawableAnimation;
    @BindView(R.id.drawable_animation)
    ImageView drawableAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable_animation);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.start_drawable_animation, R.id.stop_drawable_animation})
    public void onViewClicked(View view) {
        AnimationDrawable animationDrawable = (AnimationDrawable) drawableAnimation.getBackground();
        switch (view.getId()) {
            case R.id.start_drawable_animation:
                animationDrawable.start();
                break;
            case R.id.stop_drawable_animation:
                animationDrawable.stop();
                break;
            default:
                break;
        }
    }
}
