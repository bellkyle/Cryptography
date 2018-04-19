package lenstra;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.Random;


public class Lenstra {
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter N to be factored");
        BigInteger N;
        N = input.nextBigInteger();
        
        BigInteger a;
        BigInteger b;
        
        a = getRandomPoints();
        b = getRandomPoints().mod(N);
        System.out.println("P = ("+a +"," +b +")");
        
        BigInteger A;
        A = getRandomA();
        
        BigInteger B;
        B = (b.pow(2).subtract(a).pow(3).subtract(A).multiply(a)).mod(N);
        System.out.println("B: " +B);
    }
    
    public static BigInteger getRandomPoints() {
        Random rand = new Random();
        BigInteger result = new BigInteger(13, rand); //(2^x - 1) max value
        return result;
    }
    
    public static BigInteger getRandomA() {
        Random rand = new Random();
        BigInteger result = new BigInteger(4, rand); //(2^x - 1) max value
        return result;
    }
    
}
