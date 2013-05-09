
public class FibMemo {

	public int[] memoizeFib (int n) {
		int[] fibArray = new int[n];
		fibArray[0] = 0;
		fibArray[1] = 1;
		fibArray[2] = 1;
		for (int i=3; i < n; i++) {
			fibArray[i] = fibArray[i-2] + (fibArray[i-1]);
		}
		return fibArray;
	}
}
