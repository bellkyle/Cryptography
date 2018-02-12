import java.math.BigInteger;
import java.util.Scanner;
import java.util.*;

public class PohligHellman {
	private static ArrayList<BigInteger> listQ = new ArrayList<BigInteger>();
	private static ArrayList<BigInteger> listE = new ArrayList<BigInteger>();
	public static void main(String[] args) {
		//input all of the numbers
		Scanner input = new Scanner(System.in);
		System.out.println("Enter g");
	    BigInteger g;
	    g = input.nextBigInteger();
	    
	    System.out.println("Enter h");
	    BigInteger h;
	    h = input.nextBigInteger();
	    
	    System.out.println("Enter p");
	    BigInteger p;
	    p = input.nextBigInteger();
	    input.close();
	    
	   	//find the order    
	    BigInteger N = multiplicativeOrder(g, p);
	    
	    BabyStepGiantStep dlp = new BabyStepGiantStep();
	    ArrayList<BigInteger> xValues = new ArrayList<BigInteger>();
	    //find prime factors
		primeFactors(N);
		BigInteger gq;
		BigInteger hq;
		for(int i = 0; i < listQ.size(); i++) {
			//solve the dlp for with respect to all q values
			gq = pow(g, (N.divide(pow(listQ.get(i), listE.get(i))))).mod(p);
			hq = pow(h, (N.divide(pow(listQ.get(i), listE.get(i))))).mod(p);
			xValues.add(dlp.solve(gq, hq, p));
		}
		for(int i = 0; i < listQ.size(); i++) {
			System.out.println("q = " + listQ.get(i) + ", e = " + listE.get(i) + ", x = " + xValues.get(i));
		}
		
		/*
		 * Need Chinese remainder Theorem  to do the next part
		 */
		
		Congruent x = new Congruent();
		
		System.out.println("The solution is x = " + x.solve(xValues.size(), xValues, listQ, listE));
	}
	
	// A function to print all prime factors
    // of a given number n
    public static void primeFactors(BigInteger n)
    {
    	//ArrayList<BigInteger> arr = new ArrayList<BigInteger>();
        // Print the number of 2s that divide n
    	int count = 0;
    	int index = 0;
        while (n.mod(BigInteger.valueOf(2)).compareTo(BigInteger.ZERO)==0)
        {
        	if(!listQ.contains(BigInteger.valueOf(2)))
        		listQ.add(BigInteger.valueOf(2));
        	count++;
            n = n.divide(BigInteger.valueOf(2));
        }
        if(count != 0) {
        	listE.add(index, BigInteger.valueOf(count));
        	index++;
        }
        
        // n must be odd at this point.  So we can
        // skip one element (Note i = i +2)
        for (int i = 3; i <= Math.sqrt(n.intValue()); i+= 2)
        {
        	count = 0;
            // While i divides n, print i and divide n
            while (n.mod(BigInteger.valueOf(i)).compareTo(BigInteger.ZERO) == 0)
            {
            	if(!listQ.contains(BigInteger.valueOf(i)))
            		listQ.add(BigInteger.valueOf(i));
            	count++;
                n = n.divide(BigInteger.valueOf(i));
            }
            if(count != 0) {
            	listE.add(index, BigInteger.valueOf(count));
            	index++;
            }
        }
 
        // This condition is to handle the case when
        // n is a prime number greater than 2
        if (n.compareTo(BigInteger.valueOf(2)) == 1) {
        	listQ.add(n);
        	listE.add(index, n);
        }
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
	
    public static BigInteger pow(BigInteger base, BigInteger exponent) {
  BigInteger result = BigInteger.ONE;
  while (exponent.signum() > 0) {
    if (exponent.testBit(0)) result = result.multiply(base);
    base = base.multiply(base);
    exponent = exponent.shiftRight(1);
  }
  return result;
}
    
}
