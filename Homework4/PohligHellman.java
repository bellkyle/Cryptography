import java.math.BigInteger;
import java.util.*;

public class PohligHellman {
	public static void main(String[] args) {
		ArrayList<BigInteger> list = new ArrayList<BigInteger>();
		list = primeFactors(BigInteger.valueOf(11250));
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	// A function to print all prime factors
    // of a given number n
    public static ArrayList<BigInteger> primeFactors(BigInteger n)
    {
    	ArrayList<BigInteger> arr = new ArrayList<BigInteger>();
        // Print the number of 2s that divide n
        while (n.mod(BigInteger.valueOf(2)).compareTo(BigInteger.ZERO)==0)
        {
        	arr.add(BigInteger.valueOf(2));
            n = n.divide(BigInteger.valueOf(2));
        }
 
        // n must be odd at this point.  So we can
        // skip one element (Note i = i +2)
        for (int i = 3; i <= Math.sqrt(n.intValue()); i+= 2)
        {
            // While i divides n, print i and divide n
            while (n.mod(BigInteger.valueOf(i)).compareTo(BigInteger.ZERO) == 0)
            {
            	arr.add(BigInteger.valueOf(i));
                n = n.divide(BigInteger.valueOf(i));
            }
        }
 
        // This condition is to handle the case when
        // n is a prime number greater than 2
        if (n.compareTo(BigInteger.valueOf(2)) == 1)
        	arr.add(n);
        return arr;
    }
    
}
