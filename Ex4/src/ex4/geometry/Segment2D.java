package ex4.geometry;

import ex4.Ex4_Const;
/**
 * This class represents a 2D segment on the plane, 
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Segment2D implements GeoShape{
	
	private Point2D left, right;
	
	public Segment2D(Point2D left, Point2D right){
		this.left = left;
		this.right = right;
	}
	public Segment2D(double x1,double y1,double x2, double y2) {
		this.left = new Point2D(x1,y1);
		this.right = new Point2D(x2,y2);
	}
	
	@Override
	public boolean contains(Point2D ot) {
		double m, ot_to_m;
		m = (this.left.x()-this.right.x())/(this.left.y()-this.right.y());
		ot_to_m = (this.left.x()-ot.x())/(this.left.y()-ot.y());
		
		return m == ot_to_m;
	}

	@Override
	public Point2D centerOfMass() {
		double x, y;
		x = (Math.max(this.left.x(), this.right.x()) - Math.min(this.left.x(), this.right.x()))/2;
		y = (Math.max(this.left.y(), this.right.y()) - Math.min(this.left.y(), this.right.y()))/2;
		Point2D cen = new Point2D(x,y);
		return cen;
	}

	/**
	 */
	@Override
	public double area() {
		return 0;
	}

	@Override
	public double perimeter() {
		return this.left.distance(this.right)*2;
	}

	@Override
	public void move(Point2D vec) {
		Point2D new_right = new Point2D(this.right.x()+vec.x(),this.right.y()+vec.y());
		Point2D new_left = new Point2D(this.left.x()+vec.x(),this.left.y()+vec.y());
		this.left = new_left;
		this.right = new_right;
	}

	@Override
	public GeoShape copy() {
		return new Segment2D(this.left, this.right);
		
	}
	@Override
	public Point2D[] getPoints() {
		Point2D[] ans = new Point2D[2];
		ans[0] =new Point2D(this.left);
		ans[1] = new Point2D(this.right);
		return ans;
	}
	@Override
	public String toString() {
		return this.left.toString() +" , " + this.right.toString();
	}
}