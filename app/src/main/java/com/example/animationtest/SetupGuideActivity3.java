package com.example.animationtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SetupGuideActivity3 extends AppCompatActivity {

    @BindView(R.id.pre_step)
    Button preStep;
    @BindView(R.id.confirm)
    Button nextStep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_guide_3);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.pre_step, R.id.confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.pre_step:
                setPreStep();
                break;
            case R.id.confirm:
                confirm();
                break;
            default:
                break;
        }
    }

    private void setPreStep(){
        startActivity(new Intent(this, SetupGuideActivity2.class));
        overridePendingTransition(R.anim.left_in, R.anim.right_out);
    }

    private void confirm() {
        startActivity(new Intent(this, MainActivity.class));
        overridePendingTransition(R.anim.view_display,R.anim.top_out);
    }
}
