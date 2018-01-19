package gcd;
import java.math.BigInteger;
import java.util.*;

public class Gcd {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number a: ");
        BigInteger a;
        a = BigInteger.valueOf(input.nextInt());
        System.out.print("Enter number b: ");
        BigInteger b;
        b = BigInteger.valueOf(input.nextInt());
        
        //(1)
        BigInteger u = BigInteger.valueOf(1);
        BigInteger g = a;
        BigInteger x = BigInteger.valueOf(0);
        BigInteger y = b;
        
        BigInteger[] numbers = getNumbers(a,b,u,g,x,y);
        System.out.println("g:" +numbers[0]);//nullpointer exception
        System.out.println("u:" +numbers[1]);
        System.out.println("v:" +numbers[2]);
        
        
        //(3) Divide g by y with remainder, g = qy + t, with 0 ≤ t< y
        
        
        
    }
    
    
       
        //(2) if y = 0 , set v =( g−au)/b and return the values (g,u,v)
        public static BigInteger[] getNumbers(BigInteger a,BigInteger b, BigInteger u,BigInteger g,
            BigInteger x,BigInteger y)
        {
                  if (y.equals(BigInteger.ZERO))
             try {
                BigInteger[] nums = new BigInteger[2];
                BigInteger v = (g.subtract(a.multiply(u))).divide(b);
                nums[0] = g;
                nums[1] = u;
                nums[2] = v;
                return nums; //return g,u,v in array
             }
         catch ( ArithmeticException e) {
             System.out.println("Error! division by zero");
         }
        return null; //maybe
    }
            
}