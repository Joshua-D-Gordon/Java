package ex4;
/**
 * This class implements the GUI_shape.
 * Ex4: you should implement this class!
 * @author I2CS
 */
import java.awt.Color;
import ex4.geometry.*;

public class GUIShape implements GUI_Shape{
	
	GeoShape shape;
	boolean filled;
	Color c;
	int tag;
	
	public GUIShape(GeoShape shape, boolean filled, Color c, int tag) {
		this.shape = shape;
		this.filled = filled;
		this.c = c;
		this.tag = tag;
	}
	public GUIShape() {
		this.shape = null;
		this.filled = false;
		this.c = null;
		this.tag = 0;
	}
	
	// this is for the file load and saving so this
	//is the constuctor with strings:
	
	// need to do
	public GUIShape(String s) {
		String[] array = s.split(",");
		
		if(array[4] == "Point2D") {
			this.shape = new Point2D(Double.parseDouble(array[5]),Double.parseDouble(array[6]));
			
			this.c = Color.decode(array[1]);
			this.filled = Boolean.valueOf(array[2]);
			this.tag = Integer.parseInt(array[3]);
		}
		if(array[4] == "Circle2D") {
			Point2D c_point = new Point2D(Double.parseDouble(array[5]),Double.parseDouble(array[6]));
			this.shape = new Circle2D(c_point,Double.parseDouble(array[7]));
			
			this.c = Color.decode(array[1]);
			this.filled = Boolean.valueOf(array[2]);
			this.tag = Integer.parseInt(array[3]);
		}
		if(array[4] == "Rect2D") {
			Point2D rect_p1 = new Point2D(Double.parseDouble(array[5]),Double.parseDouble(array[6]));
			Point2D rect_p2 = new Point2D(Double.parseDouble(array[7]),Double.parseDouble(array[8]));
			this.shape = new Rect2D(rect_p1,rect_p2);
			
			this.c = Color.decode(array[1]);
			this.filled = Boolean.valueOf(array[2]);
			this.tag = Integer.parseInt(array[3]);
		}
		if(array[4] == "Triangle2D") {
			Point2D tri_p1 = new Point2D(Double.parseDouble(array[5]),Double.parseDouble(array[6]));
			Point2D tri_p2 = new Point2D(Double.parseDouble(array[7]),Double.parseDouble(array[8]));
			Point2D tri_p3 = new Point2D(Double.parseDouble(array[9]),Double.parseDouble(array[10]));
			this.shape = new Triangle2D(tri_p1,tri_p2,tri_p3);
			
			this.c = Color.decode(array[1]);
			this.filled = Boolean.valueOf(array[2]);
			this.tag = Integer.parseInt(array[3]);
		}
		if(array[4] == "Segment2D") {
			Point2D seg_p1 = new Point2D(Double.parseDouble(array[5]),Double.parseDouble(array[6]));
			Point2D seg_p2 = new Point2D(Double.parseDouble(array[7]),Double.parseDouble(array[8]));
			this.shape = new Segment2D(seg_p1,seg_p2);
			
			this.c = Color.decode(array[1]);
			this.filled = Boolean.valueOf(array[2]);
			this.tag = Integer.parseInt(array[3]);
		}
		
		
		
	}


	@Override
	public GeoShape getShape() {
		return this.shape;
	}

	@Override
	public void setShape(GeoShape g) {
		this.shape = g;
	}

	@Override
	public boolean isFilled() {
		return this.filled;	
		}

	@Override
	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	@Override
	public Color getColor() {
		return this.c;
	}

	@Override
	public void setColor(Color cl) {
		this.c = cl;
	}

	@Override
	public int getTag() {
		return this.tag;
	}

	@Override
	public void setTag(int tag) {
		this.tag = tag;
	}

	@Override
	public GUI_Shape copy() {
		return this.copy();
	}
	@Override
	public String toString() {
		return this.shape.toString() +", "+ this.tag +" ,"+ this.filled + " ," + this.c.toString();
	}
}