import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

class SpiderPanel extends JPanel {
    private int gridCellSize = 75;
    private int gridX = 20;
    private int gridY = 200;
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        // Draw 5x5 grid with gray outline

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                int x = gridX + col * gridCellSize;
                int y = gridY + row * gridCellSize;
                g.setColor(Color.BLACK);
                g.fillRect(x, y, gridCellSize, gridCellSize);
                g.setColor(Color.GRAY);
                g.drawRect(x, y, gridCellSize, gridCellSize);
            }
        }

        // Draw Spider
        // for now the spider is a dot, will change this later
        g.setColor(Color.BLACK);
        g.fillRect(panelWidth / 2 - 10, panelHeight / 2 - 10, 20, 20);

        // Draw "Spider World" text
        g.setColor(Color.BLACK);
        g.drawString("Spider World", 10, 20);
    }
    public int getGridX() {
        return gridX;
    }
    public int getGridCellSize() {
        return gridCellSize;
    }
    public int getGridY() {
        return gridY;
    }
}

public class SpiderWorldJPanel {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Spider World");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(5000, 5000);
        //create window for game
        SpiderPanel spiderPanel = new SpiderPanel();
        frame.add(spiderPanel);

        //draw blocks with text
        DrawBlocks blocks = new DrawBlocks();
        //****draw step, turn, and paint block****
        //****draw the 4 blocks with color up top****

        /*load level info
        String levelFile = "path to txt file with level";
        Map<String, Object> spiderWorldInfo = LoadInfo.readSpiderWorldInfo(levelFile);
        int[]spider_loc = LoadInfo.getSpiderLocation(spiderWorldInfo);
        int num_diamonds = LoadInfo.getNumDiamonds(spiderWorldInfo);
        int curr_level = LoadInfo.getCurrentLevel(spiderWorldInfo);
        List<int[]> diamond_locs = LoadInfo.getDiamondLocations(spiderWorldInfo);
         */

        /*draw spider
        int x = spiderPanel.getGridX() + spider_loc[0] * spiderPanel.getGridCellSize();
        int y = spiderPanel.getGridY() + spider_loc[1] * spiderPanel.getGridCellSize();
        g.setColor(Color.BLACK);
        g.fillRect(x, y, gridCellSize, gridCellSize);
        */

        /*draw red diamonds
        for (int i = 0; i < num_red_diamonds; i++) {
            int x = spiderPanel.getGridX() + red_diamond_locs[i][0] * spiderPanel.getGridCellSize();
            int y = spiderPanel.getGridY() + red_diamond_locs[i][1] * spiderPanel.getGridCellSize();
            g.setColor(Color.RED);
            g.fillRect(x, y, gridCellSize, gridCellSize);
        }*/
        /*draw blue diamonds
        for (int i = 0; i < num_red_diamonds; i++) {
            int x = spiderPanel.getGridX() + red_diamond_locs[i][0] * spiderPanel.getGridCellSize();
            int y = spiderPanel.getGridY() + red_diamond_locs[i][1] * spiderPanel.getGridCellSize();
            g.setColor(Color.BLUE);
            g.fillRect(x, y, gridCellSize, gridCellSize);
        }*/
        /*draw green diamonds
        for (int i = 0; i < num_red_diamonds; i++) {
            int x = spiderPanel.getGridX() + red_diamond_locs[i][0] * spiderPanel.getGridCellSize();
            int y = spiderPanel.getGridY() + red_diamond_locs[i][1] * spiderPanel.getGridCellSize();
            g.setColor(Color.GREEN);
            g.fillRect(x, y, gridCellSize, gridCellSize);
        }*/

        /*drag and drop
        DragDrop d = new DragDrop();
        frame.add(d);*/

        frame.setVisible(true);
    }
}
