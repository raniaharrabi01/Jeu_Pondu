package src.frames;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

class RoundedBorder implements Border {
    private int radius;

    public RoundedBorder(int radius) {
        this.radius = radius;
    }

    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
    }

    public boolean isBorderOpaque() {
        return true;
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.setColor(c.getBackground());
        g.fillRoundRect(x, y, width, height, this.radius, this.radius);
        g.setColor(Color.GRAY);
        g.drawRoundRect(x, y, width-1, height-1, this.radius, this.radius);
    }
}