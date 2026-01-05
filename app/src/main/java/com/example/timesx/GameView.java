package com.example.timesx;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;

class GameView extends View {

    private Paint paintFalling, paintPaddle;
    private ArrayList<FallingNumber> objects;
    private Random random;

    private float paddleX;             // paddle horizontal position
    private final float paddleWidth = 300;
    private final float paddleHeight = 100;

    public int score = 1;
    public int damage = 0;

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);

        paintFalling = new Paint();
        paintFalling.setColor(getResources().getColor(R.color.orange));
        paintFalling.setTextSize(60);

        paintPaddle = new Paint();
        paintPaddle.setColor(getResources().getColor(R.color.navy));

        objects = new ArrayList<>();
        random = new Random();

        // start the game loop
        post(gameLoop);
    }

    // Game loop: update & redraw
    private final Runnable gameLoop = new Runnable() {
        @Override
        public void run() {
            invalidate();           // redraw
            postDelayed(this, 30);  // 30 ms ~ 33 FPS
        }
    };

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float screenW = getWidth();
        float screenH = getHeight();

        // Draw paddle at bottom
        float paddleY = screenH - 200;
        canvas.drawRect(paddleX, paddleY, paddleX + paddleWidth, paddleY + paddleHeight, paintPaddle);

        // Spawn new falling numbers (max 4 at a time)
        if (objects.size() < 6 && random.nextInt(10) < 2) {
            objects.add(new FallingNumber(random.nextInt((int) screenW - 100)));
        }

        // Draw & update falling numbers
        for (int i = 0; i < objects.size(); i++) {
            FallingNumber obj = objects.get(i);
            obj.y += obj.speed;

            canvas.drawText(String.valueOf(obj.value), obj.x, obj.y, paintFalling);

            // Collision with paddle
            if (obj.y > paddleY && obj.x > paddleX && obj.x < paddleX + paddleWidth) {
                if (obj.value % 2 == 0) {
                    score *= 2;
                } else {
                    damage++;
                }
                objects.remove(i);
                i--; // adjust index after removal
            }

            // Remove if off screen
            else if (obj.y > screenH) {
                objects.remove(i);
                i--;
            }
        }

        // Draw Game Over text if needed
        if (damage >= 10) {
            Paint gameOverPaint = new Paint();
            gameOverPaint.setColor(Color.BLACK);
            gameOverPaint.setTextSize(100);
            canvas.drawText("GAME OVER", screenW / 2 - 250, screenH / 2, gameOverPaint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        paddleX = event.getX() - paddleWidth / 2;

        // Prevent paddle from leaving screen
        if (paddleX < 0) paddleX = 0;
        if (paddleX + paddleWidth > getWidth()) paddleX = getWidth() - paddleWidth;

        return true;
    }

    // Inner class for falling numbers
    class FallingNumber {
        float x;
        float y = 0;
        float speed = 13;
        int value;

        FallingNumber(float x) {
            this.x = x;
            this.value = random.nextInt(100); // 0-99
        }
    }
}
