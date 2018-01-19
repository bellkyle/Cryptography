package gcd;
import java.math.BigInteger;
import java.util.*;

/**
 *
 * @author Jesus
 */
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
        
        //(2) if y = 0 , set v =( g−au)/b and return the values (g,u,v)
        if (y.equals(BigInteger.ZERO))
        {
            BigInteger v = (g.subtract(a.multiply(u))).divide(b);
            System.out.println(v);
        }
    }
    
}
