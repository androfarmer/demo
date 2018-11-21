package com.example.lixiang.demo;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
        ProvinceView provinceView = findViewById(R.id.view);
        provinceView.runProvince();
         */

        /**
        ImageView imageView=findViewById(R.id.view);
        Keyframe keyframe1=Keyframe.ofFloat(0f,0);
        Keyframe keyframe2=Keyframe.ofFloat(0.5f,100);
        Keyframe keyframe3=Keyframe.ofFloat(0.9f,700);
        Keyframe keyframe4=Keyframe.ofFloat(1f,800);
//        PropertyValuesHolder propertyValuesHolderX=PropertyValuesHolder.ofFloat("x",800);
//        propertyValuesHolderX.setKeyframes(keyframe1,keyframe2,keyframe3);
        PropertyValuesHolder propertyValuesHolderX=PropertyValuesHolder.ofKeyframe("x",keyframe1,keyframe2,keyframe3,keyframe4);
         */


        /**
        PropertyValuesHolder propertyValuesHolderScaleX=PropertyValuesHolder.ofFloat("scaleX",2);
        PropertyValuesHolder propertyValuesHolderScaleY=PropertyValuesHolder.ofFloat("scaleY",2);
        ObjectAnimator objectAnimator= ObjectAnimator.ofPropertyValuesHolder(imageView,propertyValuesHolderX,propertyValuesHolderScaleY,propertyValuesHolderScaleX);
        objectAnimator.setDuration(4000);
        objectAnimator.setStartDelay(1000);
        objectAnimator.start();
        */

        /**
        PointerView pointerView = findViewById(R.id.view);
        pointerView.run();
         *
         */

        /**
        AnimatorSet animatorSet=new AnimatorSet();
        animatorSet.playSequentially(Animator1,Animator2,Animator3);
        animatorSet.start();
         */
        
    }
}
