package com.example.eugene2.flappybird;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;


public class SpriteBird {
    private GameBasic gameBasic;
    private Bitmap bird;
    private int w;
    private int h;
    private int x;
    private int y;
    private int l;
    private int ySpeed = 1;
    private int currentFrame = 0;
    private int widht;
    static int height;
    private static final int BMP_ROWS = 6;
    private static final int BMP_COLUMNS = 3;
    private SpriteStolbi spriteStolbi;
    static int x2;
    static int y2;
    static int x3;
    static int y3;
    private Main main;
    static int st;
    private int sr;
    static int wst;


// @Override
   // public void onCreate(Bundle savedInstanceState) {
    // super.onCreate(savedInstanceState);
     //   setContentView(spriteBird);
   // }


    public SpriteBird(final GameBasic gameBasic, Bitmap bird) {
        this.gameBasic = gameBasic;
        this.bird = bird;
        this.widht = bird.getWidth()/BMP_COLUMNS;
        this.height = bird.getHeight()/BMP_ROWS;
        //x2 = spriteStolbi.getXst();
        //y2 = spriteStolbi.getMst();





        gameBasic.post(new Runnable() {
            @Override
            public void run() {
                w = gameBasic.getWidth();
                h = gameBasic.getHeight();
                x = w/2 - w/4;
                y = h/2;

            }
        });
    }

    public static int getHeight(){
        return height;
    }
    public static int getSt() {
        return st;
   }

    private void update() {
        x2 = SpriteStolbi.getX();
        y2 = SpriteStolbi.getM();
        x3 = SpriteStolbi.getS();
        y3 = SpriteStolbi.getN();
        wst = SpriteStolbi.getPw();


       if (x2 == x + widht && y < y2 - height*4) {
              ySpeed = 5;
               gameBasic.l = 0;
               st = 1;
        }

        if (x2 < x + widht && y < y2 - height*4 && x2 + wst > x ) {
            ySpeed = 5;
            gameBasic.l = 0;
            st = 1;
        }


        if ( x2 == x + widht  && y + height > y2 && y2 != 0 ) {
            ySpeed = 5;
            gameBasic.l = 0;
            st = 1;
        }

        if ( x2 < x + widht  && y + height > y2 && x2 + wst > x && y2 != 0 ) {

            ySpeed = 0;
            gameBasic.l = 0;
            st = 1;
        }


        if (x3 == x + widht && y < y3 - height*4) {

            ySpeed = 5;
            gameBasic.l = 0;
            st = 1;
        }

        if (x3 < x + widht && y < y3 - height*4 && x3 + wst > x ) {

            ySpeed = 5;
            gameBasic.l = 0;
            st = 1;
        }


        if ( x3 == x + widht  && y + height > y3 && y3 != 0 ) {
            ySpeed = 5;
            gameBasic.l = 0;
            st = 1;
        }


        if ( x3 < x + widht  && y + height > y3 && x3 + wst > x && y3 != 0 ) {

            ySpeed = 0;
            gameBasic.l = 0;
            st = 1;
        }

        if (y > SpriteGrass.getY() - height && SpriteGrass.getY() != 0) {
          ySpeed = 0;
            st = 1;
        }


        y = y - gameBasic.l;
       y = y + ySpeed;
        gameBasic.l = 0;
        if (st != 1) {
            currentFrame = ++currentFrame % BMP_COLUMNS;
        }
    }


    public void onDraw(Canvas canvas) {
        update();
        int srcX = currentFrame * widht;
        int srcY = 1 * height;
        Rect src = new Rect(srcX, srcY, srcX + widht, srcY + height);
        Rect dst = new Rect(x, y, x + widht, y + height);
        canvas.drawBitmap(bird, src, dst, null);
    }


}
