package com.example.eugene2.flappybird;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;



import com.example.eugene2.flappybird.R;

public class GameBasic extends SurfaceView  {
    private Bitmap bgg;
    private Bitmap pipe;
    private SurfaceHolder holder2;
    private SpriteStolbi sprite;
    private  GameManager gameManag;

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
        sprite = new SpriteStolbi(this,pipe);
    }

    protected void onDraw(Canvas canvas)
    {
        canvas.drawBitmap(bgg, 10, 10, null);
        sprite.onDraw(canvas);
    }


}