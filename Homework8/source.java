
import java.math.BigInteger;
import java.util.*;
//4.18
public class Source {
   public void Source(){};
	public int solve(String cipher) {
		return guessA(cipher);
	}

	//function to find guess, input = encrypted code
	public static int guessA(String input) {
		input = input.replaceAll(" ", "");
		String split[] = input.split("");
		int count = 0;

		String tri[] = new String[input.length() - 2]; // string array of triplets
		int location[] = new int[input.length() - 2];  // location of triplets
		int hits[] = new int[input.length() -2];		// number of hits

		int difference[] = new int[input.length() - 2];		//difference between matches

	//placing letters in pairs of three
		for (int i = 0; i < input.length() - 2; i++) {
			tri[i] = split[i] + split[i + 1] + split[i+2];
			location[i] = i;
		}

	//checking for matches and setting hits
		for(int j = 0; j < input.length() - 2; j++) {
			for (int k = j + 1; k < input.length()-2; k++) {
				if(tri[j].equals(tri[k])) {
					hits[j] = hits[j] + 1;
					difference[j] = location[k] - location[j];
					count = count + 1;
					break;
				}
			}
		}

		String triMatches[] = new String[count]; //array of matched triplets
		int fdif[] = new int[count]; // final difference array
		int index = 0;
		int index2 = 0;
	// store only matches and set distance
		for(int m = 0; m < input.length() -2; m++){
				if (hits[m] > 0) {
					triMatches[index] = tri[m];
					index ++;
				}

				if (difference[m] > 0) {
					fdif[index2] = difference[m];
					index2++;
				}
		}

		//finding the gcd
		int gcdArray[] = new int[count]; // array of gcds
		for (int p = 0; p < count -1; p++) {
			if (fdif[p] != fdif[p+1]) {
				int n1 = fdif[p];
				int n2 = fdif[p+1];
				int gcd = 1;
				for  (int t = 1; t <= n1 && t <= n2;t++) {
					if (n1 % t == 0 && n2 % t == 0) {
						gcd = t;
					}
					gcdArray[p] = gcd;
				}
			}
		}

		//place only gcds with value greater than one in the front of the array
		int x = 0;
		int modeArray[] = new int[count];
		for (int s = 0; s < count; s++) {
			if (gcdArray[s] > 1) {
				modeArray[x] = gcdArray[s];
				x++;
			}
		}

		//create an array of only the gcds greater than 1
		int finalArray[] = new int[x];
		for (int in = 0; in < x; in++) {
			finalArray[in] = modeArray[in];
		}

		//find mode of these gcds
		int guess = calculateMode(finalArray);
		System.out.println("The estimated key length is: " + guess);
		return guess;
	}

	public static int calculateMode(int[] arr)
	{

		int modeCount = 0;	// The count of the mode value
		int mode = 0;		// The value of the mode

		int currCount = 0;
		int currElement;

		// Iterate through all values in our array and consider it as a possible mode
		for (int candidateMode : arr)
		{
			// Reset the number of times we have seen the current value
			currCount = 0;

			// Iterate through the array counting the number of times we see the current candidate mode
			for (int element : arr)
			{
				// If they match, increment the current count
				if (candidateMode == element)
				{
					currCount++;
				}
			}

			// We only save this candidate mode, if its count is greater than the current mode
			// we have stored in the "mode" variable
			if (currCount > modeCount)
			{
				modeCount = currCount;
				mode = candidateMode;
			}
		}

		return mode;
	}

}
