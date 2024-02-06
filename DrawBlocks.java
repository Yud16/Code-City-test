import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class DrawBlocks extends JComponent {

    protected void drawCenteredText(Graphics2D g2d, double x, double y, double width, double height, String text, Color color) {
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

        //move blocks
        DragDrop d = new DragDrop();
        d.setShape(new Blocks((int)x, (int)y, (int)width, (int)height));
    }
}