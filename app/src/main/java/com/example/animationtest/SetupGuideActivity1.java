package com.example.animationtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author 淡然爱汝不离
 */
public class SetupGuideActivity1 extends AppCompatActivity {

    @BindView(R.id.confirm)
    Button nextStep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_guide_1);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.confirm)
    public void onViewClicked() {
        setNextStep();
    }

    private void setNextStep(){
        startActivity(new Intent(this, SetupGuideActivity2.class));
        /*   overridePendingTransition()： 用于在Activity界面切换时指定切换动画，
                                           一般在startActivity()或者finish()之后调用  */
        overridePendingTransition(R.anim.ringht_in, R.anim.left_out);
    }
}
