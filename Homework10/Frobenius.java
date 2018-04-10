import java.util.Scanner;
import java.util.*;
import java.math.BigInteger;

public class Frobenius {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please p");
		BigInteger prime = input.nextBigInteger();
		ArrayList<BigInteger> quadratic = new ArrayList<BigInteger>();
		for(int i = 0; prime.compareTo(BigInteger.valueOf(i)) == 1; i++) {
			quadratic.add(((BigInteger.valueOf(i)).multiply(BigInteger.valueOf(i)).mod(prime)));
			
		}
		BigInteger y;
		int counter = 0;
		boolean flag = false;
		for(int i = 0; prime.compareTo(BigInteger.valueOf(i)) == 1; i++) {
			flag = false;
			y = BigInteger.valueOf(i).pow(3);
			y = y.add(BigInteger.valueOf(i));
			y = y.add(BigInteger.ONE);
			y = y.mod(prime);
			for(int j = 0; j < quadratic.size(); j++) {
				if(y.equals(quadratic.get(j)) && !flag) {	
					flag = true;
					counter++;
					if(!y.equals(BigInteger.ZERO))
						counter++;
				}
			}
		}
		counter++;
		System.out.println("The number of points is: " + counter);
		BigInteger tp = prime.add(BigInteger.ONE);
		tp = tp.subtract(BigInteger.valueOf(counter));
		System.out.println("The trace of Frobenius is: " + tp);
		double sqrt = Math.sqrt(prime.intValue());
		sqrt = 2*sqrt;
		System.out.println("2*sqrt(p) is: " + sqrt);
	}
}
