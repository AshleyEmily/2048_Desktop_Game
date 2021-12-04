package Controller;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

/**
 * 
 * @author Samantha Guanzon
 *
 */
public class Cell{
    private static final int CELL_WIDTH = 120;
    private static final int FRAME_THICKNESS = 16;
    private static final int GRID_WIDTH = 4;

    private int value;

    private Point cellLocation;
    
    public Color cellColor;

    public Cell() {
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

    public void setCellColor(Color c) {
    	cellColor = c;
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
          gg.setColor(cellColor);

        gg.fillRect(0, 0, image.getWidth(), image.getHeight());

        int x = (width / 2) - (rWidth / 2) - rX;
        int y = (width / 2) - (rHeight / 2) - rY;

        gg.setFont(largeFont);
        gg.setColor(getTextColor());
        gg.drawString(s, x, y);
        gg.dispose();
        return image;
    }

    private Color getTextColor() {
        return (value >= 256) ? Color.WHITE : Color.BLACK;
    }
}