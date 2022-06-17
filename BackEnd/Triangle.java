package BackEnd;

import java.awt.Color;
import java.awt.Graphics;

public class Triangle extends GeomObject {
    private int side;

    public Triangle(int x, int y, int side, Color color) {
        super(x, y, color);
        this.side = side;
    }

    public Triangle(int x, int y, String strColor, String s) {
        super(x, y, strColor, s);
        this.side = Integer.parseInt(s);
    }

    public int getSide() {
        return this.side;
    }

    @Override
    public int[] getElements() {
        return new int[] { super.getX(), super.getY(), side };
    }

    @Override
    public String[] getElementsName() {
        String[] arr = { "x_center", "y_center", "sisi", "color" };
        return arr;
    }

    @Override
    public String getName() {
        return "segitiga";
    }

    @Override
    public Graphics draw(Graphics g, GeomObject geom) {
        g.setColor(getColor());

        int X1 = geom.getX();
        int X2 = geom.getX() - (int) Math.floor((side / 2));
        int X3 = geom.getX() + (int) Math.floor((side / 2));
        int Y1 = geom.getY();
        int Y2 = geom.getY() + (int) Math.floor((side / 2));
        int Y3 = geom.getY() + (int) Math.floor((side / 2));

        int[] xPoints = { X3, X2, X1 };
        int[] yPoints = { Y3, Y2, Y1 };
        g.drawPolygon(xPoints, yPoints, 3);
        g.fillPolygon(xPoints, yPoints, 3);
        return g;
    }
}
