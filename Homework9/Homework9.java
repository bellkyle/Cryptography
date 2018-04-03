import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.util.Scanner;


public class Homework9 {
	static BigInteger p;
	static BigInteger g;
	static BigInteger a;

	public static void main(String[] args) {
		BigInteger x;
		BigInteger y;
		BigInteger alpha;
		BigInteger beta;
		BigInteger gamma;
		BigInteger delta;

		Scanner input = new Scanner(System.in);
		
	    System.out.println("Enter g");
	    g = input.nextBigInteger();
	    
	    System.out.println("Enter a");
	    a = input.nextBigInteger();
	    
	    System.out.println("Enter p");
	    p = input.nextBigInteger();
	    input.close();
	    
		x= BigInteger.ONE;
		//System.out.println(x);
		y = BigInteger.ZERO;
		alpha = BigInteger.ZERO;
		beta = BigInteger.ZERO;
		gamma = BigInteger.ZERO;
		delta = BigInteger.ZERO;
		int counter = 0;
		//System.out.println(x.equals(y));
		ArrayList<BigInteger> list = new ArrayList<BigInteger>();
		while(!(x.equals(y))) {
			if(counter == 0)
				y = BigInteger.ONE;
			list = Pollard(x,alpha,beta, false);
			x = list.get(0);
			alpha = list.get(1);
			beta = list.get(2);
			list = Pollard(y,gamma,delta, true);
			y = list.get(0);
			gamma = list.get(1);
			delta = list.get(2);
			counter++;
			/*System.out.print(x.toString() + " " + y.toString());
			System.out.print(" ");
			System.out.print(alpha.toString() + " " + beta.toString());
			System.out.print(" ");
			System.out.print(gamma.toString() + " " + delta.toString());
			System.out.print("\n");*/
			
		}
		
		BigInteger v = (delta.subtract(beta)).mod(p.subtract(BigInteger.ONE));
		BigInteger u = (alpha.subtract(gamma)).mod(p.subtract(BigInteger.ONE));
		//System.out.println(u.toString() + " u ");
		Gcd common = new Gcd();
		BigInteger w = common.solve(v, p.subtract(BigInteger.ONE));
		BigInteger s = BigInteger.ONE;
		while(!((s.multiply(v)).mod(p.subtract(BigInteger.ONE))).equals(w)) {
			s = s.add(BigInteger.ONE);
		}
		u = (u.multiply(s)).mod(p.subtract(BigInteger.ONE));
		//System.out.println(u.toString() + " u ");
		BigInteger q = p.subtract(BigInteger.ONE);
		u = u.divide(w);
		q = q.divide(w);
		ArrayList<BigInteger> list2 = new ArrayList<BigInteger>();
		BigInteger temp = u;
		while(temp.compareTo(p) == -1) {
			temp = temp.add(q);
			//ystem.out.println(temp);
			if(temp.compareTo(p) == 1)
				break;
			list2.add(temp);
		}
		//System.out.println("Size = " + list2.size());
		//System.out.println(pow(g, BigInteger.valueOf(5)));
		BigInteger solution = BigInteger.ZERO;
		for(int i = 0; i < list2.size(); i++) {
			temp = (pow(g,list2.get(i))).mod(p);
			//System.out.println(temp.toString() + " " + list2.get(i));
			if(temp.equals(a)) {
				solution = list2.get(i);
				break;
			}
		}
		System.out.println("The solution is " + solution);
	}
	
	public static BigInteger pow(BigInteger base, BigInteger exponent) {
		  BigInteger result = BigInteger.ONE;
		  while (exponent.signum() > 0) {
		    if (exponent.testBit(0)) result = result.multiply(base);
		    base = base.multiply(base);
		    exponent = exponent.shiftRight(1);
		  }
		  return result;
		}
	public static ArrayList<BigInteger> Pollard(BigInteger x, BigInteger alpha, BigInteger beta, boolean t) {
		if((x.compareTo(BigInteger.ZERO) == 1) && (x.compareTo(p.divide(BigInteger.valueOf(3))) == -1)) {
			x = ((g.multiply(x).mod(p)));
			alpha = ((alpha).add(BigInteger.ONE)).mod(p.subtract(BigInteger.ONE));
			beta = (beta).mod(p.subtract(BigInteger.ONE));
		}
		
		else if((x.compareTo(p.divide(BigInteger.valueOf(3))) == 1) && (x.compareTo((p.multiply(BigInteger.valueOf(2))).divide(BigInteger.valueOf(3))) == -1)) {
			x = (((x).multiply(x)).mod(p));
			alpha = (alpha.multiply(BigInteger.valueOf(2))).mod(p.subtract(BigInteger.ONE));
			beta = (beta.multiply(BigInteger.valueOf(2))).mod(p.subtract(BigInteger.ONE));
		}
		
		else if((x.compareTo((p.multiply(BigInteger.valueOf(2))).divide(BigInteger.valueOf(3))) == 1) && (x.compareTo(p) == -1)) {
			x = (a.multiply(x)).mod(p);
			alpha = (alpha).mod(p.subtract(BigInteger.ONE));
			beta = (beta.add(BigInteger.valueOf(1))).mod(p.subtract(BigInteger.ONE));
		}
		ArrayList<BigInteger> list = new ArrayList<BigInteger>();
		if(t == true)
			list = Pollard(x, alpha, beta, false);
		else {
			list.add(x);
			list.add(alpha);
			list.add(beta);
		}
		return list;
		
	}
}
