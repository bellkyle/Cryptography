import java.math.BigInteger;
/*
 * Here is an algorithm to calculate the order of the group.
 * Just copy the GCD and multiplicativeOrder methods to the program 
 * for 2.17
 * 
 */
public class Order {
	public static void main (String[] args) {
		BigInteger A = BigInteger.valueOf(9704);
		BigInteger N = BigInteger.valueOf(17389);
		
		System.out.println(multiplicativeOrder(A, N));
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
