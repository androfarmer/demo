package com.example.lixiang.demo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class CircleImageView extends View {
    private Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);
    private Bitmap bitmap;
    private float borderWidth=Utils.dp2px(4);
    public CircleImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    {
        bitmap=Utils.getBitmap(getResources(),R.drawable.lixiang,400);
        paint.setStrokeWidth(borderWidth);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(100,100);
        int saveCount= canvas.saveLayer(0,0,bitmap.getWidth(),bitmap.getHeight(),paint);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(bitmap.getWidth()/2,bitmap.getHeight()/2,+bitmap.getWidth()/2,paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap,0,0,paint);
        paint.setXfermode(null);
        canvas.restoreToCount(saveCount);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(bitmap.getWidth()/2,bitmap.getHeight()/2,+bitmap.getWidth()/2,paint);
        canvas.restore();
    }
}
