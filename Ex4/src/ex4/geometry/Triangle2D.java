package ex4.geometry;
/**
 * This class represents a 2D Triangle in the plane.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Triangle2D implements GeoShape{
	
	private Point2D top;
	private Point2D left;
	private Point2D right;
	
	public Triangle2D(Point2D top, Point2D left, Point2D right) {
		this.top = top;
		this.left = left;
		this.right = right;
	}
	public Triangle2D() {
		Point2D temp = new Point2D(0,0);
		this.top = temp;
		this.right = temp;
		this.left = temp;
	}
	@Override
	public boolean contains(Point2D ot) {
		double x_max = Math.max(Math.max(this.top.x(), this.left.x()),Math.max(this.right.x(), this.left.x()));
		double x_min = Math.min(Math.min(this.top.x(), this.left.x()),Math.min(this.right.x(), this.left.x()));
		double y_max = Math.max(Math.max(this.top.y(), this.left.y()),Math.max(this.right.y(), this.left.y()));
		double y_min = Math.min(Math.min(this.top.y(), this.left.y()),Math.min(this.right.y(), this.left.y()));
		if(x_max >= ot.x() && ot.x() >= x_min && y_max >= ot.y() && ot.y() >= y_min) {
			return true;
		}
		return false;
	}

	@Override
	public Point2D centerOfMass() {
		double avr_3_x = (this.top.x() + this.right.x() + this.left.x())/3;
		double avr_3_y = (this.top.y() + this.right.y() + this.left.y())/3;
		
		Point2D cen = new Point2D(avr_3_x,avr_3_y);
		return cen;
	}

	/**
	 * https://en.wikipedia.org/wiki/Heron%27s_formula
	 * d = peremiter/2;
	 * area = Math.sqrt((d-a)(d-b)(d-c)),  a,b,c are the edges length
	 */
	@Override
	public double area() {
		double a,b,c,p;
		a = this.right.distance(this.left);
		b = this.left.distance(this.top);
		c = this.top.distance(this.right);
		p = (a+b+c)/2;
		double area_is = Math.sqrt(p*(p-a)*(p-b)*(p-c));
		return area_is;
	}

	@Override
	public double perimeter() {
		
		return this.top.distance(this.left) + this.left.distance(this.right) + this.right.distance(this.top);
	}

	@Override
	public void move(Point2D vec) {
		Point2D new_left = new Point2D(this.left.x()+vec.x(),this.left.y()+vec.y());
		Point2D new_right = new Point2D(this.right.x()+vec.x(),this.right.y()+vec.y());
		Point2D new_top = new Point2D(this.top.x()+vec.x(),this.top.y()+vec.y());
		this.left = new_left;
		this.right = new_right;
		this.top = new_top;
	}

	@Override
	public GeoShape copy() {
		return new Triangle2D(this.top,this.left,this.right);
	}

	@Override
	public Point2D[] getPoints() {
		Point2D[] ans = new Point2D[3];
		ans[0] = new Point2D(this.top);
		ans[1] = new Point2D(this.left);
		ans[2] = new Point2D(this.right);
		return ans;
	}
	@Override
	public String toString() {
		return this.top.toString() + " , " + this.left.toString() + " , " + this.right.toString(); 
	}
}