import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class DragDrop extends JPanel {
    private Shape currentShape = null;
    private int offsetX, offsetY;

    public DragDrop() {
        // Add mouse listener
        addMouseListener(new MyMouseListener());
        addMouseMotionListener(new MyMouseMotionListener());
    }

    public void setShape(Shape shape) {
        this.currentShape = shape;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (currentShape != null) {
            currentShape.draw(g);
        }
    }

    private class MyMouseListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            if (currentShape != null && currentShape.contains(e.getPoint())) {
                offsetX = e.getX() - currentShape.getX();
                offsetY = e.getY() - currentShape.getY();
            }
        }
    }

    private class MyMouseMotionListener extends MouseAdapter {
        @Override
        public void mouseDragged(MouseEvent e) {
            if (currentShape != null) {
                currentShape.setLocation(e.getX() - offsetX, e.getY() - offsetY);
                repaint();
            }
        }
    }
}
