package com.example.eugene2.flappybird;

import android.graphics.Canvas;

public class GameManager extends Thread {
    private GameBasic view;

    /**Переменная задавания состояния потока рисования*/
    private boolean running = false;

    /**Конструктор класса*/
    public GameManager(GameBasic view)
    {
        this.view = view;
    }

    /**Задание состояния потока*/
    public void setRunning(boolean run)
    {
        running = run;
    }

    /** Действия, выполняемые в потоке */
    public void run() {
        while (running) {
            Canvas c = null;
            try {
                c = view.getHolder().lockCanvas();
                synchronized (view.getHolder()) {
                    view.onDraw(c);
                }
            } finally {
                if (c != null) {
                    view.getHolder().unlockCanvasAndPost(c);
                }
            }
        }
    }
}
