package ru.pavlenty.surfacegame2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import java.util.Random;

public class Enemy {
    Random r = new Random();
    private Bitmap bitmap;
    private int x;
    private int y;
    private int maxY;
    private int minY;
    private int speed = 20;
    private boolean boosting;
    private Rect detectCollision;
    private final int MAX_SPEED = 100;
    private final int MIN_SPEED = 20;

    public Enemy(Context context) {
        x = 2400;
        y = r.nextInt(1300);
        speed = 1;
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy);
        boosting = false;
        detectCollision =  new Rect(x, y, bitmap.getWidth(), bitmap.getHeight());
    }

    public void setBoosting() {
        boosting = true;
    }

    public void stopBoosting() {
        boosting = false;
    }

    public void update() {
        if (boosting) {
            speed += 2;
        } else {
            speed =10;
        }
        x -= speed;

        if (speed > MAX_SPEED) {
            speed = MAX_SPEED;
        }

        if (speed < MIN_SPEED) {
            speed = MIN_SPEED;
        }

        detectCollision.left = x;
        detectCollision.top = y;
        detectCollision.right = x + bitmap.getWidth();
        detectCollision.bottom = y + bitmap.getHeight();
    }
    public Rect getDetectCollision() {
        return detectCollision;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public int getX() {
        return x;
    }

    public void setX(int t) {x = t;}

    public void setY(int t) {y = t;}

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
    }
}

