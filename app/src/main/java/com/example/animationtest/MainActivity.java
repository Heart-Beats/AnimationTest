package com.example.animationtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.CycleInterpolator;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author 淡然爱汝不离
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.input_text)
    EditText inputText;
    @BindView(R.id.ok)
    Button ok;
    @BindView(R.id.to_Test_VA)
    Button toTestVA;
    @BindView(R.id.to_Test_DA)
    Button toTestDA;
    @BindView(R.id.scan_virus)
    Button scanVirus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.input_text, R.id.ok, R.id.to_Test_VA, R.id.to_Test_DA, R.id.scan_virus})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ok:
                String inputText = this.inputText.getText().toString().trim();
                if (TextUtils.isEmpty(inputText)) {
                    Animation shakeAnimation = AnimationUtils.loadAnimation(this, R.anim.shake);
                    //CycleInterpolator : 可做抖动效果动画
                    shakeAnimation.setInterpolator(new CycleInterpolator(3));
                    this.inputText.startAnimation(shakeAnimation);
                }
                break;
            case R.id.to_Test_VA:
                startActivity(new Intent(this, ViewAnimationActivity.class));
                break;
            case R.id.to_Test_DA:
                startActivity(new Intent(this, DrawableAnimationActivity.class));
                break;
            case R.id.scan_virus:
                startActivity(new Intent(this, ScanVirusActivity.class));
                break;
            default:
                break;
        }
    }
}
