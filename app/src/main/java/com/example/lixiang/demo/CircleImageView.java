package com.example.lixiang.demo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class CircleImageView extends View {
    private Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);
    private Bitmap bitmap;
    public CircleImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    {
        bitmap=Utils.getBitmap(getResources(),R.drawable.lixiang,200);
        System.out.println(bitmap.getWidth());
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(bitmap,0,0,paint);
    }
}
