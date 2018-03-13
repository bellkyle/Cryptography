import java.math.BigInteger;
import java.util.*;

public class solution{
   static String alphabet = "abcdefghijklmnopqrstuvwxyz";

   public static void main(String[] args) {
      String input;
      Scanner sc = new Scanner(System.in);
      System.out.println("input(please no newlines): ");
      input = sc.nextLine();
      input = input.replaceAll(" ", "");
      String cipher = input;
      Source source = new Source();
      int size = source.solve(cipher);
      String word = "";
      MutIndCo mutual = new MutIndCo();
      int shift[] = mutual.solve(input, size);
      int start = 0;


      for(int j = 0; j < 26; j++){
         word = "";
         for(int i = 0; i < size; i++){
            word += alphabet.charAt((start+shift[i])%26);

         }
         System.out.println(word);
         start++;
      }

      System.out.println("What key would you like to use?");
      input = sc.nextLine();
      decrypt(cipher, input, input.length());
   }

   public static void decrypt(String cipher, String key, int size){

      String shiftAlph[] = new String[size];
      String shifted = "";
      for(int j = 0; j < size; j++){
         shiftAlph[j] = "";
         for(int i = 0; i < alphabet.length(); i++){
            shiftAlph[j] += alphabet.charAt((i+alphabet.indexOf(key.charAt(j)))%alphabet.length());
         }
         System.out.println(shiftAlph[j]);
      }

      for(int i = 0; i < cipher.length(); i++){
         shifted += alphabet.charAt(shiftAlph[i%size].indexOf(cipher.charAt(i)));
      }
      System.out.println(shifted);

   }
}
