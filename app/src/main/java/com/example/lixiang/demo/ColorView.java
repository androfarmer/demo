package com.example.lixiang.demo;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class ColorView extends View {
    private Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);
    public ColorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    {
        paint.setStyle(Paint.Style.FILL);
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
        invalidate();
    }

    private int color=Color.BLACK;


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(color);
        canvas.drawCircle(getWidth()/2,getHeight()/2,Utils.dp2px(100),paint);
    }


    public void  run()
    {
        ObjectAnimator objectAnimator=ObjectAnimator.ofInt(this,"color",Color.RED,Color.YELLOW);
        objectAnimator.setEvaluator(new ArgbEvaluator());
        objectAnimator.setStartDelay(1000);
        objectAnimator.setDuration(8000);
        objectAnimator.start();
    }
}
