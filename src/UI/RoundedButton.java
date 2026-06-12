package UI;

import java.awt.*;
import javax.swing.*;

public class RoundedButton extends JButton {

    private final int radius;

    public RoundedButton(String text, int radius) {
        super(text);
        this.radius = radius;

        setContentAreaFilled(false);
        setFocusPainted(false);
        setRolloverEnabled(true);
        setBorderPainted(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        );

        Color color = getBackground();

        if (getModel().isPressed()) {
            color = color.darker();
        } else if (getModel().isRollover()) {
            color = color.brighter();
        }

        g2.setColor(color);

        g2.fillRoundRect(
            0, 0,
            getWidth(),
            getHeight(),
            radius,
            radius
        );

        g2.dispose();

        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        );

        g2.setColor(getBackground());

        g2.drawRoundRect(
            0, 0,
            getWidth() - 1,
            getHeight() - 1,
            radius, radius
        );

        g2.dispose();
    }
}
