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
    static int x;
    private Bitmap pipe;
    private int xSpeed = 1;
    private int h;
    static int m;
    static int n;
    private int w;
    private final Random random = new Random();
    static int s;
    private int mr;
    private int nr;
    static int mst;
    static int nst;
    public static int xst;
    private SpriteBird spriteBird;
    static int st2;
    static int pw;
    static int bh;

    public SpriteStolbi(final GameBasic gameBasic, final Bitmap pipe) {
        this.gameBasic = gameBasic;
        this.pipe = pipe;

        gameBasic.post(new Runnable() {
            @Override
            public void run() {
                w = gameBasic.getWidth();
                h = gameBasic.getHeight();
                x = w;
                s = w + w/2;
                mr = h/2;
                nr = h/2;
                m = random.nextInt(mr) + h/4;
                n = random.nextInt(nr) + h/4;
                mst = m; //+ pipe.getHeight();
                nst = n; //+ pipe.getHeight();
               // xst = x;
            }
        });
    }

    public static int getX(){
        return x;
    }

    public static int  getM(){
        return m;
    }
    public static int getS(){
        return s;
}
    public static int getN(){
        return n;
}
public  static int getPw(){
        return pw;
}

    private void update() {
        st2 = SpriteBird.getSt();
        if (st2 == 1 ) {
            xSpeed = 0;
        }
       if (x < 0 - pipe.getWidth() ) {
           x = gameBasic.getWidth();
           m = random.nextInt(mr) + h/4;
     }
        if (s < 0 - pipe.getWidth() ) {
            s = gameBasic.getWidth();
            n = random.nextInt(nr) + h/4;
        }
        x = x - xSpeed;
       s = s - xSpeed;

    }

    public void onDraw(Canvas canvas) {
        pw = pipe.getWidth();
        bh = (SpriteBird.getHeight())*4;
        update();
        canvas.drawBitmap(pipe, x , m, null);
        canvas.save();
        canvas.rotate(180, x , m);
        canvas.drawBitmap(pipe, x - pipe.getWidth(), m + bh,null );
        canvas.restore();
        canvas.drawBitmap(pipe, s, n, null);
        canvas.save();
        canvas.rotate(180, s , n);
        canvas.drawBitmap(pipe, s - pipe.getWidth(), n + bh,null );
        canvas.restore();
    }
}





