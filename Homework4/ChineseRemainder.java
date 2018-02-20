import java.util.Scanner;
import java.math.BigInteger;

public class ChineseRemainder {

   
    public static void main(String[] args) {
       	int cases = 0;
		Scanner input = new Scanner(System.in);
		
		//Getting user input
		System.out.println("Enter number of congruencies you want to solve: ");
		cases = input.nextInt();
		
		BigInteger[] numbers = new BigInteger[cases];
		BigInteger[] mods = new BigInteger[cases];              
                
                
		for(int i = 0; i < cases; i++)
		{
			System.out.println("Enter a number: ");
			numbers[i] = BigInteger.valueOf(input.nextInt());
			
			System.out.println("Enter the modulo: ");
			mods[i] = BigInteger.valueOf(input.nextInt());
		}
		input.close();
        
		//output of method here
		System.out.println("X = " + calculateX(numbers, mods));
	}

	//Calculating X where X = a1M1y1 + a2M2y2 + ... + akMkyk (mod M)
	public static BigInteger calculateX(BigInteger[] numbers, BigInteger[] mods)
	{
		//variables
		int length = numbers.length;
		BigInteger M = BigInteger.valueOf(0);
		BigInteger sum = BigInteger.valueOf(0);
		BigInteger[] Mis = new BigInteger[length];
		BigInteger[] yis = new BigInteger[length];
		
		M = calculateM(length, mods);
		
		Mis = calculateMis(length, M, mods);
		
		yis = calculateYis(length, Mis, mods);

		sum = calculateSum(length, numbers, Mis, yis);
		
		//Returning X
		return sum.mod(M);
	}
	
	//Calculating M where M = n1n2...nk
	public static BigInteger calculateM(int length, BigInteger[] mods)
	{
		BigInteger M = BigInteger.valueOf(1);
		
		for(int i = 0; i < length; i++)
		{
			M = M.multiply(mods[i]);
		}
		return M;
	}
	
	//Calculating Mi where Mi = M/ni
	public static BigInteger[] calculateMis(int length, BigInteger M, BigInteger[] mods)
	{
		BigInteger[] Mis = new BigInteger[length];
		
		for(int i = 0; i <length; i++)
		{
			Mis[i] = M.divide(mods[i]);
		}
		return Mis;
	}
	
	//Calculating yi where Miyi = 1 (mod ni)  (congruent)
	public static BigInteger[] calculateYis(int length, BigInteger[] Mis, BigInteger[] mods)
	{
		
		BigInteger[] yis = new BigInteger[length];
		for(int i = 0; i < length; i++)
		{
			try
			{
				yis[i] = Mis[i].modInverse(mods[i]);
			}
			
			catch(Exception e)
			{
				System.out.println("No solution exists.");
				System.out.println("n = " + Mis[i] + ", mod = " + mods[i]);
				System.exit(0);
			}
		}
				
		return yis;
	}
	
	//Calculating the sum of aiMiyi for 0 <= i <= k
	public static BigInteger calculateSum(int length, BigInteger[] numbers, BigInteger[] Mis, BigInteger[] yis)
	{
		BigInteger sum = BigInteger.valueOf(0);
		
		for(int i = 0; i < length; i++)
		{
			sum = sum.add(numbers[i].multiply(Mis[i].multiply(yis[i])));
		}
		return sum;
	}
}
