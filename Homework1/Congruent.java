package congruency;
import java.util.Scanner;
//import java.math.BigInteger;

/*
 * Notes: 	The inputs are of form x = a (mod n)
 * 			M = n1n2...nk where k is the number of inputs
 * 			x = a1M1y1 + a2M2y2 + ... + akMkyk (mod M)
 * 			Mi = M/ni
 * 			Miyi = 1 (mod ni)
 * 
 * 			Also, I have not worked much with Big Integer so this program 
 * 			does not use Big Integers, but the functionality will need to be
 * 			added prior to submission.  Feel free to alter the code to work
 * 			with Big Integers while I am learning about them.
 * 
 * 			I am having trouble calculating the y's because you have to solve
 * 			for the inverse.  I believe that the Extended Euclidean Algorithm
 * 			is used to solve this.
 * 
 */
public class Congruent {

	public static void main(String[] args) {
		int cases = 0;
		Scanner input = new Scanner(System.in);
		
		//Getting user input
		System.out.println("Enter number of congruencies you want to solve: ");
		cases = input.nextInt();
		
		int[] numbers = new int[cases];
		int[] mods = new int[cases];
		
		for(int i = 0; i < cases; i++)
		{
			System.out.println("Enter a number: ");
			numbers[i] = input.nextInt();
			
			System.out.println("Enter the modulo: ");
			mods[i] = input.nextInt();
		}
		input.close();
		
		//output of method here
		System.out.println("X = " + calculateX(numbers, mods));
	}

	//Calculating X where X = a1M1y1 + a2M2y2 + ... + akMkyk (mod M)
	public static int calculateX(int[] numbers, int[] mods)
	{
		//variables
		int length = numbers.length;
		int M = 0;
		int sum = 0;
		int[] Mis = new int[length];
		int[] yis = new int[length];
		
		M = calculateM(length, mods);
		
		Mis = calculateMis(length, M, mods);
		
		yis = calculateYis(length);

		sum = calculateSum(length, numbers, Mis, yis);
		
		//Returning X
		return sum % M;
	}
	
	//Calculating M where M = n1n2...nk
	public static int calculateM(int length, int[] mods)
	{
		int M = 1;
		
		for(int i = 0; i < length; i++)
		{
			M = M * mods[i];
		}
		return M;
	}
	
	//Calculating Mi where Mi = M/ni
	public static int[] calculateMis(int length, int M, int[] mods)
	{
		int[] Mis = new int[length];
		
		for(int i = 0; i <length; i++)
		{
			Mis[i] = M / mods[i];
		}
		return Mis;
	}
	
	//Calculating yi where Miyi = 1 (mod ni)  (congruent)
	//Not complete waiting for Extended Euclidean Algorithm to be completed
	public static int[] calculateYis(int length)
	{
		int[] yis = new int[length];
		return yis;
		
		//Calculating yi where Miyi = 1 (mod ni)  (congruent)
				/*
				for(int i = 0; i < length; i++)
				{
					/*
					 y = Mis[i] % mods[i];
					
					if((y*y) % mods[i] == 1)
						yis[i] = y;
					//This is not calculating the inverse for all values
					else
						yis[i] = (mods[i] + 1) / y;
					
					y = Mis[i] % mods[i];
					
					if(Mis[i] > mods[i])
						yis[i] = (mods[i] + 1) / y;
					else
						yis[i] = ((numbers[i] * mods[i]) + 1) / Mis[i];
					System.out.println(yis[i]);
				}
				*/
	}
	
	//Calculating the sum of aiMiyi for 0 <= i <= k
	public static int calculateSum(int length, int[] numbers, int[] Mis, int[] yis)
	{
		int sum = 0;
		
		for(int i = 0; i < length; i++)
		{
			sum = sum + (numbers[i] * Mis[i] * yis[i]);
		}
		return sum;
	}
}
