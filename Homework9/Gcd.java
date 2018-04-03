import java.math.BigInteger;
import java.util.*;
//1.12
public class Gcd {

	
	public Gcd() {
		
	}
    public  BigInteger solve(BigInteger a, BigInteger b) {
        // TODO code application logic here

        a = a.abs();
        
   
        b = b.abs();
       
        
        //if a is less than b switch them
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
        
        //(1)
        BigInteger u = BigInteger.valueOf(1);
        BigInteger g = a;
        BigInteger x = BigInteger.valueOf(0);
        BigInteger y = b;
        
        BigInteger[] numbers = getNumbers(a,b,u,g,x,y);
        /*System.out.println("g:" +numbers[0]);
        System.out.println("u:" +numbers[1]);
        System.out.println("v:" +numbers[2]);*/
        return numbers[0];
        
    }
        //(2) if y = 0 , set v =( g−au)/b and return the values (g,u,v)
        public static BigInteger[] getNumbers(BigInteger a,BigInteger b, BigInteger u,BigInteger g,
            BigInteger x,BigInteger y)
        {
            //Part D) SOlution
            if(b.equals(BigInteger.valueOf(0))){
                
                    BigInteger[] nums = new BigInteger[3];
                    nums[0] = a;
                    nums[1] = BigInteger.valueOf(1);
                    nums[2] = BigInteger.valueOf(0);
                return(nums);
            }
            
            while(true){
                
                /*if (y.equals(BigInteger.ZERO))
                  {
                    BigInteger[] nums = new BigInteger[3];
                    BigInteger v = (g.subtract(a.multiply(u))).divide(b);
                    nums[0] = g;
                    nums[1] = u;
                    nums[2] = v;
                    return nums;
                  }*/
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
                    BigInteger[] nums = new BigInteger[3];
                    BigInteger v = (g.subtract(a.multiply(u))).divide(b);
                    nums[0] = g;
                    nums[1] = u.subtract(b.divide(g));
                    nums[2] = v.add(a.divide(g));
                    
                    return nums;
            }
            
}
