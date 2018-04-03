import java.util.*;
import java.io.*;

public class Trigram
{
  private String letters = "";
  private int difference = 0;
  private ArrayList<Integer> locations = new ArrayList<Integer>();
  private ArrayList<Integer> factors = new ArrayList<Integer>();;

  //================================================================================================
  Trigram(String trigram, int position)
  {
    letters = trigram;
		locations.add(position);
  }
  //================================================================================================

  //================================================================================================
  public void addLocation(int position)
  {
    locations.add(position);
  }
  //================================================================================================

  //================================================================================================
  public void addFactors(ArrayList<Integer> facts)
  {
    factors = facts;
  }
  //================================================================================================

  //================================================================================================
  public int calcDifference()
  {
    if (locations.size() > 1)
    {
    		for (int i = 1; i < locations.size(); i++)
        {
    			difference += (locations.get(i) - locations.get(i - 1));
    		}
  		}


		return difference;
  }

  public int getDifference()
  {
    return difference;
  }

  public void addDifference(int newDiff)
  {
    difference = newDiff;
  }
  //================================================================================================

  //================================================================================================
  public ArrayList<Integer> getLocations()
  {
		ArrayList<Integer> tempLocations = new ArrayList<Integer>();

		for (Integer n : locations)
    {
			tempLocations.add(n);
		}

		return tempLocations;
  }
  //================================================================================================

  //================================================================================================
  public ArrayList<Integer> getFactors()
  {
    ArrayList<Integer> tempFactors = new ArrayList<Integer>();

		for (Integer n : factors)
    {
			tempFactors.add(n);
		}

		return tempFactors;
  }

  //================================================================================================
  public int getCount()
  {
		return locations.size();
	}
  //================================================================================================

  //================================================================================================
  public String getTrigram()
  {
		return letters;
	}
  //================================================================================================

  //================================================================================================
  public boolean isSingle()
  {
    boolean single = false;

     if(locations.size() <= 1)
     {
       single = true;
     }

     return single;
  }

  public static ArrayList<Trigram> removeSingle(ArrayList<Trigram> trigrams)
  {
		Iterator<Trigram> it = trigrams.iterator();
		while (it.hasNext())
    {
			Trigram tri = it.next();
			if (tri.isSingle())
      {
				it.remove();
			}
		}

		return trigrams;
	}
  //================================================================================================

  //================================================================================================
  public void kasaskiGraphHelper()
  {
    int numFactors = factors.size();
    String facts = "";
    int location1 = locations.get(0);
    int location2 = locations.get(getCount() - 1);

    for(int i = 0; i < numFactors; i++ )
    {
      if(i != numFactors - 1)
      {
        facts += String.format("%-2s* ", factors.get(i));
      }
      else
      {
        facts += String.format("%-2s", factors.get(i));
      }
    }


    System.out.printf("|%-10s|%-5s %-3s %5s|%-3s = %-10s|\n", letters, location1, "and", location2, difference, facts);
  }
}
