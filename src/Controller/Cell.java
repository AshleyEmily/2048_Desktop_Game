package Controller;
import Model.Model;
import Model.Settings;


import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class Cell extends Settings {
    private static final int CELL_WIDTH = 120;
    private static final int FRAME_THICKNESS = 16;
    private static final int GRID_WIDTH = 4;

    private Cell[][] grid;

    private int value;

    private Point cellLocation;

    public Cell() {
//        setValue(value);
    }

    public static int getCellWidth() {
        return CELL_WIDTH;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isZeroValue() {
        return (value == 0);
    }

    public void setCellLocation(int x, int y) {
        setCellLocation(new Point(x, y));
    }

    public void setCellLocation(Point cellLocation) {
        this.cellLocation = cellLocation;
    }

    //formats each cell; font, centering, etc
    public void drawCell(Graphics g) {
        if (value == 0) {
            g.setColor(Color.GRAY);
            g.fillRect(cellLocation.x, cellLocation.y,
                    CELL_WIDTH, CELL_WIDTH);
        } else {
            Font font = g.getFont();
            FontRenderContext frc =
                    new FontRenderContext(null, true, true);

            String s = Integer.toString(value);
            BufferedImage image =
                    createImage(font, frc, CELL_WIDTH, s);

            g.drawImage(image, cellLocation.x, cellLocation.y, null);
        }
    }

    public Dimension getPreferredSize() {
        int width = GRID_WIDTH * Cell.getCellWidth() +
                FRAME_THICKNESS * 5;
        return new Dimension(width, width);
    }

    private BufferedImage createImage(Font font, FontRenderContext frc, int width, String s) {

        Font largeFont = font.deriveFont((float) (width / 4));
        Rectangle2D r = largeFont.getStringBounds(s, frc);
        int rWidth = (int) Math.round(r.getWidth());
        int rHeight = (int) Math.round(r.getHeight());
        int rX = (int) Math.round(r.getX());
        int rY = (int) Math.round(r.getY());

        BufferedImage image = new BufferedImage(width, width,
                BufferedImage.TYPE_INT_RGB);

        Graphics gg = image.getGraphics();
        gg.setColor(getTileColor());
        gg.fillRect(0, 0, image.getWidth(), image.getHeight());

        int x = (width / 2) - (rWidth / 2) - rX;
        int y = (width / 2) - (rHeight / 2) - rY;

        gg.setFont(largeFont);
        gg.setColor(getTextColor());
        gg.drawString(s, x, y);
        gg.dispose();
        return image;
    }

    // doesn't directly change colors, just holds value of the color intended for each tile
    private Color getTileColor() {
        Color color = Color.WHITE;

        switch (value) {
            case 2:     color = new Color(238, 228, 218);
                break;
            case 4:     color = new Color(237, 224, 200);
                break;
            case 8:     color = new Color(242, 177, 121);
                break;
            case 16:    color = new Color(245, 149, 99);
                break;
            case 32:    color = new Color(246, 124, 95);
                break;
            case 64:    color = new Color(246, 94, 59);
                break;
            case 128:   color = new Color(237, 207, 114);
                break;
            case 256:   color = new Color(237, 204, 97);
                break;
            case 512:   color = new Color(237, 200, 80);
                break;
            case 1024:  color = new Color(237, 197, 63);
                break;
            case 2048:  color = new Color(237, 194, 46);
                break;
            default:    color = new Color(43, 43, 0);
                break;
        }

        return color;
    }

    private Color getTextColor() {
        return (value >= 256) ? Color.WHITE : Color.BLACK;
    }
}
