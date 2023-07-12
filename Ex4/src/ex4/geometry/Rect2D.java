package ex4.geometry;
/**
 * This class represents a 2D axis parallel rectangle.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Rect2D implements GeoShape{
	
	private Point2D left;
	private Point2D right;
	
	public Rect2D(Point2D left, Point2D right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public boolean contains(Point2D ot) {
		double x = ot.x();
		double y = ot.y();
		double max_x = Math.max(this.left.x(), this.right.x());
		double min_x = Math.min(this.left.x(), this.right.x());
		double max_y = Math.max(this.left.y(), this.right.y());
		double min_y = Math.min(this.left.y(), this.right.y());
		if(max_x >= x && x >= min_x && max_y >= y && y >= min_y ) {
			return true;
		}
		return false;
	}
	@Override
	public Point2D centerOfMass() {
		double x_avr = (this.left.x() + this.right.x())/2;
		double y_avr = (this.left.y() + this.right.y())/2;
		Point2D cen = new Point2D(x_avr,y_avr);
		return cen;
	}
	@Override
	public double area() {
		double len = Math.max(Math.abs(this.left.x()), this.right.x()) - Math.min(Math.abs(this.left.x()), this.right.x());
		double hight = Math.max(Math.abs(this.left.y()), this.right.y()) - Math.min(Math.abs(this.left.y()), this.right.y());
		return len*hight;
	}
	
	@Override
	public double perimeter() {
		double len = Math.max(Math.abs(this.left.x()), this.right.x()) - Math.min(Math.abs(this.left.x()), this.right.x());
		double hight = Math.max(Math.abs(this.left.y()), this.right.y()) - Math.min(Math.abs(this.left.y()), this.right.y());
		return 2*len + 2*hight;
	}

	@Override
	public void move(Point2D vec) {
		Point2D new_left = new Point2D(this.left.x()+vec.x(),this.left.y()+vec.y());
		Point2D new_right = new Point2D(this.right.x()+vec.x(),this.right.y()+vec.y());
		this.left = new_left;
		this.right = new_right;
	}
	@Override
	public GeoShape copy() {
		return new Rect2D(this.left, this.right);
		
	}

	@Override
	public Point2D[] getPoints() {
		Point2D[] ans = new Point2D[2];
		ans[0] = new Point2D(this.left);
		ans[1] = new Point2D(this.right);
		return ans;
	}
	@Override
	public String toString() {
		return this.left.toString() + " ," + this.right.toString();
	}

}