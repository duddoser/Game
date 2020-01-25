package ru.pavlenty.surfacegame2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.view.SurfaceHolder;

import java.util.Random;

public class Foe {
    private Bitmap bitmap;
    private int x;
    private int y;
    private int centerX;
    private int centerY;
    private int speed = 10;

    private int maxX;
    private int maxY;
    private int minX;
    private int minY;
    private Random generator = new Random();

    Foe(int screenX, int screenY, Context context){
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy);
        maxX = screenX;
        maxY = screenY - bitmap.getHeight();
        minX = 0;
        minY = 0;

        x = maxX;
        y = generator.nextInt(maxY);
    }

    public void update(int playerSpeed) {
        x -= playerSpeed;
        x -= speed;

        if (x < 0) {
            x = maxX;
            y = generator.nextInt(maxY);
        }
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
