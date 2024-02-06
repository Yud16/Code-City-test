import java.awt.*;
class Blocks implements Shape {
    private int x, y, width, height;
    private String text;
    private Color color;

    public Blocks(int x, int y, int width, int height, String text, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g) {
        DrawBlocks.drawCenteredText(g, x, y, width, height, text, color);
    }

    @Override
    public boolean contains(Point point) {
        return x <= point.x && point.x <= x + width && y <= point.y && point.y <= y + height;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public String getText(String text) {
        return text;
    }

   // @Override
    public Color getColor(Color color) {
        return color;
    }
}

