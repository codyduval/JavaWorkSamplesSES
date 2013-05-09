import java.util.HashMap;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.util.Set;

public class NGramTextGenerator {
    private HashMap<LinkedList<String>, ArrayList<String>> ngrams;
    private LinkedList<String> currentNGram;
    private final Random random;

    private final int NGRAM_LENGTH = 3;
    private final int OUTPUT_WORD_COUNT = 300;

    public NGramTextGenerator() {
        this.ngrams = new HashMap<LinkedList<String>, ArrayList<String>>();
        this.currentNGram = null;
        this.random = new Random();
    }

    public void addWord(String word) {
        if (currentNGram == null) {
            currentNGram = new LinkedList<String>();
        }

        currentNGram.addLast(word);

        if (currentNGram.size() == NGRAM_LENGTH) {
            LinkedList<String> nMinusOneGram = new LinkedList<String>(currentNGram);
            String lastWord = nMinusOneGram.removeLast();

            ArrayList<String> lastWords = this.ngrams.get(nMinusOneGram);
            if (lastWords == null) {
                lastWords = new ArrayList<String>();
            }

            lastWords.add(lastWord);
            this.ngrams.put(nMinusOneGram, lastWords);

            currentNGram.removeFirst();
        }
    }

    public void printRandomText() {
        //Start with random seed text
        LinkedList<String> words = this.randomNMinusOneGram();
        Set<LinkedList<String>> keySet = this.ngrams.keySet();
        List<LinkedList<String>> keys = new ArrayList<LinkedList<String>>(keySet);
        
        for (int i = 0; i < OUTPUT_WORD_COUNT; i++) {
        	String firstWord = words.get(0);
        	String secondWord = words.get(1);
        	System.out.print(" " + firstWord + " " + secondWord);
        	ArrayList<String> value = ngrams.get(words);
            String stringValue = value.get(random.nextInt(value.size())).toString();
            ArrayList<String> wordList = new ArrayList<String>();
            for (int j = 0; j < keys.size(); j++) {
            	LinkedList<String> tempSetOfKeys = keys.get(j);
            	String firstKeyValue = tempSetOfKeys.get(0);
            	if (firstKeyValue.equals(stringValue)) {
            		words = tempSetOfKeys;
            		keys.remove(j);
            		break;
            	}
            }

        	// print key for random n-gram (key is first two words)
        	// look for n-gram with key that starts with first-ngrams value (the unprinted trailing word, there may be more than one value, so look for random value)
        	// print key for found n-gram (two words that start with trailing word from previous n-gram]
        	// look for n-gram with key that begins with second-ngrams value (again, the unprinted word)
     	
        	//System.out.println(words);
            // Homework: Given the generated map of ngrams and tailing words, generate random-seeming text
            // It should be OUTPUT_WORD_COUNT long
            // If you come across an ngram that doesn't exist in the map, call randomNGram to get a random one
            // If words is an ngram that exist in the map, get its associated ArrayList<String> and use random.nextInt 
            //  to get a random value from it. After that, print that value
        }
    }

    public LinkedList<String> randomNMinusOneGram() {
        LinkedList<String> randomNGram = null;
        Set<LinkedList<String>> keySet = this.ngrams.keySet();
        
        List<LinkedList<String>> keys  = new ArrayList<LinkedList<String>>(keySet);
        randomNGram = keys.get( random.nextInt(keys.size()) );

        return randomNGram;
    }
}