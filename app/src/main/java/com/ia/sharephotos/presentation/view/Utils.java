package com.ia.sharephotos.presentation.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by ysantana on 30/03/2016.
 */
public class Utils {

    public static void setAnimation(Context context, View viewToAnimate, int position, int lastPosition) {
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.fade_in);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

}