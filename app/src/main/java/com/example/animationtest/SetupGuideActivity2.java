package com.example.animationtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author 淡然爱汝不离
 */
public class SetupGuideActivity2 extends AppCompatActivity {

    @BindView(R.id.pre_step)
    Button preStep;
    @BindView(R.id.confirm)
    Button nextStep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_guide_2);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.pre_step, R.id.confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.pre_step:
                setPreStep();
                break;
            case R.id.confirm:
                setNextStep();
                break;
            default:
                break;
        }
    }

    private void setPreStep(){
        startActivity(new Intent(this, SetupGuideActivity1.class));
        overridePendingTransition(R.anim.left_in, R.anim.right_out);
    }

    private void setNextStep() {
        startActivity(new Intent(this, SetupGuideActivity3.class));
        overridePendingTransition(R.anim.ringht_in, R.anim.left_out);
    }
}
