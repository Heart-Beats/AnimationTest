package com.example.animationtest;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author 淡然爱汝不离
 */
public class ScanVirusActivity extends AppCompatActivity {

    @BindView(R.id.act_scanning)
    ImageView actScanning;
    @BindView(R.id.tv_main_scan)
    TextView tvMainScan;
    @BindView(R.id.pb_main_scan)
    ProgressBar pbMainScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_virus);
        ButterKnife.bind(this);
        showScanAnimation();
        scan();
    }

    /**
     * 扫描,并显示扫描进度
     */
    @SuppressLint("StaticFieldLeak")
    private void scan() {
        //异步任务
        new AsyncTask<Void, Integer, Void>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                tvMainScan.setText("手机杀毒引擎正在扫描中...");
            }

            @Override
            protected Void doInBackground(Void... voids) {
                int maxProgress = 100;
                pbMainScan.setMax(maxProgress);
                for (int i = 0; i < maxProgress; i++) {
                    //没有休眠，由于时间太短看不出动画效果
                    SystemClock.sleep(40);
                    publishProgress(i);
                }
                return null;
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
                pbMainScan.setProgress(values[values.length-1]);
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                //隐藏进度条
                pbMainScan.setVisibility(View.GONE);
                //更新文本
                tvMainScan.setText("扫描完成, 未发现病毒应用, 请放心使用!");
                //停止扫描动画
                actScanning.clearAnimation();
            }
        }.execute();
    }

    /**
     * 显示扫描动画
     * iv_main_scan的旋转动画
     */
    private void showScanAnimation() {
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        rotateAnimation.setDuration(1000);
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        actScanning.startAnimation(rotateAnimation);
    }
}
