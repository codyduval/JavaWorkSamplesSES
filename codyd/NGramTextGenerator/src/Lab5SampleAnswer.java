import java.util.Hashtable;

public class Lab5SampleAnswer {

    public static Hashtable<Character, Integer> buildCharacterCountsForString(String s) {
        Hashtable<Character, Integer> characterCounts = new Hashtable<Character, Integer>();

        // Count characters in the string
        for (int i = 0; i < s.length(); i++) {
            Character noteCharacter = new Character(s.charAt(i));
            Integer count = characterCounts.get(noteCharacter);
            count = count == null ? new Integer(1) : new Integer(count.intValue() + 1);

            characterCounts.put(noteCharacter, count);
        }
        return characterCounts;
    }

    public static void main(String[] args) {
        String note = "foobar";
        String magazine = "foobarfoobarq";

        magazine = magazine.replaceAll("\\s","");
        note = note.replaceAll("\\s","");

        // Print 'true' if the magazine has sufficient characters to build the note
        // Print 'false' if  it does not
        Hashtable<Character, Integer> noteCharacterCounts = Lab5SampleAnswer.buildCharacterCountsForString(note);
        Hashtable<Character, Integer> magCharacterCounts = Lab5SampleAnswer.buildCharacterCountsForString(magazine);

        // For each character in the note's set of characters...
        for (Character c : noteCharacterCounts.keySet()) {
        	if (magCharacterCounts.containsKey(c)) {
        		if (noteCharacterCounts.get(c) > magCharacterCounts.get(c)) {
        			System.out.println("FALSE: The letter " + c + " exists in the magazine, but there are not enough characters to make your note.");
        			return;
        		}
        	}
        	else {
    			System.out.println("FALSE: The letter " + c + " does not exist in the magazine.");
    			return;
        	}
        }
	System.out.println("TRUE");   
    }
}