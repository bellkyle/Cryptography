import java.math.BigInteger;
import java.util.*;

public class MutIndCo{
   static class Mutual{
      public int i;
      public int j;
      public double value;
      public int shiftRelation;
      void Mutual(){
         i =0;
         j = 0;
         value = 0;
         shiftRelation = 0;
      }
      void setMutual(int i, int j, double value, int shiftRelation){
         this.i = i;
         this.j = j;
         this.value = value;
         this.shiftRelation = shiftRelation;
      }
   }
   static String alphabet = "abcdefghijklmnopqrstuvwxyz";
   public void MutIndCo(){};
   public int[] solve(String ciphertext, int wordSize) {
      String cipher = ciphertext;
      cipher = cipher.replaceAll(" ", "");
      int size = wordSize;
      String s[] = new String[size];
      for(int i = 0; i < size; i++){
         s[i] = "";
      }
      int subStringIndex = 0;
      while(subStringIndex < size){
         for(int i = subStringIndex; i < cipher.length(); i +=size){
            if(i < cipher.length())
               s[subStringIndex] += cipher.charAt(i);
         }
         subStringIndex++;
      }

      int start = 0;
      int start2 = 1;
      int shift;
      //ArrayList mutual = new ArrayList();
      Mutual mutual[] = new Mutual[100];
      int mutualIndex = 0;
      double value;
      //find the largest in the table for each i and j
      for(int i = 0; i < (size-1); i++){
         for(int j = start2; j < size; j++){
            value = mutualShifts(s[i],s[j]);
            shift = findShift(s[i],s[j],value);
            mutual[mutualIndex] = new Mutual();
            mutual[mutualIndex].setMutual(i, j, value, shift);
            //System.out.println(mutual[mutualIndex].i+ " " + mutual[mutualIndex].j + " " + mutual[mutualIndex].value + " " + mutual[mutualIndex].shiftRelation);
            mutualIndex++;
         }
         start2++;
      }


      int linearIndex = 0;
      int variable1[] = new int[50];
      int variable2[] = new int[50];
      int shiftRelation[] = new int[50];
      boolean flag[] = new boolean[size];
      flag[0] = true;
      for(int i = 1; i < size; i++){
         flag[i] = false;
      }
      //find the values that are greater than 0.065
      for(int i = 0; i < mutualIndex; i++){
         if(mutual[i].value >= 0.065){
            variable1[linearIndex] = mutual[i].i;
            variable2[linearIndex] = mutual[i].j;
            shiftRelation[linearIndex] = mutual[i].shiftRelation;
            flag[mutual[i].j] = true;
            //System.out.println(variable1[linearIndex] + " " + variable2[linearIndex] + " " + shiftRelation[linearIndex]);
            linearIndex++;
         }

      }

      double large = 0;
      for(int i = 0; i < size; i++){

         if(!flag[i]){

            for(int j = 0; j < mutualIndex; j++){
               //System.out.println(flag[i] + " " + mutual[j].i + " " + i);
               if(mutual[j].j == i && !flag[i]){
                  large = mutual[j].value;
                  variable1[linearIndex] = mutual[j].i;
                  variable2[linearIndex] = mutual[j].j;
                  shiftRelation[linearIndex] = mutual[j].shiftRelation;
                  flag[i] = true;

               }
               else if(mutual[j].j == i){
                  if(mutual[j].value > large){
                     large = mutual[j].value;
                     variable1[linearIndex] = mutual[j].i;
                     variable2[linearIndex] = mutual[j].j;
                     shiftRelation[linearIndex] = mutual[j].shiftRelation;
                     //System.out.println(variable1[linearIndex] + " " + variable2[linearIndex] + " " + shiftRelation[linearIndex]);
                     //flag[i] = true;
                  }
               }

            }
            if(flag[i])
               linearIndex++;

         }
      }
      //for(int i = 0; i < linearIndex; i++){
      //  System.out.println(variable1[i] + " " + variable2[i] + " " + shiftRelation[i]);
      //}
      //check to make sure all strings are accounted for
      return linearEquations(variable1, variable2, shiftRelation, size, linearIndex);
   }


   public static int[] linearEquations(int[] variable1, int[] variable2, int[] shiftRelation, int size, int index){
      int shift[] = new int[size];
      shift[0] = 0;
      boolean found[] = new boolean[size];
      for(int i = 0; i < size; i++){
         found[i] = false;
      }
      int count = 0;

      while(count < size-1){

         for(int i = 0; i < index; i++){

            if(variable1[i] == 0 && count == 0){
               shift[variable2[i]] = 26 - shiftRelation[i];
               found[variable2[i]] = true;
               count++;
            }
            else if(variable1[i] != 0 && !found[variable2[i]]){
               //System.out.println("ld" + variable2[i]+ " " + variable1[i] + " " + shiftRelation[i] + " " +shift[variable1[i]]);
               if(found[variable1[i]]){
                  shift[variable2[i]] = shift[variable1[i]] - shiftRelation[i];
                  //System.out.println(shift[variable2[i]]+ "= " + shift[variable1[i]]+ " - " +shiftRelation[i]);
                  if(shift[variable2[i]] < 0){
                     shift[variable2[i]] += 26;
                  }
                  found[variable2[i]] = true;
                  count++;
               }
            }
            //System.out.println(shift[variable2[i]]+ "= " + shift[variable1[i]]+ " - " +shiftRelation[i]);
         }
      }
      System.out.println("The Relative rotations are: ");
      for(int i = 0; i < size; i++){
         System.out.println(shift[i]);
      }
      return shift;
   }

   //finds the amount a mutual index of coincidence is shifted
   public static int findShift(String s, String t, double mutual){

      for(int i = 0; i < 26; i++){
         if(mutual == mutualIndex(s,shiftString(t,i)))
            return i;
      }
      return 0;
   }

   //finds the largest mutual index of coincidence of two strings while being shifted
   public static double mutualShifts(String s, String t){
      double mutual[] = new double[26];
      for(int i = 0; i < 26; i++){
         mutual[i] = mutualIndex(s,shiftString(t,i));
      }
      return largest(mutual);
   }

   //method to find largest number
   public static double largest(double[] x){
      double large = 0;
      for(int i = 0; i < x.length; i++){
         if(x[i] > large)
            large = x[i];
      }
      return large;
   }

   //method to find the individual mutual index of coincidence for a string
   public static double mutualIndex(String s, String t){
      double sum = 0;
      for(int i = 0; i < 26; i++){
         sum += numberOf(alphabet.charAt(i), s) * numberOf(alphabet.charAt(i), t);
      }
      return sum/(s.length()*t.length());
   }

   //find the number of a certain character in a string
   public static int numberOf(char character, String s){
      int count = 0;
      for(int i = 0; i < s.length(); i++){
         if(character == s.charAt(i))
            count++;
      }
      return count;
   }

   //method to shift a string by a certain amount
   public static String shiftString(String s, int shift){
      String shiftAlph = "";
      String shifted = "";
      for(int i = 0; i < alphabet.length(); i++)
      {
         shiftAlph += alphabet.charAt((i+shift)%alphabet.length());
      }

      for(int i = 0; i < s.length(); i++){
         shifted += shiftAlph.charAt(alphabet.indexOf(s.charAt(i)));
      }
      return shifted;
   }


}
