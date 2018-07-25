package com.example.animationtest;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author 淡然爱汝不离
 */
public class WelcomeActivity extends AppCompatActivity {

    @BindView(R.id.welcome_root)
    RelativeLayout welcomeRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
        showAnimation();
        Handler handler = new Handler();
        //发送一个延时处理的消息
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
                startActivity(new Intent(WelcomeActivity.this, SetupGuideActivity1.class));
            }
        },3000);
    }

    /**
     * 显示动画
     *
     * 旋转动画  RotateAnimation: 0-->360 视图的中心点 2s
     * 透明度动画 AlphaAnimation: 0-->1 2s
     * 缩放动画 ScaleAnimation: 0-->1 视图的中心点 2s
     */
    private void showAnimation() {
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        rotateAnimation.setDuration(2000);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
        alphaAnimation.setDuration(2000);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0, 1, 0, 1,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        scaleAnimation.setDuration(2000);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(rotateAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        welcomeRoot.startAnimation(animationSet);
    }
}
