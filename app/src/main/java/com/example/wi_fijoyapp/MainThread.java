package com.example.wi_fijoyapp;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class MainThread extends Thread
{
    private SurfaceHolder mSH;
    private App app;
    private boolean running;
    public static Canvas canvas;


    public void setRunning(boolean running)
    {
        this.running=running;
    }

    public MainThread(SurfaceHolder mSH, App app)
    {
        super();
        this.mSH=mSH;
        this.app=app;
    }

    @Override
    public void run()
    {
        while(running)
        {
            canvas = null;

            try
            {
                canvas = this.mSH.lockCanvas();
                synchronized(mSH)
                {
                    this.app.draw(canvas);
                    this.app.calculate();

                }
            }
            catch (Exception e) {e.printStackTrace();}
            finally {
                if(canvas!=null)
                {
                    try {
                        mSH.unlockCanvasAndPost(canvas);
                    }
                    catch(Exception e) {e.printStackTrace();}
                }

            }



        }

    }

}


