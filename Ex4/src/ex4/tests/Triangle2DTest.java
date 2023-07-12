package ex4.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ex4.geometry.GeoShape;
import ex4.geometry.Point2D;
import ex4.geometry.Triangle2D;

class Triangle2DTest {
	
	Point2D a = new Point2D(2.0,2.0);
	Point2D b = new Point2D(0.0,0.0);
	Point2D c = new Point2D(4.0,0.0);
	Triangle2D tri = new Triangle2D(a,b,c);
	Point2D t = new Point2D(2.0,1.0);

	@Test
	void testContains() {
		boolean ok = tri.contains(t);
		assertEquals(true, ok);
		Point2D v = new Point2D(0.0,3.0);
		t.move(v);
		ok = tri.contains(t);
		assertEquals(false, ok);
	}
	
	@Test
	void testCenterOfMass() {
		Point2D cen = tri.centerOfMass();
		Point2D r = new Point2D(1.0,1.0);
		tri.move(r);
		Point2D c = tri.centerOfMass();
		boolean ok = r == cen;
		assertEquals(false, ok);
	}
	
	@Test
	void area() {
		double d = tri.area();
		boolean ok;
		if(d<=4 && d>=3.99) {
			ok = true;
		}else {
			ok = false;
		}
		assertEquals(true, ok);
		Point2D[] lst = tri.getPoints();
		Point2D a = lst[0],b=lst[1],c=lst[2];
		Point2D v = new Point2D(1.0,1.0);
		a.move(v);
		Triangle2D tri_nd = new Triangle2D(a,b,c);
		double d1 = tri_nd.area();
		
		ok = d1==d;
		assertEquals(false, ok);
		
	}
	
	@Test
	void testPerimiter() {
		double d = tri.perimeter();
		double per = 4 + 2*Math.sqrt(8);
		assertEquals(per, d);
		Point2D[] lst = tri.getPoints();
		Point2D a = lst[0],b=lst[1],c=lst[2];
		Point2D v = new Point2D(1.0,1.0);
		a.move(v);
		Triangle2D tri_nd = new Triangle2D(a,b,c);
		double d1 = tri_nd.perimeter();
		boolean ok;
		ok = d1==d;
		assertEquals(false, ok);
		
	}
	
	@Test
	void testMove() {
		Point2D v = new Point2D(1.0,1.0);
		Point2D cen = tri.centerOfMass();
		tri.move(v);
		Point2D cen1 = tri.centerOfMass();
		boolean ok = cen == cen1;
		assertEquals(false, ok);
		
		
	}
	
	@Test
	void testGeoCopy() {
		
		GeoShape triCopy = tri.copy();
		
		assertEquals(tri.centerOfMass(), triCopy.centerOfMass());
		
	}
	
	

}
