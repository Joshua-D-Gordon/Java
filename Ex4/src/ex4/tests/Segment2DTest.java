package ex4.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ex4.geometry.GeoShape;
import ex4.geometry.Point2D;
import ex4.geometry.Segment2D;
import ex4.geometry.Triangle2D;

class Segment2DTest {
	Point2D a = new Point2D(0.0,0.0);
	Point2D b = new Point2D(5.0,5.0);
	Point2D c = new Point2D(4.0,4.0);
	Segment2D seg = new Segment2D(a,b);
	Point2D t = new Point2D(1.0,0.0);

	@Test
	void testContains() {
		boolean ok = seg.contains(c);
		assertEquals(true, ok);
		seg.move(t);
		ok = seg.contains(c);
		assertEquals(false, ok);
	}
	
	@Test
	void testCenterOfMass() {
		System.out.println(seg.centerOfMass());
		Point2D cen = new Point2D(2.5,2.5);
		assertEquals(true, cen.x() == seg.centerOfMass().x() && cen.y() == seg.centerOfMass().y());
		
	}
	@Test
	void area() {
		assertEquals(0, seg.area());
	}
	@Test
	void testPerimiter() {
		double dis = a.distance(b)*2;
		assertEquals(dis, seg.perimeter());
	}
	@Test
	void testMove() {
		Point2D v = new Point2D(1.0,1.0);
		Point2D cen = seg.centerOfMass();
		seg.move(v);
		Point2D cen_new = seg.centerOfMass();
		
		assertEquals(false, cen_new == cen);
	}

	@Test
	void testGeoCopy() {
		
		GeoShape segCopy = seg.copy();
		boolean ok = segCopy.area() == seg.area();
		assertEquals(true, ok);
		
	}
	
}
	
	
