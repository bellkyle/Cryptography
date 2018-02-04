package babystepgiantstep;
import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.util.Scanner;


public class BabyStepGiantStep {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    //creating our two lists
    ArrayList<BigInteger> listA = new ArrayList<BigInteger> ();
    ArrayList<BigInteger> listB = new ArrayList<BigInteger> ();
        
    Scanner input = new Scanner(System.in);
        
    System.out.println("Enter g");
    BigInteger g;
    g = BigInteger.valueOf(input.nextInt());
    
    System.out.println("Enter h");
    BigInteger h;
    h = BigInteger.valueOf(input.nextInt());
    
    System.out.println("Enter p");
    BigInteger p;
    p = BigInteger.valueOf(input.nextInt());
    
    //find multiplicative order N
    System.out.println("Finding multiplicative order. A^k(mod N ) = 1");
    System.out.println("Enter A");
    BigInteger A;
    A = BigInteger.valueOf(input.nextInt());
    
    System.out.println("Enter N");
    BigInteger N;
    N = BigInteger.valueOf(input.nextInt());
    //n = 1 + floor of square root of N
    //will need to create a method to calculate this
    BigInteger n;
   
    
    BigInteger mOrder;
    mOrder = multiplicativeOrder(A,N);
    
    
    //1st item listA
    BigInteger firstA;
    firstA = pow(g,mOrder);
    //2nd item listA
    listA.add(g);
    //1st item listB
    listB.add(h);
    //2nd item listB
    BigInteger secondB;
    
    
    
       
        
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
    
    
    public static BigInteger GCD(BigInteger a, BigInteger b) {
		if(b.compareTo(BigInteger.ZERO) == 0)
				return a;
		return GCD(b, a.mod(b));
	}
	
	public static BigInteger multiplicativeOrder(BigInteger A, BigInteger N) {
		if(GCD(A, N).compareTo(BigInteger.ONE) != 0)
			return BigInteger.valueOf(-1);
		
		BigInteger result = BigInteger.ONE;
		
		BigInteger K = BigInteger.ONE;
		
		while(K.compareTo(N) == -1) {
			result = (result.multiply(A)).mod(N);
			
			if(result.compareTo(BigInteger.ONE) == 0)
				return K;
			
			K = K.add(BigInteger.ONE);
		}
		return BigInteger.valueOf(-1);
}
    
}