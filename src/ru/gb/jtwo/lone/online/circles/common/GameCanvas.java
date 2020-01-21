package ru.gb.jtwo.lone.online.circles.common;

import ru.gb.jtwo.lone.online.circles.balls.MainCircles;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {

    CanvasListener gameController;
    long lastFrameTime;

    public GameCanvas(CanvasListener gameController) {
        this.gameController = gameController;
        lastFrameTime = System.nanoTime();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //60fps
        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f;
        gameController.onDrawFrame(this, g, deltaTime);
        lastFrameTime = currentTime;
        try {
            Thread.sleep(16);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }

    public int getLeft() { return 0; }
    public int getRight() { return getWidth() - 1; }
    public int getTop() { return 0; }
    public int getBottom() { return getHeight() - 1; }
}
