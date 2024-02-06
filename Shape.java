import java.awt.*;

public interface Shape {
    void draw(Graphics2D g);

    boolean contains(Point point);

    int getX();

    int getY();

    void setLocation(int x, int y);

}

