import java.util.*;
import java.io.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;


public class Homework8
{

  public static ArrayList<Trigram> createTrigrams(String input, int numOfTrigrams)
  {
    HashMap<String, Trigram> trigramMap = new HashMap<String, Trigram>();
		String substr = "";
    int newNumTrigram = 0;

		// Fill HashMap with all trigrams
		for (int i = 0; i < numOfTrigrams; i++)
    {
			substr = input.substring(i, i + 3);
			if (trigramMap.containsKey(substr))
      {
				trigramMap.get(substr).addLocation(i);
			}
      else
      {
				trigramMap.put(substr, new Trigram(substr, i));
			}
		}

		// Convert HashMap to ArrayList for working with the values
		ArrayList<Trigram> trigrams = new ArrayList<Trigram>(trigramMap.values());

		// Remove all substrings with only single occurrence
		trigrams = Trigram.removeSingle(trigrams);

    return trigrams;
  }

  public static int kasaski(String input, ArrayList<Trigram> trigrams, int numOfTrigrams)
  {
    HashMap<Integer, Integer> factorOccurances = new HashMap<Integer, Integer>();
    int diff = 0;
    int numFactors = 0;
    //int count = 0;
    int highestFact = 0;
    ArrayList<Integer> factors;

    for(int i = 0; i < numOfTrigrams; i++)
    {
    	diff = trigrams.get(i).calcDifference();
    	factors = calcPrimeFacts(diff);
    	trigrams.get(i).addFactors(factors);

    }

    for(int i = 0; i < numOfTrigrams; i++)
    {
      factors = trigrams.get(i).getFactors();
      numFactors = factors.size();
      for(int j = 0; j < numFactors; j++)
      {
        int inner = factors.get(j);
        if (factorOccurances.containsKey(inner))
           {
						Integer temp = factorOccurances.get(inner);
						factorOccurances.put(inner, ++temp);
					 }
          else
          {
						factorOccurances.put(inner, 1);
					}
      }
    }








  System.out.println("Hash Table: ");
  for (Map.Entry<Integer, Integer> entry : factorOccurances.entrySet())
  {
    int key = entry.getKey();
    int value = entry.getValue();

    System.out.println ("Key: " + key + " Value: " + value);
  }

  int keyLength = estimateKeyLength(factorOccurances);
  kasaskiGraph(trigrams, numOfTrigrams);




    return keyLength;
  }

  //================================================================================================

  //================================================================================================
  public static int estimateKeyLength(HashMap<Integer, Integer> occurances)
  {
		Set<Integer> keys = occurances.keySet();
		Integer maxKey = 0;
		Integer maxFreq = 0;

		for (Integer key : keys)
    {
			Integer freq = occurances.get(key);
			if (freq >= maxFreq)
      {
				maxFreq = freq;
				maxKey = key;
			}
		}

		return maxKey;

	}

  //================================================================================================
  public static void kasaskiGraph(ArrayList<Trigram> trigrams, int numOfTrigrams)
  {
    Trigram tempTri;


    System.out.println("\n             Kasaski Graph");
    System.out.println("=============================================");
    System.out.println("| Trigrams |    Appears    |   Differnce    |");
    System.out.println("|==========|===============|================|");

    for(int i = 0; i < numOfTrigrams; i++)
    {
      tempTri = trigrams.get(i);
      tempTri.kasaskiGraphHelper();
    }

    System.out.println("=============================================\n");

  }
  //================================================================================================


  //================================================================================================
  public static ArrayList<Integer> calcPrimeFacts(int num)
  {
  		ArrayList<Integer> factors = new ArrayList<Integer>();
  		int n = num;
  		for (int i = 2; i <= n / i; i++) {
  			while (n % i == 0) {
  				factors.add(i);
  				n /= i;
  			}
  		}
  		if (n > 1) {
  			factors.add(n);
  		}
  		return factors;
  }

    //================================================================================================
    public static String clean(String input)
    {
      String cleanInput = input.replaceAll("\\s+","");
      return cleanInput;
    }
    //================================================================================================


    public static int[] letterFrequency(String input)
    {
		    int[] frequencies = new int[26];

		      input = clean(input);

		   for (int i = 0; i < input.length(); i++)
       {
			      frequencies[input.charAt(i) - 'a']++;
		   }

		    return frequencies;
	     }

       public static double calcIC(int[] frequencies) {
		double ic = 0;
		int sum = 0;
		for (int i = 0; i < frequencies.length; i++) {
			sum += frequencies[i];
		}

		for (int i = 0; i < frequencies.length; i++) {
			double top = frequencies[i] * (frequencies[i] - 1);
			double bottom = sum * (sum - 1);
			ic += top / bottom;
		}
		return ic;
	}

  public static double estimateKeyLengthIC(String input) {
    int frequency[] = letterFrequency(input);
    double ic = calcIC(frequency);
		double top = 0.027 * input.length();
		double bottom = (input.length() - 1) * ic - 0.038 * input.length()
				+ 0.065;
		return top / bottom;
}

  public static void icGraph(String input)
  {
    System.out.println("\n             IC Graph");
    System.out.println("=============================================");
    System.out.println("| Key LNGT |  AVG index    |   IOC          |");
    System.out.println("|==========|===============|================|");

    for(int i = 4; i < 10; i++){
      String subInput = input.substring(0, i -1);
      double icKeyLength = estimateKeyLengthIC(subInput);
      System.out.printf("|%-10s|%-5s %.3s %5s|%-3s = %-10s|\n", i, "", -icKeyLength, "", "", "");
      System.out.println("|==========|===============|================|");
  }

}

public static String estimateKey(String ciphertext, int keyLength) {
		String separatedCipher[] = new String[keyLength];
		String key = "";

		for (int i = 0; i < keyLength; i++) {
			separatedCipher[i] = "";
		}

		for (int i = 0; i < ciphertext.length(); i++) {
			separatedCipher[i % keyLength] += ciphertext.charAt(i);
		}

		for (int i = 0; i < keyLength; i++) {
			int[] freq = letterFrequency(separatedCipher[i]);
			key += (char)((freq[25] - 4) + 'a');
		}

		return key;
	}

    //================================================================================================
    public static void main(String[] args)
    {
      String input =    "mgodt beida psgls akowu hxukc iawlr csoyh prtrt udrqh cengx " +
                        "uuqtu habxw dgkie ktsnp sekld zlvnh wefss glzrn peaoy lbyig " +
                        "uaafv eqgjo ewabz saawl rzjpv feyky gylwu btlyd kroec bpfvt " +
                        "psgki puxfb uxfuq cvymy okagl sactt uwlrx psgiy ytpsf rjfuw " +
                        "igxhr oyazd rakce dxeyr pdobr buehr uwcue ekfic zehrq ijezr " +
                        "xsyor tcylf egcy";

      input = clean(input);
      int numOfTrigrams = input.length() - 2;
      ArrayList<Trigram> trigrams = createTrigrams(input, numOfTrigrams);

      numOfTrigrams = trigrams.size();

      int kasaskiKeyLength = kasaski(input, trigrams, numOfTrigrams);


      String subInput = input.substring(0,25);
      double icKeyLength = estimateKeyLengthIC(subInput);

      icGraph(input);

      System.out.println("Kasaki Key Length: " + kasaskiKeyLength);

      System.out.println("IC Key Length: " + -icKeyLength);

      System.out.println("Key: " + estimateKey(input, kasaskiKeyLength));

  }
}
