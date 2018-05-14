package com.example.eugene2.flappybird;

/**
 * Created by Админ on 28.04.2018.
 */

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;

import java.util.Random;

public class SpriteStolbi {
    private GameBasic gameBasic;
    private int x;
    private Bitmap pipe;
    private int xSpeed = 1;
    private int h;
    private int m;
    private int n;
    private int w;
    private final Random random = new Random();
    private int s;
    private int mr;
    private int nr;


    public SpriteStolbi(final GameBasic gameBasic, Bitmap pipe) {
        this.gameBasic = gameBasic;
        this.pipe = pipe;

        gameBasic.post(new Runnable() {
            @Override
            public void run() {
                w = gameBasic.getWidth();
                h = gameBasic.getHeight();
                x = w;
                s = w + w/2;
                mr = h;
                nr = h;
                m = random.nextInt(mr);
                n = random.nextInt(nr);
            }
        });
    }
    private void update() {
       if (x < 0 - pipe.getWidth() ) {
           x = gameBasic.getWidth();
           m = random.nextInt(mr);
     }
        if (s < 0 - pipe.getWidth() ) {
            s = gameBasic.getWidth();
            n = random.nextInt(nr);
        }
        x = x - xSpeed;
       s = s - xSpeed;

    }

    public void onDraw(Canvas canvas) {
        update();
        canvas.drawBitmap(pipe, x, m, null);
        canvas.save();
        canvas.rotate(180, x , m);
        canvas.drawBitmap(pipe, x - pipe.getWidth(), m + 50,null );
        canvas.restore();
        canvas.drawBitmap(pipe, s, n, null);
        canvas.save();
        canvas.rotate(180, s , n);
        canvas.drawBitmap(pipe, s - pipe.getWidth(), n + 50,null );
        canvas.restore();
    }
}





