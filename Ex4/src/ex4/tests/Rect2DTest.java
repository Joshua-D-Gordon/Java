package ex4.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ex4.geometry.GeoShape;
import ex4.geometry.Point2D;
import ex4.geometry.Rect2D;
import ex4.geometry.Triangle2D;

class Rect2DTest {

	Point2D a = new Point2D(3.0,2.0);
	Point2D b = new Point2D(0.0,0.0);
	Point2D c = new Point2D(2.0,1.0);
	Rect2D rec = new Rect2D(a,b);
	Point2D t = new Point2D(2.0,1.0);

	@Test
	void testContains() {
		boolean ok = rec.contains(c);
		assertEquals(true, ok);
		Point2D v = new Point2D(5.0,3.0);
		t.move(v);
		ok = rec.contains(t);
		assertEquals(false, ok);
	}
	
	@Test
	void testCenterOfMass() {
		
		Point2D a = new Point2D(3.0,2.0);
		Point2D b = new Point2D(0.0,0.0);
		Rect2D rec = new Rect2D(a,b);
		
		Point2D cen = rec.centerOfMass();
	
		
		Point2D r = new Point2D(5.0,5.0);
		rec.move(r);
		Point2D u = rec.centerOfMass();
		assertEquals(false, u == cen);
	}
	
	@Test
	void area() {
		double d = rec.area();
		assertEquals(6.0, d);
		Point2D[] lst = rec.getPoints();
		Point2D a = lst[0],b=lst[1];
		Point2D v = new Point2D(5.0,20.0);

		Rect2D rec_nd = new Rect2D(a,v);
		double d1 = rec_nd.area();
		boolean ok;
		ok = d1==d;
		assertEquals(false, ok);
		
	}
	
	@Test
	void testPerimiter() {
		Rect2D rec = new Rect2D(a,b);
		double d = rec.perimeter();
		assertEquals(10, d);
		Point2D[] lst = rec.getPoints();
		Point2D a = lst[0],b=lst[1];
		Point2D v = new Point2D(4.5,-5.0);
		Rect2D rec_nd = new Rect2D(a,v);
		double d1 = rec_nd.perimeter();
		boolean ok;
		ok = d1==d;
		assertEquals(false, ok);
		
	}
	
	@Test
	void testMove() {
		Point2D a = new Point2D(3.0,2.0);
		Point2D b = new Point2D(0.0,0.0);
		
		Rect2D rec = new Rect2D(a,b);
		Point2D v = new Point2D(1.0,1.0);
		Point2D cen = rec.centerOfMass();
		rec.move(v);
		Point2D cen1 = rec.centerOfMass();
		boolean ok = cen == cen1;
		assertEquals(false, ok);
		
	}
	
	@Test
	void testGeoCopy() {
		Point2D a = new Point2D(3.0,2.0);
		Point2D b = new Point2D(0.0,0.0);
		
		Rect2D rec = new Rect2D(a,b);
		
		GeoShape recCopy = rec.copy();
		boolean ok = recCopy.area() == rec.area();
		assertEquals(true, ok);
		
	}
	
	

}