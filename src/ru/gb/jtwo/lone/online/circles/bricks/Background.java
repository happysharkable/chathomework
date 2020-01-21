package ru.gb.jtwo.lone.online.circles.bricks;

import ru.gb.jtwo.lone.online.circles.common.GameCanvas;
import ru.gb.jtwo.lone.online.circles.common.GameObject;

import java.awt.*;

public class Background implements GameObject {
    private Color color = new Color(123,214,76);

    @Override
    public void update(GameCanvas gameCanvas, float deltaTime) {
    }

    @Override
    public void render(GameCanvas gameCanvas, Graphics g) {
        gameCanvas.setBackground(color);
    }
}
