
public class Ex2 {
	
	private static double max(double px1, double px2) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static double abs(double px1) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static double f(double[] poly, double x) {// f(x)
		//returns the function : f(x) = poly(x)
		double y = 0;
		double count = 0;
		for(int i = 0; i<poly.length; i++) {
			y += poly[i]*Math.pow(x,count);
			count++;
		}
		return y;
	}
	
	public static String poly(double[] poly) {// returns a String
		String st = "";
		for(int i = poly.length - 1 ; i>0 ; i--) {
			if(poly[i] == 0) {
				
			}
			else if(poly[i]>=0 & i < poly.length -1) {
				st += " + " + poly[i] +"x^"+i;
			}else {
				st +=" " + poly[i] +"x^"+i;
			}
		}
		if(poly[0]>0) {
			st+=" + " + poly[0];
		}else {
			st+=" " + poly[0];
		}
		
		return st;
	}
	

	public static double root (double[] p,double x1,double x2,double eps){
		// returns a value (x) such that |f(p,x)|<=eps, 
		// assumes f(p,x1) * f(p,x2) <=0, see: Bisection_method
		if(Ex2.f(p,x1)<=eps) {
			return x1;
		}
		if(Ex2.f(p,x2)<=eps) {
			return x2;
		}
		
		double c = x1;
		while(Math.abs(x1-x2)>=eps) {
			
			c = (x1+x2)/2;
			
			if(Ex2.f(p, c) == 0) {
				break;
			}else if(Ex2.f(p, c)*Ex2.f(p, x1)<0){
					x2 = c;	
			}else {
				x1 = c;
			}
			
			
		}
		
		return c;
	}

	public static double[] add(double[] p1, double[] p2) {// returns a new array representing the
		//polynom of p1+p2
		int pLength;
		int newLength;
		if(p1.length>p2.length) {
			pLength = p2.length;
			newLength = p1.length;
		}
		else {
			pLength = p1.length;
			newLength = p2.length;
		}
		double[] pnew = new double[newLength];
		
		for(int i = 0; i<pLength; i++) {
			pnew[i] = p1[i] + p2[i];
		}
		if(p1.length>p2.length) {
			for(int i = pLength; i<p1.length; i++) {
				pnew[i] = p1[i];
			}
		}
		else {
			for(int i = pLength; i<p2.length; i++) {
				pnew[i] = p2[i];
		}
		}
		return pnew;
	}
	
	
	public static double[] mul(double[] p1, double[] p2) {// returns a new array representing the
		//polynom of (p1)*(p2)
		
		int newLength = p1.length + p2.length -1;
		double[] pnew = new double[newLength];
		
		for(int i = 0; i< p1.length; i++) {
			for(int j=0;j<p2.length;j++) {
				
				pnew[i+j] += p1[i] * p2[j];
				
			}
		}
	
		
		return pnew;
		
	}

	public static double[] derivative (double[] po) {//returns a new polynom representing the
		//derivative of (po),
		
		double[] derivativePo = new double[po.length - 1];
		for(int i = 0; i < derivativePo.length; i++) {
			derivativePo[i] = po[i+1]*(i+1);
		}
		return derivativePo;
		
	}
	


}
