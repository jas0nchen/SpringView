package com.liaoinstan.demospring.demo6;

import android.os.Bundle;
import android.os.Handler;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.liaoinstan.demospring.R;
import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;

public class Demo6Activity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private SpringView springView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo6);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ((RadioGroup) findViewById(R.id.group_header)).setOnCheckedChangeListener(this);

        springView = findViewById(R.id.springview);
        springView.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
                //如果当前设置的头部是QQHeader,则不finish
                if (springView.getHeader() instanceof QQHeader) return;
                new Handler().postDelayed(() -> springView.onFinishFreshAndLoad(), 1000);
            }

            @Override
            public void onLoadmore() {
                new Handler().postDelayed(() -> springView.onFinishFreshAndLoad(), 1000);
            }
        });
        springView.setHeader(new QQHeader().setMovePara(1.5f));     //设置拖拽系数（值越大，移动越慢）
        springView.setFooter(new DefaultFooter(this, R.drawable.progress_small));
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.drag_header:
                springView.setHeader(new QQHeader());
                break;
            case R.id.nomal_header:
                springView.setHeader(new DefaultHeader(this));
                break;
        }
    }
}
