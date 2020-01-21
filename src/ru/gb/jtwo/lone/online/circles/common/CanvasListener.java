package ru.gb.jtwo.lone.online.circles.common;

import java.awt.*;

public interface CanvasListener {
    void onDrawFrame(GameCanvas canvas, Graphics g, float deltaTime);
}
