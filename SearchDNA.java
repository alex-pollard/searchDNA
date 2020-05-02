/* ID: V00821661 (Alex Pollard)
 * Program Name: SearchDNA
 * Program Description: The program takes an array of DNA chains (in string form) and returns values found within the array.
 * Manual inputs can be entered by changing the value of the array, and outputs are in the form of the printed array and the values found within.
 */
public class SearchDNA{
	
	public static void main(String[] args){
		String[] arr = {"ACTG", "CCTGAA", "ACTTTG", "ATTTCG", "AA", "A", "A", "ATGG", "AA", "ACTG", "ACTG", "A", "AAAAAAAAAAAAAA","AAAAAAAAAAAAAAAAAACCCCCCCCCCCCCCCCCCCCCCCCCCTTTTTTTTTTTTGGGGG"};
		System.out.println("Printed Array:");
		printArray(arr);
		//System.out.println("CONVERTED TO");
		String longest = getLongest(arr);
		System.out.println("The longest DNA chain is " + longest +".");
		String target = "ACTG";
		int frequency = findFrequency(target,arr);
		System.out.println("The amount of times that the chain " + target +" appears without mutations is " + frequency + ".");
		int mutations = countTotalMutations(arr);
		System.out.println("The amount of mutations present in the array is "+ mutations + ".");
		int mutfreq = findFreqWithMutations(target,arr);
		System.out.println("The amount of times that the chain " + target+ " appears with mutations is "+ mutfreq + ".");
		
	}
	//This method prints the passed array, one item per line.
	public static void printArray(String[] arr){
		
		for (int i = 0; i<arr.length; i++){
			System.out.println(arr[i]);
		}
	}
	//This method finds the longest string in the array and prints it. If two strings are the same length, it prints the one that appears first.
	public static String getLongest(String[] arr){
		int topLength=0;
		String longest=null;
		
		for (int i = 0; i<arr.length; i++){
			
			if (arr[i].length()>topLength){
			topLength = arr[i].length();
			longest = arr[i];
			}
		}
		return longest;
		}
	//This method finds the frequency with which a certain string appears, ignoring those that contain mutations.
	public static int findFrequency(String target,String[] arr){
		int amount = 0;
		
		for (int i = 0; i<arr.length; i++){
			
			if (arr[i] == target){
				amount = amount + 1;
			}
		}
		return amount;
	}
	//This method counts the amount of mutated strings by reading the string for a mutation and then moving on to the next string if one or none are found.
	public static int countTotalMutations(String[] arr){
		int amount = 0;
		int x;
		
		for (int i = 0; i<arr.length; i++){
			x = 0;
			arr[i] = arr[i] + " ";
			
			for (int y = 0;y<arr[i].length() && arr[i].charAt(y+1)!=32;y++){
				
				if (arr[i].charAt(y)==arr[i].charAt(y+1)){
					amount = amount + 1;
					y = arr[i].length()+1;
				}
			}
		}
		return amount;
	}
	//This method has two parts. The first removes any mutations from the array, creating a new array with fixed values, then the second finds the amount of times the string appears in the fixed array.
	public static int findFreqWithMutations(String target, String[] arr){
		//target = target + " ";
		for (int i = 0; i<arr.length; i++){
			arr[i] = arr[i] + " ";
			String fixed = "";
			for (int y = 1; y<arr[i].length();y++){
				if (arr[i].charAt(y-1)!=arr[i].charAt(y)){
					fixed = fixed + arr[i].charAt(y-1);
					//System.out.println(fixed);
				}
				
			}
			arr[i]=fixed;
			//System.out.println(arr[i]);
		}
		
		int amount = 0;
		String[] fixed = new String[arr.length];
		for (int i = 0; i<arr.length; i++){
			fixed[i]=arr[i];
			//System.out.println(fixed[i]);
			//System.out.println("work please");
			if (fixed[i].equals(target)){
				
				//System.out.println("success");
				amount = amount + 1;
			}
			else {
				//System.out.println(fixed[i] + " does not equal "+ target);
			}
		}
		return amount;
	}
}
