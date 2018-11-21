package com.example.lixiang.demo;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class PointerView extends View {
    private Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
        invalidate();
    }

    private Point point=new Point(0,0);
    public PointerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    {
        paint.setStrokeWidth(Utils.dp2px(20));
        paint.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPoint(point.x,point.y,paint);
    }


    public void run()
    {
        ObjectAnimator objectAnimator=ObjectAnimator.ofObject(this, "point", new TypeEvaluator<Point>() {
            @Override
            public Point evaluate(float fraction, Point startValue, Point endValue) {
                Point point=new Point((int)(startValue.x+(endValue.x-startValue.x)*fraction),(int)(startValue.y+(endValue.y-startValue.y)*fraction));
                return point;
            }
        },new Point(0,0),new Point(500,500));
        objectAnimator.setStartDelay(1000);
        objectAnimator.setDuration(5000);
        objectAnimator.start();
    }

}
