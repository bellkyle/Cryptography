
import java.util.Scanner;
import java.math.BigInteger;
import java.util.*;





public class Congruent {

    public Congruent() {
    	
    }
    public BigInteger solve(int cases, ArrayList<BigInteger> x, ArrayList<BigInteger> q, ArrayList<BigInteger> e) {
        
		BigInteger[] numbers = new BigInteger[cases];
		BigInteger[] mods = new BigInteger[cases];  
		System.out.println(cases);
		for(int i = 0; i < x.size(); i++) {
			numbers[i] = x.get(i);
			mods[i] = pow(q.get(i), e.get(i));
		}
		            
                       
                
                //---------------------
                //Find u
                //BigInteger u = BigInteger.valueOf(1);
                
                //BigInteger x1 = BigInteger.valueOf(0);
                //our a is Mis
               // BigInteger M = BigInteger.valueOf(0);
                //int length = numbers.length;
                //BigInteger [] Mis = calculateMis(length, M, mods);
               // BigInteger g = numbers[0];
                //our b mods[i]
                //BigInteger y = numbers[1];
                
               // BigInteger numberU = getU(numbers[0],numbers[1],u,g,x1,y);
                
                
                
                
                
		//-----------------------
		//output of method here
        return calculateX(numbers, mods);
		//System.out.println("X = " + calculateX(numbers, mods));
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
	//Not complete waiting for Extended Euclidean Algorithm to be completed
	//Not sure what algorithm modInverse uses for BigInteger 
	public static BigInteger[] calculateYis(int length, BigInteger[] Mis, BigInteger[] mods)
	{
		/*BigInteger[] yis = new BigInteger[length];
		int temp = 0;
		
		//I believe this will be used after the gcd is calculated
		for(int i = 0; i < length; i++)
		{
			for(int j = 0; j < mods[i].intValue(); j++)
			{
				if((Mis[i].multiply(BigInteger.valueOf(j)).mod(mods[i])).compareTo(BigInteger.ONE) == 0)
				{
					temp = j;
					j = mods[i].intValue();
				}
			}
			yis[i] = BigInteger.valueOf(temp);
		}
		*/
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
        
        
        
        public static BigInteger getU(BigInteger a,BigInteger b, BigInteger u,BigInteger g,
            BigInteger x,BigInteger y)
        {
        int compare = a.compareTo(b);
        if(compare == -1)
        {
           BigInteger temp1 = BigInteger.valueOf(0);
           BigInteger temp2 = BigInteger.valueOf(0);
           temp1 = a;
           temp2 = b;
           
           a = temp2;
           b = temp1;
        }
        //Part D) SOlution
            if(b.equals(BigInteger.valueOf(0))){
                return BigInteger.valueOf(1);
            }
            
            while(true){
                if (y.equals(BigInteger.ZERO))
                    break;
                  else{
                      //(3) Divide g by y with remainder, g = qy + t, with 0 ≤ t< y
                      BigInteger q = BigInteger.valueOf(0);
                      BigInteger t = BigInteger.valueOf(0);
                      
                      //remainder
                      t = g.remainder(y);
                      //qutotient
                      q = g.divide(y);
                      
                      //g = qy + t
                      //g = q.multiply(y).add(t);
                     
                      //(4) Set s = u−qx
                      BigInteger s = BigInteger.valueOf(0);
                      s = u.subtract(q.multiply(x));
                      //System.out.println(s);

                      //(5)Set u = x and g = y
                      u = x;
                      g = y;
                      
                      //(6) Set x = s and y = t
                      x = s;
                      y = t;
                      
                     }
                    
                }
                /*//Part A) solution
                    BigInteger[] nums = new BigInteger[3];
                    BigInteger v = (g.subtract(a.multiply(u))).divide(b);
                    nums[0] = g;
                    nums[1] = u;
                    nums[2] = v;
                 */
                //Part E) Solution
                    /*BigInteger[] nums = new BigInteger[3];
                    BigInteger v = (g.subtract(a.multiply(u))).divide(b);
                    nums[0] = g;*/
                    BigInteger numberU = u.subtract(b.divide(g));
                    //nums[2] = v.add(a.divide(g));
                    
                    return numberU;
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
