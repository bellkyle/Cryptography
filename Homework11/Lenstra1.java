import java.util.Scanner;
import java.util.*;
import java.math.BigInteger;

public class Lenstra {
	static BigInteger addX;
	static BigInteger addY;
	static BigInteger multX;
	static BigInteger multY;
	static BigInteger p;
	public static void main(String[] args) {
		BigInteger A;
		BigInteger B;
		p = BigInteger.valueOf(187);
		/*Scanner input = new Scanner(System.in);
		System.out.println("E:Y^2 = X^3 + AX + B");
		System.out.println("Enter the A value of the elliptic curve equation");
		A = input.nextBigInteger();
		System.out.println("Enter the B value of the elliptic curve equation");
		B = input.nextBigInteger();
		System.out.println("Enter the prime value");
		p = input.nextBigInteger();
		BigInteger x1;
		BigInteger y1;
		BigInteger n;
		BigInteger y2;
		System.out.println("Enter the x value of the first point");
		x1 = input.nextBigInteger();
		System.out.println("Enter the y value of the first point");
		y1 = input.nextBigInteger();
		System.out.println("Enter the n value");
		n = input.nextBigInteger();
		
		input.close();*/
		//multiplication(x1,y1,n,A);
		//System.out.println(multX + " " + multY);
		if(addition(BigInteger.valueOf(43),BigInteger.valueOf(126),BigInteger.valueOf(54),BigInteger.valueOf(105),BigInteger.valueOf(3)))
			System.out.println(addX + " " + addY);
	}
	
	public static boolean addition(BigInteger x1, BigInteger y1, BigInteger x2, BigInteger y2, BigInteger A) {
		BigInteger lamda;
		if(x1.equals(x2) && y1.equals(y2))
			lamda = (((x1.pow(2).multiply(BigInteger.valueOf(3))).add(A)).multiply((y1.multiply(BigInteger.valueOf(2))).modInverse(p))).mod(p);
		
		else {
			try {
				lamda = ((y2.subtract(y1)).multiply((x2.subtract(x1)).modInverse(p))).mod(p);
			} catch
		}
		addX = (lamda.pow(2)).mod(p);
		addX = (addX.subtract(x1)).mod(p);
		addX = (addX.subtract(x2)).mod(p);
		addX = addX.mod(p);
		addY = x1.subtract(addX);
		addY = addY.multiply(lamda);
		addY = addY.subtract(y1);
		addY = addY.mod(p);
		return true;
	}
	
	
	public static void multiplication(BigInteger x, BigInteger y, BigInteger n, BigInteger A) {
		BigInteger rx = BigInteger.ZERO;
		BigInteger ry = BigInteger.ZERO;
		BigInteger on = n;
		BigInteger qx = x;
		BigInteger qy = y;
		if(n.equals(BigInteger.ONE))
		{
			multX = x;
			multY = y;
			return;
		}
		while(n.compareTo(BigInteger.ZERO) == 1) {
			if((n.mod(BigInteger.valueOf(2))).equals(BigInteger.ONE)) {
				if(n.equals(on)) {
					rx = x;
					ry = y;
				}
				else {
					addition(rx, ry, x, y, A);
					rx = addX;
					ry = addY;
				}
			}
			
			BigInteger lamda = (((x.pow(2).multiply(BigInteger.valueOf(3))).add(A)).multiply((y.multiply(BigInteger.valueOf(2))).modInverse(p))).mod(p);
			qx = (lamda.pow(2)).mod(p);
			qx = (qx.subtract(x)).mod(p);
			qx = (qx.subtract(x)).mod(p);
			qx = qx.mod(p);
			qy = x.subtract(qx);
			qy = qy.multiply(lamda);
			qy = qy.subtract(y);
			qy = qy.mod(p);
			x = qx;
			y = qy;
			
			n = n.divide(BigInteger.valueOf(2));
		}
		multX = rx;
		multY = ry;
	}
}
