package com.example.eugene2.flappybird;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;



import com.example.eugene2.flappybird.R;

public class GameBasic extends SurfaceView  {
    private Bitmap bgg;
    private Bitmap pipe;
    private Bitmap bird;
    private Bitmap grass;
    private Bitmap x5;
    private SurfaceHolder holder2;
    private SpriteStolbi sprite;
    private  GameManager gameManag;
    private SpriteBird spriteBird;
    private SpriteGrass spriteGrass;
    private SpriteOver spriteOver;
    public int l;


    public GameBasic(Context context) {
        super(context);
        holder2 = getHolder();
        gameManag = new GameManager(this);

        holder2.addCallback(new SurfaceHolder.Callback() {

            public void surfaceDestroyed(SurfaceHolder holder2) {
                boolean retry = true;
                gameManag.setRunning(false);
                while (retry)
                {
                    try
                    {
                        gameManag.join();
                        retry = false;
                    } catch (InterruptedException e)
                    {
                    }
                }
            }

            @Override
            public void surfaceCreated(SurfaceHolder holder2) {
              gameManag.setRunning(true);
              gameManag.start();
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder2, int format, int width, int height) {
            }
        });
        bgg = BitmapFactory.decodeResource(getResources(), R.drawable.bgg);
        pipe = BitmapFactory.decodeResource(getResources(), R.drawable.pipe);
        bird = BitmapFactory.decodeResource(getResources(), R.drawable.bird);
        grass = BitmapFactory.decodeResource(getResources(), R.drawable.grass);
        x5 = BitmapFactory.decodeResource(getResources(), R.drawable.x5);
        sprite = new SpriteStolbi(this,pipe);
        spriteBird = new SpriteBird(this, bird);
        spriteGrass = new SpriteGrass(this, grass);
        spriteOver = new SpriteOver(this, x5);
    }

    @Override
    public  boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            l = 20;
        }
           return true;
    }

    protected void onDraw(Canvas canvas)
    {
        canvas.drawBitmap(bgg, 10, 10, null);
        sprite.onDraw(canvas);
        spriteBird.onDraw(canvas);
        spriteGrass.onDraw(canvas);
        spriteOver.onDraw(canvas);
    }


}