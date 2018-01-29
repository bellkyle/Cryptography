import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Crypt_hw2_E {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = 2;
        int counter = 0;

        System.out.println("Enter a prime number, p:");
        int prime = reader.nextInt();
        int num = prime - 1;
        System.out.println("All primitive roots modulo " + prime + " are listed below\n");

        while (n < prime) {
            int[] array = new int[num];
            Boolean found = false;
            int x = (int) Math.pow(n, 0);
            int val = x % prime;

            for (int i=0; i < num; i++) {
                if (i > 0) {
                    x = x * n;
                    val = x % prime;
                }

                for (int z=0; z<array.length; z++) {
                    if (array[z] == val) {
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    array[i] = val;
                    x = val;
                }
                else
                    break;
            }

            if (!found) {
                System.out.println(n);
                counter++;
            }

            n++;
        }

        System.out.println("\n" + prime + " has " + counter + " primitive roots");
    }
}