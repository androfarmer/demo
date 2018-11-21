package com.example.lixiang.demo;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

public class ProvinceView extends View {
    private TextPaint paint=new TextPaint(Paint.ANTI_ALIAS_FLAG);
    public ProvinceView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    {
        paint.setTextSize(Utils.dp2px(60));
        paint.setTextAlign(Paint.Align.CENTER);
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
        invalidate();
    }

    private  String province="";

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText(province,getWidth()/2,getHeight()/2,paint);
    }


    public void runProvince()
    {
        ObjectAnimator objectAnimator=ObjectAnimator.ofObject(this, "province", new TypeEvaluator<String>() {
            @Override
            public String evaluate(float fraction, String startValue, String endValue) {
                int startIndex=ProvinceUtil.provinces.indexOf(startValue);
                int endIndex=ProvinceUtil.provinces.indexOf(endValue);

                int  index= (int) (startIndex+(endIndex-startIndex)*fraction);
                return ProvinceUtil.provinces.get(index);
            }
        },ProvinceUtil.provinces.get(0), ProvinceUtil.provinces.get(ProvinceUtil.provinces.size()-1));

        objectAnimator.setDuration(5000);
        objectAnimator.start();
    }


}
