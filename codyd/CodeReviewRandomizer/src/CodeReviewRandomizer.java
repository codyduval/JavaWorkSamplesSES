import java.util.*;

public class CodeReviewRandomizer {
	
	public static void main(String[] args) {
		String[] nameList = {"Cody", "Davis", "Mansi", "Dann", "Jose", "RyanBy", "RyanBl", "Parker"};
		assignPartners(randomizeNames(nameList));
	}
			
	public static ArrayList<String> randomizeNames(String[] names){
		int arrayLength = names.length;
		Random rand = new Random();
		ArrayList<String> randomizedNameList = new ArrayList<String>();
		for (int i=0; i<arrayLength; i++) {
			while(true) {
				Integer next = rand.nextInt(arrayLength);
				String temp = names[next];
				if (!randomizedNameList.contains(temp)) {
					randomizedNameList.add(temp);
					break;
				}
			}	
		}
        return randomizedNameList;
	}
		
	public static Map<Integer, String> assignPartners(ArrayList<String> randomizedNames) { 
		int arrayLength = randomizedNames.size();
		Map<Integer, String> partnerTable = new HashMap<Integer, String>();
		String tempTeam = new String();
		for (int i=0; i<=arrayLength/2; i++) {
			if (i > (arrayLength-1-i)) {
				break;
			}
			String firstName = randomizedNames.get(i);
			String secondName = randomizedNames.get(arrayLength-1-i);
			if (firstName.equals(secondName)) {
				String thirdName = firstName;
				tempTeam = tempTeam + " and " + thirdName;
				partnerTable.put(i-1,tempTeam);
			}
			else {
				tempTeam = firstName + " and " + secondName;
				partnerTable.put(i,tempTeam);
			}
		}
		System.out.println(partnerTable);
		return partnerTable;
	}   
}
