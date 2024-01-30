import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//
class DragDrop extends JFrame {
    private int rectX = 50;
    private int rectY = 50;
    private int rectWidth = 100;
    private int rectHeight = 50;
    private boolean isDragging = false;
    private int offsetX, offsetY;

    public DragDrop() {
        setTitle("Draggable Rectangle");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (isWithinRectangle(e.getX(), e.getY())) {
                    isDragging = true;
                    offsetX = e.getX() - rectX;
                    offsetY = e.getY() - rectY;
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                isDragging = false;
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (isDragging) {
                    rectX = e.getX() - offsetX;
                    rectY = e.getY() - offsetY;
                    repaint();
                }
            }
        });
    }

    private boolean isWithinRectangle(int x, int y) {
        return x >= rectX && x <= rectX + rectWidth && y >= rectY && y <= rectY + rectHeight;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawRect(rectX, rectY, rectWidth, rectHeight);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DragDrop frame = new DragDrop();
            frame.setVisible(true);
        });
    }
}

