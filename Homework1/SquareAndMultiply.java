import java.math.BigInteger;
import java.util.*;
public class SquareAndMultiply{
	public static void main(String[] args) {
		//Input all of the numbers
		Scanner input = new Scanner(System.in);
		System.out.print("Enter number N: ");
      BigInteger N;
      N = BigInteger.valueOf(input.nextInt());
      System.out.print("Enter number g: ");
      BigInteger g;
      g = BigInteger.valueOf(input.nextInt());
      BigInteger A;
      System.out.print("Enter number A: ");
      A = BigInteger.valueOf(input.nextInt());
      input.close();
		//set a to g and b to 1
      BigInteger a = g;
      BigInteger b = BigInteger.valueOf(1);
      //call and print the square and multiply algorithm
      System.out.print(powers(a,b,A,N));

	}

	public static BigInteger powers(BigInteger a, BigInteger b, BigInteger A, BigInteger N) {
		BigInteger[] congruent;
      while(A.compareTo(BigInteger.ZERO) == 1) {
			//use divide and remainder function to check congruency
         congruent = (A.subtract(BigInteger.ONE)).divideAndRemainder(BigInteger.valueOf(2));
        	if(congruent[1].compareTo(BigInteger.ZERO) == 0) {
        		b = (b.multiply(a)).mod(N);
        	}

        	a = (a.pow(2)).mod(N);
        	A = A.divide(BigInteger.valueOf(2));
        }

		return b;
	}
}
