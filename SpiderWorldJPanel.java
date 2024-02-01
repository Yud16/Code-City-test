import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

class SpiderPanel extends JPanel {
    private Map<String, Object> spiderWorldInfo;
    private int gridCellSize = 75;
    private int gridX = 20;
    private int gridY = 200;
    private int[]spider_loc = LoadInfo.getSpiderLocation(spiderWorldInfo);
    private int num_red_diamonds = LoadInfo.getNumDiamonds(spiderWorldInfo);
    private int num_blue_diamonds = LoadInfo.getNumDiamonds(spiderWorldInfo);
    private int num_green_diamonds = LoadInfo.getNumDiamonds(spiderWorldInfo);

    private int curr_level = LoadInfo.getCurrentLevel(spiderWorldInfo);
    private List<int[]> red_diamond_locs = LoadInfo.getDiamondLocations(spiderWorldInfo);
    private List<int[]> blue_diamond_locs = LoadInfo.getDiamondLocations(spiderWorldInfo);
    private List<int[]> green_diamond_locs = LoadInfo.getDiamondLocations(spiderWorldInfo);


    public SpiderPanel(Map<String, Object> spiderWorldInfo) {
        this.spiderWorldInfo = spiderWorldInfo;
    }
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
        //draw blocks with text
        DrawBlocks blocks = new DrawBlocks();
        //****draw step, turn, and paint block****
        //****draw the 4 blocks with color up top****

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
            int x = spiderPanel.getGridX() + blue_diamond_locs[i][0] * spiderPanel.getGridCellSize();
            int y = spiderPanel.getGridY() + blue_diamond_locs[i][1] * spiderPanel.getGridCellSize();
            g.setColor(Color.BLUE);
            g.fillRect(x, y, gridCellSize, gridCellSize);
        }*/
        /*draw green diamonds
        for (int i = 0; i < num_red_diamonds; i++) {
            int x = spiderPanel.getGridX() + blue_diamond_locs[i][0] * spiderPanel.getGridCellSize();
            int y = spiderPanel.getGridY() + blue_diamond_locs[i][1] * spiderPanel.getGridCellSize();
            g.setColor(Color.GREEN);
            g.fillRect(x, y, gridCellSize, gridCellSize);
        }*/

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
        //make window
        JFrame frame = new JFrame("Spider World");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(5000, 5000);
        frame.setLayout(new BorderLayout());
        /*load level info
        String levelFile = "path to txt file with level";
        Map<String, Object> spiderWorldInfo = LoadInfo.readSpiderWorldInfo(levelFile);
         */
        //create window for game
        SpiderPanel spiderPanel = new SpiderPanel(spiderWorldInfo);
        frame.add(spiderPanel);

        //drag and drop
        DragDrop d = new DragDrop();
        frame.add(d, BorderLayout.PAGE_END);

        frame.setVisible(true);
    }
}
