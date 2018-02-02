
import java.util.*;
import java.math.*;

public class Homework_2
{
	public static void problem132()
	{
		System.out.println( primitiveCheck( 2, 7 ) + "\t" + primitiveCheck( 2, 13 ) + "\t" + primitiveCheck( 2, 19 ) + "\t" + primitiveCheck( 2, 23 ) );
		System.out.println( primitiveCheck( 3, 5 ) + "\t" + primitiveCheck( 3, 7 ) + "\t" + primitiveCheck( 3, 11 ) + "\t" + primitiveCheck( 3, 17 ) );
		
		System.out.println( allPrimitiveValues(23).toString() );
		System.out.println( allPrimitiveValues(29).toString() );
		System.out.println( allPrimitiveValues(41).toString() );
		System.out.println( allPrimitiveValues(43).toString() );
		
		System.out.println( allPrimitiveValues(11).toString() + "\tcount = " + allPrimitiveValues(11).size() );
		
		System.out.println( allPrimitiveValues(229).toString() + "\tcount = " + allPrimitiveValues(229).size() );
		
		System.out.print("Primes less than 100 with 2 as a primitive root : ");
		for(int i = 3; i < 100; i++)
			if( primeCheck(i) )
				if( primitiveCheck(2,i) )
					System.out.print(i+", ");
		System.out.println();
		
		System.out.print("Primes less than 100 with 3 as a primitive root : ");
		for(int i = 4; i < 100; i++)
			if( primeCheck(i) )
				if( primitiveCheck(3,i) )
					System.out.print(i+", ");
		System.out.println();
		
		System.out.print("Primes less than 100 with 4 as a primitive root : ");
		for(int i = 5; i < 100; i++)
			if( primeCheck(i) )
				if( primitiveCheck(4,i) )
					System.out.print(i+", ");
		System.out.println();
	}
	
	public static void problem136()
	{
		for(int i = 3; i <= 20; i++)
		{
			if( primeCheck(i) )
				System.out.println( "2 ^ (" + i + "-1)/2 (mod " + i + ") = " + Math.pow( 2.0, (i-1.0)/2.0 ) % i );
		}
	}
	
	public static boolean primeCheck( int n )
	{
		for(int i = 2; i < n; i++)
			if( n % i == 0 )
				return false;
		return true;
	}
	
	public static boolean primitiveCheck( int possible, int mod )
	{
		boolean[] values = new boolean[mod];
		int power = possible;
		
		for(int i = 1; i < mod; i++)
		{
			power = power * possible % mod;
			if( values[ power ] == false)
				values[ power ] = true;
			else
				return false;
		}
		
		return true;
	}
	
	public static ArrayList<Integer> allPrimitiveValues( int prime )
	{
		ArrayList<Integer> retset = new ArrayList<Integer>();
		for(int i = 2; i < prime; i++)
			if( primitiveCheck(i,prime) )
				retset.add(i);
		return retset;
	}
	
	
	
	public static void main(String[] args)
	{
		problem132();
		problem136();
	}
}