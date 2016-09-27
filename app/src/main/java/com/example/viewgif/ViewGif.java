package com.example.viewgif;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;

import java.io.InputStream;

public class ViewGif extends View {

    private Movie gif;
    private long start;

    public ViewGif(Context context) {
        super(context);
        init(context);
    }

    public ViewGif(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ViewGif(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        setFocusable(true);
        InputStream gifInputStream = context.getResources().openRawResource(+ R.drawable.samplegif);

        gif = Movie.decodeStream(gifInputStream);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        long now = SystemClock.uptimeMillis();

        if (start == 0) {
            start = now;
        }

        if (gif != null) {

            int dur = gif.duration();

            if (dur == 0) {
                dur = 1000;
            }

            int realTime = (int)((now - start) % dur);

            gif.setTime(realTime);

            gif.draw(canvas, 0, 0);
            invalidate();
        }
    }
}