package BackEnd;

import java.awt.Graphics;
import java.awt.Color;

public class Circle extends GeomObject {
	private int radius;

	public Circle(double radius) {
		super(10, 10, Color.RED);
		this.radius = (int) radius;
	}

	public Circle(int x, int y, int radius, Color color) {
		super(x, y, color);
		this.radius = radius;
	}

	public Circle(int x, int y, String strColor, String s) {
		super(x, y, strColor, s);
		this.radius = Integer.parseInt(s);
	}

	public int getRadius() {
		return this.radius;
	}

	@Override
	public int[] getElements() {
		return new int[] { super.getX(), super.getY(), radius };
	}

	@Override
	public String[] getElementsName() {
		String[] arr = { "x_center", "y_center", "radius", "color" };
		return arr;
	}

	@Override
	public String getName() {
		return "lingkaran";
	}

	@Override
	public Graphics draw(Graphics g, GeomObject geom) {
		g.setColor(getColor());
		g.drawOval(geom.getX() - ((Circle) geom).getRadius(),
				geom.getY() - ((Circle) geom).getRadius(),
				2 * ((Circle) geom).getRadius(),
				2 * ((Circle) geom).getRadius());
		g.fillOval(geom.getX() - ((Circle) geom).getRadius(),
				geom.getY() - ((Circle) geom).getRadius(),
				2 * ((Circle) geom).getRadius(),
				2 * ((Circle) geom).getRadius());
		return g;
	}

	public String toString() {
		return "radius :" + radius;
	}

}
