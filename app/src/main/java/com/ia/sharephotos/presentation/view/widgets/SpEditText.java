package com.ia.sharephotos.presentation.view.widgets;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by ysantana on 28/03/2016.
 */
public class SpEditText extends EditText {
    public SpEditText(Context context) {
        super(context);
        init();
    }

    public SpEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SpEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }


    public void init() {
        Typeface openSans = null;
        if (getTypeface() != null && getTypeface().getStyle() == Typeface.BOLD)
            openSans = Typeface.createFromAsset(getContext().getAssets(), "fonts/OpenSans-Bold.ttf");
        else if (getTypeface() != null && getTypeface().getStyle() == Typeface.ITALIC) {
            openSans = Typeface.createFromAsset(getContext().getAssets(), "fonts/OpenSans-Light.ttf");
        } else if (getTypeface() != null && getTypeface().getStyle() == Typeface.BOLD_ITALIC) {
            openSans = Typeface.createFromAsset(getContext().getAssets(), "fonts/OpenSans-Semibold.ttf");
        } else {
            openSans = Typeface.createFromAsset(getContext().getAssets(), "fonts/OpenSans-Regular.ttf");
        }
        if (openSans != null) {
            setTypeface(openSans);
        }
    }
}