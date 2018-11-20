package com.example.lixiang.demo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class DashView extends View {
    private Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);
    private int ANGLE =40;
    private float RADIUS=Utils.dp2px(100);
    private float pointLength=Utils.dp2px(60);
    private Path arcPath;
    private PathDashPathEffect pathEffet;
    private int pointIndex=3;
    public DashView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    {

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(Utils.dp2px(4));
        Path effectPath= new Path();
        effectPath.addRect(new RectF(0,0,Utils.dp2px(5),Utils.dp2px(10)),Path.Direction.CCW);
        arcPath=new Path();
        arcPath.addArc(new RectF(200,200,200+2*RADIUS,200+2*RADIUS), ANGLE +90,360- ANGLE *2);
        PathMeasure pathMeasure=new PathMeasure();
        pathMeasure.setPath(arcPath,false);
        float length=pathMeasure.getLength();
        pathEffet=new PathDashPathEffect(effectPath,(length-Utils.dp2px(5))/20,0, PathDashPathEffect.Style.ROTATE);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(arcPath,paint);
        paint.setPathEffect(pathEffet);
        canvas.drawPath(arcPath,paint);
        paint.setPathEffect(null);
        canvas.drawLine(200+RADIUS,200+RADIUS,getPointX()+200+RADIUS,getPointY()+200+RADIUS,paint);
    }

    private float getPointX()
    {
        return (float)Math.cos(Math.toRadians(ANGLE +90+(360- ANGLE *2)/20*pointIndex))*pointLength;
    }

    private float getPointY()
    {
        return (float)Math.sin(Math.toRadians(ANGLE +90+(360- ANGLE *2)/20*pointIndex))*pointLength;
    }


}
