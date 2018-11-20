package com.example.lixiang.demo;

import android.appwidget.AppWidgetHost;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.util.TypedValue;

public  class Utils {
    public static Bitmap getBitmap(Resources res,int resId,int width)
    {
        BitmapFactory.Options options=new BitmapFactory.Options();
        options.inJustDecodeBounds=true;
        BitmapFactory.decodeResource(res,resId,options);

//        int inSampleSize=1;
//        if(options.outWidth>width)
//        {
//            inSampleSize=options.outWidth/width;
//        }
//        options.inSampleSize=inSampleSize;
        options.inDensity=options.outWidth;
        options.inTargetDensity=width;
        options.inJustDecodeBounds=false;
        options.inMutable=true;
        return BitmapFactory.decodeResource(res,resId,options);
    }

    public static float dp2px(float dp)
    {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dp,Resources.getSystem().getDisplayMetrics());
    }
}
