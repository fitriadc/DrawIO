package BackEnd;

import java.awt.Graphics;
import java.awt.Color;

public abstract class GeomObject {
    private int x;
    private int y;
    private Color color;
    private String colorName;

    public GeomObject(int x, int y, String strColor, String s) {
        this.x = x;
        this.y = y;
        this.colorName = strColor;
        color = transformColour(strColor);
    };

    public GeomObject(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public abstract String getName();

    public abstract int[] getElements();

    public abstract String[] getElementsName();

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setColor(Color colorSelected) {
        this.color = colorSelected;
    }

    public Color getColor() {
        return this.color;
    }

    public String getColorName() {
        return this.colorName;
    }

    public abstract Graphics draw(Graphics g, GeomObject geom);

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    // method to set color name
    public static Color transformColour(String strColor) {
        if (strColor.equals("Red")) {
            return Color.RED;
        } else if (strColor.equals("Yellow")) {
            return Color.YELLOW;
        } else if (strColor.equals("Green")) {
            return Color.GREEN;
        } else if (strColor.equals("Gray")) {
            return Color.GRAY;
        } else if (strColor.equals("Blue")) {
            return Color.BLUE;
        } else if (strColor.equals("Black")) {
            return Color.BLACK;
        } else if (strColor.equals("Orange")) {
            return Color.ORANGE;
        } else if (strColor.equals("Pink")) {
            return Color.PINK;
        } else if (strColor.equals("Cyan")) {
            return Color.CYAN;
        } else {
            return Color.WHITE;
        }
    }
}
