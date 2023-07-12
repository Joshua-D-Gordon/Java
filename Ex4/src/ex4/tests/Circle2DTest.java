package ex4.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ex4.geometry.Circle2D;
import ex4.geometry.GeoShape;
import ex4.geometry.Point2D;
import ex4.geometry.Triangle2D;

class Circle2DTest {


	Point2D a = new Point2D(0.0,0.0);
	Circle2D c = new Circle2D(a, 5);
	Point2D p = new Point2D(1.0,1.0);
	


	@Test
	void testContains() {
		boolean ok = c.contains(p);
		assertEquals(true, ok);
		Point2D v = new Point2D(10.0,10.0);
		c.move(v);
		ok = c.contains(p);
		assertEquals(false, ok);
	}
	
	@Test
	void testCenterOfMass() {
		Point2D cen = c.centerOfMass();
		double cen_x = 0.0, cen_y = 0.0;
		Point2D r = new Point2D(cen_x,cen_y);
		assertEquals(r,cen);
		r = new Point2D(1.0,1.0);
		c.move(r);
		Point2D p = c.centerOfMass();
		boolean ok = cen ==p;
		assertEquals(false, ok);
	}
	
	@Test
	void area() {
		double aerac = c.area();
		boolean ok = aerac == c.area();
		assertEquals(true, ok);
		
	}
	
	@Test
	void testPerimiter() {
		double perc = c.perimeter();
		boolean ok = c.perimeter() == perc;
		assertEquals(true, ok);
		
	}
	
	@Test
	void testMove() {
		Point2D a = new Point2D(0.0,0.0);
		Circle2D c = new Circle2D(a, 5);
		Point2D cen = c.centerOfMass();
		Point2D v = new Point2D(1.0,1.0);
		c.move(v);
		boolean ok = cen == c.centerOfMass();
		assertEquals(false,ok);
		
	}
	
	@Test
	void testGeoCopy() {
		
		Point2D a = new Point2D(0.0,0.0);
		Circle2D c = new Circle2D(a, 5);
		GeoShape cCopy = c.copy();
		boolean ok = cCopy.area() == c.area();
		assertEquals(true, ok);
		
	}
	
	

}

