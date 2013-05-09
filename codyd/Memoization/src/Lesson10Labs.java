import java.util.Arrays;
import java.util.HashSet;
import java.util.Collection;

public class Lesson10Labs {
    // Your task is to identify the complexity of this function, and rewrite it to have a better complexity.
    static void FirstLab()
    {
        // Instantiate and populate an array of n random floats.
    	int n = 20;
    	float total = 0.0f;
        float[] array = new float[n];
        for (int i = 0; i < n; i++)
        {
            array[i] = (float)Math.random();
        }
        
        System.out.println("Array: " + Arrays.toString(array));
        for (int j = 0; j < n; j++)
        {
            total += array[j];
        }
        
        for (int i = 0; i < n; i++)
        {
            float thisValue = array[i];
            float average = total / n;
            System.out.println("Value " + thisValue + " is " + (thisValue / average) * 100.0f + "% of the average.");
        }       
    }
    
    /** Make this code faster. */
    static void SecondLab()
    {
        // Instantiate and populate an array of 10 random integers between 0 and 9.
        int n = 20;
    	int[] array = new int[n];
        for (int i = 0; i < n; i++)
        {
            array[i] = (int)(Math.random() * n);
        }
        
        System.out.println("Array: " + Arrays.toString(array));
        Collection<Integer> noDups = new HashSet<Integer>();
        for (int i = 0; i < n; i++)
        {
            int thisValue = array[i];
            if (noDups.contains(thisValue)){
            	System.out.println("Value " + thisValue + " is a duplicate.");
            }
            noDups.add(thisValue);  
        }       
    }
    
    static void ThirdLab() 
    {
        // Assignment: Print the first N fibonacci numbers recursively, how fast is this?
        int n = 35;
        CalculateFib fibcalc = new CalculateFib();
        System.out.println(fibcalc.calculateFibonannci(n));
    }
    
    static void FourthLab() 
    {
        // Assignment: Print the first N fibonacci numbers taking advantage of memoization. How fast is this?
        int n = 25;
        FibMemo fibmemo = new FibMemo();
        int[] fibSequence = fibmemo.memoizeFib(n);
        for (int i=0; i < n; i++) {
        	System.out.println(fibSequence[i]);
        }
        
    }
    
    static void BstLab() 
    {
    	BSTLab bstLab = new BSTLab();
       bstLab.printAllValues() ;
        
    }
    
    static final int EXP_CACHE_SIZE = 100;
    static float exp_cache[] = new float[EXP_CACHE_SIZE];
    
    /** Initializes a cache of exp() results for quantized values between 0 and 1.0. */
    void initExpCache()
    {
        for (int i = 0; i < EXP_CACHE_SIZE; i++) {
            exp_cache[i] = (float) Math.exp(-((float)i / (float)EXP_CACHE_SIZE));
        }
    }

    /** Computes an approximation of the exp() function from a pre-computed cache, if possible.
     * Falls back to Math.exp() if the range if the cache is exceeded.
     * @param a The input value to compute the exp() of.
     * @return A fast approximation of exp(a).
     */
    double fast_exp(double a)
    {
        int idx = (int)(-a * EXP_CACHE_SIZE);
        if (idx > 0 && idx < EXP_CACHE_SIZE) {
            return exp_cache[idx];
        } else {
            return Math.exp(a);
        }
    }
    
    public static void main(String[] args)
    {
        //FirstLab();
        //SecondLab();
        //ThirdLab();
        //FourthLab();
    	BstLab();
    }
}