import java.util.Scanner;
import java.util.*;
import java.math.BigInteger;

public class Lenstra1 {
	static BigInteger addX;
	static BigInteger addY;
	static BigInteger multX;
	static BigInteger multY;
	static BigInteger p;
	static BigInteger d;
	public static void main(String[] args) {
		BigInteger A;
		BigInteger B;
		p = BigInteger.valueOf(0);
		Scanner input = new Scanner(System.in);
		System.out.println("E:Y^2 = X^3 + AX + B");
		System.out.println("Enter the A value of the elliptic curve equation");
		A = input.nextBigInteger();
		System.out.println("Enter the B value of the elliptic curve equation");
		B = input.nextBigInteger();
		System.out.println("Enter the prime value");
		p = input.nextBigInteger();
		BigInteger x;
		BigInteger y;
		//BigInteger n;
		//BigInteger y2;
		System.out.println("Enter the x value of the first point");
		x = input.nextBigInteger();
		System.out.println("Enter the y value of the first point");
		y = input.nextBigInteger();
		multX = x;
		multY = y;
		addX = x;
		addY = y;
		input.close();
		BigInteger j = BigInteger.valueOf(2);
		for(int i = 0; i < 1; i++) {
			if(!addition(x,y,addX,addY,A))
				System.out.println(d);
		}
		System.out.println(addX + " " + addY);
		while(addition(x,y,addX,addY,A)) {
			//System.out.println(multX + " " + multY + " " + j + " " + d);

			j = j.add(BigInteger.ONE);
		}
		BigInteger solution = p.divide(d);
		System.out.println(solution + " " + d);
	}
	
	public static boolean addition(BigInteger x1, BigInteger y1, BigInteger x2, BigInteger y2, BigInteger A) {
		BigInteger num;
		BigInteger denom;
		if(x2.equals(BigInteger.ZERO) && y2.equals(BigInteger.ONE)) {
			addX = x1;
			addY = y1;
			return true;
		}
		if(x1.equals(x2)) {
			if((y1.add(y2).mod(p)).equals(BigInteger.ZERO))
				return false;
			num = (x1.pow(2).multiply(BigInteger.valueOf(3)).add(A)).mod(p);
			denom = (y1.multiply(BigInteger.valueOf(2))).mod(p);
		}
		else{
			num = (y2.subtract(y1)).mod(p);
			denom = (x2.subtract(x1)).mod(p);
		}
		try {
			denom = denom.modInverse(p);
		}catch(ArithmeticException e) {
			d = denom;
			return false;
		}
		BigInteger lamda = num.multiply(denom);
		addX = lamda.pow(2);
		addX = addX.subtract(x1);
		addX = (addX.subtract(x2)).mod(p);
		addY = x1.subtract(addX);
		addY = addY.multiply(lamda);
		addY = (addY.subtract(y1)).mod(p);
		return true;
	}
	
	
	public static boolean multiplication(BigInteger x, BigInteger y, BigInteger n, BigInteger A) {
		BigInteger rx = BigInteger.ZERO;
		BigInteger ry = BigInteger.ONE;
		while(n.compareTo(BigInteger.ZERO) == 1) {
			if((n.mod(BigInteger.valueOf(2))).equals(BigInteger.ONE)) {
				addition(x, y, rx, ry, A);
			}
			n = n.divide(BigInteger.valueOf(2));
			if(!addition(x, y, x, y, A))
				return false;
		}
		multX = addX;
		multY = addY;
		return true;
	}
}
