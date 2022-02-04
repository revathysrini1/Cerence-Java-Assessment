import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AlgorithmQuestionV1 {
	
	/**
	 * This method displays the final result matching the format ["tailor" (tail+or), "hotdog" (hot+dog)]
	 * Currently System.out.print is used which can be replaced by Logger or anyother format.
	 * @param displayResult
	 * @param lword
	 */
	
	public static void displayResult(HashMap<String,String> displayResult, List<String> lword)
	{
		
		
		StringBuffer displayVal = new StringBuffer();
		
		for (Map.Entry<String, String> entry : displayResult.entrySet()) {
			displayVal.append("\"" + entry.getKey() + "\" (" + entry.getValue() + "),") ;
		
		}
		displayVal.deleteCharAt(displayVal.length()-1);  
		System.out.println("Output for the array inputs  "+lword);
		System.out.print("[");
		System.out.print(displayVal.toString());
		System.out.print("]");
	}
	
	
	/**
	 * This method determines if a word formed of two smaller words in the input exist
	 * Adds the final results to Hashmap for display
	 * @param permutationComb1
	 * @param permutationComb2
	 * @param lword
	 * @return HashMap
	 */
	
	public static HashMap<String,String>  compareAlgorithm(ArrayList<String> permutationComb1 , ArrayList<String> permutationComb2 ,List<String> lword )
	{
		
		HashMap<String,String> finalMap=new HashMap<String,String>();
		
		
		
		// this for loop adds words of Length N to the map
		for (String str2:permutationComb1) {
			
			
			if(lword.contains(str2))
			{
				finalMap.put(str2, str2);
			}
			
	
	}
	
		// this for loop adds words formed by adding two smaller words to the hashmap
		for (String str1:permutationComb2) {
			
			
				String temp = str1.replace("+", "");
			
				if(lword.contains(temp))
				{
					finalMap.put(temp, str1);
				}
				
		
		}
	

		return finalMap;
		
		
		
	}
	
	
	/**
	 * This is the main function to determine the algorithm
	 * @param lword
	 * @param nsize
	 */
	
	public static void determineAlgorithm(List<String> lword , int nsize)
	{
		
		
		
		
		ArrayList<String> permutationComb1=new ArrayList();
		ArrayList<String> permutationComb2=new ArrayList();
		

		
		for(String index : lword)
		{
			for(String jIndex : lword)
			{
				String temp1 = index;
				if(index == jIndex) 
				{
					if((index).length() == nsize)
						permutationComb1.add(index);
					
				}
				else {
					
					
					
					if((index+jIndex).length() == nsize)
					{
						
						
						permutationComb2.add((index + "+" + jIndex ));
					}
					
					
				} // else ends 
			}
		}
		
		//System.out.println(permutationComb);
		
		HashMap<String,String> finalMap =	compareAlgorithm(permutationComb1, permutationComb2 ,lword);
		if(finalMap.size() > 0)
			displayResult(finalMap, lword);
		else
			System.out.println("There are no matching criterias in the input list");
		
	}
	

	public static void main(String[] args) {
		
		System.out.println ( "This program has the algorithm to print words from list that:");
		System.out.println( "- are of length N");
		System.out.println( "- are formed from two smaller words from list");
		System.out.println();
		System.out.println("It takes Input N - length for comparison , Length Of Array and String of Array ");
		System.out.println();
		System.out.println("Sample :");
		System.out.println("Please enter Length Of N for the algorithm . It is a positive number greater than 0: --> 6"  );
		System.out.println("Please enter Length Of array: --> 3"  );
		System.out.println("Please enter the array of strings for the algorithm"  );
		System.out.println("tail");
		System.out.println("or");
		System.out.println("tailor");
		System.out.println();
		System.out.println("Output for the array inputs  [tail, or, tailor] ");
		System.out.println("[\"tailor\" (tail+or)]");
		
		System.out.println();System.out.println();
		
		
		System.out.println("----------------------------------------------");
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		int NofAlgorithm = 0;
		int lengthofarray = 0;
		
        
        System.out.println("Please enter Length Of N for the algorithm . It is a positive number greater than 0: ");
        try {
        	NofAlgorithm = scanner.nextInt();
        }
        catch(Exception e)
        {
        	System.out.println(" Length N for the algorithm must be an Integer number.");
        	System.exit(0);
        }
        if(NofAlgorithm <=0)
        {
        	System.out.println(" Length N for the algorithm must be an Integer number greater than 0.");
        	scanner.close();
        	System.exit(0);
        }
        
        System.out.println("Please enter Length Of array: ");
        try {
         lengthofarray = scanner.nextInt();
        }
        catch(Exception e)
        {
        	System.out.println(" Length N for the algorithm must be an Integer number ");
        	scanner.close();
        	System.exit(0);
        }
        
        if(lengthofarray <=0)
        {
        	System.out.println(" Length of the array must be an Integer number greater than 0.");
        	scanner.close();
        	System.exit(0);
        }
        List <String> lword = new ArrayList<String>(lengthofarray);

		System.out.println("Please enter the array of strings for the algorithm");
		
		
		for(int i =0 ; i <= lengthofarray ; i++)
		{
		
			lword.add(scanner.nextLine().trim());
		}
		lword.remove(0);
		
		determineAlgorithm(lword, NofAlgorithm);
		

	}

}
