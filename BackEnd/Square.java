package BackEnd;

import java.awt.Graphics;
import java.awt.Color;

public class Square extends GeomObject {
    private int side;

    public Square(int x, int y, int side, Color color) {
        super(x, y, color);
        this.side = side;
    }

    public Square(int x, int y, String strColor, String s) {
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
        return "persegi";
    }

    @Override
    public Graphics draw(Graphics g, GeomObject geom) {
        g.setColor(getColor());
        g.drawRect(geom.getX() - ((Square) geom).getSide(),
                geom.getY() - ((Square) geom).getSide(),
                ((Square) geom).getSide(),
                ((Square) geom).getSide());
        g.fillRect(geom.getX() - ((Square) geom).getSide(),
                geom.getY() - ((Square) geom).getSide(),
                ((Square) geom).getSide(),
                ((Square) geom).getSide());
        return g;
    }
}
