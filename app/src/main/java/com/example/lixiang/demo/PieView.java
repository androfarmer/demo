package com.example.lixiang.demo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class PieView extends View {
    private int[] angles={100,30,60,80,90};
    private int[] colors={Color.GREEN,Color.RED,Color.BLUE,Color.CYAN,Color.DKGRAY};
    private Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);
    private int floatIndex=3;
    private int floatDis=40;
    public PieView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    {
        paint.setStyle(Paint.Style.FILL);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int startAngle=0;
        for (int i = 0; i <angles.length ; i++) {

            paint.setColor(colors[i]);
            if(i==floatIndex)
            {
                canvas.save();
                canvas.translate(getFloatX(startAngle+ angles[i]/2),getFloatY(startAngle+ angles[i]/2));
                canvas.drawArc(new RectF(100,100,700,700),startAngle,angles[i],true,paint);
                canvas.restore();
            }
            else {
                canvas.drawArc(new RectF(100, 100, 700, 700), startAngle, angles[i], true, paint);
            }
            startAngle+=angles[i];
        }
    }

    private float getFloatX(int angle)
    {
        return (float) (floatDis* Math.cos(Math.toRadians(angle)));
    }

    private float getFloatY(int angle)
    {
        return (float) (floatDis* Math.sin(Math.toRadians(angle)));
    }
}
