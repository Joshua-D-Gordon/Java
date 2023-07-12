import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Ex2_Test {
	
	static double[] po1={2,0,3, -1,0}, 
			po2 = {0.1,0,1, 0.1,3};
	static final double EPS = 0.0001;

	@Test
	void testF() {
		double fx0 = Ex2.f(po1, 0);
		double fx1 = Ex2.f(po1, 1);
		double fx2 = Ex2.f(po1, 2);
		assertEquals(fx0,2);
		assertEquals(fx1,4);
		assertEquals(fx2,6);
	}

	@Test
	void testPoly() {
		String p = Ex2.poly(po1);
		assertEquals(p," -1.0x^3 + 3.0x^2 + 2.0");
	}

	@Test
	void testRoot() {
		double x12 = Ex2.root(po1, 0, 10, EPS);
		assertEquals(x12, 3.1958, 0.001);
	}

	@Test
	void testAdd() {
		double[] pol1_add_pol2 = Ex2.add(po1, po2);
		String pol1and2_string = Ex2.poly(pol1_add_pol2);
		assertEquals(pol1and2_string, " 3.0x^4 -0.9x^3 + 4.0x^2 + 2.1");
	}

	@Test
	void testMul() {
		double[] pol1_mul_pol2 = Ex2.mul(po1, po2);
		String pol1mulpol2_string = Ex2.poly(pol1_mul_pol2);
		assertEquals(pol1mulpol2_string, " -3.0x^7 + 8.9x^6 -0.7x^5 + 9.0x^4 + 0.1x^3 + 2.3x^2 + 0.2");
	}

	@Test
	void testDerivative() {
		double[] p = {1,2,3}; // 3X^2+2x+1
		double[] dp1 = {2,6}; // 6x+2
		double[] dp2 = Ex2.derivative(p);
		assertEquals(dp1[0], dp2[0],EPS);
		assertEquals(dp1[1], dp2[1],EPS);
		assertEquals(dp1.length, dp2.length);
	}

}
