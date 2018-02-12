import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.util.Scanner;


public class BabyStepGiantStep {

    /**
     * @param args the command line arguments
     */
	
	public BabyStepGiantStep() {
		
	}
    public BigInteger solve(BigInteger g, BigInteger h, BigInteger p) {
        
    //creating our two lists
    ArrayList<BigInteger> listA = new ArrayList<BigInteger> ();
    ArrayList<BigInteger> listB = new ArrayList<BigInteger> ();
        
    /*Scanner input = new Scanner(System.in);
        
    System.out.println("Enter g");
    BigInteger g;
    g = input.nextBigInteger();
    
    System.out.println("Enter h");
    BigInteger h;
    h = input.nextBigInteger();
    
    System.out.println("Enter p");
    BigInteger p;
    p = input.nextBigInteger();
    input.close();*/
    //find multiplicative order N
    //System.out.println("Finding multiplicative order. A^k(mod N ) = 1");
    /*System.out.println("Enter A");
    BigInteger A;
    A = BigInteger.valueOf(input.nextInt());
    
    //System.out.println("Enter N");
    BigInteger N;
    N = BigInteger.valueOf(input.nextInt());*/
   
    
    BigInteger mOrder;
    mOrder = multiplicativeOrder(g,p); //this is our k
    //System.out.println("Multiplicative order: " +mOrder);
    
    //n = 1 + floor of square root of N
    BigInteger n;
    n = sqrt(mOrder).add(BigInteger.ONE);
    //System.out.println("sqrt: " + n);
    
    
    //1st item listA
    BigInteger firstA;
    firstA = pow(g,mOrder).mod(p);
    //2nd item listA
    listA.add(firstA);
    //1st item listB
    //listB.add(h.mod(p));
    //2nd item listB
    //BigInteger secondB;
    //secondB = pow(g,n.negate());
    listB.add(h);
       
    for(BigInteger i = BigInteger.valueOf(1); i.compareTo(n)< 0; i = i.add(BigInteger.ONE))    
    {
        listA.add(pow(g,i).mod(p));
        listB.add(h.multiply(g.modPow(n.negate().multiply(i), p)).mod(p));        
        i.add(BigInteger.ONE);
    }
    //System.out.println("list A: " + Arrays.toString(listA.toArray()));
    //System.out.println("list B: " + Arrays.toString(listB.toArray()));
    
    
    int A = 0;
    int B = 0;
    boolean test = false;
    for ( int x =0; x < listA.size(); x++)
    {
        for (int y = 0; y < listB.size(); y++)
        {
            if ( listA.get(x).equals(listB.get(y)))
            {
                test = true;
                A = x;
                B = y;
                break;
            }
        }
        if(test)
        {
            break;
        }
            
    }
    //Then x = i + jn is a solution to gx = h.
    BigInteger i = BigInteger.valueOf(A);
    BigInteger j = BigInteger.valueOf(B);
    
    BigInteger solution;
    solution = i.add(j.multiply(n));
    return solution;
    //System.out.println("Solution: " + solution);
       
        
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
    
    public static BigInteger sqrt(BigInteger n) {
	BigInteger a = BigInteger.ONE;
	BigInteger b = n.shiftRight(5).add(BigInteger.valueOf(8));
	while (b.compareTo(a) >= 0) {
		BigInteger mid = a.add(b).shiftRight(1);
		if (mid.multiply(mid).compareTo(n) > 0) {
			b = mid.subtract(BigInteger.ONE);
		} else {
			a = mid.add(BigInteger.ONE);
		}
	}
	return a.subtract(BigInteger.ONE);
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
