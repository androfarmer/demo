package com.example.lixiang.demo;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

class MeshDrawable extends Drawable {
    private int interval= (int) Utils.dp2px(30);
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    @Override
    public void draw(@NonNull Canvas canvas) {
        for (int i = 0; i < getBounds().right; i+=interval) {
            canvas.drawLine(i,getBounds().top,i,getBounds().bottom,paint);
            for (int j = 0; j <getBounds().bottom ; j+=interval) {
                canvas.drawLine(getBounds().left,j,getBounds().right,j,paint);
            }
        }
    }

    @Override
    public void setAlpha(int alpha) {
        paint.setAlpha(alpha);
    }

    @Override
    public int getAlpha() {
        return paint.getAlpha();
    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        paint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return getAlpha() == 0x00 ? PixelFormat.TRANSPARENT :
                getAlpha() == 0xff ? PixelFormat.OPAQUE :
                        PixelFormat.TRANSLUCENT;
    }
}
