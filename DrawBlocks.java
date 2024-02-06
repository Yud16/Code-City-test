import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class DrawBlocks extends JComponent {
    /*

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        drawCenteredText(g2d, 50, 50, 100, 50, "step", Color.GRAY);
        drawCenteredText(g2d, 50, 110, 100, 50, "turn", Color.GRAY);
        drawCenteredText(g2d, 50, 170, 100, 50, "paint", Color.RED);
    }*/

    public static void drawCenteredText(Graphics2D g2d, double x, double y, double width, double height, String text, Color color) {
        // Draw rectangle
        Rectangle2D.Double r = new Rectangle2D.Double(x, y, width, height);
        g2d.setColor(color);
        g2d.fill(r);

        // Calculate the position to center the text horizontally and vertically on top of the rectangle
        FontMetrics fm = g2d.getFontMetrics();
        int textWidth = fm.stringWidth(text);
        int textHeight = fm.getHeight();
        int textX = (int) (x + (width - textWidth) / 2);
        int textY = (int) (y + (height - textHeight) / 2 + fm.getAscent());

        // Set the color of the text to black
        g2d.setColor(Color.BLACK);

        // Draw the text centered both horizontally and vertically on top of the rectangle
        g2d.drawString(text, textX, textY);
    }
}