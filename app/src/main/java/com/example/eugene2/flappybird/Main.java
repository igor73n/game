package com.example.eugene2.flappybird;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;

public class Main extends Activity {

    public static int s = 0;
    public static int sSpeed = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(new GameBasic(this));
    }
@Override
        public boolean onTouchEvent(MotionEvent event)
        {
          //  switch (event.getAction()) {
              //  case MotionEvent.ACTION_DOWN:
                    s = s + sSpeed;
                    return true; //если вернуть ложь, я думаю, move не выполнится.
              //  case MotionEvent.ACTION_MOVE:
                    //выполняю код
                  //  return true;
               // case MotionEvent.ACTION_UP:
                    //выполняю код и ничего не возвращаю, так как для меня это было последнее событие.
            //}
            //return super.onTouchEvent(event);
        }

}
