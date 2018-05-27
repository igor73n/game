package com.example.eugene2.flappybird;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class SpriteGrass {
    private GameBasic gameBasic;
    private Bitmap grass;
    static int h;
    static int w;
    static int x;
    static int s;
    static int y;
    private int xSpeed = 1;
    private int sSpeed = 1;
    static int st2;

    public SpriteGrass (final GameBasic gameBasic, final Bitmap grass) {
        this.gameBasic = gameBasic;
        this.grass = grass;

        gameBasic.post(new Runnable() {
            @Override
            public void run() {
                w = gameBasic.getWidth();
                h = gameBasic.getHeight();
                x = 0;
                y = h - (grass.getHeight())/2;
                s = grass.getWidth();
            }
        });

    }

    public static int getY() {
        return y;
    }
        private void update() {
        st2 = SpriteBird.getSt();
            if (st2 == 1 ) {
                xSpeed = 0;
                sSpeed = 0;
            }

        if ( x < 0 - grass.getWidth()) {
            x = gameBasic.getWidth() - 2;
        }

            if ( s < 0 - grass.getWidth()) {
                s = gameBasic.getWidth() - 2;
            }

            x = x - xSpeed;
            s = s - sSpeed;
        }

        public void onDraw(Canvas canvas) {
            update();
            canvas.drawBitmap(grass, x, y, null);
            canvas.drawBitmap(grass, s , y, null);
        }
    }




