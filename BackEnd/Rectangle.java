package BackEnd;

import java.awt.Graphics;
import java.awt.Color;

public class Rectangle extends GeomObject {
    private int width;
    private int height;

    public Rectangle(int x, int y, int width, int height, Color color) {
        super(x, y, color);
        this.width = width;
        this.height = height;
    }

    public Rectangle(int x, int y, String strColor, String s) {
        super(x, y, strColor, s);
        this.width = Integer.parseInt(s.split(",")[0]);
        this.height = Integer.parseInt(s.split(",")[1]);
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    @Override
    public int[] getElements() {
        return new int[] { super.getX(), super.getY(), width, height };
    }

    @Override
    public String[] getElementsName() {
        String[] arr = { "x_center", "y_center", "width", "height", "color" };
        return arr;
    }

    @Override
    public String getName() {
        return "persegi_panjang";
    }

    @Override
    public Graphics draw(Graphics g, GeomObject geom) {
        g.setColor(getColor());
        g.drawRect(geom.getX() - ((Rectangle) geom).getWidth() / 2,
                geom.getY() - ((Rectangle) geom).getHeight() / 2,
                ((Rectangle) geom).getWidth(),
                ((Rectangle) geom).getHeight());
        g.fillRect(geom.getX() - ((Rectangle) geom).getWidth() / 2,
                geom.getY() - ((Rectangle) geom).getHeight() / 2,
                ((Rectangle) geom).getWidth(),
                ((Rectangle) geom).getHeight());
        return g;
    }
}
