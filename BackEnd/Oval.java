package BackEnd;

import java.awt.Graphics;
import java.awt.Color;

public class Oval extends GeomObject {
    private int width;
    private int height;

    public Oval(int x, int y, int width, int height, Color color) {
        super(x, y, color);
        this.width = width;
        this.height = height;
    }

    public Oval(int x, int y, String strColor, String s) {
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
        return "oval";
    }

    @Override
    public Graphics draw(Graphics g, GeomObject geom) {
        g.setColor(getColor());
        g.drawOval(geom.getX() - ((Oval) geom).getWidth() / 2,
                geom.getY() - ((Oval) geom).getHeight() / 2,
                ((Oval) geom).getWidth(),
                ((Oval) geom).getHeight());
        g.fillOval(geom.getX() - ((Oval) geom).getWidth() / 2,
                geom.getY() - ((Oval) geom).getHeight() / 2,
                ((Oval) geom).getWidth(),
                ((Oval) geom).getHeight());

        return g;
    }

}
