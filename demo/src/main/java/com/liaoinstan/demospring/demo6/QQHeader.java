package com.liaoinstan.demospring.demo6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.liaoinstan.demospring.R;
import com.liaoinstan.springview.container.BaseSimpleHeader;
import com.liaoinstan.springview.widget.SpringView;

/**
 * Created by liaoinstan on 2016/3/23.
 * 简单定制的QQ新年刷红包效果，可以在此基础上自己增加动画特效，这里只是模拟出该效果框架进行演示，故该Header不放在library里面
 */
//TODO:重构后该demo失效，待修复
public class QQHeader extends BaseSimpleHeader {

    private TextView text_dot;
    private int dotcount;

    public QQHeader() {
        setType(SpringView.Type.OVERLAP);
        setMovePara(2.0f);
    }

    @Override
    public View getView(LayoutInflater inflater, ViewGroup viewGroup) {
        View view = inflater.inflate(R.layout.header_qq, viewGroup, false);
        text_dot = view.findViewById(R.id.text_dot);
        return view;
    }

    @Override
    public int getDragLimitHeight(View rootView) {
        return 150;
    }

    @Override
    public int getDragMaxHeight(View rootView) {
        return rootView.getMeasuredHeight();
    }

    @Override
    public int getDragSpringHeight(View rootView) {
        return rootView.getMeasuredHeight() - 100;
    }

    @Override
    public void onPreDrag(View rootView) {
        dotcount++;
        text_dot.setText("x" + dotcount);
    }

    @Override
    public void onFinishDrag(View rootView) {
    }

    @Override
    public void onDropAnim(View rootView, int dy) {
    }

    @Override
    public void onLimitDes(View rootView, boolean upORdown) {
    }

    @Override
    public void onStartAnim() {
    }

    @Override
    public void onFinishAnim() {
    }
}
