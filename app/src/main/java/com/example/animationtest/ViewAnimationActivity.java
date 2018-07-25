package com.example.animationtest;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author 淡然爱汝不离
 */
public class ViewAnimationActivity extends AppCompatActivity {

    private static final String TAG = "ViewAnimationActivity";
    @BindView(R.id.start_code_scale)
    Button startCodeScale;
    @BindView(R.id.start_XML_scale)
    Button startXMLScale;
    @BindView(R.id.start_code_rotate)
    Button startCodeRotate;
    @BindView(R.id.start_XML_rotate)
    Button startXMLRotate;
    @BindView(R.id.start_code_alpha)
    Button startCodeAlpha;
    @BindView(R.id.start_XML_alpha)
    Button startXMLAlpha;
    @BindView(R.id.start_code_translate)
    Button startCodeTranslate;
    @BindView(R.id.start_XML_translate)
    Button startXMLTranslate;
    @BindView(R.id.start_code_animation_set)
    Button startCodeAnimationSet;
    @BindView(R.id.start_XML_animation_set)
    Button startXMLAnimationSet;
    @BindView(R.id.test_animation_listener)
    Button testAnimationListener;
    @BindView(R.id.animation)
    ImageView animation;
    @BindView(R.id.animation_msg)
    TextView animationMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animation);
        ButterKnife.bind(this);
    }

    @SuppressLint("SetTextI18n")
    @OnClick({R.id.start_code_scale, R.id.start_XML_scale, R.id.start_code_rotate, R.id.start_XML_rotate, R.id.start_code_alpha, R.id.start_XML_alpha, R.id.start_code_translate, R.id.start_XML_translate, R.id.start_code_animation_set, R.id.start_XML_animation_set, R.id.test_animation_listener})
    public void onViewClicked(View view) {
        Animation animation = null;
        switch (view.getId()) {
            case R.id.start_code_scale:
                animationMsg.setText("Code缩放动画: 宽度从0.5到1.5, 高度从0.0到1.0, " +
                        "缩放的圆心为顶部中心点,延迟1s开始,持续2s,最终还原");
                animation = new ScaleAnimation(0.5f, 1.5f, 0, 1,
                        Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                        0);
                animation.setDuration(2000);
                animation.setStartOffset(1000);
                animation.setFillBefore(true);
                break;
            case R.id.start_XML_scale:
                animationMsg.setText("XML缩放动画: 宽度从0.0到1.5, 高度从0.0到1.0," +
                        " 延迟1s开始,持续3s,圆心为右下角, 最终固定");
                animation = AnimationUtils.loadAnimation(this, R.anim.test_scale);
                break;
            case R.id.start_code_rotate:
                animationMsg.setText("Code旋转动画: 以图片中心点为中心, 从负90度到正90度, 持续5s");
                animation = new RotateAnimation(-90, 90, Animation.RELATIVE_TO_SELF,
                        0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                animation.setDuration(5000);
                break;
            case R.id.start_XML_rotate:
                animationMsg.setText("XML旋转动画: 以左顶点为坐标, 从正90度到负90度, 持续5s");
                animation = AnimationUtils.loadAnimation(this, R.anim.test_rotate);
                break;
            case R.id.start_code_alpha:
                animationMsg.setText("Code透明度动画: 从完全透明到完全不透明, 持续4s");
                animation = new AlphaAnimation(0, 1);
                animation.setDuration(4000);
                break;
            case R.id.start_XML_alpha:
                animationMsg.setText("XML透明度动画: 从完全不透明到完全透明, 持续4s");
                animation = AnimationUtils.loadAnimation(this, R.anim.test_alpha);
                break;
            case R.id.start_code_translate:
                animationMsg.setText("Code移动动画: 向右移动一个自己的宽度," +
                        " 向下移动一个自己的高度, 持续2s");
                animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0,
                        Animation.RELATIVE_TO_SELF, 1, Animation.RELATIVE_TO_SELF,
                        0, Animation.RELATIVE_TO_SELF, 1);
                animation.setDuration(2000);
                break;
            case R.id.start_XML_translate:
                animationMsg.setText("XML移动动画: 从屏幕的右边逐渐回到原来的位置, 持续2s");
                //***此效果用于界面切换的动画效果
                animation = AnimationUtils.loadAnimation(this, R.anim.test_translate);
                break;
            case R.id.start_code_animation_set:
                animationMsg.setText("Code复合动画: 透明度从透明到不透明, 持续2s," +
                        " 接着进行顺时针旋转360度的动画, 持续2s");
                AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
                alphaAnimation.setDuration(2000);
                RotateAnimation rotateAnimation = new RotateAnimation(0, 360,
                        Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                        0.5f);
                rotateAnimation.setDuration(2000);
                rotateAnimation.setStartOffset(2000);
                AnimationSet animationSet = new AnimationSet(true);
                animationSet.addAnimation(alphaAnimation);
                animationSet.addAnimation(rotateAnimation);
                animation = animationSet;
                break;
            case R.id.start_XML_animation_set:
                animationMsg.setText("Xml复合动画: 透明度从透明到不透明, 持续2s, " +
                        "接着进行逆时针旋转360度的动画, 持续2s");
                animation = AnimationUtils.loadAnimation(this, R.anim.test_animation_set);
                break;
            case R.id.test_animation_listener:
                animationMsg.setText("测试动画监听");
                animation = new RotateAnimation(0, 360,
                        Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f);
                animation.setDuration(2000);
                //设置动画重复次数
                //animation.setRepeatCount(1);
                //设置动画的变化率
                animation.setInterpolator(new LinearInterpolator());
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        Log.d(TAG, "动画开始");
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Log.d(TAG, "动画结束");
                        ViewAnimationActivity.this.animation.startAnimation(animation);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        Log.d(TAG, "动画重复");
                    }
                });
                break;
            default:
                break;
        }
        if (animation != null) {
            this.animation.startAnimation(animation);
        }
    }
}
