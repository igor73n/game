package com.example.eugene2.flappybird;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class SpriteOver {
    private GameBasic gameBasic;
    private Bitmap x5;
    static int w;
    static int h;
    static int x;
    static int y;
    private int ySpeed = 0;
    static int st2;

    public SpriteOver (final GameBasic gameBasic, final Bitmap x5) {
        this.gameBasic = gameBasic;
        this.x5 = x5;

        gameBasic.post(new Runnable() {
            @Override
            public void run() {
                w = gameBasic.getWidth();
                h = gameBasic.getHeight();
                x = w/2 - (x5.getWidth())/2;
                y = 0 - x5.getHeight();
            }
        });
    }

    private void update(){
        st2 = SpriteBird.getSt();
        if (st2 == 1) {
            ySpeed = 5;
        }

        if (y - x5.getHeight() > h/2 - h/4 ) {
            ySpeed = 0;
        }

        y = y + ySpeed;
    }

public void onDraw(Canvas canvas) {
        update();
        canvas.drawBitmap(x5, x, y, null);
}

}
