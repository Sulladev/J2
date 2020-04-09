package ru.gb.jtwo.lesson_2.engines.bricks;

import ru.gb.jtwo.lesson_2.engines.common.GameCanvas;
import ru.gb.jtwo.lesson_2.engines.common.Sprite;

import java.awt.*;

public class Bricks extends Sprite {
    private final Color color = new Color (
            (int)(Math.random() * 255),
            (int)(Math.random() * 255),
            (int)(Math.random() * 255)
    );
    private float vX = (float)(100f + (Math.random() * 200f));
    private float vY = (float)(100f + (Math.random() * 200f));

    Bricks() {
        halfHeight = 20 + (float)(Math.random() * 50f);
        halfWidth = halfHeight;
    }

    //для того чтобы добавлять мячик по координатам клика дописываем конструктор Ball

    Bricks (int x, int y){
    //задаем рандомные размеры из первого конструктора
        this();
        this.x = x;
        this.y = y;
    }

    @Override
    public void update(GameCanvas canvas, float deltaTime) {
        x += vX * deltaTime;
        y += vY * deltaTime;
        if (getLeft() < canvas.getLeft()) {
            setLeft(canvas.getLeft());
            vX = -vX;
        }
        if (getRight() > canvas.getRight()) {
            setRight(canvas.getRight());
            vX = -vX;
        }
        if (getTop() < canvas.getTop()) {
            setTop(canvas.getTop());
            vY = -vY;
        }
        if (getBottom() > canvas.getBottom()) {
            setBottom(canvas.getBottom());
            vY = -vY;
        }

    }

    @Override
    public void render(GameCanvas canvas, Graphics g) {
        g.setColor(color);
        g.drawRect((int) getLeft(), (int) getTop(),
                (int) getWidth(), (int) getHeight());
    }


}
