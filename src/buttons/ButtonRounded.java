package src.buttons;
import javax.lang.model.util.ElementScanner14;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ButtonRounded extends JButton {

    protected static Color HOVER_COLOR  = new Color(145, 223, 62);
    protected static Color NORMAL_COLOR  = Color.white;

    public ButtonRounded(String text) {
        super(text);
        setOpaque(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFont(new Font("SERIF", Font.BOLD, 27));
        setBackground(ButtonRounded.NORMAL_COLOR);
        if(text.equals("S'identifier") || text.equals("Annuler") || text.equals("S'inscrire"))
        {
            setFont(new Font("SERIF", Font.BOLD, 16)); 
        }
        

        addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                if (!getBackground().equals(ButtonRounded.HOVER_COLOR)) {
                    setBackground(ButtonRounded.HOVER_COLOR);
                    repaint();
                }
                
            }
            public void mouseExited(MouseEvent e) {
                if (!getBackground().equals(ButtonRounded.NORMAL_COLOR)) {
                    setBackground(Color.white);
                    repaint();
                }
            }
        });
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(getBackground());

        int width = getWidth();
        int height = getHeight();
        int arc = 60; // corner radius

        g2.fillRoundRect(0, 0, width - 1, height - 1, arc, arc);

        g2.setColor(Color.black); // Change this to your desired text color
        FontMetrics fontMetrics = g2.getFontMetrics();
        int x = (width - fontMetrics.stringWidth(getText())) / 2;
        int y = (height - fontMetrics.getHeight()) / 2 + fontMetrics.getAscent();
        g2.drawString(getText(), x, y);

        g2.dispose();

    }
}

