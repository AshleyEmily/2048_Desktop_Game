//package Model;
//
//import java.awt.Color;
//import java.awt.Font;
//import java.awt.Graphics;
//import java.awt.Point;
//import java.awt.font.FontRenderContext;
//import java.awt.geom.Rectangle2D;
//import java.awt.image.BufferedImage;
//
//public class Number extends Settings{
//	private int numValue;
//	private int xCoord;
//	private int yCoord;
//	private static final int CELL_WIDTH = 120;
//    private Point cellLocation;
//
//	
//	public Number(int x, int y){
//		numValue = 2;
//		xCoord = x;
//		yCoord = y; 
//		setCellLocation(x, y);
//	}
//	
//	public void moveToNewPlace(int x, int y) { //set new Coordinates
//		xCoord = x;
//		yCoord = y;
//		setCellLocation(x, y);
//	}
//	public int getXcoord() {
//		return xCoord;
//	}
//	public int getYcoord() {
//		return yCoord;
//	}
//	
//	public static int getCellWidth() {
//        return CELL_WIDTH;
//    }
//	
//	public void setCellLocation(int x, int y) {
//        setCellLocationPoint(new Point(x, y));
//    }
//	
//	public void setCellLocationPoint(Point cellLocation) {
//        this.cellLocation = cellLocation;
//    }
//	
//	public int getNumValue() {
//		return numValue;
//	}
//	public void updateNumber() { //set new NumValue
//		numValue += numValue;
//	}
//	public boolean equals(Number that) {
//		return (that.numValue == this.numValue);
//	}
//
//	
//	public void draw(Graphics g) {
////        if () {
////            g.setColor(Color.GRAY);
////            g.fillRect(cellLocation.x, cellLocation.y,
////                    CELL_WIDTH, CELL_WIDTH);
////        } else {
//            Font font = g.getFont();
//            FontRenderContext frc =
//                    new FontRenderContext(null, true, true);
//
//            String s = Integer.toString(numValue);
//            BufferedImage image =
//                    createImage(font, frc, CELL_WIDTH, s);
//
//            g.drawImage(image, cellLocation.x, cellLocation.y, null);
//        //}
//    }
//
//    private BufferedImage createImage(Font font, FontRenderContext frc,
//                                      int width, String s) {
//
//        Font largeFont = font.deriveFont((float) (width / 4));
//        Rectangle2D r = largeFont.getStringBounds(s, frc);
//        int rWidth = (int) Math.round(r.getWidth());
//        int rHeight = (int) Math.round(r.getHeight());
//        int rX = (int) Math.round(r.getX());
//        int rY = (int) Math.round(r.getY());
//
//        BufferedImage image = new BufferedImage(width, width,
//                BufferedImage.TYPE_INT_RGB);
//
//        Graphics gg = image.getGraphics();
//        gg.setColor(getTileColor());
//        gg.fillRect(0, 0, image.getWidth(), image.getHeight());
//
//        int x = (width / 2) - (rWidth / 2) - rX;
//        int y = (width / 2) - (rHeight / 2) - rY;
//
//        gg.setFont(largeFont);
//        gg.setColor(getTextColor());
//        gg.drawString(s, x, y);
//        gg.dispose();
//        return image;
//    }
//
//    private Color getTileColor() {
//        return Color.decode(getTheme()[(int)(Math.log(numValue/ Math.log(2)))-1]);
//        
////        switch (numValue) {
////            case 2:     color = Color.decode(getTheme()[0]);
////                break;
////            case 4:     color = Color.decode(getTheme()[1]);
////                break;
////            case 8:     color = theme1[1];
////                break;
////            case 16:    color = new Color(111, 236, 91);
////                break;
////            case 32:    color = new Color(255, 255, 85);
////                break;
////            case 64:    color = new Color(255, 255, 43);
////                break;
////            case 128:   color = new Color(255, 255, 0);
////                break;
////            case 256:   color = new Color(213, 213, 0);
////                break;
////            case 512:   color = new Color(170, 170, 0);
////                break;
////            case 1024:  color = new Color(128, 128, 0);
////                break;
////            case 2048:  color = new Color(85, 85, 0);
////                break;
////            default:    color = new Color(43, 43, 0);
////                break;
////        }
//
//       // return color;
//    }
//
//    private Color getTextColor() {
//        return (numValue >= 256) ? Color.WHITE : Color.BLACK;
//    }
//	
//
//}
